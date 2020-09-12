package com.fundallocation.exception;

/**
 * @author baburao.annasaheb
 * Implemented Exception for FundAllocation Service
 *
 */
public class FundAllocationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FundAllocationException(String execptionMessage) {
		super(execptionMessage);
	}
	
	
	
}
