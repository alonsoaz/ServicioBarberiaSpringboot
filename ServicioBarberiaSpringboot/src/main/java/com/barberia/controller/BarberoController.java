package com.barberia.controller;

import com.barberia.entity.BuscarBarberoInterno;
import com.barberia.entity.InsertarBarbero;
import com.barberia.entity.ListarBarbero;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarBarberoInterno;
import com.barberia.model.BarberoModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/barbero" })
public class BarberoController {
	@Autowired
	private BarberoModel BarberoModel;

	public BarberoController(BarberoModel BarberoModel) {
		this.BarberoModel = BarberoModel;
	}

	@GetMapping(value = { "/allbarberos" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.ListarBarberoInterno> getBarberos() {
		return BarberoModel.getInstance().getBarberoRecords();
	}
	
	@GetMapping(value = { "/android/allbarberos" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarBarbero> getBarberoR() {
		return BarberoModel.getInstance().getBarberoR();
	}

	@GetMapping(value = { "/allbarberos" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	public List<BuscarBarberoInterno> getBarberoByWords(@RequestParam String words) {
		return BarberoModel.getInstance().getBarberoByWords(words);
	}

	@GetMapping(value = { "/android/allbarberos" }, params = { "words" }, produces = {
			"application/json" })
	@ResponseBody
	public List<com.barberia.entity.BuscarBarbero> getBarbByWords(
			@RequestParam String words) {
		return BarberoModel.getInstance().getBarbByWords(words);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarBarbero> getBarbById(@PathVariable int id) {
		return BarberoModel.getInstance().getBarberoA(id);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarBarberoInterno> getBarberoById(@PathVariable int id) {
		return BarberoModel.getInstance().getBarbero(id);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> registerUsuario(@PathVariable int idUser, @RequestBody InsertarBarbero ins) {
		InsertarBarbero inst = new InsertarBarbero(ins.getAnombre(), ins.getBapellido(), ins.getCtelefono(),
				ins.getDdni(), ins.getEcorreo(), ins.getFdireccion());

		return BarberoModel.getInstance().addBarbero(ins, idUser);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> updateBarber(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarBarberoInterno ins) {
		RecuperarBarberoInterno inst = new RecuperarBarberoInterno(ins.getAidEstado(), ins.getbNombre(),
				ins.getcApellido(), ins.getdTelefono(), ins.geteDni(), ins.getfEmail(), ins.getgDireccion());

		return BarberoModel.getInstance().updtBarbero(id, ins, idUser);
	}

	@PutMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteUser(@PathVariable int idUser, @PathVariable int id) {
		return BarberoModel.getInstance().delBarbero(id);
	}
}
