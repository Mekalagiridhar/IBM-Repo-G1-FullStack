/**
 * 
 */
package com.crs.ibm.service;

import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.CourseNotDeletedException;
import com.crs.ibm.exception.ProfessorNotAddedException;
import com.crs.ibm.exception.StudentNotFoundException;

/**
 * @author 003N75744
 *
 */
public interface AdminInterface {
	public void genreportcard();
	public void addprof() throws ProfessorNotAddedException;
	public void studreg()throws StudentNotFoundException ;
	public void courseadd()throws MySQLIntegrityConstraintViolationException;
	public void courserem()throws CourseNotDeletedException;
}
