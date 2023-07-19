package com.premium.premiummanagement.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premium.premiummanagement.entity.PaymentMethods;
import com.premium.premiummanagement.repository.PaymentMethodsRepository;


@Service
public class PaymentMethodsService {
	
	@Autowired
	private PaymentMethodsRepository paymentMethodsRepository;
	
	public List<PaymentMethods>getPaymentMethods(){
		List<PaymentMethods> payments=new ArrayList<>();
		paymentMethodsRepository.findAll()//iterable
		.forEach(payments::add); //add in list
		return payments;
		
	}
}
