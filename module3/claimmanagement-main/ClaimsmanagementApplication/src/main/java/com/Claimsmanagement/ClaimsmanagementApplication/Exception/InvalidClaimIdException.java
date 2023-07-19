package com.Claimsmanagement.ClaimsmanagementApplication.Exception;

public class InvalidClaimIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidClaimIdException() {
		super("invalid claimtype id");
	}

}
