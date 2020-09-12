package com.fundallocation.service;

/**
 * @author baburao.annasaheb
 * Implemented Service Class for FundAllocation Service
 *
 */
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundallocation.model.PendingParticipantFund;
import com.fundallocation.model.dto.PendingParticipantFundDTO;
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
	
	public List<PendingParticipantFundDTO> fetchPendingParticipantFund(){
		
		Predicate<PendingParticipantFund> partialWithdrawalStatus = (PendingParticipantFund pendintParticipant) -> pendintParticipant.getWithdrawalStatus().equalsIgnoreCase(PARTIAL);
		Predicate<PendingParticipantFund> fullWithdrawalStatus = (PendingParticipantFund pendintParticipant) -> pendintParticipant.getWithdrawalStatus().equalsIgnoreCase(FULL);

		List<PendingParticipantFund> pendingParticipantFundList = pendingParticipantFundRepository.getPendingParticipantFund();
		
		for(PendingParticipantFund pendingParticipantFund: pendingParticipantFundList) {
			
			allocateFund(partialWithdrawalStatus, fullWithdrawalStatus, pendingParticipantFund);
			
		}
		
		return null;	
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
		
		String withdrawalStatus = pendingParticipantFund.getWithdrawalStatus();
		Integer averageFund = pendingParticipantFund.getAverageFund();
		
		String referenceTransactionId = pendingParticipantFund.getReferenceTransactionId();
		PendingParticipantFund pendingParticipantFundEntity = pendingParticipantFundRepository.getPendingParticipantFundFromTransactionId(referenceTransactionId);
	}
	
}
