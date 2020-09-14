package com.fundallocation.service;

/**
 * @author baburao.annasaheb
 * Implemented Service Class for FundAllocation Service
 *
 */

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fundallocation.exception.FundAllocationException;
import com.fundallocation.model.ParticipantFund;
import com.fundallocation.model.ParticipantFundPrimaryKey;
import com.fundallocation.model.PendingParticipantFund;
import com.fundallocation.repository.ParticipantFundRepository;
import com.fundallocation.repository.PendingParticipantFundRepository;

@Service
public class FundAllocationService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String PARTIAL = "Partial";
	private static final String FULL = "Full";
	
	@Autowired
	private PendingParticipantFundRepository pendingParticipantFundRepository; 
	
	@Autowired
	private ParticipantFundRepository participantFundRepository;
	
	public HttpStatus fetchPendingParticipantFund(){
		
		Predicate<PendingParticipantFund> partialWithdrawalStatus = (PendingParticipantFund pendintParticipant) -> pendintParticipant.getWithdrawalStatus().equalsIgnoreCase(PARTIAL);
		Predicate<PendingParticipantFund> fullWithdrawalStatus = (PendingParticipantFund pendintParticipant) -> pendintParticipant.getWithdrawalStatus().equalsIgnoreCase(FULL);
		
		try{
		List<PendingParticipantFund> pendingParticipantFundList = pendingParticipantFundRepository.getPendingParticipantFund();
		
		for(PendingParticipantFund pendingParticipantFund: pendingParticipantFundList) {
			
			allocateFund(partialWithdrawalStatus, fullWithdrawalStatus, pendingParticipantFund);
		}
		}catch(Exception e) {
			throw new FundAllocationException(e.getMessage());
		}
		
		return HttpStatus.OK;	
	}

	private void allocateFund(Predicate<PendingParticipantFund> partialWithdrawalStatus,
			Predicate<PendingParticipantFund> fullWithdrawalStatus, PendingParticipantFund pendingParticipantFund) {
	
		Integer withdrawalUnits = pendingParticipantFund.getWithdrawalUnits();
		Integer fundUnitsHeld = pendingParticipantFund.getFundUnits();
		
		Integer fundId = pendingParticipantFund.getFundId();
		Integer participantId = pendingParticipantFund.getParticipantId();
		Integer planId = pendingParticipantFund.getPlanId();
		
		Integer rowsUpdated = 0;
		
		if(partialWithdrawalStatus.test(pendingParticipantFund)) {
			Integer currentFundUnits = fundUnitsHeld-withdrawalUnits;
			rowsUpdated = participantFundRepository.updateWhenWithdrawalStatusPartial(currentFundUnits, participantId, fundId, planId);
		
		}
		else if(fullWithdrawalStatus.test(pendingParticipantFund)) {
			rowsUpdated = participantFundRepository.updateWhenWithdrawalStatusFull(participantId, fundId, planId);
		}
		
		if(rowsUpdated>0)
			logger.info(String.format("The rows updated for Participant : %s", pendingParticipantFund.getParticipantId()));
		
		Integer transactionId = pendingParticipantFund.getTransactionId();
		Optional<PendingParticipantFund> pendingParticipantFundFromTransactionId = pendingParticipantFundRepository.getPendingParticipantFundFromTransactionId(transactionId);

		if(pendingParticipantFundFromTransactionId.isPresent()) 
		{

		insertParticipantFundDetails(pendingParticipantFundFromTransactionId.get());
		
		}
	}

	private void insertParticipantFundDetails(PendingParticipantFund pendingParticipantFundEntity) {
		ParticipantFundPrimaryKey participantFundPrimaryKey = new ParticipantFundPrimaryKey();
		participantFundPrimaryKey.setParticipantId(pendingParticipantFundEntity.getParticipantId());
		participantFundPrimaryKey.setPlanId(pendingParticipantFundEntity.getPlanId());
		participantFundPrimaryKey.setFundId(pendingParticipantFundEntity.getFundId());
		
		ParticipantFund participandFund = new ParticipantFund();

		participandFund.setParticipantFundPrimaryKey(participantFundPrimaryKey);
		participandFund.setParticipantName(pendingParticipantFundEntity.getParticipantName());
		participandFund.setFundName(pendingParticipantFundEntity.getFundName());
		participandFund.setFundUnits(pendingParticipantFundEntity.getFundUnits());
		participandFund.setAverageFund(pendingParticipantFundEntity.getAverageFund());
		participandFund.setParticipantHoldingPercentage(pendingParticipantFundEntity.getParticipantHoldingPercentage());
		participandFund.setPreviousFundExchangeDate(pendingParticipantFundEntity.getPreviousFundExchangeDate());
		participandFund.setActivestatus("Y");
		
		logger.info(String.format("The ParticipantFund details : %s", participandFund));

		ParticipantFund addParticipandFundDetails = participantFundRepository.save(participandFund);
		
		if(addParticipandFundDetails != null)
			logger.info(String.format("The ParticipantFund values inserted to table for transaction Id : %s", addParticipandFundDetails.getParticipantFundPrimaryKey().getParticipantId()));
	}
	
}
