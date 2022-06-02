/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class CourseAlreadyRegisteredException extends Exception {
	public  CourseAlreadyRegisteredException()
	 {
		 super("Course Already Registered Exception");
	 }
	 public CourseAlreadyRegisteredException(String message)
	 {
		 super(message);
	 }
}
