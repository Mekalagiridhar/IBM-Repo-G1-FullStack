/**
 * 
 */
package com.ibm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author 003N75744
 *
 */
@Repository
public interface AdminDaointerface {
	public void addCourse(String course, int id);
	public int deleteCourse(int id);
	public int addProfessor(String prof_id,String prof_name);
	public int set_stud_approval(int  name);
	public int assign(int p_id ,int c_id );
	public void addCourse_to_catalog(String course, int id);
	public void deleteCourse_from_catalog(int id);
}
