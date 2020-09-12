package com.fundallocation.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author baburao.annasaheb
 * Implemented Entity Class for ParticipantFund Table
 *
 */
@Entity
@Table(name = "ParticipantFund")
public class ParticipantFund {
	
	@EmbeddedId
	private ParticipantFundPrimaryKey participantFundPrimaryKey;

	@Column(name = "ParticipantName")
	private String participantName;

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

	@Column(name = "Active")
	private String activestatus;

	public ParticipantFundPrimaryKey getParticipantFundPrimaryKey() {
		return participantFundPrimaryKey;
	}

	public void setParticipantFundPrimaryKey(ParticipantFundPrimaryKey participantFundPrimaryKey) {
		this.participantFundPrimaryKey = participantFundPrimaryKey;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
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

	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}

	@Override
	public String toString() {
		return "ParticipantFund [participantFundPrimaryKey=" + participantFundPrimaryKey + ", participantName="
				+ participantName + ", fundName=" + fundName + ", fundUnits=" + fundUnits + ", averageFund="
				+ averageFund + ", participantHoldingPercentage=" + participantHoldingPercentage
				+ ", previousFundExchangeDate=" + previousFundExchangeDate + ", activestatus=" + activestatus + "]";
	}

}
