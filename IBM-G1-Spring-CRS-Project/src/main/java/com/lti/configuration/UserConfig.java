/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.services.UserInterface;
import com.lti.services.UserService;



/**
 * @author 003N75744
 *
 */
public class UserConfig {
	@Bean(name="UserBean")
	public UserInterface userInterface ()
	{
		return new UserService();
	}
}
