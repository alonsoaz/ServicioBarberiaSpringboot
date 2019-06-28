package com.barberia.controller;

import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVentaPagada;
import com.barberia.entity.MostrarVentaPagada;
import com.barberia.entity.RecuperarDetalleVenta;
import com.barberia.entity.RegistrarDetalleVentaXpAgar;
import com.barberia.model.RegDetVentModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/compras" })
public class RegDetVentController {
	@Autowired
	private RegDetVentModel RegDetVentModel;

	public RegDetVentController(RegDetVentModel RegDetVentModel) {
		this.RegDetVentModel = RegDetVentModel;
	}

	@PostMapping(value = {"/{idClient}/android/producto/{idProd}" }, produces = {
					"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MessagenID> registerProducto(@PathVariable int idClient, @PathVariable int idProd,
			@RequestBody RegistrarDetalleVentaXpAgar ins) {
		RegistrarDetalleVentaXpAgar inst = new RegistrarDetalleVentaXpAgar(ins.getCantidad());

		return RegDetVentModel.getInstance().regDetVent(inst, idClient, idProd);
	}

	@GetMapping(value = { "/{idClient}/android/carrito" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.MostrarVentaPorPagar> showVentaXpagar(@PathVariable int idClient) {
		return RegDetVentModel.getInstance().showVentaXpagar(idClient);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/delete" }, produces = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteVentaXpagar(@PathVariable int idClient) {
		return RegDetVentModel.getInstance().delVenta(idClient);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/pagar" }, produces = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> payVentaXpagar(@PathVariable int idClient) {
		return RegDetVentModel.getInstance().payVenta(idClient);
	}

	@GetMapping(value = { "/{idClient}/android/carrito/detalle" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.MostrarDetalleVenta> ShowDVxPagar(@PathVariable int idClient) {
		return RegDetVentModel.getInstance().ShowDVxPagar(idClient);
	}

	@GetMapping(value = { "/{idClient}/android/carrito/detalle/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarDetalleVenta> getDV(@PathVariable int idClient, @PathVariable int id) {
		return RegDetVentModel.getInstance().getDV(id);
	}

	@PutMapping(value = { "/{idClient}/android/carrito/detalle/update/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> updtDetVent(@PathVariable int idClient, @PathVariable int id,
			@RequestBody RegistrarDetalleVentaXpAgar ins) {
		RegistrarDetalleVentaXpAgar inst = new RegistrarDetalleVentaXpAgar(ins.getCantidad());

		return RegDetVentModel.getInstance().updtDetVent(id, inst);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/detalle/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> delDV(@PathVariable int id) {
		return RegDetVentModel.getInstance().delDV(id);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/detalle/pagar/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> payDetVentaXpagar(@PathVariable int idClient, @PathVariable int id) {
		return RegDetVentModel.getInstance().payDetVenta(idClient, id);
	}

	@GetMapping(value = { "/{idClient}/android/allcompras" }, produces = { "application/json" })
	@ResponseBody
	public List<MostrarVentaPagada> showVentaPagada(@PathVariable int idClient) {
		return RegDetVentModel.getInstance().showVentaPagada(idClient);
	}

	@GetMapping(value = { "/{idClient}/android/allcompras/detalle/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<MostrarDetalleVentaPagada> showVentaPagada(@PathVariable int idClient, @PathVariable int id) {
		return RegDetVentModel.getInstance().showDetVentaPagada(idClient, id);
	}
}
