package com.ibm.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lti.services.UserInterface;
import com.lti.services.UserService;
import com.lti.exception.CourseNotDeletedException;
import com.lti.exception.MySQLIntegrityConstraintViolationException;
import com.lti.exception.ProfessorNotAddedException;
import com.lti.exception.StudentCourseNotDletedException;
import com.lti.exception.StudentNotAddedException;
import com.lti.exception.StudentNotFoundException;
import com.lti.configuration.AppConfig;
import com.lti.services.AdminInterface;
import com.lti.services.ProfessorInterface;
import com.lti.services.StudentInterface;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@Import((AppConfig.class))
public class LtiCrsSpringCoreProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LtiCrsSpringCoreProjectApplication.class, args);
		ApplicationContext context=SpringApplication.run(AppConfig.class);
		AdminInterface a=(AdminInterface) context.getBean("AdminBean");
		ProfessorInterface p=(ProfessorInterface) context.getBean("ProfessorBean");
		StudentInterface s=(StudentInterface) context.getBean("StudentBean");
Scanner sc=new Scanner(System.in);
		
		int v=1;
		while(v==1)
		{  UserInterface u=(UserInterface) context.getBean("UserBean");;
			System.out.println("welcome to crsapplication");
			LocalDate localdate=LocalDate.now();
			LocalTime localtime=LocalTime.now();
			System.out.println("Current Date :"+localdate+ "\tTime of login:\t"+localtime);
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
                //System.out.println("12: Creating the report card for student");
                System.out.println("13: Adding professor course and details");
                System.out.println("14: Approving student registration");
                System.out.println("15: Adding course in college portal");
                System.out.println("16: Removing the courses in the portal");
                int h=sc.nextInt();
                switch(h)
                {
               
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


