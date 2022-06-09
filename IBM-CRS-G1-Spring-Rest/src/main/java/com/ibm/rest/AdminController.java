/**
 * 
 */
package com.ibm.rest;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exception.CourseNotFound;
import com.ibm.exception.ProfessorNotFound;
import com.ibm.exception.StudentNotFound;
import com.ibm.services.AdminInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
@Autowired
AdminInterface admininterface;
 
/*
 * Admin can add the courses
 * throws course not found Exception
 */
@GetMapping(path = "/addcourse/{name}/{id}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity addcour(@PathVariable("name") String name1,@PathVariable("id") int id) throws CourseNotFound{
	List<String> rs = admininterface.addCourse(name1,id);
	 if(rs ==null)
	   {
		   return new ResponseEntity("course not found"+id,HttpStatus.NOT_FOUND);
	   }
	   return new ResponseEntity("corses registered"+rs,HttpStatus.NOT_FOUND);
}

/*
 * Admin can delete the course
 * throws course not found Exception
 */
@RequestMapping("/delete/course/{id}")
public ResponseEntity deleteCour(@PathVariable("id") int id) throws CourseNotFound{
	boolean v =admininterface. removeCourse(id);
	if (v == false)
		return new ResponseEntity("Course Not Found " +id, HttpStatus.NOT_FOUND);
	return new ResponseEntity(" Course " + id + " has been deleted",HttpStatus.OK);
}

/*
 * Admin can add the professor to the course
 * throws  professor not found Exception
 */
@GetMapping(path = "/addprofessor/{pid}/{cid}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity addcorseprof(@PathVariable("pid") int id1,@PathVariable("cid") int id2)  throws ProfessorNotFound{
	boolean s=admininterface.assignCourseProfessor(id1,id2);
	if (s == false)
		return new ResponseEntity("professor Not Found " + id1, HttpStatus.NOT_FOUND);
	return new ResponseEntity(" Course " + id2 + " has been added",HttpStatus.OK);
}

/*
 * Admin can approve the student for course registration
 * throws student not found Exception
 */
@GetMapping(path = "/approval/{id}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity approv(@PathVariable("id") int id) throws StudentNotFound{
	boolean k=admininterface.set_admin_approval(id);
	if (k == false)
		return new ResponseEntity("student Not Found " + id, HttpStatus.NOT_FOUND);
	return new ResponseEntity(" student " + id + " has been approved",HttpStatus.OK);
}


}
