package com.jarodsmith.model;

import java.util.Date;

public class Atencion {

	private int idAtencion;
	private int idPaciente;
	private int idServicio;
	private String username;
	private Date fechaAtencion;
	
	public Atencion() {
	}

	public Atencion(int idAtencion, int idPaciente, int idServicio, String username, Date fechaAtencion) {
		this.idAtencion = idAtencion;
		this.idPaciente = idPaciente;
		this.idServicio = idServicio;
		this.username = username;
		this.fechaAtencion = fechaAtencion;
	}

	public int getIdAtencion() {
		return idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	@Override
	public String toString() {
		return "Atencion [idAtencion=" + idAtencion + ", idPaciente=" + idPaciente + ", idServicio=" + idServicio
				+ ", username=" + username + ", fechaAtencion=" + fechaAtencion + "]";
	}
	
	
}
