package com.fundallocation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author baburao.annasaheb
 * Implemented ParticipantFundPrimaryKey for Composite Primary Keys
 *
 */
@Embeddable
public class ParticipantFundPrimaryKey implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "ParticipantID")
	private Integer participantId;
	
	@Column(name = "PlanID")
	private Integer planId;
	
	@Column(name = "FundID")
	private Integer fundId;

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
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

	@Override
	public String toString() {
		return "ParticipantFundPrimaryKey [participantId=" + participantId + ", planId=" + planId + ", fundId=" + fundId
				+ "]";
	}
	
}
