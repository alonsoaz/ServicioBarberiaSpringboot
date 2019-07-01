package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface MarcaProductoService {

	public List<Excepcion> listarMarcaProducto(String cod);
	public List<Excepcion> recuperarMarcaProducto(String cod);
	public List<Excepcion> registrarMarcaProducto(String cod);
	public List<Excepcion> actualizarMarcaProducto(String cod);
	public List<Excepcion> eliminarMarcaProducto(String cod);
	
}
