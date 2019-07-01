package com.barberia.controller;

import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVenta;
import com.barberia.entity.MostrarDetalleVentaPagada;
import com.barberia.entity.MostrarVentaPagada;
import com.barberia.entity.MostrarVentaPorPagar;
import com.barberia.entity.RecuperarDetalleVenta;
import com.barberia.entity.RegistrarDetalleVentaXpAgar;
import com.barberia.repositoryImpl.RegDetVentRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.RegDetVentServiceImpl;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/compras" })
@Api(value="Rest de Compras")
public class RegDetVentController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private RegDetVentRepositoryImpl RegDetVentRepositoryImpl;
	
	@Autowired
	private RegDetVentServiceImpl RegDetVentServiceImpl;

	public RegDetVentController(RegDetVentRepositoryImpl RegDetVentRepositoryImpl) {
		this.RegDetVentRepositoryImpl = RegDetVentRepositoryImpl;
	}

	@PostMapping(value = {"/{idClient}/android/producto/{idProd}" }, produces = {
					"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra un producto dentro del carrito de compras.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> registerProducto(@PathVariable int idClient, @PathVariable int idProd,
			@RequestBody RegistrarDetalleVentaXpAgar ins) {
		RegistrarDetalleVentaXpAgar inst = new RegistrarDetalleVentaXpAgar(ins.getCantidad());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().regDetVent(inst, idClient, idProd); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.regProdxPagar(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.regProdxPagar(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/carrito" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Muestra la información del carrito de compras.")
	public ResponseEntity<Respuesta<MostrarVentaPorPagar,Responses,Excepcion>> showVentaXpagar(@PathVariable int idClient) {
		Respuesta<MostrarVentaPorPagar, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().showVentaXpagar(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.mostrarCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.mostrarCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/delete" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina el carrito de compras.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteVentaXpagar(@PathVariable int idClient) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().delVenta(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.eliminarCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.eliminarCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/pagar" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Paga el carrito de compras.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> payVentaXpagar(@PathVariable int idClient) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().payVenta(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.pagarCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.pagarCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/carrito/detalle" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Muestra la información del detalle del carrito de compras.")
	public ResponseEntity<Respuesta<MostrarDetalleVenta,Responses,Excepcion>> ShowDVxPagar(@PathVariable int idClient) {
		Respuesta<MostrarDetalleVenta, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().ShowDVxPagar(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.mostrarDetalleCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.mostrarDetalleCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/carrito/detalle/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina el detalle del carrito de compras.")
	public ResponseEntity<Respuesta<RecuperarDetalleVenta,Responses,Excepcion>> getDV(@PathVariable int idClient, @PathVariable int id) {
		Respuesta<RecuperarDetalleVenta, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().getDV(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.recuperarDetalleCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.recuperarDetalleCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idClient}/android/carrito/detalle/update/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Actualiza el detalle del carrito de compras.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updtDetVent(@PathVariable int idClient, @PathVariable int id,
			@RequestBody RegistrarDetalleVentaXpAgar ins) {
		RegistrarDetalleVentaXpAgar inst = new RegistrarDetalleVentaXpAgar(ins.getCantidad());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().updtDetVent(id, inst); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.actualizarDetalleCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.actualizarDetalleCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/detalle/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina un detalle del carrito de compras.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> delDV(@PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().delDV(id);
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.eliminarDetalleCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.eliminarDetalleCarrito(HttpStatus.OK.toString().trim()); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/carrito/detalle/pagar/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Paga un detalle del carrito de compras.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> payDetVentaXpagar(@PathVariable int idClient, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().payDetVenta(idClient, id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.pagarDetalleCarrito(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.pagarDetalleCarrito(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/allcompras" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Lista todas las compras por cliente.")
	public ResponseEntity<Respuesta<MostrarVentaPagada,Responses,Excepcion>> showVentaPagada(@PathVariable int idClient) {
		Respuesta<MostrarVentaPagada, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().showVentaPagada(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.listarCompras(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.listarCompras(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/allcompras/detalle/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Lista un detalle por compra de un cliente")
	public ResponseEntity<Respuesta<MostrarDetalleVentaPagada,Responses,Excepcion>> showVentaPagada(@PathVariable int idClient, @PathVariable int id) {
		Respuesta<MostrarDetalleVentaPagada, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = RegDetVentRepositoryImpl.getInstance().showDetVentaPagada(idClient, id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=RegDetVentServiceImpl.listarDetalleDeCompras(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=RegDetVentServiceImpl.listarDetalleDeCompras(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
