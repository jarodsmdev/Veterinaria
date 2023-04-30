/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */
package com.jarodsmith.model;

public class Especie {

	/**
	 * Miembros de clase: Atributos
	 */
	private int idEspecie;
	private String especie;
	
	/**
	 * Constructor predeterminado
	 */
	public Especie() {
	}

	/**
	 * Constructor parametrizado
	 * @param idEspecie
	 * @param especie
	 */
	public Especie(int idEspecie, String especie) {
		this.idEspecie = idEspecie;
		this.especie = especie;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Especie [idEspecie=" + idEspecie + ", especie=" + especie + "]";
	}
	
	
}
