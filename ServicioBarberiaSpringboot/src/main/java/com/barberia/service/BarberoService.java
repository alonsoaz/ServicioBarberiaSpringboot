package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface BarberoService {

	public List<Excepcion> listarBarberoInterno(String cod);
	public List<Excepcion> buscarBarberoInterno(String cod);
	public List<Excepcion> listarBarbero(String cod);
	public List<Excepcion> buscarBarbero(String cod);
	public List<Excepcion> recuperarBarbero(String cod);
	public List<Excepcion> registrarBarbero(String cod);
	public List<Excepcion> actualizarBarbero(String cod);
	public List<Excepcion> eliminarBarbero(String cod);
	
}
