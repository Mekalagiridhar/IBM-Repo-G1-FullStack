/**
 * 
 */
package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.bean.User;
import com.ibm.configuration.JDBCConfiguration;
import com.ibm.constant.SQLQueryConstant;
import com.ibm.mapper.UserMapper;

/**
 * @author 003N75744
 *
 */
@Repository
public class UserDaoservice implements UserDaointerface{
	Logger logger = LoggerFactory.getLogger(UserDaoservice.class);
	
    @Autowired
    JDBCConfiguration jdbcConfiguration;
	  
/**
 * Get user name and password from database
 * @param name
 * @param password
 * @return List with username and password if present in the database
 */

	public List<String> getUsernamePassword(String name, String password) {
			List<String> ls = new ArrayList<String>();
			String SQL = SQLQueryConstant.GET_USERNAME_PASSWORD;
	       List<User> user = jdbcConfiguration.jdbcTemplate().query(SQL, new UserMapper());
	       for (User u : user) {

	    	   String user_name_from_table = u.getUser_name();
	    	   String password_from_table = u.getUser_password();
	    	   
	    	   if (user_name_from_table.equals(name) && password_from_table.equals(password)) { 
	    		    ls.add("User ID : " + u.getUser_id() + " Exists in the table");
	    	   }
	           }
	       return ls;
			}

/**
* Add new user to database
* @param id
* @param name
* @param pw
*/

public void newUser(String id, String name, String pw) {


String SQL = SQLQueryConstant.NEW_USER;
jdbcConfiguration.jdbcTemplate().update( SQL, id, name, pw);

}
/**
* Change password of a user
* @param id
* @param pw
* @return 1
*/

public int pw_change(String name, String pw) {

String SQL = SQLQueryConstant.PASSWORD_CHANGE; 
jdbcConfiguration.jdbcTemplate().update(SQL, pw, name);
return 1;
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
	String SQL = SQLQueryConstant.ADD_STUDENT_TO_STUDENT_TABLE;
	jdbcConfiguration.jdbcTemplate().update( SQL, x, name, "Odisha", email, null, 0);

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
	String SQL = SQLQueryConstant.ADD_STUDENT_TO_ROLE;
	jdbcConfiguration.jdbcTemplate().update( SQL, x1, "student", name);
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
String SQL = SQLQueryConstant.ADD_STUDENT_TO_ROLE;
jdbcConfiguration.jdbcTemplate().update( SQL, x1, "professor", name);
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
	String SQL = SQLQueryConstant.ADD_PROF_TO_PROF_TABLE;
	jdbcConfiguration.jdbcTemplate().update( SQL, name, "India", email, x, null);
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
String SQL = SQLQueryConstant.ADD_ADMIN_TO_ADMIN_TABLE;
jdbcConfiguration.jdbcTemplate().update( SQL, x, name, null);
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
String SQL = SQLQueryConstant.ADD_ADMIN_TO_ADMIN_TABLE;
jdbcConfiguration.jdbcTemplate().update( SQL, x1, "admin", email);

}
}
