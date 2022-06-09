/**
 * 
 */
package com.ibm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.ProfessorDaointerface;
import com.ibm.dao.ProfessorDaoservice;
import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;
import com.ibm.services.ProfessorInterface;

/**
 * @author 003N75744
 *
 */
@Service
public class ProfessorService implements ProfessorInterface{
	@Autowired
	ProfessorDaointerface pr;
	/**
	 * View Enrolled student from student table
	 * @throws StudentNotEnrolled
	 */
	public List<String> viewEnrolledStudents() throws StudentsNotEnrolled{
		try {
			List<String> v = pr.enrolledStudents();
		if (v.isEmpty()) {
			throw new StudentsNotEnrolled();
		}
		else
			return v;
		}catch(StudentsNotEnrolled s) {
		}
		return null;
	}
	/**
	 * Add Grades to Student in Student Table
	 * @param id
	 * @param name
	 * @param grade
	 * @throws StudentNotFound
	 */
	
	public boolean addGrades(int id, String grade) throws StudentNotFound{
		
		try {
			int v = pr.add_grade(id, grade);
		if (v == 0) {
			throw new StudentNotFound();
		}
		else
			return true; 
		}catch(StudentNotFound s) {
		}
		return false;
		
	}
	/**
	 * View Course details from Catalog table
	 */
	public List<String> viewCourse() {
		if (pr.show_course().isEmpty())
			return null;
		return pr.show_course();
		
	}
	
}
