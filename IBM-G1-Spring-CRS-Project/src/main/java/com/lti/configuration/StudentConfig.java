/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Bean;

import com.lti.services.StudentInterface;
import com.lti.services.StudentService;


/**
 * @author 003N75744
 *
 */
public class StudentConfig {
	@Bean(name="StudentBean")
	public StudentInterface studentInterface ()
	{
		return new StudentService();
	}
}
