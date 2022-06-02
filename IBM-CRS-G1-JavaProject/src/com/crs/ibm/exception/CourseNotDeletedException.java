/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class CourseNotDeletedException extends Exception{
	public  CourseNotDeletedException()
	 {
		 super("course Not Added Exception");
	 }
	 public CourseNotDeletedException(String message)
	 {
		 super(message);
	 }
}
