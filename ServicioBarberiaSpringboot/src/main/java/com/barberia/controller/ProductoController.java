package com.barberia.controller;

import com.barberia.entity.BuscaProductoInterno;
import com.barberia.entity.BuscarProducto;
import com.barberia.entity.InsertarProducto;
import com.barberia.entity.ListarProducto;
import com.barberia.entity.ListarProductoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarProductoInterno;
import com.barberia.repositoryImpl.ProductoRepositoryImpl;
import com.barberia.service.ProductoService;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.ProductoServiceImpl;

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
@org.springframework.web.bind.annotation.RequestMapping(path = { "/producto" })
@Api(value="Rest de Productos")
public class ProductoController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private ProductoRepositoryImpl ProductoRepositoryImpl;
	
	@Autowired
	private ProductoServiceImpl ProductoServiceImpl;

	public ProductoController(ProductoRepositoryImpl ProductoRepositoryImpl) {
		this.ProductoRepositoryImpl = ProductoRepositoryImpl;
	}

	@GetMapping(value = { "/allproductos" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Productos.")
	public ResponseEntity<Respuesta<ListarProductoInterno,Responses,Excepcion>> getProductos() {
		Respuesta<ListarProductoInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().getProductoRecords(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.listarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.listarProductos(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/allproductos" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, descripción o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscaProductoInterno,Responses,Excepcion>> getProductoByWords(@RequestParam String words) {
		Respuesta<BuscaProductoInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().getProductoByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.buscarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.buscarProductos(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/allproductos" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Productos en la aplicación móvil.")
	public ResponseEntity<Respuesta<ListarProducto,Responses,Excepcion>> getProdA() {
		Respuesta<ListarProducto, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().getProductoR(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.listarProductosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.listarProductosA(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/allproductos" }, params = { "words" }, produces = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias en la aplicación móvil cuyo nombre, descripción o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarProducto,Responses,Excepcion>> getServByWords(@RequestParam String words) {
		Respuesta<BuscarProducto, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		rpt.lista = ProductoRepositoryImpl.getInstance().getProdByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.buscarProductosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.buscarProductosA(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador para el cliente móvil.")
	public ResponseEntity<Respuesta<ListarProducto,Responses,Excepcion>> getServById(@PathVariable int id) {
		Respuesta<ListarProducto, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().getProd(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.recuperarProductosA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.recuperarProductosA(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarProductoInterno,Responses,Excepcion>> getServicioById(@PathVariable int id) {
		Respuesta<RecuperarProductoInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().getProducto(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.recuperarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.recuperarProductos(HttpStatus.OK.toString().trim());


		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerProducto(@PathVariable int idUser, @RequestBody InsertarProducto ins) {
		InsertarProducto inst = new InsertarProducto(ins.getAnombre(), ins.getBidMarca(), ins.getCidTipo(),
				ins.getDStock(), ins.getEPrecio(), ins.getFdescripcion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		rpt.lista = ProductoRepositoryImpl.getInstance().addProducto(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.registrarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.registrarProductos(HttpStatus.OK.toString().trim());

		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateProducto(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarProductoInterno ins) {
		RecuperarProductoInterno inst = new RecuperarProductoInterno(ins.getAIdMarca(), ins.getBidTipo(),
				ins.getCNombre(), ins.getDidEstado(), ins.getFStock(), ins.getGPrecio(), ins.getHdescripcion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ProductoRepositoryImpl.getInstance().updtProducto(id, inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.actualizarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.actualizarProductos(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de un producto tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteProducto(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		rpt.lista = ProductoRepositoryImpl.getInstance().delProducto(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ProductoServiceImpl.eliminarProductos(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ProductoServiceImpl.eliminarProductos(HttpStatus.OK.toString().trim());

		
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
