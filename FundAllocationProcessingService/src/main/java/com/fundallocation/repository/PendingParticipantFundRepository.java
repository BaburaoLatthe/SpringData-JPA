package com.fundallocation.repository;
/**
 * @author baburao.annasaheb
 * Implemented Repository for PendingParticipantFund Table
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundallocation.model.PendingParticipantFund;

@Repository
public interface PendingParticipantFundRepository extends JpaRepository<PendingParticipantFund , Integer> {
	
	@Query(value = "SELECT * FROM PENDING_PARTICIPANT_FUND WHERE PROCESSED = 'N' AND REFERENCE_TRANSACTIONID is NULL", nativeQuery = true)
	public List<PendingParticipantFund> getPendingParticipantFund();
	
	@Query(value = "SELECT * FROM PENDING_PARTICIPANT_FUND WHERE REFERENCE_TRANSACTIONID = :transactionId", nativeQuery = true )
	public Optional<PendingParticipantFund> getPendingParticipantFundFromTransactionId(@Param("transactionId") Integer referenceTransactionId);
	
}
