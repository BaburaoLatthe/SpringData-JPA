package com.fundallocation.controller;

/**
 * @author baburao.annasaheb
 * Implemented Controller for Fund Allocation
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundallocation.model.dto.PendingParticipantFundDTO;
import com.fundallocation.service.FundAllocationService;

@RestController
@RequestMapping(path = "/fundallocation")
public class FundAllocationController {
	
	@Autowired
	private FundAllocationService fundAllocationService;
	
	@PutMapping(path = "/allocatefund")
	public void allocateNewFund() {
		
		List<PendingParticipantFundDTO> fetchPendingParticipantFund = fundAllocationService.fetchPendingParticipantFund();
	}
}
