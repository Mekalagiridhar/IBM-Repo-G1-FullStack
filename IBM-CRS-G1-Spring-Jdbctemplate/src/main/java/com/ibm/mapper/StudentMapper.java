/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Student;

/**
 * @author 003N75744
 *
 */
public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student students=new Student();
		students.setStudentid(rs.getInt("id"));
		students.setStudname(rs.getString("stud_name"));
		students.setAddress(rs.getString("address"));
		students.setEmail(rs.getString("email"));
		students.setGrades(rs.getString("grade"));
		students.setApproval(rs.getInt("admin_approval"));
		return students;
	}

}
