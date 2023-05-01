package com.jarodsmith.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jarodsmith.dao.AuthoritiesRowMapper;
import com.jarodsmith.dao.GenericDAO;
import com.jarodsmith.dao.UserRowMapper;
import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;

@Repository
public class AuthoritiesDAOImpl implements GenericDAO<Authorities> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String GETONEFORID = "";
	final String GETROLESFORUSERNAME = "SELECT * FROM authorities WHERE username = ?;";
	final String GETALL = "";
	final String INSERT = "INSERT INTO authorities(username, authority) VALUES (?, ?)";
	final String UPDATE = "";
	final String DELETEFORUSERNAME = "DELETE FROM authorities WHERE username = ?";
	
	public List<Authorities> buscarRolesPorUsername(String username){
		List<Authorities> listaRoles = jdbcTemplate.query(GETROLESFORUSERNAME, new Object[]{username}, new AuthoritiesRowMapper());
		return listaRoles;
	}
	
	public void eliminarRolesPorUsername(String username) {
		//System.out.println("[DAOELIMINAR]: " + username); //DEBUG
		jdbcTemplate.update(DELETEFORUSERNAME, username);
	}

	@Override
	public Authorities buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authorities buscarPorNombre(String nombre) {
		// TODO
		return null;
	}

	@Override
	public List<Authorities> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Authorities objeto) {
		Object[]params = {objeto.getUsername(), objeto.getAuthority()};
		jdbcTemplate.update(INSERT, params);
		//System.out.println("[DAO]: " + objeto.toString()); //DEBUG
		
	}

	@Override
	public void actualizar(Authorities objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		
	}

}
