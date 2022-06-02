/**
 * 
 */
package com.lti.dao;

import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.StudentCourseNotDletedException;
import com.lti.exception.StudentNotAddedException;

/**
 * @author 003N75744
 *
 */
public interface StudentDaointerface {
	public void addstudents(int studentid,String studname,String gender,int courseid,String grades,int fees)throws StudentNotAddedException;
	public void deletecourse(int studentid)throws StudentCourseNotDletedException;
	public void viewgrades();
	public void viewfee();
    public void addcourses()throws MySQLIntegrityConstraintViolationException;
}
