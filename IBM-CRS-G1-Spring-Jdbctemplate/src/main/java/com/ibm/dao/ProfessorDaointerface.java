/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.bean.Course;
import com.ibm.bean.Student;

/**
 * @author 003N75744
 *
 */
@Repository
public interface ProfessorDaointerface {
	public List<Course> show_course();
	public List<Student> enrolledStudents();
	public boolean add_grade(int id, String grade);
}
