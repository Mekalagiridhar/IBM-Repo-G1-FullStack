/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class ProfessorNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;
	public ProfessorNotFound() {
		super("Professor Not Found\nTry again.");
	}
	public ProfessorNotFound(String message) {
		super(message);
	}
}
