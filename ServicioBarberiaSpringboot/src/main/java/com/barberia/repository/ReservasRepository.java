package com.barberia.repository;

import java.util.List;

import com.barberia.entity.BuscarReservaPorCliente;
import com.barberia.entity.ConsultaDisponibilidadBarbero;
import com.barberia.entity.ListarReservasPorCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;

public interface ReservasRepository {

	public List<MensajesBeans> askBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idServicio) ;
	public List<MessagenID> tryBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idCliente, int idServicio);
	public List<ListarReservasPorCliente> getReservas(int idCliente);
	public List<BuscarReservaPorCliente> getReserva(int idCliente, int idReserva);
	public List<MensajesBeans> delReserva(int idCliente, int idReserva);
	public List<MensajesBeans> payReserva(int idCliente, int idReserva);
	
}
