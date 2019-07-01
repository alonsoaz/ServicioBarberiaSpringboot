package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface UsuarioService {
	
	public List<Excepcion> listarUsuarios(String cod);
	public List<Excepcion> buscarUsuarios(String cod);
	public List<Excepcion> recuperarUsuario(String cod);
	public List<Excepcion> registrarUsuario(String cod);
	public List<Excepcion> registarUsuarioLogin(String cod);
	public List<Excepcion> loginUsuario(String cod);
	public List<Excepcion> cambiarPassUsuarios(String cod);
	public List<Excepcion> actualizarUsuarios(String cod);
	public List<Excepcion> listarTipoUsuario(String cod);

}
