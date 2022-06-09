/**
 * 
 */
package com.ibm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;

/**
 * @author 003N75744
 *
 */
@Service
public interface ProfessorInterface {
	public List<String> viewEnrolledStudents() throws StudentsNotEnrolled;
	public boolean  addGrades(int id, String grade) throws StudentNotFound;
	public List<String> viewCourse();
}
