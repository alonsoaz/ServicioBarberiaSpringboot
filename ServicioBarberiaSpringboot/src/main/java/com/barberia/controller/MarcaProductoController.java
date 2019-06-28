package com.barberia.controller;

import com.barberia.entity.InsertarMarca;
import com.barberia.entity.ListarMarca;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarMarcaInterno;
import com.barberia.model.MarcaProductoModel;
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
@RequestMapping(path = { "/marca" })
public class MarcaProductoController {
	@Autowired
	private MarcaProductoModel MarcaProductoModel;

	public MarcaProductoController(MarcaProductoModel MarcaProductoModel) {
		this.MarcaProductoModel = MarcaProductoModel;
	}

	@GetMapping(value = { "/allmarcas" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarMarca> getMarcas() {
		return MarcaProductoModel.getInstance().getMarcaProductoR();
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarMarcaInterno> getMarcaById(@PathVariable int id) {
		return MarcaProductoModel.getInstance().getMarcaProducto(id);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public MensajesBeans registerMarca(@PathVariable int idUser, @RequestBody InsertarMarca ins) {
		InsertarMarca inst = new InsertarMarca(ins.getMarca());

		return MarcaProductoModel.getInstance().addMarcaProducto(inst, idUser);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> updateMarca(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarMarcaInterno ins) {
		RecuperarMarcaInterno inst = new RecuperarMarcaInterno(ins.getCmarca(), ins.getDidEstado());

		return MarcaProductoModel.getInstance().updtMarcaProducto(id, inst);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		return MarcaProductoModel.getInstance().delMarcaProducto(id);
	}
}
