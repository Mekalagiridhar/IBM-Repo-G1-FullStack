/**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.dao.AdminDaointerface;
import com.ibm.utils.DBUtiles;
import com.ibm.constants.SQLQueriesConstants;

/**
 * @author 003N75744
 *
 */
@Repository
public class AdminDaoservice implements AdminDaointerface{
	Connection conn = null;
	   PreparedStatement stmt = null;

		/**
		 * Add Courses in Course Table
		 * @param course
		 * @param id
		 */
//	@SuppressWarnings("null")
	public List<String> addCourse(String course, int id) {
		List<String> lst = new ArrayList<String>();

		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_COURSE);
			      lst.add(course);
			      stmt.setInt(1, id);
			      stmt.setString(2, course);
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
		   return lst;
			}//end main
	/**
	 * Add Courses details to Catalog Table
	 * @param course
	 * @param id
	 */
	public List<String> addCourse_to_catalog(String course, int id) {
		List<String> lst = new ArrayList<String>();
				int mn = 600;
				int mx = 700;
				Random ran = new Random();
				int x = ran.nextInt(mx) + mn;

		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_COURSE_TO_CATALOG);
			     // ResultSet rs = stmt.executeQuery(SQLQueriesConstants.ADD_COURSE_TO_CATALOG);
			      lst.add(course);
			      stmt.setInt(1, x);
			      stmt.setInt(2, id);
			      stmt.setString(3, course);
			      stmt.setString(4, "Engineering");
			      stmt.setInt(5, 1);
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
		   return lst;
			}//end main
	/**
	 * Delete Courses details to Catalog Table
	 * @param course
	 * @param id
	 */
	
public void deleteCourse_from_catalog(int id) {
	   try{
		      conn = DBUtiles.getConnection();
		      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.DELETE_COURSE_TO_CATALOG);
		      stmt.setInt(1, id);
		      System.out.println("Courses has been deleted.\n");
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
		}//end main
	   
	/**
	 * Delete Courses in Course Table
	 * @param crs_id
	 */
	
	public int deleteCourse(int crs_id) {

	   	   conn = DBUtiles.getConnection();
	   	   int f = 0;
		   try{

			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.GET_COURSE_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_COURSE_ID);
			      while(rs.next()){
				         int name1 = rs.getInt("course_id");
				         if (crs_id == name1) {
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.DELETE_COURSE);
					      stmt.setInt(1, crs_id);
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

	/**
	 * Add Professor in Professor Table
	 * @param course
	 * @param id
	 */

	public int addProfessor(int pf_id,String us_name) {
			conn = DBUtiles.getConnection();
			int f = 0;
			int mn = 120;
			int mx = 130;
			Random ran = new Random();
			int x = ran.nextInt(mx) + mn;
		   try{

			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.GET_USERID);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_USERID);
			      while(rs.next()){
				         int name1 = rs.getInt("user_id");
				         if (pf_id == name1) {
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);
					      stmt.setString(1, us_name);
					      stmt.setString(2, "India");
					      stmt.setString(3, null);
					      stmt.setInt(4, x);
					      stmt.setString(5, null);
					      f = 1;
				         }
			      }
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
	 * Get Professor ID and CourseID
	 * @param p_id
	 * @param c_id
	 */
	
	public int assign_crs_to_Professor(int p_id ,int c_id ) {
		conn = DBUtiles.getConnection();
		int f = 0;
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.GET_PROFESSOR_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_PROFESSOR_ID);
			      while(rs.next()){
				          int id = rs.getInt("prof_id");
				          int crse_id = rs.getInt("courseID");

				          if (p_id == id) {
					          if (crse_id != 0) {
				        	 // System.out.println("Course Already been assgined");
					          }
				        	f = 1;
				        	return f;
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
	/**
	 * Assign Course to Professors
	 * @param course
	 * @param id
	 */
	public void assign(int p_id ,int c_id ) {
		   try{
			      conn = DBUtiles.getConnection();
			      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.ASSIGN_COURSE_PROFESSOR);
			      stmt.setInt(1, c_id);
			      stmt.setInt(2, p_id);
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
	   }
		
	/**
	 * Approve Student
	 * @param id
	 */
	public int set_stud_approval(int id) {
		
		   conn = DBUtiles.getConnection();
		   int f = 0;
		   try{
			      stmt =  (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			      ResultSet rs = stmt.executeQuery(SQLQueriesConstants.GET_STUDENT_ID);
			      while(rs.next()){
				         int name1 = rs.getInt("id");
				         int ap = rs.getInt("admin_approval");
				         if (name1 == id)
				         {
					         if (ap == 1) {
					        	// System.out.println("Student has already been approved");
					        	 f = 1;
					        	 break;
					         }
					      stmt = (PreparedStatement) conn.prepareStatement(SQLQueriesConstants.SET_STUDENT_APPROVAL);
					      stmt.setInt(1, 1);
					      stmt.setInt(2, id);
					      f = 1;
					     // System.out.println("Student ID " + id + " has been approved\n");
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
