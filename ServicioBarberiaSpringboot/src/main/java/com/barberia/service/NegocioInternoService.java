package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface NegocioInternoService {
	
	public List<Excepcion> listarVentas(String cod);
	public List<Excepcion> listarDetalleVentas(String cod);
	public List<Excepcion> listarReservasPorBarbero(String cod);
	public List<Excepcion> listarReservasPorCliente(String cod);

}
