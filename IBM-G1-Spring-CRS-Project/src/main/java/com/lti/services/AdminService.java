/**
 * 
 */
package com.lti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.exception.CourseNotDeletedException;
import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.ProfessorNotAddedException;
import com.lti.exception.StudentNotFoundException;
import com.lti.dao.AdminDaointerface;
import com.lti.dao.AdminDaoservice;
import com.lti.services.AdminInterface;

/**
 * @author 003N75744
 *
 */
public class AdminService  implements AdminInterface {
	AdminDaointerface ad=new AdminDaoservice();
	Scanner s=new Scanner(System.in);
	List a=new ArrayList();
	/*
	 * adding professor
	 * throw professornotadded exception
	 */
	
	public void addprof()throws ProfessorNotAddedException 
	{try
	{
		ad.addprofcou();
	}
	catch(ProfessorNotAddedException e)
	{
   //throw e;
	}
	
	}
	/*
	 * student approval registration
	 * throw studentnot approval exception
	 */
	public void studreg()throws StudentNotFoundException 
	{try
	{
		ad.studregappr();
	}
	catch(StudentNotFoundException e)
	{
		
	}
	}
	/*
	 * adding course in the catalog
	 * throw coursenotaddedexception
	 */
	public void courseadd() throws MySQLIntegrityConstraintViolationException
	{try
	{
		ad.addcoursemain();
	}
	catch(MySQLIntegrityConstraintViolationException e)
	{System.out.println("course not added exception");
		
		
	}
	}
	/*
	 * deleting course in the catalog
	 * throw coursenotdeletedexception
	 */
	public void courserem()throws CourseNotDeletedException 
	{try
	{
		ad.removecoursemain();
	}
	catch(CourseNotDeletedException e)
	{System.out.println(" Course  Not  Deleted  Exception");
		
	}
	}

}
