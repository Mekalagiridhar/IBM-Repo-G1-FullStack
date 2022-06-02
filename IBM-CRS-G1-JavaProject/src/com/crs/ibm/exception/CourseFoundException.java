/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class CourseFoundException extends Exception{
	 private int courseid;
	   public  CourseFoundException(int courseid) {
		   this.courseid=courseid;
	   }
	   public int getcourseid()
	   {
		   return this.courseid;
	   }
	   public String getMessage()
	    {
		   return "course already in the catalog"+courseid;
		   }

}
