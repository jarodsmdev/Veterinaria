package com.jarodsmith.model;

public class Telefono {
	private int idTelefono;
	private String telefono;
	
	public Telefono() {}
	
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
