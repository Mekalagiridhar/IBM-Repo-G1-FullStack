/**
 * 
 */
package com.ibm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.ibm.services.AdminInterface;
import com.ibm.application.IbmCrsGroupSpringRestApplication;
import com.ibm.dao.AdminDaointerface;
import com.ibm.dao.AdminDaoservice;
import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;

/**
 * @author 003N75744
 *
 */
@Service
public class AdminService implements AdminInterface {
AdminDaointerface ad = new AdminDaoservice();
	
	
	/**
	 * Add Course to Course Table
	 * @param course
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public List<String> addCourse(String course, int id) throws CourseNotFound{
		try {
	List<String> v=ad.addCourse(course, id);
	List<String> r=ad.addCourse_to_catalog(course, id);
			//IbmCrsGroupSpringRestApplication.main(null);
			
		if (course == null && id == 0) {
			throw new CourseNotFound();
		}
		if (v.isEmpty()&&r.isEmpty()) {
			return null;
	        }
		return v;
		
		}catch(CourseNotFound c) {
		System.out.println(c.getMessage());
	}
		return null;
	
	}
	
	
	/**
	 * Delete Course to Course Table
	 * @param id
	 * @throws CourseNotFound
	 */
	
	public boolean removeCourse(int id) throws CourseNotFound {
		
			int v = ad.deleteCourse(id);
			ad.deleteCourse_from_catalog(id);
			if (v == 0) 
				return false;
			return true;
			
	}
	/**
	 * Assign Course to Professors 
	 * @param p_id
	 * @param c_id
	 * @throws ProfessorNotFound
	 */
	
	public boolean assignCourseProfessor(int p_id ,int c_id ) throws ProfessorNotFound {
		
		int v = ad.assign_crs_to_Professor(p_id, c_id);
		if (v == 1) {
			ad.assign(p_id, c_id);
			//System.out.println("Professor ID " + p_id + " has been assigned to " + c_id);
		}
		else
		{
			return false;
		}
		return true;
		
	}
	/**
	 * Approve Student by Admin 
	 * @param id
	 * @throws StudentNotFound
	 */
	
	public boolean set_admin_approval(int id) throws StudentNotFound {
		
		int v = ad.set_stud_approval(id);
		if (v == 0) 
			return false;
		return true;
			
		
		
		/**
		 * Add Professor by admin into professor table 
		 * @param prof_id
		 * @param prof_name
		 * @throws StudentNotFound
		 */
	}
	public void addProfessor(int prof_id,String prof_name) throws ProfessorNotFound{
		try {
		     int v = ad.addProfessor(prof_id, prof_name);
		if (prof_id == 0 || v == 0) {
			throw new ProfessorNotFound("Professor Not Found");
		}
	}catch(ProfessorNotFound e) {
		System.out.println(e.getMessage());
	}

	}
}
