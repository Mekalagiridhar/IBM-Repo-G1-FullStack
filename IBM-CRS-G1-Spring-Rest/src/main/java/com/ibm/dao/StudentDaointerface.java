/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.bean.Courses;


/**
 * @author 003N75744
 *
 */
@Repository
public interface StudentDaointerface {
	public List<String> register(int id, String c1, String c2, String c3, String c4);
	public int delete_course(int st_id,String crs_id);
	public int add_course(int stud_id, String course);
	public int check_st_id(int stud_id,String course);
	public List<String> viewCourses(int id);
	public int pay_fee(int id, int amount,  String pay_type); 
	public String view_reportCard(int id);
	public int check_approval(String u_name);
	public List<String> update_already_registered_course(int st_id, String course_name, String new_course);
}
