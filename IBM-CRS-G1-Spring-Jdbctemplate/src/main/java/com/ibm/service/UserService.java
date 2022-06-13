/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.dao.UserDaointerface;
import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;

/**
 * @author 003N75744
 *
 */
@Component
public class UserService implements UserInterface{
	@Autowired
	UserDaointerface us;
	/**
	 * Login to main Page
	 * @param username
	 * @param password
	 */
	
	public List<String> login(String username, String password) {
			List<String> v = us.getUsernamePassword(username, password);
			return v;
	}
			
	/**
	 * Change password of Users
	 * @param id
	 * @param pw
	 * @throws UserNotFound
	 */
	
	public boolean password_change(String id, String pw)  throws UserNotFound{
		
		try {
			int v = us.pw_change(id, pw);
			if (v == 0) {
				throw new UserNotFound();
			}
			else 
				return true;
		}catch(UserNotFound e) {
		return false;
		}

	}
	
	/**
	 * Adding new user to database
	 * @param id
	 * @param name
	 * @param pw
	 * @throws NewUserProperName
	 */
	
	public void new_user(String id, String name, String pw) throws NewUserProperName{
		try {
			    us.newUser(id, name, pw);
			    if (name == null || pw == null) {
					throw new NewUserProperName();
			    }
		}catch(NewUserProperName e) {
		}
		
	}
	/**
	 * Adding new student to database
	 * @param name
	 * @param email
	 */
	public void add_stud(String name, String email){
		us.add_student(name, email);
		us.add_student_role_table(name);
		
	}
	/**
	 * Adding new professor to database
	 * @param name
	 * @param email
	 */
	public void add_prof(String name, String email){
		us.add_prof(name, email);
		us.add_prof_role_table(name);	
	}
	/**
	 * Adding new_admin to database
	 * @param name
	 * @param email
	 */
	public void add_admin(String name, String email){
		us.add_admin(name, email);
		us.add_admin_role_table(email);
	}
}
