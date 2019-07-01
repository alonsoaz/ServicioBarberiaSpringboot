package com.barberia.controller;

import com.barberia.entity.Aidis;
import com.barberia.entity.BuscarClienteInterno;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarCliente;
import com.barberia.entity.ListarClienteInterno;
import com.barberia.entity.LoginCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarClienteInterno;
import com.barberia.repositoryImpl.ClienteRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.ClienteServiceImpl;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/cliente" })
public class ClienteController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private ClienteServiceImpl ClienteServiceImpl;
	
	@Autowired
	private ClienteRepositoryImpl ClienteRepositoryImpl;

	public ClienteController(ClienteRepositoryImpl ClienteRepositoryImpl) {
		this.ClienteRepositoryImpl = ClienteRepositoryImpl;
	}

	@GetMapping(value = { "/allclientes" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Clientes.")
	public ResponseEntity<Respuesta<ListarClienteInterno,Responses,Excepcion>> getClientes() {
		Respuesta<ListarClienteInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().getClienteByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.listarClientes(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.listarClientes(HttpStatus.OK.toString().trim());

		rpt.lista = ClienteRepositoryImpl.getInstance().getClienteRecords(); 
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/allclientes" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, apellido o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarClienteInterno,Responses,Excepcion>> getClienteByWords(
			@org.springframework.web.bind.annotation.RequestParam String words) {
		Respuesta<BuscarClienteInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.buscarClientes(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.buscarClientes(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperarClienteInterno,Responses,Excepcion>> getClienteById(@PathVariable int id) {
		Respuesta<RecuperarClienteInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().getCliente(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.recuperarCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.recuperarCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra un cliente tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerUsuario(@PathVariable int idUser, @RequestBody InsertarCliente ins) {
		InsertarCliente inst = new InsertarCliente(ins.getANombre(), ins.getBApellido(), ins.getCTelefono(),
				ins.getDDni(), ins.getEEmail(), ins.getFDirecion(), ins.getPassword());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().addCliente(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.registrarCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.registrarCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/{idUser}/register/login" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Registra un cliente tomando como parámetro al usuario que lo registra, devuelve mensajes de error o confirmacióny su identificador para el posterior acceso a su cuenta (Log In).")
	public ResponseEntity<Respuesta<Aidis,Responses,Excepcion>> registerUsuarioLogin(@PathVariable int idUser, @RequestBody InsertarCliente ins) {
		InsertarCliente inst = new InsertarCliente(ins.getANombre(), ins.getBApellido(), ins.getCTelefono(),
				ins.getDDni(), ins.getEEmail(), ins.getFDirecion(), ins.getPassword());

		Respuesta<Aidis, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().addClienteLogin(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.registrarCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.registrarCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/android/login" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Inicia sesión de un cliente en el aplicativo móvil, devuelve un mensaje de error o confirmación y el identificador del usuario.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> logInClient(@RequestBody LoginCliente ins) {
		LoginCliente inst = new LoginCliente(ins.getADni(), ins.getBPassword());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().LogInClient(inst); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.loginCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.loginCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/android/register" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra a un cliente en el aplicativo móvil, tomando como parámetro al usuario que lo registra y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerCliente(@RequestBody InsertarCliente ins) {
		InsertarCliente inst = new InsertarCliente(ins.getANombre(), ins.getBApellido(), ins.getCTelefono(),
				ins.getDDni(), ins.getEEmail(), ins.getFDirecion(), ins.getPassword());
		int idUser = 2;

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().addCliente(inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.registrarClienteA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.registrarClienteA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/android/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador en el aplicativo móvil.")
	public ResponseEntity<Respuesta<RecuperarClienteInterno,Responses,Excepcion>> getClientById(@PathVariable int id) {
		Respuesta<RecuperarClienteInterno, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().getCliente(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.recuperarClienteA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.recuperarClienteA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/android/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un cliente dentro del aplicativo móvil y devuelve un mensaje de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateCliente(@PathVariable int id, @RequestBody RecuperarClienteInterno ins) {
		RecuperarClienteInterno inst = new RecuperarClienteInterno(
				ins.getBnombre(),
				ins.getCapellido(), 
				ins.getDtelefono(), 
				ins.getEDni(), 
				ins.getFcorreo(), 
				ins.getGdireccion(),
				ins.getIdEstado());
		int idUser = 2;
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().updtClient(id, inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.actualizarClienteA(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.actualizarClienteA(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/android/changepass/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Cambia la contraseña de un cliente dentro del aplicativo móvil, devuelve un mensaje de error o confirmación y el identificador.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> changePassUsr(@PathVariable int id, @RequestBody CambiarClave ins) {
		CambiarClave inst = new CambiarClave(ins.getApass(), ins.getBNewPass());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().changePass(inst, id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.cambairPassCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.cambairPassCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un cliente y devuelve un mensaje de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> updateClient(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarClienteInterno ins) {
		RecuperarClienteInterno inst = new RecuperarClienteInterno(
				ins.getBnombre(),
				ins.getCapellido(), 
				ins.getDtelefono(), 
				ins.getEDni(), 
				ins.getFcorreo(), 
				ins.getGdireccion(),
				ins.getIdEstado());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().updtClient(id, inst, idUser); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.actualizarCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.actualizarCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{idUser}/cliente/delete/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	@ApiOperation("Elimina la información de un cliente y devuelve un mensaje de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> deleteUser(@PathVariable int idUser, @PathVariable int id) {
		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = ClienteRepositoryImpl.getInstance().delClient(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=ClienteServiceImpl.eliminarCliente(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=ClienteServiceImpl.eliminarCliente(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
