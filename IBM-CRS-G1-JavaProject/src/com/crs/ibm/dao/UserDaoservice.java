/**
 * 
 */
package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.crs.ibm.constant.SQLQueriesConstants;
import com.crs.ibm.utile.DBUtiles;

/**
 * @author 003N75744
 *
 */
public class UserDaoservice implements UserDaointerface {
	Connection conn = null;
	Scanner sc=new Scanner(System.in);
	/*
	 * user can login using id and password
	 * throw login id and password wrong Exceptions
	 */
	public int userlogin(String id,int pass)
	{
		conn=DBUtiles.getConnection();			   
	    PreparedStatement stmts = null;
	    int flag=0;
	    try
	    {
	    	 stmts = conn.prepareStatement(SQLQueriesConstants.LOGIN_QUERY);
	    	 ResultSet rs=stmts.executeQuery(SQLQueriesConstants.LOGIN_QUERY);
	    	 while(rs.next())
	    	 {
	    		 String loginid=rs.getString("userloginid");
	    		 int passw=rs.getInt("password");
	    		 if((loginid.equals(id))&&(passw==pass))
	    		 {
	    			 System.out.println("succesfully login");
	    			 flag=1;
	    		 }
	    		
	    	 }
	    	 rs.close();
	    	 stmts.close();
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
	/*
	 * user can create new user id and password
	 * throw Exceptions
	 */
	
	public void newuserlogin() {

		System.out.println("enter user name");
		String a=sc.nextLine();
		System.out.println("enter user id");
		String b=sc.nextLine();
		System.out.println("enter password");
		int c=sc.nextInt();
		conn=DBUtiles.getConnection();			   
	    PreparedStatement stmts = null;
	    try
	    {
	    	stmts = conn.prepareStatement(SQLQueriesConstants.NEW_LOGIN_QUERY);
	    	stmts.setString(1, a);
	    	stmts.setInt(2, c);
	    	stmts.setString(3, b);
	    	stmts.executeUpdate();
	    	stmts.close();
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
