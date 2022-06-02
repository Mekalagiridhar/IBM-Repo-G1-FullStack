/**
 * 
 */
package com.crs.ibm.dao;

import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.StudentCourseNotDletedException;
import com.crs.ibm.exception.StudentNotAddedException;

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
