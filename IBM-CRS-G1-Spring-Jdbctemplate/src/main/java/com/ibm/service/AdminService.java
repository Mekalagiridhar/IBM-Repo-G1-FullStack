/**
 * 
 */
package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.dao.AdminDaointerface;
import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;

/**
 * @author 003N75744
 *
 */
@Component
public class AdminService implements AdminInterface {
	@Autowired
	AdminDaointerface ad;
	
	
	/**
	 * Add Course to Course Table
	 * @param course
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public boolean addCourse(String course, int id) throws CourseNotFound{
		try {
			ad.addCourse(course, id);
			ad.addCourse_to_catalog(course, id);
		if (course == null && id == 0) {
			throw new CourseNotFound();
		}
		else
			return true;
		}catch(CourseNotFound c) {
		return false;
	}
	}
	
	
	/**
	 * Delete Course to Course Table
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public boolean removeCourse(int id) throws CourseNotFound {
		try {
			int v = ad.deleteCourse(id);
			ad.deleteCourse_from_catalog(id);
		if (id == 0 || v == 0) {
			throw new CourseNotFound();
		   }
		else
			return true;
		}catch(CourseNotFound c) {
		}
		return false;
	}
	/**
	 * Assign Course to Professors 
	 * @param p_id
	 * @param c_id
	 * @throws ProfessorNotFound
	 */
	
	public boolean assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound {
		int v = ad.assign(p_id, c_id);
		if (v == 1) {
			return true;
		}
		else if( v== 0) {
			return false;
		}
		else
			return true;
	}
	/**
	 * Approve Student by Admin 
	 * @param id
	 * @throws StudentNotFound
	 */
	
	public boolean set_admin_approval(int id) throws StudentNotFound {
		try {
		int v = ad.set_stud_approval(id);
		if (id == 0 || v == 0) {
			throw new StudentNotFound();
		}
		else
			return true;
	}catch(StudentNotFound e) {
		return false;
	}
		
		/**
		 * Add Professor by admin into professor table 
		 * @param prof_id
		 * @param prof_name
		 * @throws StudentNotFound
		 */
	}
	public boolean addProfessor(String prof_id,String prof_name) throws ProfessorNotFound{
		try {
		     int v = ad.addProfessor(prof_id, prof_name);
		if (prof_id == null || v == 0) {
			throw new ProfessorNotFound();
		}
		else
			return true;
	}catch(ProfessorNotFound e) {
	}
		return false;
	}
}
