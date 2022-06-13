/**
 * 
 */
package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.User;

/**
 * @author 003N75744
 *
 */
public class UserMapper  implements RowMapper<User>{
public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setUser_id(rs.getString("user_id"));
		user.setUser_name(rs.getString("user_name"));
		user.setUser_password(rs.getString("user_password"));
		return user;
	}
}
