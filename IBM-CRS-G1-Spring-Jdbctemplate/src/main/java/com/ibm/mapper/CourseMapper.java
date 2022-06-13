/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Course;


/**
 * @author 003N75744
 *
 */
public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Course course = new Course();
		  course.setCourseid(rs.getInt("course_id"));
		  course.setCoursename(rs.getString("course_name"));
		  
		return course;
	}

}
