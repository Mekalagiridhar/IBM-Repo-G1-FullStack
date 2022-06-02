/**
 * 
 */
package com.crs.ibm.dao;

import java.sql.Connection;


//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Scanner;
//import java.util.InputMismatchException;
import  java.sql.Statement;

import com.crs.ibm.constant.SQLQueriesConstants;
import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.StudentCourseNotDletedException;
import com.crs.ibm.exception.StudentNotAddedException;
//import com.ibm.bean.Student;
import com.crs.ibm.utile.DBUtiles;
/**
 * @author 003N75744
 *
 */
public class StudentDaoservice implements StudentDaointerface {
	Connection conn = null;
	Formatter fmt=new Formatter();
	Scanner s=new Scanner(System.in);
	/*
	 * students are registering to the courses
	 * throws student not added exceptions
	 */
	public void addstudents(int studentid,String studname,String gender,int courseid,String grades,int fees)throws StudentNotAddedException
	{
		 conn=DBUtiles.getConnection();			   
		    PreparedStatement stmts = null;
		  
	
		try{
			   
			   
			      // Execute a query
			     // System.out.println("Creating statement...");
			     // String sql="insert into student values(?,?,?,?,?,?)";
			      
			      stmts = conn.prepareStatement( SQLQueriesConstants.ADD_STUDENT_QUERY);
					/*
					 * int studentid=8; String studname="anu"; String gender="female"; int
					 * courseid=3; String grades="A"; int fees=30000;
					 */
			      ResultSet rs=stmts.executeQuery(SQLQueriesConstants.NEW_STUDENT_QUERY);
				     while(rs.next()) {
				    	int cou=rs.getInt("studentid"); 
					if (studentid==cou)
					{  throw new  StudentNotAddedException();
					
					}}
					
			      stmts.setInt(1,studentid);  
			      stmts.setString(2,studname);
			      stmts.setString(3,gender);
			      stmts.setInt(4,courseid);
			      stmts.setString(5,grades);
			      stmts.setInt(6,fees);
			      System.out.println("sucessfully added");
			      stmts.executeUpdate();
			      stmts.close();
			      conn.close();
			      
			   }catch(StudentNotAddedException se){
			      //Handle errors for JDBC
			      //se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmts!=null)
			            stmts.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			  
			  
	}
	/*
	 * students can delete the course
	 * throw student course not deleted exception
	 */
	public void deletecourse(int stuentid)throws StudentCourseNotDletedException
	{
		
		  PreparedStatement stmt = null;
		  
	
		try{
			   System.out.println("Enter student id to delete course");
			   int studentid=s.nextInt();
			  
			    conn =DBUtiles.getConnection();
			    
			      stmt = conn.prepareStatement(SQLQueriesConstants.STUDENT_DELETE_COURSE_QUERY);
			      int f=0;
			      ResultSet rs=stmt.executeQuery(SQLQueriesConstants.NEW_STUDENT_DELETE_QUERY);
				     while(rs.next()) {
				    	int cou=rs.getInt("studentid"); 
					if (studentid==cou)
					{  //throw new   CourseNotDeletedException();
					f++;
					}}
				     if(f==1)
				     {
			      stmt.setInt(1, studentid);
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
				     }
				     else
				     {// System.out.println("Student Course Not Deleted Exception");
				    	 throw new StudentCourseNotDletedException();
				     }
		}
		catch(StudentCourseNotDletedException se){
		      //Handle errors for JDBC
		     // se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
		
	}
	/*
	 * students can view the grades
	 * throw exceptions
	 */
	public void viewgrades()
	{ Connection conn = null;
    	PreparedStatement stmts = null;
	   
		  
		
	try{
		   
		   // Regiater Driver here and create connection 
		   
		 // Class.forName("com.mysql.jdbc.Driver");

		   // make/open  a connection 
		   
		    //  System.out.println("Connecting to database...");
		      conn = DBUtiles.getConnection();
		     
		    Statement  stmt = conn.createStatement();
		   
		      // Execute a query
		      ResultSet rs=stmt.executeQuery(SQLQueriesConstants.VIEW_GRADES_QUERY);
		      while(rs.next())
		      {
		    	  System.out.println("courseid="+rs.getInt("courseid"));
		    	  System.out.println("grades="+rs.getString("grades"));
		    	  System.out.println("");
		      }
		     
		      stmt.close();
		      conn.close();
	}
	catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.fgf
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
		   try{
		         if(stmts!=null)
		            stmts.close();
		      }catch(SQLException se2){
		      }
	      
	   }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }
	/*
	 * students can view the fee details
	 * And students can pay the fee
	 * throw Exceptions
	 */
	public void viewfee()
	{
		Connection conn = null;
		PreparedStatement stmts = null;
		   
			  
			
		try{
			   
			   // Regiater Driver here and create connection 
			   
			 //  Class.forName("com.mysql.jdbc.Driver");

			   // make/open  a connection 
			   
			    //  System.out.println("Connecting to database...");
			      conn =DBUtiles.getConnection();
			   
			    Statement  stmt = conn.createStatement();
			   
			      // Execute a query
			      ResultSet rs=stmt.executeQuery(SQLQueriesConstants.VIEW_FEES_QUERY);
			      while(rs.next())
			      {
			    	  System.out.println("studentid="+rs.getInt("studentid"));
			    	  System.out.println("fees="+rs.getInt("fees"));
			    	  System.out.println("");
			      }
			     
			      stmt.close();
			      conn.close();
		}
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
			   try{
			         if(stmts!=null)
			            stmts.close();
			      }catch(SQLException se2){
			      }
		      
		   }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
	}
	 public void addcourses()throws MySQLIntegrityConstraintViolationException
	 {Scanner sc=new Scanner(System.in);
		 conn=DBUtiles.getConnection();			   
	    PreparedStatement stmts = null;
		  try
		  {
			  stmts=conn.prepareStatement(SQLQueriesConstants.VIEW_COURSE_QUERY);
			  System.out.println("this are the available courses");
			  System.out.format("%15s %15s\n","courseid","coursename");
			  System.out.println("---------------------------------------");
			  ResultSet rs=stmts.executeQuery(SQLQueriesConstants.VIEW_COURSE_QUERY);
			  while(rs.next())
			  {
				  int cou=rs.getInt("courseid");
				  String name=rs.getString("coursename");
				  System.out.format("%14s %17s\n",cou,name);
						  
			  }
			  stmts.close();
			  System.out.println("Enter the student id");
			  int stdid=sc.nextInt();
			  
			  System.out.println("Enter the course id");
			  int couid=sc.nextInt();
			  
			  System.out.println("enter no");
			  int l=sc.nextInt(); 
			  stmts=conn.prepareStatement(SQLQueriesConstants.STUDENT_ADD_COURSE_QUERY);
			  rs=stmts.executeQuery(SQLQueriesConstants.STUDENT_ADD_NEW_COURSE_QUERY);
			  while(rs.next())
			  {
				  int c=rs.getInt("courseid");
				  int st=rs.getInt("studentid");
				  if(c==couid && st==stdid)
				  {
					 throw new MySQLIntegrityConstraintViolationException(); 
				  }
			  }
			  stmts.setInt(1,couid);
			  stmts.setInt(2,stdid);
			  stmts.setInt(3,l);
			  stmts.executeUpdate();
			  stmts.close();
			  conn.close();
		  }
		  catch(MySQLIntegrityConstraintViolationException se){
		      //Handle errors for JDBC
		     // se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
			   try{
			         if(stmts!=null)
			            stmts.close();
			      }catch(SQLException se2){
			      }
		      
		   }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		 
	 }
	}


