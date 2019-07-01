package com.barberia.controller;

import com.barberia.serviceImpl.ReservasServicioImpl;
import com.barberia.entity.BuscarReservaPorCliente;
import com.barberia.entity.ConsultaDisponibilidadBarbero;
import com.barberia.entity.ListarReservasPorCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.repositoryImpl.ReservasRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;

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
@RequestMapping(path = { "/reserva" })
@Api(value="Rest de Reservas")
public class ReservaController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private ReservasServicioImpl ReservasServicioImpl; 
	
	@Autowired
	private ReservasRepositoryImpl ReservasRepositoryImpl;

	public ReservaController(ReservasRepositoryImpl ReservasRepositoryImpl) {
		this.ReservasRepositoryImpl = ReservasRepositoryImpl;
	}

	@PostMapping(value = { "/{idClient}/android/barbero/{idBarbero}/consulta/{idServicio}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Consulta la disponibilidad de cada barbero de acuerdo con el servicio seleccionado y una fecha seleccionada.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> askBarbero(@RequestBody ConsultaDisponibilidadBarbero ins, @PathVariable int idBarbero,
			@PathVariable int idClient, @PathVariable int idServicio) {
		ConsultaDisponibilidadBarbero inst = new ConsultaDisponibilidadBarbero(
				ins.getBYear(), 
				ins.getCMonth(),
				ins.getDDay(), 
				ins.getEHour(), 
				ins.getFMinut(),0);

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().askBarbero(inst, idBarbero, idServicio); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.consultarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.consultarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/barbero/{idBarbero}/registro/{idServicio}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra una reserva de acuerdo con el servicio  y barbero seleccionados, y una fecha seleccionada.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> tryBarbero(@RequestBody ConsultaDisponibilidadBarbero ins, @PathVariable int idBarbero,
			@PathVariable int idClient, @PathVariable int idServicio) {
		ConsultaDisponibilidadBarbero inst = new ConsultaDisponibilidadBarbero(
				ins.getBYear(), 
				ins.getCMonth(),
				ins.getDDay(), 
				ins.getEHour(), 
				ins.getFMinut(),0);

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().tryBarbero(inst, idBarbero, idClient, idServicio); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.reservarBarbero(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.reservarBarbero(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/allreservas" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos las reservas por cliente.")
	public ResponseEntity<Respuesta<ListarReservasPorCliente,Responses,Excepcion>> getReservas(@PathVariable int idClient) {
		Respuesta<ListarReservasPorCliente, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().getReservas(idClient); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.listarReservasporCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.listarReservasporCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/{idClient}/android/{idReserva}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador para el cliente móvil.")
	public ResponseEntity<Respuesta<BuscarReservaPorCliente,Responses,Excepcion>> getReserva(@PathVariable int idClient,
			@PathVariable int idReserva) {
		Respuesta<BuscarReservaPorCliente, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().getReserva(idClient, idReserva); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.recuperarReservasporCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.recuperarReservasporCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = {"/{idClient}/android/{idReserva}/delete" }, produces = {
					"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Elimina una reserva.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> delReserva(@PathVariable int idClient, @PathVariable int idReserva) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().delReserva(idClient, idReserva); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.eliminarReservaporCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.eliminarReservaporCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idClient}/android/{idReserva}/pay" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Paga una reserva.")	
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> payReserva(@PathVariable int idClient, @PathVariable int idReserva) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ReservasRepositoryImpl.getInstance().payReserva(idClient, idReserva); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ReservasServicioImpl.pagarReservasporCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ReservasServicioImpl.pagarReservasporCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
