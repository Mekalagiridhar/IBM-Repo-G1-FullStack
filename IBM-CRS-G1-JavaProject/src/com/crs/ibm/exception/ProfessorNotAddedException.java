/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class ProfessorNotAddedException extends Exception {
 public  ProfessorNotAddedException()
 {
	 System.out.println("Professor Not Added Exception");
 }
 public ProfessorNotAddedException(String message)
 {
	 super(message);
 }

}
