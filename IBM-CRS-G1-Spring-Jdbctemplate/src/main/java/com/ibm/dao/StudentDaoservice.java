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
import com.ibm.bean.Courseregistraion;
import com.ibm.bean.Student;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.mapper.CourseMapper;
import com.ibm.mapper.StudentMapper;

/**
 * @author 003N75744
 *
 */
@Repository
public class StudentDaoservice implements StudentDaointerface{
	Logger logger = LoggerFactory.getLogger(ProfessorDaoservice.class);
	 @Autowired
	    JDBCConfiguration jdbcConfiguration;
	 
	 
	 /*
		 * students can view the course
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
	 * Student can register to the courses
	 * throws student not approved Exception
	 */
	@Override
	public boolean register(int id,int studid, String c1, String c2, String c3, String c4) {
		// TODO Auto-generated method stub
		String SQL = "insert into courseregister (register_id,stud_id,course1,course2,course3,course4) values (?, ?,?,?,?,?)";
	      
		jdbcConfiguration.jdbcTemplate().update( SQL, id,studid,c1,c2,c3,c4);
	// System.out.println("Created Record Name = " + name + " Age = " + age);
		return true;
	}
	
	
	/*
	 * Student can add the course
	 * throws student not found Exception
	 * throws course not found Exception
	 */
	@Override
	public boolean add_course(int stud_id, String course) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE courseregister set course5 = ? WHERE stud_id = ?";
	      
		jdbcConfiguration.jdbcTemplate().update( SQL, course,stud_id);
		return true;
	}
	
	
	/*
	 * Student can delete the courses
	 * throws course not found Exception
	 */
	@Override
	public boolean delete_course(int st_id) {
		// TODO Auto-generated method stub
		String SQL ="UPDATE courseregister set course5 = null WHERE stud_id = ?";
		jdbcConfiguration.jdbcTemplate().update( SQL, st_id);
		return true;
	}
	
	/*
	 * Student can view the grades
	 * throws student not found Exception
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String view_reportCard(int id) {
		// TODO Auto-generated method stub
		String s="";
		String SQL="select * from student where id=?";
		@SuppressWarnings({ "unchecked", "deprecation" })
		Student students=  jdbcConfiguration.jdbcTemplate().queryForObject(SQL,new Object[]{id}, new StudentMapper());
	     s+=students.getGrades();
		return s;
	}
}
