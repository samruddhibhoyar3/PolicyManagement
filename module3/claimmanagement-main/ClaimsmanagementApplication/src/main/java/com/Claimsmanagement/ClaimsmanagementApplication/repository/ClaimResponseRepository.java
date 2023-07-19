package com.Claimsmanagement.ClaimsmanagementApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimResponse;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.ClaimType;

@Repository
public interface ClaimResponseRepository extends CrudRepository<ClaimType, Integer> {

	void save(ClaimResponse reponseDto);

}
