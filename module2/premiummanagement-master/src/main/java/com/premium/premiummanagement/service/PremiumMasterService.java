package com.premium.premiummanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import com.premium.premiummanagement.entity.PremiumsMaster;
import com.premium.premiummanagement.repository.PremiumMasterRepository;

@Service
public class PremiumMasterService {
	
	private PremiumMasterRepository premiumMasterRepository;
	
	@Autowired
	public PremiumMasterService(PremiumMasterRepository premiumMasterRepository) {
		this.premiumMasterRepository=premiumMasterRepository;
	}
	
	public PremiumsMaster getListSubscriptionId(int subscriptionId) {
		List<PremiumsMaster>premium= new ArrayList<>();
		premium=(List<PremiumsMaster>) premiumMasterRepository.findAll();
		for(int i=0;i<premium.size();i++) {
			if(subscriptionId==premium.get(i).getSubscriptionId()) {
				return premium.get(i);
			}
		}
		return null;
		
	}
	
	public PremiumsMaster getListUsername(String Username) {
		List<PremiumsMaster>premium= new ArrayList<>();
		premium=(List<PremiumsMaster>) premiumMasterRepository.findAll();
		for(int i=0;i<premium.size();i++) {
			System.out.println(premium.get(i).getUsername());
			if(Username.equalsIgnoreCase(premium.get(i).getUsername())) {
				return premium.get(i);
			}
		}
		return null;
	}
	
	
	public List<PremiumsMaster> getPaymentsBefore9thDate() {
        LocalDate ninthDate = LocalDate.now().withDayOfMonth(9);
        return premiumMasterRepository.findByLastPaymentDateDayLessThan(ninthDate);
    }
	
}
