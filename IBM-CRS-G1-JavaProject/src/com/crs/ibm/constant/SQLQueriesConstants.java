/**
 * 
 */
package com.crs.ibm.constant;

/**
 * @author 003N75744
 *
 */
public class SQLQueriesConstants {
	
	//.......Admin.....................
public static final String ADD_COURSE_QUERY="insert into course values(?,?)";
public static final String NEW_COURSE_QUERY="select courseid from course";
public static final String DELETE_COURSE_QUERY="delete from course where courseid=?";
public static final String APPROVE_STUDENT_QUERY="select studentid,courseid from student where studentid=1";
public static final String ADD_PROFESSOR_QUERY="insert into admin values(?,?,?,?,?)";
public static final String  NEW_PROFESSOR_QUERY="select adminid from admin";
public static final String NEW_STUDENT_APPROVE_QUERY="select studentid from student ";
  
//.......professor...................
public static final String ADD_GRADES_QUERY="insert into professor values(?,?,?,?,?)";
public static final String STUDENT_ENROLLMENT_QUERY="Select * from student where studentid=1";

//..........student....................
public static final String ADD_STUDENT_QUERY="insert into student values(?,?,?,?,?,?)";
public static final String STUDENT_DELETE_COURSE_QUERY="delete from courseregistration where studentid=?";
public static final String VIEW_GRADES_QUERY="select courseid,grades from student";
public static final String VIEW_FEES_QUERY="select studentid,fees from student where studentid=1";
public static final String NEW_STUDENT_QUERY="select studentid from courseregistration";
public static final String NEW_STUDENT_DELETE_QUERY="select studentid from student";
public static final String VIEW_COURSE_QUERY="select courseid,coursename from course";
public static final String STUDENT_ADD_COURSE_QUERY="insert into courseregistration values(?,?,?)";
public static final String STUDENT_ADD_NEW_COURSE_QUERY="select courseid,studentid from  courseregistration";
 

//..........user....................
public static final String LOGIN_QUERY="select userloginid,password from user";
public static final String NEW_LOGIN_QUERY="insert into user values(?,?,?)";
}
