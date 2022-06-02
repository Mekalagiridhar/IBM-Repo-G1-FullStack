/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.services.AdminInterface;
import com.lti.services.AdminService;



/**
 * @author 003N75744
 *
 */
public class AdminConfig {
	@Bean(name="AdminBean")
	public AdminInterface adminInterface()
	{
		return new AdminService();
	}
}
