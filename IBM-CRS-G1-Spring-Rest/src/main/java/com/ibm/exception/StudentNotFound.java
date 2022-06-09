/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class StudentNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	
	public StudentNotFound() {
		super("Student not found \nTry again.");
	}
	public StudentNotFound(String message) {
		super(message);
	}

}
