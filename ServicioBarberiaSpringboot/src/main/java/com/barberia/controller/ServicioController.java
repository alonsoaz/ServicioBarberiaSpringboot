package com.barberia.controller;

import com.barberia.entity.BuscarServicioInterno;
import com.barberia.entity.InsertarServicio;
import com.barberia.entity.ListarServicio;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarServicioInterno;
import com.barberia.model.ServicioModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/servicio" })
public class ServicioController {
	@Autowired
	private ServicioModel ServicioModel;

	public ServicioController(ServicioModel ServicioModel) {
		this.ServicioModel = ServicioModel;
	}

	@GetMapping(value = { "/allservicios" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.ListarServicioInterno> getServicios() {
		return ServicioModel.getInstance().getServicioRecords();
	}

	@GetMapping(value = { "/allservicios" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	public List<BuscarServicioInterno> getServicioByWords(@RequestParam String words) {
		return ServicioModel.getInstance().getServicioByWords(words);
	}

	@GetMapping(value = { "/android/allservicios" }, produces = {
			"application/json" })
	@ResponseBody
	public List<ListarServicio> getServ() {
		return ServicioModel.getInstance().getServicioR();
	}

	@GetMapping(value = { "/android/allservicios" }, params = {
			"words" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.BuscarServicio> getServByWords( @RequestParam String words) {
		return ServicioModel.getInstance().getServByWords(words);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarServicio> getServById(@PathVariable int id) {
		return ServicioModel.getInstance().getServicioA(id);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarServicioInterno> getServicioById(@PathVariable int id) {
		return ServicioModel.getInstance().getServicio(id);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> registerServicio(@PathVariable int idUser, @RequestBody InsertarServicio ins) {
		InsertarServicio inst = new InsertarServicio(ins.getBnombser(), ins.getCidEstado(), ins.getDminutos(),
				ins.getEprecio(), ins.getFdescripcion());

		return ServicioModel.getInstance().addServicio(inst, idUser);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> updateServicio(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarServicioInterno ins) {
		RecuperarServicioInterno inst = new RecuperarServicioInterno(ins.getBnombser(), ins.getCidEstado(),
				ins.getDminutos(), ins.getEprecio(), ins.getFdescripcion());

		return ServicioModel.getInstance().updtServicio(id, inst, idUser);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		return ServicioModel.getInstance().delServicio(id);
	}
}
