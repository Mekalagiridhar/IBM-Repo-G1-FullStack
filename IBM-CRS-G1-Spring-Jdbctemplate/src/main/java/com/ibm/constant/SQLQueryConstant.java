/**
 * 
 */
package com.ibm.constant;

/**
 * @author 003N75744
 *
 */
public class SQLQueryConstant {
//  ADMIN CONSTANTS
	public static final String ADD_COURSE = "insert into course values (?, ?)";
	public static final String DELETE_COURSE = "delete from course where course_id =?";
	public static final String ADD_PROFESSOR = 	"insert into professor values (?, ?, ?, ?, ?)";
	public static final String ASSIGN_COURSE_PROFESSOR = "UPDATE professor set courseID= ? WHERE prof_id= ? ";
	public static final String SET_STUDENT_APPROVAL = "UPDATE student set admin_approval= ? WHERE id= ? ";
	public static final String GET_STUDENT_ID = "SELECT id, admin_approval, email, stud_name FROM student";
	public static final String GET_PROFESSOR_ID = "SELECT prof_id, courseID FROM professor";
	public static final String GET_COURSE = "SELECT * from course";
	public static final String ADD_COURSE_TO_CATALOG = "insert into catalog values (?, ?, ?, ?, ?)";
	public static final String DELETE_COURSE_TO_CATALOG = "delete from catalog where course_id = ?";
	
//	PROFESSOR CONSTANTS
	public static final String SHOW_COURSE = "SELECT course_name, course_id FROM course";
	public static final String SHOW_ENROLLED_STUDENT = "SELECT * FROM student";
	public static final String ADD_GRADES = "UPDATE student set grade= ? WHERE id= ? ";
	public static final String SHOW_COURSE_CATALOG = "SELECT * FROM CATALOG";

//	STUDENT CONSTANTS
	public static final String REGISTER_COURSE = "insert into courseregister values(?,?,?,?,?,?,?)";
	public static final String DELETE_COURSE_STUDENT = "UPDATE courseregister set course5 = null WHERE stud_id = ? ";
	public static final String ADD_COURSE_STUDENT = "UPDATE courseregister set course5 = ? WHERE stud_id = ?"; 
	public static final String VIEW_COURSES = "select * from courseregister where stud_id = ?";
	public static final String PAY_FEE = "insert into payment values(?,?,?,?,?)";
	public static final String VIEW_REPORT_CARD = "SELECT * FROM student WHERE id = ?";
	public static final String UPDATE_COURSE_ONE_STUDENT = "UPDATE courseregister set course1 = ?";
	public static final String UPDATE_COURSE_TWO_STUDENT = "UPDATE courseregister set course2 = ?";
	public static final String UPDATE_COURSE_THREE_STUDENT = "UPDATE courseregister set course3 = ?";
	public static final String UPDATE_COURSE_FOUR_STUDENT = "UPDATE courseregister set course4 = ?";
	
//	USER CONSTANTS
	public static final String GET_USERNAME_PASSWORD = "SELECT * FROM user";
	public static final String NEW_USER = "insert into user values (?, ?, ?)";
	public static final String PASSWORD_CHANGE = "UPDATE user set user_password= ? WHERE user_name= ? ";
	public static final String ADD_STUDENT_TO_STUDENT_TABLE ="insert into student values (?,?,?,?,?,?) ";
	public static final String GET_USERID = "SELECT user_id, user_name FROM user";
	public static final String ADD_PROF_TO_PROF_TABLE = "insert into professor values(?,?,?,?,?)";
	public static final String ADD_STUDENT_TO_ROLE = "insert into role values(?,?,?) ";
	public static final String ADD_PROFESSOR_TO_ROLE = "insert into role values(?, ?, ?)";
	public static final String ADD_ADMIN_TO_ADMIN_TABLE ="insert into admin values (?,?,?) ";
	public static final String ADD_ADMIN_TO_ROLE_TABLE ="insert into role values (?,?,?) ";
}
