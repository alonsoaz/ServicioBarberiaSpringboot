package com.barberia.service;

import java.util.List;

import com.barberia.response.Excepcion;

public interface ReservasServicio {
	
	public List<Excepcion> consultarBarbero(String cod);
	public List<Excepcion> reservarBarbero(String cod);
	public List<Excepcion> listarReservasporCliente(String cod);
	public List<Excepcion> recuperarReservasporCliente(String cod);
	public List<Excepcion> eliminarReservaporCliente(String cod);
	public List<Excepcion> pagarReservasporCliente(String cod);

}
