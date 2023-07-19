package com.premium.premiummanagement.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premium.premiummanagement.entity.PremiumPayments;
import com.premium.premiummanagement.repository.PremiumPaymentsRepository;

@Service
public class PremiumPaymentsService {
	
	@Autowired
	private PremiumPaymentsRepository premiumPaymentsRepository;
	
	public void addPremiumPayments(PremiumPayments premiumPayments) {
		//System.out.println("Done");
		premiumPaymentsRepository.save(premiumPayments);
	}
	
	public float calculateLateFee(PremiumPayments premiumPayments) {
		//LocalDate paymentDate = LocalDate.now();
		//PremiumPayments premiumPayments1=new PremiumPayments(1,paymentDate,"22",2222,0,1,2);
		LocalDate date = premiumPayments.getPaymentDate();
		String temp=date.toString();
		String day=temp.substring(8);
		//int num=Integer.parseInt("8");
		int num=Integer.parseInt(day);
		//float amount=10000;
		float amount=premiumPayments.getPremiumAmount();
		int lateDays=num-5;
		float lateFee=0;
		if(lateDays>0) {
			lateFee=(float) (lateDays*(0.00025*amount));
		}
		System.out.println(lateFee);
		return lateFee;
	}

}
