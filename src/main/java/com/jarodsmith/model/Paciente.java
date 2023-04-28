package com.jarodsmith.model;

import java.util.Date;

public class Paciente {
	
	private int idPaciente;
	private int idCliente;
	private int idEspecie;
	private String nombre;
	private String genero;
	private String color;
	private float peso;
	private String observaciones;
	private Date fechaNacimiento;
	
	public Paciente() {
	}
	
	public Paciente(int idPaciente, int idCliente, int idEspecie, String nombre, String genero, String color,
			float peso, String observaciones, Date fechaNacimiento) {
		this.idPaciente = idPaciente;
		this.idCliente = idCliente;
		this.idEspecie = idEspecie;
		this.nombre = nombre;
		this.genero = genero;
		this.color = color;
		this.peso = peso;
		this.observaciones = observaciones;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", idCliente=" + idCliente + ", idEspecie=" + idEspecie
				+ ", nombre=" + nombre + ", genero=" + genero + ", color=" + color + ", peso=" + peso
				+ ", observaciones=" + observaciones + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
}
