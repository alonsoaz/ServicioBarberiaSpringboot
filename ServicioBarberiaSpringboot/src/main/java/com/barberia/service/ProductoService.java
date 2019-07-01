package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface ProductoService {

	public List<Excepcion> listarProductos(String cod);
	public List<Excepcion> buscarProductos(String cod);
	public List<Excepcion> listarProductosA(String cod);
	public List<Excepcion> buscarProductosA(String cod);
	public List<Excepcion> recuperarProductosA(String cod);
	public List<Excepcion> recuperarProductos(String cod);
	public List<Excepcion> registrarProductos(String cod);
	public List<Excepcion> actualizarProductos(String cod);
	public List<Excepcion> eliminarProductos(String cod);
	
}
