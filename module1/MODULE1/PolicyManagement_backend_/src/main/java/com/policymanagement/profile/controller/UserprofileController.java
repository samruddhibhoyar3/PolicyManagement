package com.policymanagement.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.policymanagement.profile.exception.InvalidIdProofTypeException;
import com.policymanagement.profile.model.UserprofileDTO;
import com.policymanagement.profile.service.UserprofileService;
import com.policymanagement.profile.util.UsernameGenerator;

import jakarta.validation.Valid;

@Validated
@CrossOrigin("*")
@RestController

@RequestMapping("/api")
public class UserprofileController {
	@Autowired
	private UserprofileService userprofileService;

	@PostMapping("/profile")
	public ResponseEntity<Map<String, String>> createUser(@Valid @RequestBody UserprofileDTO profileDTO) {
		try {
			String generatedUsername = UsernameGenerator.generateUsername(profileDTO.getFirstName(),
					profileDTO.getLastName());
			profileDTO.setUsername(generatedUsername);

			userprofileService.createUser(profileDTO);
			Map<String, String> response = new HashMap<>();
			 response.put("message", "Profile created successfully!");
		        response.put("generatedUsername", generatedUsername);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (InvalidIdProofTypeException e) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "Failed to create profile: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    } catch (Exception e) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "Failed to create profile: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	@GetMapping("/profile/{username}")
    public ResponseEntity<UserprofileDTO> getUserProfile(@PathVariable("username") String username) {
        try {
            UserprofileDTO userProfile = userprofileService.getUserProfile(username);
            if (userProfile != null) {
                return ResponseEntity.ok(userProfile);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
