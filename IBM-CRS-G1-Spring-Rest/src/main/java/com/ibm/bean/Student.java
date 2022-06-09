/**
 * 
 */
package com.ibm.bean;

/**
 * @author 003N75744
 *
 */
public class Student {
	private int id;
	private String name;
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Student() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	public void add_course(int id2, int courseID) {
		// TODO Auto-generated method stub
		
	}
}
