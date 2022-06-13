/**
 * 
 */
package com.ibm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;

/**
 * @author 003N75744
 *
 */
@Component
public interface UserInterface {
	public List<String> login(String n7, String n8) throws UserNotFound;
	public boolean password_change(String id, String pw) throws UserNotFound;
	public void new_user(String id, String name, String pw) throws NewUserProperName ; 
	public void add_stud(String name, String email);
	public void add_prof(String name, String email);
	public void add_admin(String name, String email);
}
