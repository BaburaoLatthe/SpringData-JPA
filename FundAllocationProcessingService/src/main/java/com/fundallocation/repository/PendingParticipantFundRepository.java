package com.fundallocation.repository;
/**
 * @author baburao.annasaheb
 * Implemented Repository for PendingParticipantFund Table
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundallocation.model.PendingParticipantFund;

@Repository
public interface PendingParticipantFundRepository extends JpaRepository<PendingParticipantFund , Integer> {
	
	@Query(value = "SELECT * FROM PENDING_PARTICIPANT_FUND WHERE PROCESSED = 'N' AND REFERENCE_TRANSACTIONID is NULL", nativeQuery = true)
	public List<PendingParticipantFund> getPendingParticipantFund();
	
	@Query(value = "SELECT * FROM PENDING_PARTICIPANT_FUND WHERE REFERENCE_TRANSACTIONID = :refernenceTransactionId", nativeQuery = true )
	public PendingParticipantFund getPendingParticipantFundFromTransactionId(@Param("refernenceTransactionId") String referenceTransactionId);
	
}
