/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */
package com.jarodsmith.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Users {

	/**
	* Miembros de Clase: propiedades
	*/
	@NotNull
	@NotBlank(message = "Campo requerido")
	//@Size(min = 2, message= "Campo requerido")
	private String username;
	@NotNull
	@NotBlank(message = "Campo requerido")
	private String password;
	private int enabled;
	private List<Authorities> authorities;
	
	/**
	 * Constructor predeterminado
	 */
	public Users() {
	}
	
	/**
	 * Constructor Parametrizado
	 * @param username
	 * @param password
	 * @param enabled
	 * @param authorities
	 */
	public Users(String username, String password, int enabled, List<Authorities> authorities) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}


	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authorities="
				+ authorities + "]";
	}

}
