/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class UserNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFound() {
		super("User not found \n Try again.");
	}
	public UserNotFound(String message) {
		super(message);
	}

}
