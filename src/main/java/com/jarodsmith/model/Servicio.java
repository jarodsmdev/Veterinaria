/**
 * @author Leonel Briones Palacios
 * @version 0.0.1
 */
package com.jarodsmith.model;

public class Servicio {

	/**
	 * Miembros de clase: Atributos
	 */
	private int idServicio;
	private String servicio;
	private int valor;
	
	/**
	 * Constructor predeterminado
	 */
	public Servicio() {
	}

	/**
	 * Constructor parametrizado
	 * @param idServicio
	 * @param servicio
	 * @param valor
	 */
	public Servicio(int idServicio, String servicio, int valor) {
		this.idServicio = idServicio;
		this.servicio = servicio;
		this.valor = valor;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", servicio=" + servicio + ", valor=" + valor + "]";
	}
	
	
}
