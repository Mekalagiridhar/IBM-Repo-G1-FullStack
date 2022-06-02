package com.crs.ibm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.crs.ibm.dao.StudentDaointerface;
import com.crs.ibm.dao.StudentDaoservice;
import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.StudentCourseNotDletedException;
import com.crs.ibm.exception.StudentNotAddedException;

public class StudentService implements StudentInterface {
	StudentDaointerface sd = new StudentDaoservice();

	Scanner s = new Scanner(System.in);
	List<String> a = new ArrayList<String>();

	
	public void coursereg() throws StudentNotAddedException {
		  Scanner d=new Scanner(System.in);
		  System.out.println("Enter studentid");
		  int studentid=d.nextInt();
		  System.out.println("Enter student name");
	      String studname=d.nextLine();
	      System.out.println("Enter gender");
	      String gender=d.nextLine();
	      System.out.println("Enter course id");
	      int courseid=d.nextInt();
	     
	      String grades="A";
	    
	      int fees=20000;
		try {
			sd.addstudents(studentid,studname,gender,courseid,grades,fees);
		} catch (StudentNotAddedException e) {

		}
	}

	/*
	 * students can add the courses
	 * throw course not added exception
	 */
	public void addcourse()throws MySQLIntegrityConstraintViolationException {
		try
		{
		sd.addcourses();
		}
		catch(MySQLIntegrityConstraintViolationException e)
		{
			
		}
		
	}

	/*
	 * student can drop the courses
	 *  throw student course not deleted exception
	 */
	public void dropcouse(int id) throws StudentCourseNotDletedException {
		try {
			sd.deletecourse(id);
		} 
		catch (StudentCourseNotDletedException e) {

		}

	}

	/*
	 * students can view the grades
	 */
	public void grades() {
		// student can view the grades
		System.out.println("student can  view the grades");
		sd.viewgrades();

	}
	/*
	 * student can view the fee details 
	 * student can pay the fee
	 */

	public void fee() {
		// student can view the fee details for payment
		System.out.println("student can view the fee details for payment");
		// System.out.println(" total fee is 30000");
		sd.viewfee();
		System.out.println("select your payment method");
		System.out.println("1.paytm");
		System.out.println("2.phonepay");
		System.out.println("3.netbanking");
		int x = s.nextInt();
		switch (x) {
		case 1:
			System.out.println("you have selected paytm method");
			System.out.println("enter yes to start the payment");
			String o = s.nextLine();
			System.out.println("your payment is successfull");
			break;
		case 2:
			System.out.println("you have selected phonepay method");
			System.out.println("enter yes to start the payment");
			String p = s.nextLine();
			System.out.println("your payment is successfull");
			break;
		case 3:
			System.out.println("you have selected netbanking method");
			System.out.println("enter yes to start the payment");
			String q = s.nextLine();
			System.out.println("your payment is successfull");
			break;
		default:
			System.out.println("select right payment method");
			break;
		}
	}
}
