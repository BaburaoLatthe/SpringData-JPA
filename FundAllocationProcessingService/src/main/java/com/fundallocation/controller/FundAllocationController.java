package com.fundallocation.controller;

/**
 * @author baburao.annasaheb
 * Implemented Controller for FundAllocation Service
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundallocation.service.FundAllocationService;

@RestController
@RequestMapping(path = "/fundallocation")
public class FundAllocationController {
	
	@Autowired
	private FundAllocationService fundAllocationService;
	
	@PutMapping(path = "/allocatefund")
	public ResponseEntity<HttpStatus> allocateNewFund() {
		
		HttpStatus fetchPendingParticipantFund = fundAllocationService.fetchPendingParticipantFund();
		
		return new ResponseEntity<>(fetchPendingParticipantFund);
	}
}
