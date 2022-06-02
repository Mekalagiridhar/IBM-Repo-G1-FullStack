/**
 * 
 */
package com.crs.ibm.application;

import java.util.Scanner;

import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.CourseNotDeletedException;
import com.crs.ibm.exception.ProfessorNotAddedException;
import com.crs.ibm.exception.StudentCourseNotDletedException;
import com.crs.ibm.exception.StudentNotAddedException;
import com.crs.ibm.exception.StudentNotFoundException;
import com.crs.ibm.service.AdminInterface;
import com.crs.ibm.service.AdminService;
import com.crs.ibm.service.ProfessorInterface;
import com.crs.ibm.service.ProfessorService;
import com.crs.ibm.service.StudentInterface;
import com.crs.ibm.service.StudentService;
import com.crs.ibm.service.UserInterface;
import com.crs.ibm.service.Userservice;

/**
 * @author 003N75744
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// UserInterface u=new Userservice();
		AdminInterface a=new AdminService();
		ProfessorInterface p=new ProfessorService();
		StudentInterface s=new StudentService();
		Scanner sc=new Scanner(System.in);
		
		int v=1;
		while(v==1)
		{  UserInterface u=new Userservice();
			System.out.println("welcome to crsapplication");
			System.out.println("1: Login  ");
			System.out.println("2: New registration");
			System.out.println("3: Exit");
			int l=sc.nextInt();
	   switch(l)
	   {
	   case 1: //here student , professor and admin can login using their id
		   u.portal();
		  // u.newuser();
		   break;
	   case 2:// you can get id and password here
		   u.newuser();
		 //  u.portal();
		try {
			a.studreg();
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   break;
	   default:
		   System.out.println("You are exit from CRSapplication ");
		   System.exit(l);
		   break;
	   }
	   System.out.println("1: CRS application page");
       v=sc.nextInt();
		}
		System.out.println("Choose the profession");
		System.out.println("1: Student");
		System.out.println("2: Professor");
		System.out.println("3: Admin");
		//int ou;
		//ou=v;
		int ou=sc.nextInt();
		switch(ou) 
		{
		case 1:
		       int k=0;
		       while(k==0)
		       {
		    	   System.out.println("Student portal");			   
			       System.out.println("Choose the reqired details");
			       System.out.println("4: Course registration");
			       System.out.println("5: Adding the course");
			       System.out.println("6: Droping the course");
			       System.out.println("7: View the grades of your course");
	               System.out.println("8: Checking the fee details");
			       int f=sc.nextInt();
		       switch(f)
		       {
		       case 4: // student can register for course  
		    	   try {
					s.coursereg();
				       } catch (StudentNotAddedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       break;
		       case 5: // student can add the course 
		    	   try {
					s.addcourse();
				} catch (MySQLIntegrityConstraintViolationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       break;
		       case 6:// student can drop the course 
		    	   try {
					s.dropcouse(2);
				} catch (StudentCourseNotDletedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       break;
		       case 7: // student can  view the grades
		    	   s.grades();
		       break;
		       case 8://student can view the fee details for payment
		    	   s.fee();
		       break;
		       default:
			   System.out.println("Choose the valid section");
			   break;
		       }
		       System.out.println("0: To change anything in students");
		       k=sc.nextInt();
		       }
		   break;
		case 2:int i=0;
		       while(i==0)
		       {
			   System.out.println(" Professor menu");		
			   System.out.println("Choose the required details");
		       System.out.println(" 9:  Adding grades for students ");
		       System.out.println(" 10: Student enrollment");
		       int g=sc.nextInt();
		       switch(g)
		       {
		       case 9:// Here proffesor can add a grade to the student
		    	   p.addgrades();
		       break;
		       case 10:// Here professor can check the student enrollment of course
		    	   p.studentenroll();
		       break;
		       default:
		    	   System.out.println(" Choose the valid selection");
		    	   break;
		       }
		       System.out.println("0:To add the course");
		       i=sc.nextInt();
		       }
		       break;
		    
		 case 3:int c=0;
		        while(c==0)
		        {
			    System.out.println("Admin menu");		
			    System.out.println("Choose the require details");
                System.out.println("12: Creating the report card for student");
                System.out.println("13: Adding professor course and details");
                System.out.println("14: Approving student registration");
                System.out.println("15: Adding course in college portal");
                System.out.println("16: Removing the courses in the portal");
                int h=sc.nextInt();
                switch(h)
                {
                case 12:// here admin can gnerate the report card for students
                	a.genreportcard();
                break;
                case 13:// here admin can add the professor to the particular courses
                	try {
						a.addprof();
					} catch (ProfessorNotAddedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
                break;
                case 14:// here admin can approve the student registration for courses
                	try {
						a.studreg();
					} catch (StudentNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                break;
                case 15://here admin can add the new courses in college portal
                	try {
						a.courseadd();
					} catch (MySQLIntegrityConstraintViolationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                break;
                case 16://here admin can remove the courses in college portal
                	try {
						a.courserem();
					} catch (CourseNotDeletedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                break;
                default:
                	System.out.println("Enter valid selection");
                    break;
                }
                System.out.println("0:To make changes in admin");
                c=sc.nextInt();
		        }
		        break;
		}
		
    
     
     
	}

}
