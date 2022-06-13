/**
 * 
 */
package com.ibm.rest;

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

import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;
import com.ibm.service.AdminInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	private AdminInterface adminInterface;
	
	
	/**
	 * Add course into catalog and course tables
	 * @param id
	 * @param name
	 * @return List with courses
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(path = "/addcourse/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addcourse(@PathVariable("name") String name, @PathVariable("id") int id) throws CourseNotFound{
		boolean cour = adminInterface.addCourse(name, id);
		if (cour == false) {
			return new ResponseEntity("Course Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Course " + name + " has been added ", HttpStatus.OK);
    }
	
	
	/**
	 * Delete course into catalog and course tables
	 * @param id
	 * @param name
	 * @return List with courses
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/deletecourse/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity deletecourse(@PathVariable("id") int id) throws CourseNotFound{
		boolean cour = adminInterface.removeCourse(id);
		if (cour == false) {
			return new ResponseEntity("Course Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("CourseID "+ id + " has been removed ", HttpStatus.OK);
    }
	
	
	/**
	 * Assign course to a professor 
	 * @param pid(professor id)
	 * @param cid(course id)
	 * @return message that course has been assigned or else shows professor not found
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/assigncourseprofessor/{prof_id}/{course_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity assigncourseprof(@PathVariable("prof_id") int prof_id, @PathVariable("course_id") int course_id) throws ProfessorNotFound{
		boolean cour = adminInterface.assignCourseProfessor(prof_id, course_id);
		if (cour == false) {
			return new ResponseEntity("Professor Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("CourseID " + course_id + " has been assigned to professorID " + prof_id, HttpStatus.OK);
    }
	
	/**
	 * Approve student 
	 * @param id
	 * @return message that student has been approved or else shows student not found
	 */
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/studentapproval/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity studentapproval(@PathVariable("id") int id) throws StudentNotFound{
		boolean cour = adminInterface.set_admin_approval(id);
		if (cour == false) {
			return new ResponseEntity("Student Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("StudentID " + id + " has been approved", HttpStatus.OK);
    }
	
	/**
	 * Add professors 
	 * @param pid
	 * @param name
	 * @return message that professor has been added or else shows professor not found
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/addprof/{prof_id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addprof(@PathVariable("prof_id") String prof_id, @PathVariable("name") String name) throws ProfessorNotFound{
		boolean cour = adminInterface.addProfessor(prof_id, name);
		if (cour == false) {
			return new ResponseEntity("Professor Not added",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Professor " + name + " has been added", HttpStatus.OK);
    }
}
