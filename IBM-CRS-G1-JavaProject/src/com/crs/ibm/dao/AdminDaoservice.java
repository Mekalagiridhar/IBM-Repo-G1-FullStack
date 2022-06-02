package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.crs.ibm.constant.SQLQueriesConstants;
import com.crs.ibm.exception.MySQLIntegrityConstraintViolationException;
import com.crs.ibm.exception.CourseNotDeletedException;
import com.crs.ibm.exception.ProfessorNotAddedException;
import com.crs.ibm.exception.StudentNotAddedException;
import com.crs.ibm.exception.StudentNotFoundException;
import com.crs.ibm.utile.DBUtiles;
import com.mysql.jdbc.Statement;
public class AdminDaoservice implements AdminDaointerface
{Connection conn = null;
/*
 * Add course using SQL commands
 * trows coursenotadded Exception
 */
	public void addcoursemain()throws MySQLIntegrityConstraintViolationException
	{
		 conn=DBUtiles.getConnection();			   
		    PreparedStatement stmts = null;
		  
	
		try{
			   Scanner d=new Scanner(System.in);
			   
			      // Execute a query
			    //  System.out.println("Creating statement...");
			   //   String sql="insert into course values(?,?)";
			      
			      stmts = conn.prepareStatement( SQLQueriesConstants.ADD_COURSE_QUERY);
			      System.out.println("Enter courseid and name");
			     int coursei=d.nextInt();
			     String coursename=d.nextLine();
			     ResultSet rs=stmts.executeQuery(SQLQueriesConstants.NEW_COURSE_QUERY);
			     while(rs.next()) {
			    	int cou=rs.getInt("courseid"); 
				if (coursei==cou)
				{  throw new  MySQLIntegrityConstraintViolationException();
				
				}}
			      stmts.setInt(1,coursei);  
			      stmts.setString(2,coursename);
			 
					
					  stmts.executeUpdate(); 
					 
			      stmts.close();
			      conn.close();
			      //throw new  MySQLIntegrityConstraintViolationException(); 
				}
		catch( MySQLIntegrityConstraintViolationException  se){
			throw new MySQLIntegrityConstraintViolationException(); 
		
				  //Handle errors for JDBC
			      //se.printStackTrace();
			   }catch(Exception  e){
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
	 * Delete course using SQL commands
	 * throws coursenotdeleted Exception
	 */
	
	public void removecoursemain()throws CourseNotDeletedException {
		  PreparedStatement stmt = null;
		  
			
			try{
				   
				 Scanner c=new Scanner(System.in);
				   
				   // System.out.println("Connecting to database...");
				    conn =DBUtiles.getConnection();
				    //  conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      // Execute a query
				      System.out.println("deleting the course");
				    //  String sql="delete from course where courseid=5";
				      stmt = conn.prepareStatement( SQLQueriesConstants.DELETE_COURSE_QUERY);
				      System.out.println("Enter the courseid");
				      int couse=c.nextInt();
				      int f=0;
				      ResultSet rs=stmt.executeQuery(SQLQueriesConstants.NEW_COURSE_QUERY);
					     while(rs.next()) {
					    	int cou=rs.getInt("courseid"); 
						if (couse==cou)
						{  //throw new   CourseNotDeletedException();
						f++;
						}}
					     if(f==1)
					     {
				      stmt.setInt(1,couse);
				      stmt.executeUpdate();
				      stmt.close();
				      conn.close();
					     }
					     else
					     {
					    	 throw new   CourseNotDeletedException(); 
					     }
				      
			}
			catch( CourseNotDeletedException se){
				throw new   CourseNotDeletedException(); 
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
	 * Students approving using SQL commands
	 * throws studentnotapproved Exception
	 */
	public void studregappr()throws StudentNotFoundException
	{
		// TODO Auto-generated method stub

		conn=DBUtiles.getConnection();
		PreparedStatement stmts = null;
		
		try{
			  
			     // System.out.println("Connecting to database...");
			      int studentid=5;
			      //String sql="select studentid from student";
			      stmts=conn.prepareStatement(SQLQueriesConstants.NEW_STUDENT_APPROVE_QUERY);
			     System.out.println("waiting for the admin approvel");
			   // int studentid=5;
			    int v=0;
			    ResultSet rs=stmts.executeQuery(SQLQueriesConstants.NEW_STUDENT_APPROVE_QUERY);
			     while(rs.next()) {
			    	int cou=rs.getInt("studentid"); 
				if (studentid==cou)
				{  
				System.out.println(" student has been approved" );
				v++;
				}}
			     
				if(v==1)
				{
			      stmts.close();
			      conn.close();
				}
				else
				{
					throw new StudentNotFoundException();
				}
				
		}
		catch(StudentNotFoundException  se){
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
	/*
	 * Add professor using SQL commands
	 * throws professornotadded Exception
	 */
	public void addprofcou() throws ProfessorNotAddedException {

		   conn=DBUtiles.getConnection();			   
		    PreparedStatement stmt = null;
		  
	
		try{  Scanner l=new Scanner(System.in);
			   
			     // System.out.println("Creating statement...");
			   //   String sql="insert into admin values(?,?,?,?,?)";
			      System.out.println("adding professor");
			      stmt = conn.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_QUERY);
			      System.out.println("Enter adminid");
			      int adminid=l.nextInt();
			      System.out.println("Enter admin name");
			      String adminname=l.nextLine();
			      System.out.println("Enter studentid");
			      int studentid=l.nextInt();
			      System.out.println("Enter professorid");
			      int profid=l.nextInt();
			      System.out.println("Enter courseid");
			      int courseid=l.nextInt();
			      ResultSet rs=stmt.executeQuery(SQLQueriesConstants. NEW_PROFESSOR_QUERY );
				     while(rs.next()) {
				    	int cou=rs.getInt("adminid"); 
					if (adminid==cou)
					{ throw new ProfessorNotAddedException();
					
					}}
					
			      stmt.setInt(1,adminid);  
			      stmt.setString(2,adminname);
			      stmt.setInt(3,studentid);
			      stmt.setInt(4,profid);
			      stmt.setInt(5,courseid);
			   
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
			      
			   }catch(ProfessorNotAddedException se){
				  // throw new ProfessorNotAddedException();
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

	
	

}