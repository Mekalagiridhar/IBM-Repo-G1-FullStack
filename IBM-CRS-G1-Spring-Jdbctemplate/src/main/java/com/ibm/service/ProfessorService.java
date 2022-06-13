/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bean.Course;
import com.ibm.bean.Student;
import com.ibm.dao.ProfessorDaointerface;

/**
 * @author 003N75744
 *
 */
@Component
public class ProfessorService implements ProfessorInterface{
@Autowired
ProfessorDaointerface professordaointerface;



/*
 * professor can view the course
 * throws course not found exception
 */
	@Override
	public List<Course> show_courses() {
		// TODO Auto-generated method stub
		List<Course> cr=professordaointerface.show_course();
		return cr;
	}
	
	
	/*
	 * professor can Enroll the students
	 * throws  no students enrolled Exception
	 */

	@Override
	public List<Student> enrolledStudent() {
		// TODO Auto-generated method stub
		List<Student> st=professordaointerface.enrolledStudents();
		return st;
	}

	
	/*
	 * professor can add the grades to the student
	 * throws student not found Exception
	 */
	@Override
	public boolean add_grades(int id, String grade) {
		// TODO Auto-generated method stub
		boolean d=professordaointerface.add_grade(id,grade );
		return d;
	}

}
