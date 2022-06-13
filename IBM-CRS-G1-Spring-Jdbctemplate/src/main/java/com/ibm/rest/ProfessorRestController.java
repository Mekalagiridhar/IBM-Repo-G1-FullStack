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
import com.ibm.dao.ProfessorDaointerface;
import com.ibm.service.ProfessorInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorRestController {
@Autowired
ProfessorInterface professorinterface;


/*
 * professor can view the course
 * throws course not found exception
 */
@GetMapping(path="/viewcourse")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity viewcourses() {
	List<Course> course = professorinterface.show_courses();
	if (course== null) {
		return new ResponseEntity<String>("There are no courses.", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity(course, HttpStatus.OK);
}


/*
 * professor can Enroll the students
 * throws  no students enrolled Exception
 */
@GetMapping(path="/studentenrollment")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity enrollment()
{
	List<Student> students=professorinterface.enrolledStudent();
	if (students== null) {
		return new ResponseEntity<String>("There are no students.", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity(students, HttpStatus.OK);
}



/*
 * professor can add the grades to the student
 * throws student not found Exception
 */
@RequestMapping(path = "/addGrades/{id}/{grade}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity addgrade(@PathVariable("id") int id, @PathVariable("grade") String gd){
	boolean ad = professorinterface.add_grades(id, gd);
	if (ad == false) {
		return new ResponseEntity<String>("Student Not Found.", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<String>(" Grade has been added ", HttpStatus.OK);
}
}
