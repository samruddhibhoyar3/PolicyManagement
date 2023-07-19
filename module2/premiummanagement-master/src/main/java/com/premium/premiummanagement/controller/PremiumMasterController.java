package com.premium.premiummanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premium.premiummanagement.entity.PremiumsMaster;
import com.premium.premiummanagement.service.PremiumMasterService;

@RestController
@RequestMapping("/api/premium")
public class PremiumMasterController {
	
	@Autowired
	private PremiumMasterService premiumMasterService;
	
	@RequestMapping("/{param}/history")
	public PremiumsMaster getList(@PathVariable String param) {
	    if (isString(param)) {
	        return getListByUsername(param);
	    } else if (isInteger(param)) {
	        int subscriptionId = Integer.parseInt(param);
	        return getListBySubscriptionId(subscriptionId);
	    } else {
	        // Handle invalid input
	        throw new IllegalArgumentException("Invalid parameter: " + param);
	    }
	}

	private boolean isString(String param) {
	    return param.matches("[a-zA-Z]+");
	}

	private boolean isInteger(String param) {
	    try {
	        Integer.parseInt(param);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	private PremiumsMaster getListByUsername(String username) {
	    return premiumMasterService.getListUsername(username);
	}

	private PremiumsMaster getListBySubscriptionId(int subscriptionId) {
	    return premiumMasterService.getListSubscriptionId(subscriptionId);
	}

	
	@GetMapping("/dues")
    public List<PremiumsMaster> getPaymentsBefore9thDate() {
        return premiumMasterService.getPaymentsBefore9thDate();
    }
}
