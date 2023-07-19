package com.premium.premiummanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.premium.premiummanagement.entity.PremiumPayments;
import com.premium.premiummanagement.service.PremiumPaymentsService;

@RestController
@RequestMapping("/api")
public class PremiumPaymentsController {
	
	@Autowired
	private PremiumPaymentsService premiumPaymentsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/premium")
	public void addPremiumPayments(@RequestBody PremiumPayments premiumPayments) {
		premiumPaymentsService.addPremiumPayments(premiumPayments);
	}
	
	@RequestMapping("/premium/calculatelatefee")
	public void lateFee(PremiumPayments premiumPayments) {
		premiumPaymentsService.calculateLateFee(premiumPayments);
	}
}
