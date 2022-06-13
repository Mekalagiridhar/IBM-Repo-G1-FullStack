/**
 * 
 */
package com.ibm.service;

import org.springframework.stereotype.Component;

import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;

/**
 * @author 003N75744
 *
 */
@Component
public interface AdminInterface {
	public boolean addCourse(String n, int id) throws CourseNotFound;
	public boolean removeCourse(int id) throws CourseNotFound;
	public boolean assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound;
	public boolean set_admin_approval(int name) throws StudentNotFound;
	public boolean addProfessor(String n, String name) throws ProfessorNotFound;
}
