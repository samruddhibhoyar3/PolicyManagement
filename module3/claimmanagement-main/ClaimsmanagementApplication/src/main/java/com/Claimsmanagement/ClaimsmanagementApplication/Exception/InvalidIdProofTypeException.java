package com.Claimsmanagement.ClaimsmanagementApplication.Exception;


public class InvalidIdProofTypeException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public InvalidIdProofTypeException() {
		super("invalid id proof type");
	}
}
