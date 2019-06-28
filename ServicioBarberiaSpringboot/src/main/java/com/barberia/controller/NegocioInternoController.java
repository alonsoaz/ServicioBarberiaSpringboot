package com.barberia.controller;

import com.barberia.entity.ListarReservasPorBarberoInterno;
import com.barberia.entity.MostrarDetalleVentaInterno;
import com.barberia.entity.MostrarVentaInterno;
import com.barberia.model.NegocioInternoModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/negocio" })
public class NegocioInternoController {
	@Autowired
	private NegocioInternoModel NegocioInternoModel;

	public NegocioInternoController(NegocioInternoModel NegocioInternoModel) {
		this.NegocioInternoModel = NegocioInternoModel;
	}

	@GetMapping(value = { "/{idUser}/tienda/allventas" }, produces = { "application/json" })
	@ResponseBody
	public List<MostrarVentaInterno> getVenta(@PathVariable int idUser) {
		return NegocioInternoModel.getInstance().getVenta();
	}

	@GetMapping(value = { "/{idUser}/tienda/{idVenta}" }, produces = { "application/json" })
	@ResponseBody
	public List<MostrarDetalleVentaInterno> getDetVenta(@PathVariable int idUser, @PathVariable int idVenta) {
		return NegocioInternoModel.getInstance().getDetVenta(idVenta);
	}

	@GetMapping(value = { "/{idUser}/tienda/reserva/allreservas/barbero/{idBarbero}" }, produces = {
			"application/json" })
	@ResponseBody
	public List<ListarReservasPorBarberoInterno> getResBarbero(@PathVariable int idUser, @PathVariable int idBarbero) {
		return NegocioInternoModel.getInstance().getResBarbero(idBarbero);
	}

	@GetMapping(value = { "/{idUser}/tienda/reserva/allreservas/cliente/{idClient}" }, produces = {
			"application/json" })
	@ResponseBody
	public List<com.barberia.entity.ListarReservasPorClienteInterno> getResCliente(@PathVariable int idUser,
			@PathVariable int idClient) {
		return NegocioInternoModel.getInstance().getResCliente(idClient);
	}
}
