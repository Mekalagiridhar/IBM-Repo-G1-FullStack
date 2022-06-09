/**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.dao.UserDaointerface;
import com.ibm.utils.DBUtiles;
import com.ibm.constants.SQLQueriesConstants;

/**
 * @author 003N75744
 *
 */
@Repository
public class UserDaoservice implements UserDaointerface{
	Connection conn = null;
	   PreparedStatement stmt = null;
	  
		/**
		 * Get user name and password from database
		 * @param name
		 * @param password
		 * @return 1 if user name and password found in the database
		 */
	   
	public int getUsernamePassword(String name, String password) {
	       conn = DBUtiles.getConnection();
	       int flag = 0;
		   try{ 
	

			      stmt =  conn.prepareStatement(SQLQueriesConstants.GET_USERNAME_PASSWORD);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_USERNAME_PASSWORD);
			      while(rs.next()){
			         String name1 = rs.getString("user_name");
			         String pass_w = rs.getString("user_password");
			         if (name1.equals(name) && pass_w.equals(password))
			         {	
			        	 flag = 1;
			        	 return flag;
			         }
			      }
			   	  rs.close();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
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
		   return flag;
			}//end main
	
	/**
	 * Add new user to database
	 * @param id
	 * @param name
	 * @param pw
	 */
	
	public int newUser(String id, String name, String pw) {
			int f=0;
		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.NEW_USER);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.NEW_USER_CHECK);
			      while(rs.next()){
			    	  String g=rs.getString("user_id");
			    	  if(g.equals(id)) {
			    		  f=1;
			    		  return f;
			    	  }
			      }
			      stmt.setString(1, id);
			      stmt.setString(2, name);
			      stmt.setString(3, pw);
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
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
		   return f;
   		}
	/**
	 * Change password of a user
	 * @param id
	 * @param pw
	 * @return 1 if user name and password found in the database
	 */
	
	public int pw_change(String name, String pw) {
		conn = DBUtiles.getConnection();
		int flag = 0;
		try {
		
	      stmt =  conn.prepareStatement(SQLQueriesConstants.GET_USERID);
	      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_USERID);
	      while(rs.next()){
	         String name1 = rs.getString("user_name");
	         if (name1.equals(name))
	         {	
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.PASSWORD_CHANGE);
			      stmt.setString(1, pw);
			      stmt.setString(2, name);
			      flag = 1;
	         }
	      }

	      stmt.execute();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
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
		return flag;	
		
	}
	/**
	 * Add student to student table
	 * @param name
	 * @param email
	 */
	public void add_student(String name, String email) {
			int mn = 1;
			int mx = 30;
			Random ran = new Random();
			int x = ran.nextInt(mx) + mn;
			

		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT_TO_STUDENT_TABLE);
			      stmt.setInt(1, x);
			      stmt.setString(2, name);
					System.out.println("Enter the user address");
					Scanner sccc4 = new Scanner(System.in);
					String s = sccc4.next();
			      stmt.setString(3, s);
			      stmt.setString(4, email);
			      stmt.setString(5, null);
			      stmt.setInt(6, 0);
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
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
	/**
	 * Add student to role table
	 * @param email
	 */
	public void add_student_role_table(String name) {
			int mn1 = 300;
			int mx1 = 200;
			Random ran1 = new Random();
			int x1 = ran1.nextInt(mx1) + mn1;
			   try{
				      conn = DBUtiles.getConnection();
				      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT_TO_ROLE);
				      stmt.setInt(1, x1);
				      stmt.setString(2, "student");
				      stmt.setString(3, name);
				      stmt.executeUpdate();
				      stmt.close();
				      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception ep){
		      //Handle errors for Class.forName
		      ep.printStackTrace();
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
		      }catch(SQLException sep){
		         sep.printStackTrace();
		      }//end finally try
		   }//end try
	}
	/**
	 * Add Professor to role table
	 * @param email
	 */
	public void add_prof_role_table(String name) {
		int mn1 = 300;
		int mx1 = 200;
		Random ran1 = new Random();
		int x1 = ran1.nextInt(mx1) + mn1;
		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_TO_ROLE);
			      stmt.setInt(1, x1);
			      stmt.setString(2, "professor");
			      stmt.setString(3, name);
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception ep){
	      //Handle errors for Class.forName
	      ep.printStackTrace();
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
	      }catch(SQLException sep){
	         sep.printStackTrace();
	      }//end finally try
	   }//end try
}
	/**
	 * Add Professor to Professor table
	 * @param name
	 * @param email
	 */
	public void add_prof(String name, String email) {
			int mn = 120;
			int mx = 130;
			Random ran = new Random();
			int x = ran.nextInt(mx) + mn;
		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_PROF_TO_PROF_TABLE);
			      stmt.setString(1, name);
			      stmt.setString(2, "India");
			      stmt.setString(3, email);
			      stmt.setInt(4, x);
			      stmt.setString(5, null);
			      stmt.executeUpdate();

			      stmt.close();
			      conn.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
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
	/**
	 * Add Admin to Admin table
	 * @param name
	 * @param email
	 */
	public void add_admin(String name, String email) {
		int mn = 500;
		int mx = 550;
		Random ran = new Random();
		int x = ran.nextInt(mx) + mn;
	   try{
		      conn = DBUtiles.getConnection();
		      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_ADMIN_TO_ADMIN_TABLE);
		      stmt.setInt(1, x);
		      stmt.setString(2, name);
		      stmt.setString(3, null);
		      stmt.executeUpdate();

		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
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
	/**
	 * Add Admin to Role table
	 * @param email
	 */
	public void add_admin_role_table(String email) {
		int mn1 = 300;
		int mx1 = 200;
		Random ran1 = new Random();
		int x1 = ran1.nextInt(mx1) + mn1;
		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_ADMIN_TO_ROLE_TABLE);
			      stmt.setInt(1, x1);
			      stmt.setString(2, "admin");
			      stmt.setString(3, email);
			      stmt.executeUpdate();
			      stmt.close();
			      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception ep){
	      //Handle errors for Class.forName
	      ep.printStackTrace();
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
	      }catch(SQLException sep){
	         sep.printStackTrace();
	      }//end finally try
	   }//end try
}
}
