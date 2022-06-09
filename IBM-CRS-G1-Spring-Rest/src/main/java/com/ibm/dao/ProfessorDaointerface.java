/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.bean.Professor;

/**
 * @author 003N75744
 *
 */
@Repository
public interface ProfessorDaointerface {
	public List<String> show_course();
	public List<String> enrolledStudents();
	public int add_grade(int id, String grade);
}
