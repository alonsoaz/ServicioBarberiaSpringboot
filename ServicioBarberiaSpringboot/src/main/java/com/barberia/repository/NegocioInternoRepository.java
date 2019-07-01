package com.barberia.repository;

import java.util.List;

import com.barberia.entity.ListarReservasPorBarberoInterno;
import com.barberia.entity.ListarReservasPorClienteInterno;
import com.barberia.entity.MostrarDetalleVentaInterno;
import com.barberia.entity.MostrarVentaInterno;

public interface NegocioInternoRepository {

	public List<MostrarVentaInterno> getVenta();
	public List<MostrarDetalleVentaInterno> getDetVenta(int idVenta);
	public List<ListarReservasPorClienteInterno> getResCliente(int idCliente);
	public List<ListarReservasPorBarberoInterno> getResBarbero(int idBarbero);
	
}
