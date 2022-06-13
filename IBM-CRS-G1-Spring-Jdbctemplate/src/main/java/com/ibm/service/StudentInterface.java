/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.bean.Course;

/**
 * @author 003N75744
 *
 */
@Component
public interface StudentInterface {
	public List<Course> show_courses();
	public boolean registers(int id,int stusid, String c1, String c2, String c3, String c4);
	public boolean delete_courses(int st_id);
	public boolean add_courses(int stud_id, String course);
	public String view_reportCards(int id);
}
