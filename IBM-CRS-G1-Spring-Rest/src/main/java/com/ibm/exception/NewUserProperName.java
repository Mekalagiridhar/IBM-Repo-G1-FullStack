/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class NewUserProperName extends Exception{
	private static final long serialVersionUID = 1L;

	public NewUserProperName() {
		super("User name and password can not be null");
	}
	public NewUserProperName(String message) {
		super(message);
	}
}
