/**
 * 
 */
package com.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class CourseNotFound extends Exception{
private static final long serialVersionUID = 1L;
	
	public CourseNotFound() {
		super("Course not found \nTry again.");
	}
	public CourseNotFound(String message) {
		super(message);
	}
}
