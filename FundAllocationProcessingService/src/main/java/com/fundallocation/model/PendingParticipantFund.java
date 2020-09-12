package com.fundallocation.model;
/**
 * 
 * @author baburao.annasaheb
 * Implemented Entity Class for PENDING_PARTICIPANT_FUND Table
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PendingParticipantFund")
public class PendingParticipantFund {

	@Id
	@Column(name = "TransactionID")
	private Integer transactionId;

	@Column(name = "ParticipantID")
	private Integer participantId;

	@Column(name = "ParticipantName")
	private String participantName;

	@Column(name = "PlanID")
	private Integer planId;

	@Column(name = "FundID")
	private Integer fundId;

	@Column(name = "FundName")
	private String fundName;

	@Column(name = "FundUnitsHeld")
	private Integer fundUnits;

	@Column(name = "AvgFundNAV")
	private Integer averageFund;

	@Column(name = "ParticipantHoldingPercentage")
	private Integer participantHoldingPercentage;

	@Column(name = "PreviousFundexchangeDate")
	private String previousFundExchangeDate;

	@Column(name = "Processed")
	private String processed;

	@Column(name = "WithDrawalUnits")
	private Integer withdrawalUnits;

	@Column(name = "ReferenceTransactionID", nullable = true)
	private String referenceTransactionId;

	@Column(name = "WithdrawalStatus")
	private String withdrawalStatus;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Integer getFundUnits() {
		return fundUnits;
	}

	public void setFundUnits(Integer fundUnits) {
		this.fundUnits = fundUnits;
	}

	public Integer getAverageFund() {
		return averageFund;
	}

	public void setAverageFund(Integer averageFund) {
		this.averageFund = averageFund;
	}

	public Integer getParticipantHoldingPercentage() {
		return participantHoldingPercentage;
	}

	public void setParticipantHoldingPercentage(Integer participantHoldingPercentage) {
		this.participantHoldingPercentage = participantHoldingPercentage;
	}

	public String getPreviousFundExchangeDate() {
		return previousFundExchangeDate;
	}

	public void setPreviousFundExchangeDate(String previousFundExchangeDate) {
		this.previousFundExchangeDate = previousFundExchangeDate;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public Integer getWithdrawalUnits() {
		return withdrawalUnits;
	}

	public void setWithdrawalUnits(Integer withdrawalUnits) {
		this.withdrawalUnits = withdrawalUnits;
	}

	public String getReferenceTransactionId() {
		return referenceTransactionId;
	}

	public void setReferenceTransactionId(String referenceTransactionId) {
		this.referenceTransactionId = referenceTransactionId;
	}

	public String getWithdrawalStatus() {
		return withdrawalStatus;
	}

	public void setWithdrawalStatus(String withdrawalStatus) {
		this.withdrawalStatus = withdrawalStatus;
	}

	@Override
	public String toString() {
		return "PendingParticipantFund [transactionId=" + transactionId + ", participantId=" + participantId
				+ ", participantName=" + participantName + ", planId=" + planId + ", fundId=" + fundId + ", fundName="
				+ fundName + ", fundUnits=" + fundUnits + ", averageFund=" + averageFund
				+ ", participantHoldingPercentage=" + participantHoldingPercentage + ", previousFundExchangeDate="
				+ previousFundExchangeDate + ", processed=" + processed + ", withdrawalUnits=" + withdrawalUnits
				+ ", referenceTransactionId=" + referenceTransactionId + ", withdrawalStatus=" + withdrawalStatus + "]";
	}

}
