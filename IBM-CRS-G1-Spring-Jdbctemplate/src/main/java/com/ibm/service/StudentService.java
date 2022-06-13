/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bean.Course;
import com.ibm.dao.StudentDaointerface;

/**
 * @author 003N75744
 *
 */
@Component
public class StudentService implements StudentInterface{
@Autowired
StudentDaointerface studentdaointerface;
	

/*
 * students can view the course
 * throws course not found exception
 */
	@Override
	public List<Course> show_courses() {
		// TODO Auto-generated method stub
		List<Course> cr=studentdaointerface.show_course();
		return cr;
	}

	
	/*
	 * Student can register to the courses
	 * throws student not approved Exception
	 */
	@Override
	public boolean registers(int id, int stusid, String c1, String c2, String c3, String c4) {
		// TODO Auto-generated method stub
		boolean a=studentdaointerface.register( id, stusid, c1, c2,  c3, c4);
		return a;
	}

	
	/*
	 * Student can delete the courses
	 * throws course not found Exception
	 */
	@Override
	public boolean delete_courses(int st_id) {
		// TODO Auto-generated method stub
		boolean d=studentdaointerface.delete_course(st_id);
		return d;
	}

	
	
	/*
	 * Student can add the course
	 * throws student not found Exception
	 * throws course not found Exception
	 */
	@Override
	public boolean add_courses(int stud_id, String course) {
		// TODO Auto-generated method stub
		boolean a=studentdaointerface.add_course(stud_id,course);
		return a;
	}

	
	/*
	 * Student can view the grades
	 * throws student not found Exception
	 */
	@Override
	public String view_reportCards(int id) {
		// TODO Auto-generated method stub
		String s=studentdaointerface.view_reportCard(id);
		return s;
	}

}
