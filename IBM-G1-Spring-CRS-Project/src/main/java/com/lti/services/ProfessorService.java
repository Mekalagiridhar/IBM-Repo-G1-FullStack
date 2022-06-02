/**
 * 
 */
package com.lti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.dao.ProfessorDaointerface;
import com.lti.dao.ProfessorDaoservice;
import com.lti.services.ProfessorInterface;

/**
 * @author 003N75744
 *
 */
public class ProfessorService implements ProfessorInterface {
	ProfessorDaointerface pd=new ProfessorDaoservice();
	Scanner s=new Scanner(System.in);
	List a=new ArrayList();
	List c=new ArrayList();
	/*
	 * professor adding grades to the students
	 */
	public void addgrades()
	{pd.adgrades();
		
		
	}
	/*
	 * professor enrolling the student for the courses
	 */
	public void studentenroll()
	{
		// Here professor can check the student details of course

     pd.getenrolledstudent();
	}
	

}
