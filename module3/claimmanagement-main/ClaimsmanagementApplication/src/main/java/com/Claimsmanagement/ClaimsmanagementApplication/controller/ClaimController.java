package com.Claimsmanagement.ClaimsmanagementApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Claimsmanagement.ClaimsmanagementApplication.Service.ClaimResponseService;
import com.Claimsmanagement.ClaimsmanagementApplication.Service.ClaimService;
import com.Claimsmanagement.ClaimsmanagementApplication.Service.ClaimTypeService;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.Claim;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimResponse;
//import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimResponse;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimType;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private ClaimTypeService claimTypeService;
	
	@Autowired
	private ClaimResponseService responseService;
	
	
	//Endpoint1
	@GetMapping("/types")
	public List<ClaimType> getAllTypes() {
		System.out.println("Get claimtypes verified");
		return claimTypeService.getAllTypes();
	}
	
	//Endpoint2
	@RequestMapping(method=RequestMethod.POST, value="")
	public ResponseEntity<HttpStatus> addNewClaim(@RequestBody Claim claimDTO) {
		 claimService.addNewClaim(claimDTO);
		 System.out.println("post new claim verified");
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	//Endpoint3
	@GetMapping("")
	public List<Claim> getNewClaims() {
		System.out.println("Get new claims verified");
		return claimService.getNewClaims();
	}
	
	//Endpoint4
	@GetMapping("/{claimid}")
	public Claim getClaimsByClaimId(@PathVariable int claimid) {
		System.out.println("Get claim by id verified");
		return claimService.getClaimsByClaimId(claimid);
	}
	
	//Endpoint5
	@RequestMapping(method=RequestMethod.PUT, value="/{claimid}/process")
	public ClaimResponse processClaimRequest(@PathVariable int claimid,@RequestBody ClaimResponse reponseDto ) {
//		return new ResponseEntity<List<ClaimResponse>>(responseService.updateClaimStatus(claimId,reponseDto),
//				HttpStatus.OK);
		
		return responseService.updateClaimStatus(claimid,reponseDto);
	}
}
