/**
 * 
 */
package com.lti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.dao.StudentDaointerface;
import com.lti.dao.StudentDaoservice;
import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.StudentCourseNotDletedException;
import com.lti.exception.StudentNotAddedException;
import com.lti.services.StudentInterface;

/**
 * @author 003N75744
 *
 */
public class StudentService implements StudentInterface{
	StudentDaointerface sd = new StudentDaoservice();

	Scanner s = new Scanner(System.in);
	List<String> a = new ArrayList<String>();

	
	public void coursereg() throws StudentNotAddedException {
		  Scanner d=new Scanner(System.in);
		  System.out.println("Enter studentid");
		  int studentid=d.nextInt();
		  System.out.println("Enter student name");
	      String studname=d.next();
	      System.out.println("Enter gender");
	      String gender=d.next();
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
			System.out.println("Enetr account number");
			int j=s.nextInt();
			System.out.println("enter yes to start the payment");
			String o = s.next();
			System.out.println("your payment is successfull");
			break;
		case 2:
			System.out.println("you have selected phonepay method");
			System.out.println("Enter account number");
			int y=s.nextInt();
			System.out.println("enter yes to start the payment");
			String p = s.next();
			System.out.println("your payment is successfull");
			break;
		case 3:
			System.out.println("you have selected netbanking method");
			System.out.println("Enter account number");
			int w=s.nextInt();
			System.out.println("enter yes to start the payment");
			String q = s.next();
			System.out.println("your payment is successfull");
			break;
		default:
			System.out.println("select right payment method");
			break;
		}
	}
}
