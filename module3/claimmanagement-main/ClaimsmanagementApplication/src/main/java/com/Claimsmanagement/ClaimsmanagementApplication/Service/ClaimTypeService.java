package com.Claimsmanagement.ClaimsmanagementApplication.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimType;
import com.Claimsmanagement.ClaimsmanagementApplication.repository.ClaimTypeRepository;
@Service
public class ClaimTypeService {
	//Endpoint1 service implement
	private ClaimTypeRepository claimTypeRepository;
	

	@Autowired
	public ClaimTypeService(ClaimTypeRepository claimTypeRepository) {
		this.claimTypeRepository=claimTypeRepository;
	}

	public List<ClaimType> getAllTypes() {
		List<ClaimType>claimtype= new ArrayList<>();
		claimtype=(List<ClaimType>) claimTypeRepository.findAll();
		return claimtype;
	}

}
