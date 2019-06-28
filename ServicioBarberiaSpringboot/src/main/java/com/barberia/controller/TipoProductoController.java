package com.barberia.controller;

import com.barberia.entity.InsertarTipo;
import com.barberia.entity.ListarTipoProducto;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarTipoProducto;
import com.barberia.model.TipoProductoModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = { "/tipo" })
public class TipoProductoController {
	@Autowired
	private TipoProductoModel TipoProductoModel;

	public TipoProductoController(TipoProductoModel TipoProductoModel) {
		this.TipoProductoModel = TipoProductoModel;
	}

	@GetMapping(value = { "/alltipos" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarTipoProducto> getTipos() {
		return TipoProductoModel.getInstance().getTipoProductoR();
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarTipoProducto> getTipoById(@PathVariable int id) {
		return TipoProductoModel.getInstance().getTipoProducto(id);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public MensajesBeans registerTipo(@PathVariable int idUser, @RequestBody InsertarTipo ins) {
		InsertarTipo inst = new InsertarTipo(ins.getTipo());

		return TipoProductoModel.getInstance().addTipoProducto(inst, idUser);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> updateTipo(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarTipoProducto ins) {
		RecuperarTipoProducto inst = new RecuperarTipoProducto(ins.getbTipo(), ins.getCidEstado());

		return TipoProductoModel.getInstance().updtTipoProducto(id, inst);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		return TipoProductoModel.getInstance().delTipoProducto(id);
	}
}
