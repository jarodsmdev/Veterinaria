/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */
package com.jarodsmith.model;

public class Telefono {
	
	/**
	 * Miembros de clase: Atributos
	 */
	private int idTelefono;
	private String telefono;
	
	/**
	 * Constructor predeterminado
	 */
	public Telefono() {}
	
	/**
	 * Constructor parametrizado
	 * @param idTelefono
	 * @param telefono
	 */
	public Telefono(int idTelefono, String telefono) {
		this.idTelefono = idTelefono;
		this.telefono = telefono;
	}


	public int getIdTelefono() {
		return idTelefono;
	}


	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", telefono=" + telefono + "]";
	}
	
	
}
