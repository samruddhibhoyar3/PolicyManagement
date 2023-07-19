package com.policymanagement.profile.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.policymanagement.profile.entity.UserNominee;
import com.policymanagement.profile.entity.Userprofile;

@Repository
public interface UserNomineeDAO extends JpaRepository<UserNominee,Long>{
	List<UserNominee> findByUserProfile(Userprofile userProfile);
}
