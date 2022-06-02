/**
 * 
 */
package com.lti.dao;

import com.lti.exception.CourseNotDeletedException;
import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.ProfessorNotAddedException;
import com.lti.exception.StudentNotFoundException;

/**
 * @author 003N75744
 *
 */
public interface AdminDaointerface {
	public void addcoursemain()throws MySQLIntegrityConstraintViolationException;
	public void removecoursemain()throws CourseNotDeletedException;
	public void studregappr()throws StudentNotFoundException ;
	public void addprofcou()throws ProfessorNotAddedException;
}
