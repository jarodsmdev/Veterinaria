/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */


package com.jarodsmith.model;

public class Cliente extends Base{
	
	/**
	 * Miembros de Clase: atributos
	 */
	private int idCliente;
	private String rut;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String email;
	
	
	/**
	 * Constructor predeterminado
	 */
	public Cliente() {}


	/**
	 * Constructor parametrizado
	 * @param idCliente
	 * @param rut
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param direccion
	 * @param email
	 */
	public Cliente(int idCliente, String rut, String nombre, String apellido, String telefono, String direccion,
			String email) {
		super();
		this.idCliente = idCliente;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
	/**
	 * Método que concatena nombre y apellido de Cliente y los retorna en String
	 * @return String
	 */
	public String nombreCompleto() {
		return this.getNombre() + " "+ this.getApellido();
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", telefono=" + telefono + ", rut=" + rut + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", direccion=" + direccion + ", email=" + email + "]";
	}

	
}
