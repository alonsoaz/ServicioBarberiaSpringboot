package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface ClienteService {

	public List<Excepcion> listarClientes (String cod);
	public List<Excepcion> buscarClientes (String cod);
	public List<Excepcion> recuperarCliente (String cod);
	public List<Excepcion> registrarCliente (String cod);
	public List<Excepcion> loginCliente (String cod);
	public List<Excepcion> registrarClienteA (String cod);
	public List<Excepcion> recuperarClienteA (String cod);
	public List<Excepcion> actualizarClienteA (String cod);
	public List<Excepcion> cambairPassCliente (String cod);
	public List<Excepcion> actualizarCliente (String cod);
	public List<Excepcion> eliminarCliente (String cod);
	
}

