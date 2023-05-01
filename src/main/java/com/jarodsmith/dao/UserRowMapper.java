package com.jarodsmith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;

public class UserRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {

		Users user = new Users();
		
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getInt("enabled"));
    
        //System.out.println("[USERROWMAPPER]: " + user.toString()); //DEBUG
        return user;
	}

}
