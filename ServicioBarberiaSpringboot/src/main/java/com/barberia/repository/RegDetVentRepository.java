package com.barberia.repository;

import java.util.List;

import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVenta;
import com.barberia.entity.MostrarDetalleVentaPagada;
import com.barberia.entity.MostrarVentaPagada;
import com.barberia.entity.RecuperarDetalleVenta;
import com.barberia.entity.RegistrarDetalleVentaXpAgar;

public interface RegDetVentRepository {
	
	public List<MessagenID> regDetVent(RegistrarDetalleVentaXpAgar ins, int idClient, int idProd);
	public List<com.barberia.entity.MostrarVentaPorPagar> showVentaXpagar(int idClient);
	public List<MensajesBeans> delVenta(int idCliente);
	public List<MensajesBeans> payVenta(int idCliente);
	public List<MostrarDetalleVenta> ShowDVxPagar(int idCliente);
	public List<RecuperarDetalleVenta> getDV(int id);
	public List<MensajesBeans> updtDetVent(int idDetVent, RegistrarDetalleVentaXpAgar ins);
	public List<MensajesBeans> delDV(int idDetVent);
	public List<MensajesBeans> payDetVenta(int idCliente, int idDetVenta);
	public List<MostrarVentaPagada> showVentaPagada(int idClient);
	public List<MostrarDetalleVentaPagada> showDetVentaPagada(int idClient, int idVenta);
		
}
