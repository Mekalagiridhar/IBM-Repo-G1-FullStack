/**
 * 
 */
package com.ibm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;

/**
 * @author 003N75744
 *
 */
@Service
public interface AdminInterface {
	public List<String> addCourse(String n, int id) throws CourseNotFound;
	public boolean removeCourse(int id) throws CourseNotFound;
	public boolean assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound;
	public boolean set_admin_approval(int name) throws StudentNotFound;
	public void addProfessor(int n, String name) throws ProfessorNotFound;
}
