/**
 * 
 */
package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Course;
import com.ibm.bean.Student;
import com.ibm.dao.StudentDaointerface;
import com.ibm.service.StudentInterface;



/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentRestController {
	@Autowired
	StudentInterface studentinterface;
	
	
	/*
	 * students can view the course
	 * throws course not found exception
	 */
	@GetMapping(path="/viewcourse")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewcourses() {
		List<Course> course = studentinterface.show_courses();
		if (course== null) {
			return new ResponseEntity<String>("There are no courses.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(course, HttpStatus.OK);
	}
	
	
	/*
	 * Student can register to the courses
	 * throws student not approved Exception
	 */
	
	@RequestMapping(value = "/register/{id}/{studid}/{name}/{name2}/{name3}/{name4}") 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity registerCourse(@PathVariable("id") int id,@PathVariable("studid") int studentid,@PathVariable("name") String course1,@PathVariable("name2") String course2,@PathVariable("name3") String course3,@PathVariable("name4") String course4) {
   boolean rs = studentinterface.registers(id,studentid,course1,course2,course3,course4);
   if(rs ==false)
   {
	   return new ResponseEntity("StudenNotApproved"+id,HttpStatus.NOT_FOUND);
   }
   return new ResponseEntity("corses registered",HttpStatus.NOT_FOUND);
		}
	
	
	/*
	 * Student can add the course
	 * throws student not found Exception
	 * throws course not found Exception
	 */

	@RequestMapping(path = "/post/addnewcourse/{id}/{course}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addCourse(@PathVariable("id") int id,@PathVariable("course") String c1)  {
		
		boolean ad = studentinterface.add_courses(id, c1);
		if (ad == false)
			return new ResponseEntity("Course Not Found " + c1, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course " + c1 + " has been added",HttpStatus.OK);
    }
	
	
	/*
	 * Student can delete the courses
	 * throws course not found Exception
	 */
	@RequestMapping("/delete/course/{id}")
	public ResponseEntity deleteCourse(@PathVariable("id") int id) {
		
		boolean v = studentinterface.delete_courses(id);
		if (v == false)
			return new ResponseEntity("Course Not Found ", HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course has been deleted",HttpStatus.OK);
    }
	
	/*
	 * Student can view the grades
	 * throws student not found Exception
	 */
	@RequestMapping(path = "/viewreport/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewreport(@PathVariable("id") int id)  {
		
	String ad = studentinterface.view_reportCards(id);
		if (ad == null)
			return new ResponseEntity("Student not Found ID " + id, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Report card of student " + id + " is "  + ad,HttpStatus.OK);
    }
}
