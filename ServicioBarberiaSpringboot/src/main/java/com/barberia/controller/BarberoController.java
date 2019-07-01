package com.barberia.controller;

import com.barberia.entity.BuscarBarbero;
import com.barberia.entity.BuscarBarberoInterno;
import com.barberia.entity.InsertarBarbero;
import com.barberia.entity.ListarBarbero;
import com.barberia.entity.ListarBarberoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarBarberoInterno;
import com.barberia.repositoryImpl.BarberoRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.BarberoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Api(value="Rest de Barberos")
public class BarberoController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());

	
	@Autowired
	private BarberoRepositoryImpl BarberoRepositoryImpl;
	
	@Autowired
	private BarberoServiceImpl BarberoServiceImpl;

	public BarberoController(BarberoRepositoryImpl BarberoRepositoryImpl) {
		this.BarberoRepositoryImpl = BarberoRepositoryImpl;
	}

	
	@GetMapping(value = { "/allbarberos" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Barberos.")
	public ResponseEntity<Respuesta<ListarBarberoInterno,Responses,Excepcion>> getBarberos() {
		Respuesta<ListarBarberoInterno, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = BarberoRepositoryImpl.getInstance().getBarberoRecords(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.listarBarberoInterno(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=BarberoServiceImpl.listarBarberoInterno(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
	
	@GetMapping(value = { "/android/allbarberos" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Barberos para el cliente móvil.")
	public ResponseEntity<Respuesta<ListarBarbero,Responses, Excepcion>> getBarberoR() {
		Respuesta<ListarBarbero, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().getBarberoR(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.listarBarberoInterno(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=BarberoServiceImpl.listarBarberoInterno(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/allbarberos" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, apellido o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarBarberoInterno,Responses,Excepcion>> getBarberoByWords(@RequestParam String words) {
		
		Respuesta<BuscarBarberoInterno, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().getBarberoByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.buscarBarberoInterno(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=BarberoServiceImpl.buscarBarberoInterno(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
		
	}

	@GetMapping(value = { "/android/allbarberos" }, params = { "words" }, produces = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, apellido o código concuerde con un parámetro de texto para el cliente móvil.")
	public ResponseEntity<Respuesta<BuscarBarbero,Responses, Excepcion>> getBarbByWords(
			@RequestParam String words) {
		Respuesta<BuscarBarbero, Responses, Excepcion> rpt = new Respuesta<>();
		
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().getBarbByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.listarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
	    rpt.excepcion=BarberoServiceImpl.listarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador para el cliente móvil.")
	public ResponseEntity<Respuesta<ListarBarbero,Responses,Excepcion>> getBarbById(@PathVariable int id) {
		Respuesta<ListarBarbero, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().getBarberoA(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.buscarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=BarberoServiceImpl.buscarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarBarberoInterno,Responses, Excepcion>> getBarberoById(@PathVariable int id) {
		Respuesta<RecuperarBarberoInterno, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().getBarbero(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.recuperarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=BarberoServiceImpl.recuperarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Registra un barbero tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses, Excepcion>> registerBarbero(@PathVariable int idUser, @RequestBody InsertarBarbero ins) {
		InsertarBarbero inst = new InsertarBarbero(ins.getAnombre(), ins.getBapellido(), ins.getCtelefono(),
				ins.getDdni(), ins.getEcorreo(), ins.getFdireccion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = BarberoRepositoryImpl.getInstance().addBarbero(ins, idUser);
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.registrarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
	    rpt.excepcion=BarberoServiceImpl.registrarBarbero(HttpStatus.OK.toString().trim()); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un barbero tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>>  updateBarber(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarBarberoInterno ins) {
		RecuperarBarberoInterno inst = new RecuperarBarberoInterno(ins.getAidEstado(), ins.getBNombre(),
				ins.getCApellido(), ins.getDTelefono(), ins.getEDni(), ins.getFEmail(), ins.getGDireccion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = BarberoRepositoryImpl.getInstance().updtBarbero(id, ins, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.actualizarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
	    rpt.excepcion=BarberoServiceImpl.actualizarBarbero(HttpStatus.OK.toString().trim());

		
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de un barbero tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteUser(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses,Excepcion> rpt = new Respuesta<>();
		Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = BarberoRepositoryImpl.getInstance().delBarbero(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=BarberoServiceImpl.eliminarBarbero
		    		(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
	    rpt.excepcion=BarberoServiceImpl.eliminarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
