package com.barberia.controller;

import com.barberia.entity.ListarReservasPorBarberoInterno;
import com.barberia.entity.ListarReservasPorClienteInterno;
import com.barberia.entity.MostrarDetalleVentaInterno;
import com.barberia.entity.MostrarVentaInterno;
import com.barberia.repositoryImpl.NegocioInternoRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.NegocioInternoServiceImpl;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/negocio" })
@Api(value="Rest del negocio")
public class NegocioInternoController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private NegocioInternoServiceImpl NegocioInternoServiceImpl;
	
	@Autowired
	private NegocioInternoRepositoryImpl NegocioInternoRepositoryImpl;

	public NegocioInternoController(NegocioInternoRepositoryImpl NegocioInternoRepositoryImpl) {
		this.NegocioInternoRepositoryImpl = NegocioInternoRepositoryImpl;
	}

	@GetMapping(value = { "/{idUser}/tienda/allventas" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todas las ventas.")
	public ResponseEntity<Respuesta<MostrarVentaInterno,Responses,Excepcion>> getVenta(@PathVariable int idUser) {
		Respuesta<MostrarVentaInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(NegocioInternoRepositoryImpl.getInstance().getVenta().size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=NegocioInternoServiceImpl.listarVentas(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=NegocioInternoServiceImpl.listarVentas(HttpStatus.OK.toString().trim());

		rpt.lista = NegocioInternoRepositoryImpl.getInstance().getVenta(); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idUser}/tienda/{idVenta}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<MostrarDetalleVentaInterno,Responses,Excepcion>> getDetVenta(@PathVariable int idUser, @PathVariable int idVenta) {
		Respuesta<MostrarDetalleVentaInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(NegocioInternoRepositoryImpl.getInstance().getDetVenta(idVenta).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=NegocioInternoServiceImpl.listarDetalleVentas(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=NegocioInternoServiceImpl.listarDetalleVentas(HttpStatus.OK.toString().trim());

		rpt.lista = NegocioInternoRepositoryImpl.getInstance().getDetVenta(idVenta); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idUser}/tienda/reserva/allreservas/barbero/{idBarbero}" }, produces = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todas las reservas realizadas por cada barbero.")
	public ResponseEntity<Respuesta<ListarReservasPorBarberoInterno,Responses,Excepcion>> getResBarbero(@PathVariable int idUser, @PathVariable int idBarbero) {
		Respuesta<ListarReservasPorBarberoInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(NegocioInternoRepositoryImpl.getInstance().getResBarbero(idBarbero).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=NegocioInternoServiceImpl.listarReservasPorBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=NegocioInternoServiceImpl.listarReservasPorBarbero(HttpStatus.OK.toString().trim());

		rpt.lista = NegocioInternoRepositoryImpl.getInstance().getResBarbero(idBarbero); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idUser}/tienda/reserva/allreservas/cliente/{idClient}" }, produces = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todas las reservas realizadas por cada cliente.")
	public ResponseEntity<Respuesta<ListarReservasPorClienteInterno,Responses,Excepcion>> getResCliente(@PathVariable int idUser,
			@PathVariable int idClient) {
		Respuesta<ListarReservasPorClienteInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(NegocioInternoRepositoryImpl.getInstance().getResCliente(idClient).size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=NegocioInternoServiceImpl.listarReservasPorCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=NegocioInternoServiceImpl.listarReservasPorCliente(HttpStatus.OK.toString().trim());

		rpt.lista = NegocioInternoRepositoryImpl.getInstance().getResCliente(idClient); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
