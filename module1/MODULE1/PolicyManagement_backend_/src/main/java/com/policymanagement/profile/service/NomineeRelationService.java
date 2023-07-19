package com.policymanagement.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.policymanagement.profile.entity.NomineeRelation;
import com.policymanagement.profile.model.NomineeRelationDTO;

@Service
public interface NomineeRelationService {
	List<NomineeRelationDTO> getNomineeTypes();



	void seedNomineeTypes(List<String> nomineeTypes);

}
