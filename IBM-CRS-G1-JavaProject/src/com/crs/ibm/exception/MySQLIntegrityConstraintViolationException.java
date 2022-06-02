/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003N75744
 *
 */
public class MySQLIntegrityConstraintViolationException extends Exception{
	public  MySQLIntegrityConstraintViolationException()
	 {
		 System.out.println("course Not Added Exception");
	 }
	 public MySQLIntegrityConstraintViolationException(String message)
	 {
		 super(message);
	 }
}
