package com.premium.premiummanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.premium.premiummanagement.entity.PremiumsMaster;


@Repository
public interface PremiumMasterRepository extends CrudRepository<PremiumsMaster,Integer> {
	

	@Query(value = "SELECT * FROM premiumsmaster WHERE EXTRACT(DAY FROM lastpaymentdate) > 9", nativeQuery = true)
	List<PremiumsMaster> findByLastPaymentDateDayLessThan(LocalDate ninthDate);
	
}
