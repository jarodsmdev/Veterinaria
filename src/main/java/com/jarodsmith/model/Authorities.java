/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */
package com.jarodsmith.model;

public class Authorities {

	/**
	 * Miembros de Clase: Atributos
	 */
	private String username;
	private String authority;
	
	/**
	 * Constructor predeterminado
	 */
	public Authorities() {
	}

	/**
	 * Constructor Parametrizado
	 * @param username
	 * @param authority
	 */
	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}
	
}
