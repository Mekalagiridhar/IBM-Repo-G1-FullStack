/**
 * 
 */
package com.crs.ibm.dao;

import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.CourseNotDeletedException;
import com.crs.ibm.exception.ProfessorNotAddedException;
import com.crs.ibm.exception.StudentNotFoundException;

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
