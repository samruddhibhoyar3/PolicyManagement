package com.Claimsmanagement.ClaimsmanagementApplication.Exception;

public class ClaimentDetailException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public ClaimentDetailException() {
		super("user name and claimant name are same."
				+ "policy cannot be claimed since claimtype is death.Hence claimant information is required");
	}
}
