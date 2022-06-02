/**
 * 
 */
package com.crs.ibm.service;

import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.StudentCourseNotDletedException;
import com.crs.ibm.exception.StudentNotAddedException;

/**
 * @author 003N75744
 *
 */
public interface StudentInterface {
	public void coursereg()throws StudentNotAddedException;
	public void addcourse()throws MySQLIntegrityConstraintViolationException;
	public void dropcouse(int id) throws StudentCourseNotDletedException;
	public void grades();
	public void fee();
}
