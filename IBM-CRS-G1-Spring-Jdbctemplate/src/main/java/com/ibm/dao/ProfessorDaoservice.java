/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.bean.Course;
import com.ibm.bean.Student;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.CourseMapper;
import com.ibm.mapper.StudentMapper;

/**
 * @author 003N75744
 *
 */
@Repository
public class ProfessorDaoservice implements ProfessorDaointerface{
	Logger logger = LoggerFactory.getLogger(ProfessorDaoservice.class);
	 @Autowired
	    JDBCConfiguration jdbcConfiguration;
	 
	 
	 /*
	  * professor can view the course
	  * throws course not found exception
	  */
	@Override
	public List<Course> show_course() {
		// TODO Auto-generated method stub
		 String SQL = "select * from course";
		 List <Course> courses = jdbcConfiguration.jdbcTemplate().query(SQL, 
                 new CourseMapper());
         logger.debug("in debug");
		return courses;
	}

	
	/*
	 * professor can Enroll the students
	 * throws  no students enrolled Exception
	 */
	@Override
	public List<Student> enrolledStudents() {
		// TODO Auto-generated method stub
		String SQL="select * from student";
		List<Student> students=jdbcConfiguration.jdbcTemplate().query(SQL,new StudentMapper()); 
		logger.debug("in debug");
		return students;
	}

	
	/*
	 * professor can add the grades to the student
	 * throws student not found Exception
	 */
	@Override
	public boolean add_grade(int id, String grade) {
		// TODO Auto-generated method stub
		String SQL="UPDATE student set grade= ? WHERE id= ? ";
		 jdbcConfiguration.jdbcTemplate().update(SQL, grade, id);
	     // System.out.println("Updated Record with ID = " + id );
	      return true;
		
	}

}
