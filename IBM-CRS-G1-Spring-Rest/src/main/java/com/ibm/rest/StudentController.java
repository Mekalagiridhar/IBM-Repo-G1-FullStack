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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bean.Courses;
import com.ibm.bean.Student;
import com.ibm.exception.CourseNotFound;
import com.ibm.exception.StudenNotApproved;
import com.ibm.exception.StudentNotFound;
import com.ibm.services.StudentInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentInterface studentinterface;
	
	
	/*
	 * Student can register to the courses
	 * throws student not approved Exception
	 */
	@RequestMapping(value = "/register/{id}/{name}/{name2}/{name3}/{name4}") 
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity registerCourse(@PathVariable("id") int id,@PathVariable("name") String course1,@PathVariable("name2") String course2,@PathVariable("name3") String course3,@PathVariable("name4") String course4) throws StudenNotApproved {
   List<String> rs = studentinterface.registerCourse(id,course1,course2,course3,course4);
   if(rs ==null)
   {
	   return new ResponseEntity("StudenNotApproved"+id,HttpStatus.NOT_FOUND);
   }
   return new ResponseEntity("corses registered"+rs,HttpStatus.NOT_FOUND);
		}
		
	
	/*
	 * Student can view the registered courses
	 * throws student not found Exception
	*/
	
	@GetMapping(path = "/course/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse(@PathVariable("id") int id) throws StudentNotFound {
		List<String> cs = studentinterface.viewCourses(id);
		if (cs == null) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(cs, HttpStatus.OK);
    }
	
	
	/*
	 * Student can add the course
	 * throws student not found Exception
	 * throws course not found Exception
	 */
	
	@RequestMapping(path = "/post/addnewcourse/{id}/{course}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addCourse(@PathVariable("id") int id,@PathVariable("course") String c1) throws CourseNotFound, StudenNotApproved {
		
		boolean ad = studentinterface.addCourse(id, c1);
		if (ad == false)
			return new ResponseEntity("Course Not Found " + c1, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course " + c1 + " has been added",HttpStatus.OK);
    }
	
	/*
	 * Student can delete the courses
	 * throws course not found Exception
	 */
	@RequestMapping("/delete/course/{id}/{course}")
	public ResponseEntity deleteCourse(@PathVariable("id") int id,@PathVariable("course") String course1) throws StudentNotFound {
		
		boolean v = studentinterface.dropCourse(id, course1);
		if (v == false)
			return new ResponseEntity("Course Not Found " + course1, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Course " + course1 + " has been deleted",HttpStatus.OK);
    }
	
	/*
	 * Student can update the courses
	 * throws student not found Exception
	 */
	@RequestMapping(path = "/updatecourse/{id}/{old_course}/{new_course}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity update(@PathVariable("id") int id,@PathVariable("old_course") String course1, @PathVariable("new_course") String course2) throws StudentNotFound {
		
		List<String> up = studentinterface.update_already_registered_course(id, course1, course2);
		if (up == null) {
			return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Updated Courses"  + up,HttpStatus.OK);
    }
	
	/*
	 * Student can pay the fees
	 * throws student not found Exception
	 */
	@RequestMapping(path = "/payfee/{id}/{amount}/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity payfee(@PathVariable("id") int id,@PathVariable("amount") int amount1, @PathVariable("type") String type2) throws StudentNotFound {
		
		boolean ad = studentinterface.payFee(id, amount1, type2);
		if (ad == false)
			return new ResponseEntity("Student not Found ID " + id, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Payment " + amount1 + " has been paid by studentID " + id,HttpStatus.OK);
    }
	
	/*
	 * Student can view the report card
	 * throws student not found Exception
	 */
	@RequestMapping(path = "/viewreport/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewreport(@PathVariable("id") int id) throws StudentNotFound {
		
		String ad = studentinterface.viewReportCard(id);
		if (ad == null)
			return new ResponseEntity("Student not Found ID " + id, HttpStatus.NOT_FOUND);
		return new ResponseEntity(" Report card of student " + id + " is "  + ad,HttpStatus.OK);
    }
}
