/**
 * 
 */
package com.lti.configuration;

import org.springframework.context.annotation.Import;

/**
 * @author 003N75744
 *
 */
@Import({AdminConfig.class,ProfessorConfig.class,StudentConfig.class,UserConfig.class})
public class AppConfig {

}
