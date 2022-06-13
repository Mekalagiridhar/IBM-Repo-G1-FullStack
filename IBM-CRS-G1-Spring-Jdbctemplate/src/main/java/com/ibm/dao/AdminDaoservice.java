/**
 * 
 */
package com.ibm.dao;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.configuration.JDBCConfiguration;
import com.ibm.constant.SQLQueryConstant;



/**
 * @author 003N75744
 *
 */
@Repository
public class AdminDaoservice implements AdminDaointerface{
	Logger logger = LoggerFactory.getLogger(AdminDaoservice.class);

    @Autowired
    JDBCConfiguration jdbcConfiguration;
		/*
		 * Add Courses in Course Table
		 * @param course
		 * @param id
		 */
	public void addCourse(String course, int id) {
		
		String SQL = SQLQueryConstant.ADD_COURSE;
		jdbcConfiguration.jdbcTemplate().update(SQL, id,course);
	}
	/*
	 * Add Courses details to Catalog Table
	 * @param course
	 * @param id
	 */
	public void addCourse_to_catalog(String course, int id) {
				int mn = 600;
				int mx = 700;
				Random ran = new Random();
				int x = ran.nextInt(mx) + mn;
				
				
				String SQL = SQLQueryConstant.ADD_COURSE_TO_CATALOG;
				jdbcConfiguration.jdbcTemplate().update(SQL, x, id, course, "Engineering", 1);

	}
	/*
	 * Delete Courses details to Catalog Table
	 * @param course
	 * @param id
	 */
	
   public void deleteCourse_from_catalog(int id) {
	   
		String SQL = SQLQueryConstant.DELETE_COURSE_TO_CATALOG;
		jdbcConfiguration.jdbcTemplate().update(SQL, id);

}

	   
	/*
	 * Delete Courses in Course Table
	 * @param crs_id
	 */
	
	public int deleteCourse(int crs_id) {
		String SQL = SQLQueryConstant.DELETE_COURSE;
		jdbcConfiguration.jdbcTemplate().update(SQL, crs_id);
		return 1;
	}

	/*
	 * Add Professor in Professor Table
	 * @param course
	 * @param id
	 */

	public int addProfessor(String pf_id,String us_name) {
			int mn = 120;
			int mx = 130;
			Random ran = new Random();
			int x = ran.nextInt(mx) + mn;
			
			String SQL = SQLQueryConstant.ADD_PROFESSOR;
			jdbcConfiguration.jdbcTemplate().update(SQL, us_name, "India", null, x, null);
			return 1;
	}
	


	/*
	 * Assign Course to Professors
	 * @param course
	 * @param id
	 */
	public int assign(int p_id ,int c_id ) {
		
		String SQL = SQLQueryConstant.ASSIGN_COURSE_PROFESSOR;
		jdbcConfiguration.jdbcTemplate().update(SQL, c_id, p_id);
		return 1;
	}

		
	/*
	 * Approve Student
	 * @param id
	 */
	public int set_stud_approval(int id) {
			
		String SQL = SQLQueryConstant.SET_STUDENT_APPROVAL;
		jdbcConfiguration.jdbcTemplate().update(SQL, 1, id);
		return 1;
	}
}
