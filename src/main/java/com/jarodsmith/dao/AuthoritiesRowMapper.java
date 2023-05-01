package com.jarodsmith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jarodsmith.model.Authorities;

public class AuthoritiesRowMapper implements RowMapper<Authorities> {
	

	@Override
	public Authorities mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authorities authorities = new Authorities();
		authorities.setUsername(rs.getString("username"));
		authorities.setAuthority(rs.getString("authority"));
		return authorities;
	}
	
}
