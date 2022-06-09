/**
 * 
 */
package com.ibm.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 003N75744
 *
 */
@Repository
public interface UserDaointerface {
public int getUsernamePassword(String name,String password);
	
	public int newUser(String id, String name, String pw);
	public int pw_change(String id, String pw);
	public void add_student(String name, String email);
	public void add_prof(String name, String email);
	public void add_student_role_table(String e);
	public void add_prof_role_table(String e);
	public void add_admin(String name, String email);
	public void add_admin_role_table(String e);
}
