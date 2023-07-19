package com.Claimsmanagement.ClaimsmanagementApplication.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Claimsmanagement.ClaimsmanagementApplication.entity.Claim;

import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimResponse;
import com.Claimsmanagement.ClaimsmanagementApplication.repository.ClaimResponseRepository;
@Service
public class ClaimResponseService {
	private ClaimResponseRepository claimResponseRepository;
	
	private ClaimService claimService;
	
	@Autowired
	public ClaimResponseService(ClaimResponseRepository claimResponseRepository,ClaimService claimService) {
		this.claimResponseRepository=claimResponseRepository;
		this.claimService=claimService;
	}

	public ClaimResponse updateClaimStatus(int claimId, ClaimResponse reponseDto) {
		System.out.println("inside func");
		System.out.println(reponseDto);
		System.out.println(reponseDto.getClaimId());
		List<Claim>newclaimfromdb= new ArrayList<>();
		newclaimfromdb=claimService.getAllRecords();
		if(!(newclaimfromdb.isEmpty())==true) {
			System.out.println("got all records");
		}
		//System.out.println(reponseDto.getResponseDetails());
		//System.out.println((reponseDto.getResponseDetails()).getClass().getName());
		for(int i=0;i<newclaimfromdb.size();i++) {
			if(claimId==newclaimfromdb.get(i).getId()) {
				
				newclaimfromdb.get(i).setClaimStatus(reponseDto.getResponseDetails());
			}
		}
		reponseDto.setResponseDate(LocalDate.now());
		claimResponseRepository.save(reponseDto);
		System.out.println("policy update Successfully saved");
		return reponseDto;
	}

}
