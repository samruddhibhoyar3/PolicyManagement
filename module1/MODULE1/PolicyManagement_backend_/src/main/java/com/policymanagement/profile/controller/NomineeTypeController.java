package com.policymanagement.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policymanagement.profile.model.NomineeRelationDTO;
import com.policymanagement.profile.service.NomineeRelationService;
@CrossOrigin("*")
@RestController

@RequestMapping("/api")
public class NomineeTypeController {

	private final NomineeRelationService nomineeRelationService;

	@Autowired
	public NomineeTypeController(NomineeRelationService nomineeRelationService) {
		this.nomineeRelationService = nomineeRelationService;
	}

	@GetMapping("/nomineetypes")
	public ResponseEntity<List<NomineeRelationDTO>> getNomineeTypes() {
		List<NomineeRelationDTO> nomineeTypes = nomineeRelationService.getNomineeTypes();
		return ResponseEntity.ok(nomineeTypes);
	}
	@PostMapping("/nomineetypes")
    public ResponseEntity<String> seedNomineeTypes(@RequestBody List<String> nomineeTypes) {
        nomineeRelationService.seedNomineeTypes(nomineeTypes);
        return ResponseEntity.ok("Nominee relation types seeded successfully.");
    }
}
