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

import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;
import com.ibm.services.UserInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
@Autowired
UserInterface userinterface;

/*
 * user can login here
 * throws user not found Exception
 */
@RequestMapping(path ="/login/{name1}/{name2}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity log(@PathVariable("name1") String c1,@PathVariable("name2") String c2) throws UserNotFound{
	boolean d=userinterface.login(c1,c2);
	if (d == false)
	{
		return new ResponseEntity("user Not Found " +c1, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity(""+ c1 + " has been logged",HttpStatus.OK);
}

/*
 * user can create login id and password
 * throws new user proper name Exception
 */
@GetMapping(path ="/newuser/{name1}/{name2}/{name3}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity newuse(@PathVariable("name1") String c1,@PathVariable("name2") String c2,@PathVariable("name3") String c3) throws NewUserProperName {
	boolean a=userinterface.new_user(c1,c2,c3);
	if (a == false)
	{
		return new ResponseEntity("user id already exist use different name " +c1, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity("user id"+ c1 + " has been created",HttpStatus.OK);
}

/*
 * Adding the professor details
 * 
 */
@GetMapping(path="/professor/{name1}/{name2}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity prof(@PathVariable("name1") String c1,@PathVariable("name2") String c2) {
	boolean g=userinterface.add_prof(c1,c2);
	if (g == false)
	{
		return new ResponseEntity("professor id already exist use different name " +c1, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity("professor id"+ c1 + " has been created",HttpStatus.OK);
}
@RequestMapping(path = "/passwordchange/{id}/{password}")
@Produces(MediaType.APPLICATION_JSON)
public ResponseEntity pw_change(@PathVariable("id") String id, @PathVariable("password") String password) throws UserNotFound{
	boolean cs = userinterface.password_change(id, password);
	if (cs == false) {
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity("Passowrd for ID " + id + " has been changed.", HttpStatus.OK);
}

}
