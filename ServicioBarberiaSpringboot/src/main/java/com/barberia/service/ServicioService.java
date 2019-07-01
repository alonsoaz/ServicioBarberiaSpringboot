package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface ServicioService {
	
	public List<Excepcion> listarServicios(String cod);
	public List<Excepcion> buscarServicios(String cod);
	public List<Excepcion> listarServiciosA(String cod);
	public List<Excepcion> buscarServiciosA(String cod);
	public List<Excepcion> recuperarServiciosA(String cod);
	public List<Excepcion> recuperarServicios(String cod);
	public List<Excepcion> registrarServicios(String cod);
	public List<Excepcion> actualizarServicios(String cod);
	public List<Excepcion> eliminarServicios(String cod);

}
