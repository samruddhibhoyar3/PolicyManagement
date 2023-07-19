package com.premium.premiummanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premium.premiummanagement.entity.PaymentMethods;
import com.premium.premiummanagement.service.PaymentMethodsService;

@RestController
@RequestMapping("/api")
public class PaymentMethodsController {
	
	@Autowired
	private PaymentMethodsService paymentMethodsService;
	
	@RequestMapping("/paymentmethods")
	public List<PaymentMethods>getPaymentMethods(){
		System.out.println("Done");
		return paymentMethodsService.getPaymentMethods();
	}
}
