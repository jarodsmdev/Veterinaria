package com.jarodsmith.model;

public class Cliente {
	
	private int idCliente;
	private int idTelefono;
	private String rut;
	private String nombre;
	private String apellido;
	private String direccion;
	private String email;
	
	public Cliente() {}

	public Cliente(int idCliente, int idTelefono, String rut, String nombre, String apellido, String direccion,
			String email) {
		this.idCliente = idCliente;
		this.idTelefono = idTelefono;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", idTelefono=" + idTelefono + ", rut=" + rut + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", direccion=" + direccion + ", email=" + email + "]";
	}
	
	
}
