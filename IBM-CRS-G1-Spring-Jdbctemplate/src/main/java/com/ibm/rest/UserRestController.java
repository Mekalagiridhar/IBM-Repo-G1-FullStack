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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exception.NewUserProperName;
import com.ibm.exception.UserNotFound;
import com.ibm.service.UserInterface;

/**
 * @author 003N75744
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserInterface userInterface;
	
	
	/**
	 * Add new user
	 * @param id
	 * @param role
	 * @param name
	 * @param password
	 * @return a message that user has been added
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/newuser/{role}/{id}/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity newuser(@PathVariable("id") String id, @PathVariable("role") String role,@PathVariable("name") String name, @PathVariable("password") String password) throws NewUserProperName{
		
		userInterface.new_user(id, name, password);
		if (role.equals("student")) {
			userInterface.add_stud(name, id);
		}
		else if (role.equals("professor"))
			userInterface.add_prof(name, id);
		else if(role.equals("admin"))
			userInterface.add_admin(name, id);
			
		if (userInterface == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("User has been added", HttpStatus.OK);
     }
	
	/**
	 * Change password of a user
	 * @param id
	 * @param password
	 * @return a message that password has been changed
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/passwordchange/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity pw_change(@PathVariable("id") String id, @PathVariable("password") String password) throws UserNotFound{
		boolean cs = userInterface.password_change(id, password);
		if (cs == false) {
			return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Passowrd for ID " + id + " has been changed.", HttpStatus.OK);
	}
	
	
	/**
	 * Login of a user
	 * @param id
	 * @param password
	 * @return List with username and password
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/username/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity get_username(@PathVariable("id") String id, @PathVariable("password") String password) throws UserNotFound{
		List<String> cs = userInterface.login(id, password);
		if (cs.isEmpty()) {
			return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Username and Password " + cs, HttpStatus.OK);
	}

}
