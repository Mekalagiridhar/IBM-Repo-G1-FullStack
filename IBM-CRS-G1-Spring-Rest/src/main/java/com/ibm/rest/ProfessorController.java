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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ibm.bean.Professor;
import com.ibm.dao.ProfessorDaointerface;
import com.ibm.exception.StudentNotFound;
import com.ibm.exception.StudentsNotEnrolled;
import com.ibm.services.ProfessorInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	private ProfessorInterface professorinterface;

	/*
	 * professor can Enroll the students
	 * throws  no students enrolled Exception
	 */
	@GetMapping(path = "/viewEnrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse() throws StudentsNotEnrolled{
		List<String> cs = professorinterface.viewEnrolledStudents();
		if (cs == null) {
			return new ResponseEntity<String>("There are no students enrolled.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(cs, HttpStatus.OK);
    }
	
	/*
	 * professor can add the grades to the student
	 * throws student not found Exception
	 */
	@RequestMapping(path = "/addGrades/{id}/{grade}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity addgrade(@PathVariable("id") int id, @PathVariable("grade") String gd) throws StudentNotFound{
		boolean ad = professorinterface.addGrades(id, gd);
		if (ad == false) {
			return new ResponseEntity<String>("Student Not Found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(" Grade has been added ", HttpStatus.OK);
    }
	
	/*
	 * professor can view the courses
	 */
	@GetMapping(path = "/viewCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity viewCourse1(){
		List<String> ad = professorinterface.viewCourse();
		if (ad == null) {
			return new ResponseEntity<String>("Course Not Found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(ad, HttpStatus.OK);
    }
}
