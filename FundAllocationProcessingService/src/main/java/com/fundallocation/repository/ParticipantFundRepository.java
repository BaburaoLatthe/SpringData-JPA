package com.fundallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundallocation.model.ParticipantFund;
import com.fundallocation.model.ParticipantFundPrimaryKey;

/**
 * @author baburao.annasaheb
 * Implemented Repository for ParticipantFund Table
 */

@Repository
public interface ParticipantFundRepository extends JpaRepository<ParticipantFund, ParticipantFundPrimaryKey> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE PARTICIPANT_FUND SET FUND_UNITS_HELD = :fundsUnit, PREVIOUS_FUNDEXCHANGE_DATE = now() WHERE PARTICIPANTID = :participandId AND FUNDID = :fundId AND PLANID = :planId", nativeQuery = true)
	public Integer updateWhenWithdrawalStatusPartial(@Param("fundsUnit") Integer fundsUnit,
													 @Param("participandId") Integer participandId,
													 @Param("fundId") Integer fundId,
													 @Param("planId") Integer planId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE PARTICIPANT_FUND SET FUND_UNITS_HELD = 0, PREVIOUS_FUNDEXCHANGE_DATE = now(), ACTIVE = 'N' WHERE PARTICIPANTID = :participandId AND FUNDID = :fundId AND PLANID = :planId", nativeQuery = true)
	public Integer updateWhenWithdrawalStatusFull(@Param("participandId") Integer participandId,
												  @Param("fundId") Integer fundId,
												  @Param("planId") Integer planId);
	
}
