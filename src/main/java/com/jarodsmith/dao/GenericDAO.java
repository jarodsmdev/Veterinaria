package com.jarodsmith.dao;

import java.util.List;

public interface GenericDAO <T> {
	
	public T buscarPorId(int id);
	public T buscarPorNombre(String nombre);
	public List<T> obtenerTodos();
	public void insertar(T objeto);
	public void actualizar(T objeto);
	public void borrar(int id);
}
