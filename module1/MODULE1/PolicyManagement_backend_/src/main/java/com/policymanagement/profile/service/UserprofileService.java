package com.policymanagement.profile.service;

import org.springframework.stereotype.Service;

import com.policymanagement.profile.entity.Userprofile;
import com.policymanagement.profile.model.UserprofileDTO;

@Service
public interface UserprofileService {
	UserprofileDTO createUser(UserprofileDTO userprofileDTO);

	Userprofile getUserByUsername(String username);

	UserprofileDTO getUserProfile(String username);

	
}
