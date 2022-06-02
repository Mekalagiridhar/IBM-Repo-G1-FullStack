/**
 * 
 */
package com.lti.services;

import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.StudentCourseNotDletedException;
import com.lti.exception.StudentNotAddedException;

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
