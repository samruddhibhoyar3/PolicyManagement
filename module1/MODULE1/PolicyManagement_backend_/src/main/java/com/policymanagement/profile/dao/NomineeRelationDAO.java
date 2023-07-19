package com.policymanagement.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policymanagement.profile.entity.NomineeRelation;


@Repository
public interface NomineeRelationDAO extends JpaRepository<NomineeRelation,Long>{

}
