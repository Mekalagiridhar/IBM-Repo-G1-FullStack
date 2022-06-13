/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class StudenNotApproved extends Exception{
	private static final long serialVersionUID = 1L;

	public StudenNotApproved() {
		super("Student has not been approved.\n");
	}
	public StudenNotApproved(String message) {
		super(message);	
	}
}
