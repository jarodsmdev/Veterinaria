package com.jarodsmith.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jarodsmith.dao.GenericDAO;
import com.jarodsmith.dao.UserRowMapper;
import com.jarodsmith.model.Users;

@Repository
public class UserDAOImpl implements GenericDAO<Users> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String GETONEFORID = "SELECT * FROM users INNER JOIN authorities ON users.username = authorities.username";
	final String GETONEFORNAME = "SELECT * FROM users WHERE username = ?;";
	final String GETALL = "SELECT * FROM users;";
	final String INSERT = "INSERT INTO users (username, password, enabled) VALUES (?, ? , ?)";
	final String UPDATE = "UPDATE users SET password = ?, enabled = ? WHERE username = ?";
	final String DELETEFORUSERNAME = "DELETE FROM users WHERE username = ?";

	@Override
	public Users buscarPorId(int id) {
		Users user = jdbcTemplate.queryForObject(GETONEFORID, new Object[]{id}, new UserRowMapper());
		return user;
	}

	/**
	 * Método que retorna un objeto tipo Users
	 * @param nombre String
	 * @return
	 */
	@Override
	public Users buscarPorNombre(String nombre) {
		Users user = jdbcTemplate.queryForObject(GETONEFORNAME, new Object[]{nombre}, new UserRowMapper());
		return user;
	}

	/**
	 * Método que retorna una lista de objetos tipo Users
	 * @return userList List<Users>
	 */
	@Override
	public List<Users> obtenerTodos() {
		List<Users> usersList = jdbcTemplate.query(GETALL, new UserRowMapper());
		return usersList;
	}

	@Override
	public void insertar(Users objeto) {
		Object[]params = {objeto.getUsername(), objeto.getPassword(), objeto.getEnabled()};
		jdbcTemplate.update(INSERT, params);
		//System.out.println("[DAO]: " + objeto.toString()); //DEBUG
	}

	@Override
	public void actualizar(Users objeto) {
		Object[]params = {objeto.getPassword(), objeto.getEnabled(), objeto.getUsername()};
		jdbcTemplate.update(UPDATE, params);

	}

	@Override
	public void borrar(int id) {
		//NO SE IMPLEMENTA YA QUE LA BASE DE DATOS NO MANEJA ID PARA LA TABLA USUARIOS
	}
	
	public void borrarPorUsername(String username) {
		//System.out.println("[DAO]: " + username);
		jdbcTemplate.update(DELETEFORUSERNAME, username);
	}

}
