/**
 * 
 *	@author Leonel Briones Palacios
 *	@version 0.0.1
 */
package com.jarodsmith.model;

public class Base {
	/**
	 * Miembros de clase
	 */
	private int enabled;

	/**
	 * Contructor predefinido
	 */
	public Base() {
	}

	/**
	 * Contructor parametrizado
	 * @param int enabled
	 */
	public Base(int enabled) {
		this.enabled = enabled;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Base [enabled=" + enabled + "]";
	}
	
	
}
