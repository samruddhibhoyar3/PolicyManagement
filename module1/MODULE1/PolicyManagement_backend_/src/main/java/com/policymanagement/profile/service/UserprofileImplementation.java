package com.policymanagement.profile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policymanagement.profile.dao.UserprofileDAO;
import com.policymanagement.profile.entity.Userprofile;
import com.policymanagement.profile.exception.Only1NomineeAllowedException;
import com.policymanagement.profile.model.UserprofileDTO;

@Service
public class UserprofileImplementation implements UserprofileService {

	private final UserprofileDAO userprofileRepository;

	@Autowired
	public UserprofileImplementation(UserprofileDAO userprofileRepository) {
		this.userprofileRepository = userprofileRepository;
	}

	@Override
	public UserprofileDTO createUser(UserprofileDTO profileDTO) {
		validateUser(profileDTO);
		generateUsername(profileDTO);
		Userprofile userprofile = convertToEntity(profileDTO);
		Userprofile savedUser = userprofileRepository.save(userprofile);
		return convertToDTO(savedUser);
	}

	private void validateUser(UserprofileDTO profileDTO) {
	//	if (profileDTO.getNominee() != null && profileDTO.getNominee().size() > 1) {
		// throw new Only1NomineeAllowedException("Only 1 nominee is allowed per user.");
		// }

		if (!"Indian".equalsIgnoreCase(profileDTO.getNationality())
				&& !"Passport".equalsIgnoreCase(profileDTO.getIdProof())) {
			throw new IllegalArgumentException(
					"If nationality is not Indian, the only acceptable ID proof type is Passport.");
		}
	}

	void generateUsername(UserprofileDTO profileDTO) {
		String firstName = profileDTO.getFirstName().substring(0, 2).toLowerCase();
		String lastName = profileDTO.getLastName().substring(0, 4).toLowerCase();
		String serialNumber = String.format("%04d", userprofileRepository.count() + 1);
		String username = firstName + lastName + serialNumber;
		profileDTO.setUsername(username);
	}

	private Userprofile convertToEntity(UserprofileDTO profileDTO) {
		Userprofile userprofile = new Userprofile();
		userprofile.setUsername(profileDTO.getUsername());
		userprofile.setFirstName(profileDTO.getFirstName());
		userprofile.setMiddleName(profileDTO.getMiddleName());
		userprofile.setLastName(profileDTO.getLastName());
		userprofile.setDateOfBirth(profileDTO.getDateOfBirth());
		userprofile.setGender(profileDTO.getGender());
		userprofile.setProfession(profileDTO.getProfession());
		userprofile.setCurrentAddress(profileDTO.getCurrentAddress());
		userprofile.setNationality(profileDTO.getNationality());
		userprofile.setIdProof(profileDTO.getIdProof());
		userprofile.setDocNumber(profileDTO.getDocNumber());
		userprofile.setPhoneNumber(profileDTO.getPhoneNumber());
		userprofile.setEmailAddress(profileDTO.getEmailAddress());
		return userprofile;
	}

	private UserprofileDTO convertToDTO(Userprofile userprofile) {
		UserprofileDTO profileDTO = new UserprofileDTO();
		profileDTO.setUsername(userprofile.getUsername());
		profileDTO.setFirstName(userprofile.getFirstName());
		profileDTO.setMiddleName(userprofile.getMiddleName());
		profileDTO.setLastName(userprofile.getLastName());
		profileDTO.setDateOfBirth(userprofile.getDateOfBirth());
		profileDTO.setGender(userprofile.getGender());
		profileDTO.setProfession(userprofile.getProfession());
		profileDTO.setCurrentAddress(userprofile.getCurrentAddress());
		profileDTO.setNationality(userprofile.getNationality());
		profileDTO.setIdProof(userprofile.getIdProof());
		profileDTO.setDocNumber(userprofile.getDocNumber());
		profileDTO.setPhoneNumber(userprofile.getPhoneNumber());
		profileDTO.setEmailAddress(userprofile.getEmailAddress());
		return profileDTO;
	}

	@Override
	public Userprofile getUserByUsername(String username) {
	    Optional<Userprofile> userprofileOptional = Optional.ofNullable(userprofileRepository.findByUsername(username));
	    return userprofileOptional.orElse(null);
	}

	public UserprofileDTO getUserProfile(String username) {
	    // TODO: Implement the logic to retrieve the user profile from the database or any other data source
	    // Example code:
	    Userprofile userProfileEntity = userprofileRepository.findByUsername(username);
	    if (userProfileEntity != null) {
	        UserprofileDTO userProfileDTO = convertToDTO(userProfileEntity); // Convert the entity to DTO
	        return userProfileDTO;
	    } else {
	        return null; // Return null if the user profile does not exist
	    }
	}



	
}
