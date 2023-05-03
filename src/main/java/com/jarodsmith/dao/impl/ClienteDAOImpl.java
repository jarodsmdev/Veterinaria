package com.jarodsmith.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jarodsmith.dao.ClienteRowMapper;
import com.jarodsmith.dao.GenericDAO;
import com.jarodsmith.dao.UserRowMapper;
import com.jarodsmith.model.Cliente;

public class ClienteDAOImpl implements GenericDAO<Cliente> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String GETONE = "SELECT * FROM cliente WHERE idCliente = ?";
	final String GETONEFORNAME = "SELECT * FROM cliente WHERE nombre = ?";
	final String GETALL = "SELECT * FROM cliente";
	final String INSERT = "INSERT INTO cliente(nombre, apellido, idTelefono, direccion, email) VALUES (?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE cliente SET nombre = ?, apellido = ?, idTelefono = ?, direccion = ?, email = ? WHERE idCliente = ?";
	final String DELETE = "DELETE FROM cliente WHERE idCliente = ?";

	@Override
	public Cliente buscarPorId(int id) {
		Cliente cliente = jdbcTemplate.queryForObject(GETONE, new Object[]{id}, new ClienteRowMapper());
		return cliente;
	}

	@Override
	public Cliente buscarPorNombre(String nombre) {
		Cliente cliente = jdbcTemplate.queryForObject(GETONEFORNAME, new Object[]{nombre}, new ClienteRowMapper());
		return cliente;
	}

	@Override
	public List<Cliente> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		
	}



}
