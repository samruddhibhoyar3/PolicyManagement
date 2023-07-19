package com.Claimsmanagement.ClaimsmanagementApplication.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.Claimsmanagement.ClaimsmanagementApplication.Exception.ClaimentDetailException;
import com.Claimsmanagement.ClaimsmanagementApplication.Exception.InvalidClaimIdException;
import com.Claimsmanagement.ClaimsmanagementApplication.Exception.InvalidIdProofTypeException;
import com.Claimsmanagement.ClaimsmanagementApplication.Exception.PolicyAlreadyClaimedException;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.Claim;
import com.Claimsmanagement.ClaimsmanagementApplication.repository.ClaimRepository;

@Service
public class ClaimService {
	private ClaimRepository claimRepository;
	
	@Autowired
	public ClaimService(ClaimRepository claimRepository) {
		this.claimRepository=claimRepository;
	}
	
	//1.Endpoint2 implement 
	public void addNewClaim(Claim claimDTO) {
		List<Claim>claimfromdb= new ArrayList<>();
		claimfromdb=(List<Claim>) claimRepository.findAll();
		for(int i=0;i<claimfromdb.size();i++) {
			if((claimfromdb.get(i).getUserName().equals(claimDTO.getUserName()))&&
					(claimfromdb.get(i).getPolicyId()==claimDTO.getPolicyId())
					&&(claimfromdb.get(i).getClaimStatus().equals("Approved"))) {
				throw new PolicyAlreadyClaimedException();
		}
		claimDTO.setClaimStatus("New");
		
		claimDTO.setClaimDate(LocalDate.now());
		
		if(claimDTO.getClaimTypeId()==1) {
			claimDTO.setResponseETA((claimDTO.getClaimDate()).plusDays(7));
		}else if(claimDTO.getClaimTypeId()==2) {
			claimDTO.setResponseETA((claimDTO.getClaimDate()).plusDays(30));
		}else if(claimDTO.getClaimTypeId()==3) {
			claimDTO.setResponseETA((claimDTO.getClaimDate()).plusDays(15));
		}else {
			throw new InvalidClaimIdException();
		}
		
		if(claimDTO.getClaimTypeId()==2) {
			if((claimDTO.getClaimantFullName().equals(claimDTO.getUserName()))) {
				if((claimDTO.getClaimantAddress().equals(""))||(claimDTO.getClaimantDateOfBirth()==null)
						||(claimDTO.getClaimantIDProofType().equals("")||(claimDTO.getClaimantIDProofNumber().equals("")))){
					throw new ClaimentDetailException();
				
			}
		}
	}
		
		if((claimDTO.getClaimantIDProofType().equals("Passport"))||(claimDTO.getClaimantIDProofType().equals("Aadhar"))||
					(claimDTO.getClaimantIDProofType().equals("PAN"))||(claimDTO.getClaimantIDProofType().equals("DrivingLicense"))) {
		claimRepository.save(claimDTO);
		System.out.println("Successfully saved");
			}else {
				throw new InvalidIdProofTypeException();
			}
		}
	}


	//2.endpoint3 implement-get request for new claims for policy managers
	public List<Claim> getNewClaims() {
		List<Claim>newclaimfromdb= new ArrayList<>();
		List<Claim>newclaimtoreturn= new ArrayList<>();
		String newstatus="New";
		newclaimfromdb=(List<Claim>) claimRepository.findAll();
//		System.out.println(newclaimfromdb.getClass().getName());
//		System.out.println(newclaimfromdb.size());
		for(int i=0;i<newclaimfromdb.size();i++) {
//			System.out.println("in func1");
//			System.out.println(newclaimfromdb.get(i));
//			System.out.println((newclaimfromdb.get(i)).getClass().getName());
//			System.out.println(newclaimfromdb.get(i).getClaimStatus());
//			System.out.println((newclaimfromdb.get(i).getClaimStatus()).getClass().getName());
			if(newclaimfromdb.get(i).getClaimStatus().equals(newstatus)) {
				//System.out.println("in func");
				newclaimtoreturn.add(newclaimfromdb.get(i));	
			}
		}
//		System.out.println("size: ");
//		System.out.println(newclaimtoreturn.size());
		if(newclaimtoreturn.size()==0) {
			return null;
		}else {
		return newclaimtoreturn;
		}
	}

	//3.Endpoint4 implement-get request for claim details for any claim request(s) by policy manager 
	public Claim getClaimsByClaimId(int id) {
		List<Claim>claims= new ArrayList<>();
		claims=(List<Claim>) claimRepository.findAll();
		for(int i=0;i<claims.size();i++) {
			if(id==claims.get(i).getId()) {
				return claims.get(i);
			}
		}
		return null;
	}
	//Endpoint5-function to get claims
	public List<Claim> getAllRecords(){
	List<Claim>newclaimfromdb= new ArrayList<>();
	newclaimfromdb=(List<Claim>) claimRepository.findAll();
	return newclaimfromdb;
}
}