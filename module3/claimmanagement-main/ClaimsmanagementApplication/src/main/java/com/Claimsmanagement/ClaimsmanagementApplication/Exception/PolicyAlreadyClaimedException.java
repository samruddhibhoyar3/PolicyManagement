package com.Claimsmanagement.ClaimsmanagementApplication.Exception;

public class PolicyAlreadyClaimedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PolicyAlreadyClaimedException() {
		super("Policy already claimed.");
	}

}
