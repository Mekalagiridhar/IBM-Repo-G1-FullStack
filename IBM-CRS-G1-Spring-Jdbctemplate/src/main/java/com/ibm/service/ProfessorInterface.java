/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.bean.Course;
import com.ibm.bean.Student;

/**
 * @author 003N75744
 *
 */
@Component
public interface ProfessorInterface {
	public List<Course> show_courses();
	public List<Student> enrolledStudent();
	public boolean add_grades(int id, String grade);
}
