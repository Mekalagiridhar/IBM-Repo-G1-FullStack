/**
 * 
 */
package com.ibm.services;

import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.application.IbmCrsGroupSpringRestApplication;
import com.ibm.dao.UserDaointerface;
import com.ibm.dao.UserDaoservice;
import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;

/**
 * @author 003N75744
 *
 */
@Component
public class UserService implements UserInterface{
	UserDaointerface us = new UserDaoservice();
	/**
	 * Login to main Page
	 * @param username
	 * @param password
	 * @throws UserNotFound
	 */
	
	public boolean login(String username, String password) throws UserNotFound  {
		
			// call method from UserDaoInterface
		
			int v = us.getUsernamePassword(username, password);
			if (v == 0) {
				return false;
			}
			return true;
		
	}
	/**
	 * Change password of Users
	 * @param id
	 * @param pw
	 * @throws UserNotFound
	 */
	
	public boolean password_change(String id, String pw)  throws UserNotFound{
		
//		call method from UserDaoInterface
		
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
	
	public boolean new_user(String id, String name, String pw) throws NewUserProperName{
		
			  int e=  us.newUser(id, name, pw);
			  if(e==0)
			  {
				  return true;
			  }
			  return false;
			   
		
	}
	/**
	 * Adding new student to database
	 * @param name
	 * @param email
	 */
	public void add_stud(String name, String email){
		us.add_student(name, email);
		us.add_student_role_table(name);
		System.out.println("New user account has been created \n");
		
	}
	/**
	 * Adding new professor to database
	 * @param name
	 * @param email
	 */
	public boolean add_prof(String name, String email){
		us.add_prof(name, email);
		us.add_prof_role_table(name);
		//System.out.println("New user account has been created \nYou can login now.");	
		return true;
	}
	/**
	 * Adding new admin to database
	 * @param name
	 * @param email
	 */
	public void add_admin(String name, String email){
		us.add_admin(name, email);
		us.add_admin_role_table(email);
		System.out.println("New user account has been created \n");
		
	}
}
