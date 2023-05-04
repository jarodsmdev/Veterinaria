package com.jarodsmith.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jarodsmith.dao.ClienteRowMapper;
import com.jarodsmith.dao.GenericDAO;
import com.jarodsmith.model.Cliente;


@Repository
public class ClienteDAOImpl implements GenericDAO<Cliente> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String GETONE = "SELECT * FROM cliente WHERE idCliente = ?";
	final String GETONEFORNAME = "SELECT * FROM cliente WHERE nombre = ?";
	final String GETALL = "SELECT * FROM cliente";
	final String INSERT = "INSERT INTO cliente(nombre, apellido, telefono, direccion, email) VALUES (?, ?, ?, ?, ?)";
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
		List<Cliente> clienteList = jdbcTemplate.query(GETALL, new ClienteRowMapper());
		return clienteList;
	}

	@Override
	public void insertar(Cliente objeto) {
		Object[]params = {objeto.getNombre(), objeto.getApellido(), objeto.getTelefono(), objeto.getDireccion(), objeto.getEmail()};
		jdbcTemplate.update(INSERT, params);
	}

	@Override
	public void actualizar(Cliente objeto) {
		Object[]params = {objeto.getNombre(), objeto.getApellido(), objeto.getTelefono(), objeto.getDireccion(), objeto.getEmail(), objeto.getIdCliente()};
		jdbcTemplate.update(INSERT, params);
	}

	@Override
	public void borrar(int id) {
		jdbcTemplate.update(DELETE, id);
	}

}
