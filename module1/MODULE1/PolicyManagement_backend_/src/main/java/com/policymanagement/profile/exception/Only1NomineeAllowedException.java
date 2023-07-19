package com.policymanagement.profile.exception;

public class Only1NomineeAllowedException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Only1NomineeAllowedException(String message) {
        super(message);
    }

}
