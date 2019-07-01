package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface TipoProductoService {

	public List<Excepcion> listarTipoProducto(String cod);
	public List<Excepcion> recuperarTipoProducto(String cod);
	public List<Excepcion> registrarTipoProducto(String cod);
	public List<Excepcion> actualizarTipoProducto(String cod);
	public List<Excepcion> eliminarTipoProducto(String cod);
	
}
