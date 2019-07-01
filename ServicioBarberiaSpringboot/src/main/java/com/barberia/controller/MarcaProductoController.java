package com.barberia.controller;

import com.barberia.entity.InsertarMarca;
import com.barberia.entity.ListarMarca;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarMarcaInterno;
import com.barberia.repositoryImpl.MarcaProductoRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.MarcaProductoServiceImpl;

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
@RequestMapping(path = { "/marca" })
@Api(value="Rest de Marcas de los Productos")
public class MarcaProductoController {	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private MarcaProductoRepositoryImpl MarcaProductoRepositoryImpl;
	
	@Autowired
	private MarcaProductoServiceImpl MarcaProductoServiceImpl;

	public MarcaProductoController(MarcaProductoRepositoryImpl MarcaProductoRepositoryImpl) {
		this.MarcaProductoRepositoryImpl = MarcaProductoRepositoryImpl;
	}

	@GetMapping(value = { "/allmarcas" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todas las Marcas.")
	public ResponseEntity<Respuesta<ListarMarca,Responses,Excepcion>> getMarcas() {
		Respuesta<ListarMarca, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = MarcaProductoRepositoryImpl.getInstance().getMarcaProductoR(); 
		
		if(rpt.lista.size()==0) 
		{
			LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=MarcaProductoServiceImpl.listarMarcaProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=MarcaProductoServiceImpl.listarMarcaProducto(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarMarcaInterno,Responses,Excepcion>> getMarcaById(@PathVariable int id) {
		Respuesta<RecuperarMarcaInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = MarcaProductoRepositoryImpl.getInstance().getMarcaProducto(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=MarcaProductoServiceImpl.recuperarMarcaProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=MarcaProductoServiceImpl.recuperarMarcaProducto(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Registra la marca de un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerMarca(@PathVariable int idUser, @RequestBody InsertarMarca ins) {
		InsertarMarca inst = new InsertarMarca(ins.getMarca());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = MarcaProductoRepositoryImpl.getInstance().addMarcaProducto(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=MarcaProductoServiceImpl.registrarMarcaProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=MarcaProductoServiceImpl.registrarMarcaProducto(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de la marca de un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateMarca(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarMarcaInterno ins) {
		RecuperarMarcaInterno inst = new RecuperarMarcaInterno(ins.getCmarca(), ins.getDidEstado());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = MarcaProductoRepositoryImpl.getInstance().updtMarcaProducto(id, inst);
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=MarcaProductoServiceImpl.actualizarMarcaProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=MarcaProductoServiceImpl.actualizarMarcaProducto(HttpStatus.OK.toString().trim()); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de la marca de un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteServicio(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = MarcaProductoRepositoryImpl.getInstance().delMarcaProducto(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=MarcaProductoServiceImpl.eliminarMarcaProducto(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=MarcaProductoServiceImpl.eliminarMarcaProducto(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
