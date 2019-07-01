package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface RegDetVentService {
	
	public List<Excepcion> regProdxPagar(String cod);
	public List<Excepcion> mostrarCarrito(String cod);
	public List<Excepcion> eliminarCarrito(String cod);
	public List<Excepcion> pagarCarrito(String cod);
	public List<Excepcion> mostrarDetalleCarrito(String cod);
	public List<Excepcion> recuperarDetalleCarrito(String cod);
	public List<Excepcion> actualizarDetalleCarrito(String cod);
	public List<Excepcion> eliminarDetalleCarrito(String cod);
	public List<Excepcion> pagarDetalleCarrito(String cod);
	public List<Excepcion> listarCompras(String cod);
	public List<Excepcion> listarDetalleDeCompras(String cod);

}
