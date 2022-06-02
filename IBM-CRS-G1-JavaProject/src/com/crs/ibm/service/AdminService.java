/**
 * 
 */
package com.crs.ibm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.dao.AdminDaointerface;
import com.crs.ibm.dao.AdminDaoservice;
import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.CourseNotDeletedException;
import com.crs.ibm.exception.ProfessorNotAddedException;
import com.crs.ibm.exception.StudentNotFoundException;

/**
 * @author 003N75744
 *
 */
public class AdminService implements AdminInterface{
	AdminDaointerface ad=new AdminDaoservice();
	Scanner s=new Scanner(System.in);
	List a=new ArrayList();
	/*
	 * admin genrating reportcards
	 * throw report cards not genrated
	 */
	public void genreportcard() 
	{
		// here admin can gnerate the report card for students
		System.out.println("here admin can generate the report card for students");
		System.out.println("enter student id for generating the report card");
		int k=s.nextInt();
		System.out.println("giridhar reddy");
		System.out.println("cse");
		System.out.println("java   A");
		System.out.println("c      B");
		System.out.println("opps   A");
		System.out.println("pythan  B");
		
	}
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
