package com.barberia.controller;

import com.barberia.entity.BuscarServicio;
import com.barberia.entity.BuscarServicioInterno;
import com.barberia.entity.InsertarServicio;
import com.barberia.entity.ListarServicio;
import com.barberia.entity.ListarServicioInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarServicioInterno;
import com.barberia.repositoryImpl.ServicioRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.ServicioServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Api(value="Rest de Servicios")
public class ServicioController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private ServicioServiceImpl ServicioServiceImpl;
	
	@Autowired
	private ServicioRepositoryImpl ServicioRepositoryImpl;

	public ServicioController(ServicioRepositoryImpl ServicioRepositoryImpl) {
		this.ServicioRepositoryImpl = ServicioRepositoryImpl;
	}

	@GetMapping(value = { "/allservicios" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Servicios.")
	public ResponseEntity<Respuesta<ListarServicioInterno,Responses,Excepcion>>getServicios() {
		Respuesta<ListarServicioInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServicioRecords(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.listarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.listarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/allservicios" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, descripción o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarServicioInterno,Responses,Excepcion>> getServicioByWords(@RequestParam String words) {
		Respuesta<BuscarServicioInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServicioByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.buscarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.buscarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/allservicios" }, produces = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Servicios en la aplicación móvil.")
	public ResponseEntity<Respuesta<ListarServicio,Responses,Excepcion>> getServ() {
		Respuesta<ListarServicio, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServicioR(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.listarServiciosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.listarServiciosA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/allservicios" }, params = {
			"words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias en la aplicación móvil cuyo nombre, descripción o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarServicio,Responses,Excepcion>> getServByWords( @RequestParam String words) {
		Respuesta<BuscarServicio, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.buscarServiciosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.buscarServiciosA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador para el cliente móvil.")
	public ResponseEntity<Respuesta<ListarServicio,Responses,Excepcion>> getServById(@PathVariable int id) {
		Respuesta<ListarServicio, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServicioA(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.recuperarServiciosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.recuperarServiciosA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarServicioInterno,Responses,Excepcion>> getServicioById(@PathVariable int id) {
		Respuesta<RecuperarServicioInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().getServicio(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.recuperarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.recuperarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Registra un servicio tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerServicio(@PathVariable int idUser, @RequestBody InsertarServicio ins) {
		InsertarServicio inst = new InsertarServicio(ins.getBnombser(), ins.getCidEstado(), ins.getDminutos(),
				ins.getEprecio(), ins.getFdescripcion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().addServicio(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.registrarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.registrarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un servicio tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateServicio(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarServicioInterno ins) {
		RecuperarServicioInterno inst = new RecuperarServicioInterno(ins.getBnombser(), ins.getCidEstado(),
				ins.getDminutos(), ins.getEprecio(), ins.getFdescripcion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().updtServicio(id, inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.actualizarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.actualizarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de un servicio tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ServicioRepositoryImpl.getInstance().delServicio(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ServicioServiceImpl.eliminarServicios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ServicioServiceImpl.eliminarServicios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
