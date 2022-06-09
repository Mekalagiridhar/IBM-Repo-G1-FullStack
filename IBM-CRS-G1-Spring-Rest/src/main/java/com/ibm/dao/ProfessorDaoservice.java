/**
 * 
 */
package com.ibm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.bean.Professor;
import com.ibm.constants.SQLQueriesConstants;
import com.ibm.dao.ProfessorDaointerface;
import com.ibm.utils.DBUtiles;
import com.mysql.jdbc.Connection;

/**
 * @author 003N75744
 *
 */
@Repository
public class ProfessorDaoservice implements ProfessorDaointerface {
	Connection conn = null;
	   PreparedStatement stmt = null;
	   
		/**
		 * Show course details from catalog
		 */
	   
	   public List<String> show_course() {
		   List<String> ls = new ArrayList<String>();
		   try{
			      conn = (Connection) DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.SHOW_COURSE_CATALOG);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.SHOW_COURSE_CATALOG);
			      
			      while(rs.next()){
			         int ca_id  = rs.getInt("catalog_id");
			         int cs_id  = rs.getInt("course_id");
			         String name = rs.getString("course_name");
			         String tp = rs.getString("course_type");
			         int sem = rs.getInt("semester");
			         
			         ls.add("Course : " + name);
			      }
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
		   return ls;
	}
	   
		/**
		 * Show EnrolledStudents from Student Table in the Database
		 * @return 1 if student id found in the database or else return 0 
		 */
	   public List<String> enrolledStudents(){
		   List<String> st = new ArrayList<String>();
		   try{
			      conn = (Connection) DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.SHOW_ENROLLED_STUDENT);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.SHOW_ENROLLED_STUDENT);
			      while(rs.next()){
			    	 int s_id = rs.getInt("id");
			         String name = rs.getString("stud_name");
			         String email = rs.getString("email");
			         if (s_id == 0) {
			        	 break;
			      }
			         st.add("Name :" + name);
			      }
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
		   return st;
	   }
	   
		/**
		 * Add Grades to Students in Student Table
		 * @param id
		 * @param name 
		 * @param grade
		 * @return 1 if user id found in the database or else return 0 
		 */
	   public int add_grade(int id, String grade) {
		   conn = (Connection) DBUtiles.getConnection();
		   int f = 0;
		   try{
			   
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_STUDENT_ID);
			      while(rs.next()){
				         int id1 = rs.getInt("id");
				         if (id == id1) {
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_GRADES);
					      stmt.setString(1, grade);
					      stmt.setInt(2, id);
					      f = 1;
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
		   return f;
	   }
}
