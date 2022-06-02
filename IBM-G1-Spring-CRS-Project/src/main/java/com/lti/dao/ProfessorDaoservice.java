/**
 * 
 */
package com.lti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.lti.constants.SQLQueriesConstants;
import com.lti.utile.DBUtiles;
import com.lti.dao.ProfessorDaointerface;
import com.mysql.jdbc.Connection;

/**
 * @author 003N75744
 *
 */
public class ProfessorDaoservice implements ProfessorDaointerface{
	 Connection conn =null;
	  /*
	   * grades are added to the sudent courses
	   * throw exceptions
	   */
	  public void adgrades()
	  {
		  conn = (Connection) DBUtiles.getConnection();
          Scanner sc=new Scanner(System.in);
		   PreparedStatement stmt = null;
		  
	
		try{
			   
			
			   
			  
			     
			      stmt = conn.prepareStatement(SQLQueriesConstants.ADD_GRADES_QUERY);
			      System.out.println("Enter professor id");
			      int profid=sc.nextInt();
			      System.out.println("Enter professor name");
			      String profname=sc.next();
			      System.out.println("Enter student id");
			      int studentid=sc.nextInt();
			      System.out.println("Add grades");
			      String addgrades=sc.next();
			      System.out.println("Enter course id");
			      int courseid=sc.nextInt();
			      
					
			      stmt.setInt(1, profid);  
			      stmt.setString(2,profname);
			      stmt.setInt(3,studentid);
			      stmt.setString(4, addgrades);
			      stmt.setInt(5, courseid);
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
	  /*
	   * students are enrolled by the professor
	   * throw exceptions
	   */
	  public void getenrolledstudent()
	  {
		  conn=(Connection) DBUtiles.getConnection();	
		   
		   PreparedStatement stmt = null;
		   ResultSet rs=null; 
		   try{
			   
			   
			   
			      //System.out.println("Creating statement...");
			     // String sql="Select * from student where studentid=1"; 
			      stmt = conn.prepareStatement(SQLQueriesConstants.STUDENT_ENROLLMENT_QUERY);
			      rs=stmt.executeQuery();
			      System.out.println("");
//			      System.out.println("Student Id:"+id  +"Name:"+name +"Qualification:"+qualification +"Branch:"+branch +"Contact:" +contact +"Address:" +address +"Grade:"+grade);
			       while(rs.next())
			       {
			    	   int studentid=rs.getInt("studentid");
			    	   String studname = rs.getString("studname");
			    	   String gendar=rs.getString("gendar");
			    	   int courseid=rs.getInt("courseid");
                      String grades= rs.getString("grades");
                      int fees=rs.getInt("fees");
                     System.out.println("");
       		       System.out.println("Student Id:"+studentid  +"\tName:"+studname +"\tgendar:"+gendar +"\tcourseid:"+courseid +"\tgrades:"+grades +"\tfees:"+fees);
			        //   System.out.println(id + "\t\t" +name +"\t\t"+qualification +"\t\t"+branch + "\t\t"+contact + "\t\t"+address + "\t\t" +grade);
			       }
			   
			 
			 
			      //STEP 6: Clean-up environment
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
			  // System.out.println("Goodbye!"); 
	  }
}
