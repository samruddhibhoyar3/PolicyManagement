package com.policymanagement.profile.controller;

import com.policymanagement.profile.dao.UserNomineeDAO;
import com.policymanagement.profile.entity.UserNominee;
import com.policymanagement.profile.entity.Userprofile;
import com.policymanagement.profile.exception.ResourceNotFoundException;
import com.policymanagement.profile.model.UserNomineeDTO;
import com.policymanagement.profile.service.UserNomineeService;
import com.policymanagement.profile.service.UserprofileService;
import com.policymanagement.profile.exception.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController

@RequestMapping("/api/profile/{username}/nominee")
public class UserNomineeController {

	private final UserNomineeService userNomineeService;
	@Autowired
	private  UserprofileService userprofileService;
	@Autowired
	private UserNomineeDAO userNomineeDAO;

	@Autowired
	public UserNomineeController(UserNomineeService userNomineeService) {
		this.userNomineeService = userNomineeService;

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserNomineeDTO addNominee(@PathVariable("username") String username, @RequestBody UserNomineeDTO nomineeDTO) {
	    Userprofile userProfile = userprofileService.getUserByUsername(username);
	    UserNominee userNominee = new UserNominee();
	    userNominee.setUserProfile(userProfile);
	    // Set the properties of the userNominee object from the nomineeDTO
	    userNominee.setFullName(nomineeDTO.getFullName());
	    userNominee.setDateOfBirth(nomineeDTO.getDateOfBirth());
	    userNominee.setGender(nomineeDTO.getGender());
	    userNominee.setIdProofType(nomineeDTO.getIdProofType());
	    userNominee.setIdProofDocument(nomineeDTO.getIdProofDocument());
	    userNominee.setNationality(nomineeDTO.getNationality());
	    userNominee.setNomineeRelation(nomineeDTO.getNomineeRelation());
	    
	    userNomineeService.addNominee(userNominee);
	    
	    return nomineeDTO;
	}

	
	
	@GetMapping
	public UserNomineeDTO getNominee(@PathVariable("username") String username) {
	    // Use the additionalParam in your logic if needed
	   
	    
	    
	    Userprofile userprofile = userprofileService.getUserByUsername(username);
	    List<UserNominee> userNominees = userNomineeDAO.findByUserProfile(userprofile);

	    if (userNominees.isEmpty()) {
	        throw new ResourceNotFoundException("No nominee found for the given username: " + username);
	    }

	    UserNominee userNominee = userNominees.get(0);
	    userNominee.getUserProfile(); 
	    return userNominee.toDTO();
	}


	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> removeNominee(@PathVariable("username") String username) {
		userNomineeService.removeNominee(username);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Nominee deleted successfully.");
	}
	
	@ExceptionHandler(Only1NomineeAllowedException.class)
    public ResponseEntity<String> handleOnly1NomineeAllowedException(Only1NomineeAllowedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
