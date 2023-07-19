package com.Claimsmanagement.ClaimsmanagementApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Claimsmanagement.ClaimsmanagementApplication.entity.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim,Integer> {

}
