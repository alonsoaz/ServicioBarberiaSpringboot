package com.barberia.controller;

import com.barberia.entity.InsertarTipo;
import com.barberia.entity.ListarTipoProducto;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarTipoProducto;
import com.barberia.repositoryImpl.TipoProductoRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.TipoProductoServiceImpl;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = { "/tipo" })
@Api(value="Rest de Tipos de Productos")
public class TipoProductoController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	
	@Autowired
	private TipoProductoRepositoryImpl TipoProductoRepositoryImpl;
	
	@Autowired
	private TipoProductoServiceImpl TipoProductoServiceImpl;

	public TipoProductoController(TipoProductoRepositoryImpl TipoProductoRepositoryImpl) {
		this.TipoProductoRepositoryImpl = TipoProductoRepositoryImpl;
	}

	@GetMapping(value = { "/alltipos" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Tipos de productos.")
	public ResponseEntity<Respuesta<ListarTipoProducto,Responses,Excepcion>> getTipos() {
		Respuesta<ListarTipoProducto, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(TipoProductoRepositoryImpl.getInstance().getTipoProductoR().size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=TipoProductoServiceImpl.listarTipoProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=TipoProductoServiceImpl.listarTipoProducto(HttpStatus.OK.toString().trim());

		rpt.lista = TipoProductoRepositoryImpl.getInstance().getTipoProductoR(); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarTipoProducto,Responses,Excepcion>> getTipoById(@PathVariable int id) {
		Respuesta<RecuperarTipoProducto, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(TipoProductoRepositoryImpl.getInstance().getTipoProducto(id).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=TipoProductoServiceImpl.recuperarTipoProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=TipoProductoServiceImpl.recuperarTipoProducto(HttpStatus.OK.toString().trim());

		rpt.lista = TipoProductoRepositoryImpl.getInstance().getTipoProducto(id); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Registra un tipo de producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerTipo(@PathVariable int idUser, @RequestBody InsertarTipo ins) {
		InsertarTipo inst = new InsertarTipo(ins.getTipo());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(TipoProductoRepositoryImpl.getInstance().addTipoProducto(inst, idUser).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=TipoProductoServiceImpl.registrarTipoProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=TipoProductoServiceImpl.registrarTipoProducto(HttpStatus.OK.toString().trim());

		rpt.lista = TipoProductoRepositoryImpl.getInstance().addTipoProducto(inst, idUser); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un tipo de producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateTipo(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarTipoProducto ins) {
		RecuperarTipoProducto inst = new RecuperarTipoProducto(ins.getbTipo(), ins.getCidEstado());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(TipoProductoRepositoryImpl.getInstance().updtTipoProducto(id, inst).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=TipoProductoServiceImpl.actualizarTipoProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=TipoProductoServiceImpl.actualizarTipoProducto(HttpStatus.OK.toString().trim());

		rpt.lista = TipoProductoRepositoryImpl.getInstance().updtTipoProducto(id, inst); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de un tipo de producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(TipoProductoRepositoryImpl.getInstance().delTipoProducto(id).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=TipoProductoServiceImpl.eliminarTipoProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=TipoProductoServiceImpl.eliminarTipoProducto(HttpStatus.OK.toString().trim());

		rpt.lista = TipoProductoRepositoryImpl.getInstance().delTipoProducto(id); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
