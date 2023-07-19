package com.premium.premiummanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.premium.premiummanagement.entity.PremiumPayments;

@Repository
public interface PremiumPaymentsRepository extends CrudRepository<PremiumPayments,Integer> {

}
