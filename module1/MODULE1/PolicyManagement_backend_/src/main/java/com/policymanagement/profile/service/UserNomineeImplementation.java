package com.policymanagement.profile.service;

import com.policymanagement.profile.dao.UserNomineeDAO;
import com.policymanagement.profile.entity.UserNominee;
import com.policymanagement.profile.entity.Userprofile;
import com.policymanagement.profile.exception.Only1NomineeAllowedException;
import com.policymanagement.profile.exception.ResourceNotFoundException;
import com.policymanagement.profile.model.UserNomineeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserNomineeImplementation implements UserNomineeService {

    private final UserNomineeDAO userNomineeDAO;
    private final UserprofileService userprofileService;

    @Autowired
    public UserNomineeImplementation(UserNomineeDAO userNomineeDAO, UserprofileService userprofileService) {
        this.userNomineeDAO = userNomineeDAO;
        this.userprofileService = userprofileService;
    }

    @Override
    public void addNominee(UserNominee userNominee) {
        Userprofile userprofile = userNominee.getUserProfile();

        List<UserNominee> existingNominees = userNomineeDAO.findByUserProfile(userprofile);
        if (!existingNominees.isEmpty()) {
            throw new Only1NomineeAllowedException("Only one nominee is allowed.");
        }

        userNomineeDAO.save(userNominee);
    }

    @Override
    public UserNomineeDTO getNominee(String username) {
        Userprofile userprofile = userprofileService.getUserByUsername(username);
        List<UserNominee> userNominees = userNomineeDAO.findByUserProfile(userprofile);

        if (userNominees.isEmpty()) {
            throw new ResourceNotFoundException("No nominee found for the given username: " + username);
        }

        UserNominee userNominee = userNominees.get(0);

        UserNomineeDTO nomineeDTO = new UserNomineeDTO();
        nomineeDTO.setFullName(userNominee.getFullName());
        nomineeDTO.setDateOfBirth(userNominee.getDateOfBirth());
        nomineeDTO.setGender(userNominee.getGender());
        nomineeDTO.setIdProofType(userNominee.getIdProofType());
        nomineeDTO.setIdProofDocument(userNominee.getIdProofDocument());
        nomineeDTO.setNationality(userNominee.getNationality());
        nomineeDTO.setNomineeRelation(userNominee.getNomineeRelation());

        return nomineeDTO;
    }

    @Override
    public void removeNominee(String username) {
        Userprofile userprofile = userprofileService.getUserByUsername(username);
        List<UserNominee> userNomineeList = userNomineeDAO.findByUserProfile(userprofile);

        if (userNomineeList.isEmpty()) {
            throw new ResourceNotFoundException("No nominee found for the given username: " + username);
        }

        UserNominee userNominee = userNomineeList.get(0); // Assuming you only want to remove the first nominee

        userNomineeDAO.delete(userNominee);
    }

    // Exception handler for Only1NomineeAllowedException
    @ExceptionHandler(Only1NomineeAllowedException.class)
    public void handleOnly1NomineeAllowedException(Only1NomineeAllowedException ex) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
    }

    // Exception handler for ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFoundException(ResourceNotFoundException ex) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
    }
}
