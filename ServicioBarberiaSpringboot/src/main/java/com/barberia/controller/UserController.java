package com.barberia.controller;

import com.barberia.entity.BuscarUsuario;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarUsuario;
import com.barberia.entity.ListarUsuario;
import com.barberia.entity.LoginUsuario;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarTipoUsuario;
import com.barberia.entity.RecuperaraUsuario;
import com.barberia.repositoryImpl.UsuarioRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.response.Responses;
import com.barberia.response.Respuesta;
import com.barberia.serviceImpl.UsuarioServiceImpl;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = { "/usuario" })
@Api(value="Rest de Usuarios")
public class UserController {
	

	private final Logger LOG = Logger.getLogger(this.getClass());
	
	@Autowired
	private UsuarioServiceImpl UsuarioServiceImpl;
	
	@Autowired
	private UsuarioRepositoryImpl UsuarioRepositoryImpl;

	public UserController(UsuarioRepositoryImpl UsuarioRepositoryImpl) {
		this.UsuarioRepositoryImpl = UsuarioRepositoryImpl;
	}

	@GetMapping(value = { "/allusuarios" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la Lista de todos los Usuarios.")
	public ResponseEntity<Respuesta<ListarUsuario,Responses,Excepcion>> getUsuarios() {
		Respuesta<ListarUsuario, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().getUsuarioRecords(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.listarUsuarios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.listarUsuarios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/allusuarios" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna la lista de coincidencias cuyo nombre, apellido o código concuerde con un parámetro de texto.")
	public ResponseEntity<Respuesta<BuscarUsuario,Responses,Excepcion>> getUsuarioByWords(@RequestParam String words) {
		Respuesta<BuscarUsuario, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().getUsuarioByWords(words); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.buscarUsuarios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.buscarUsuarios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Retorna un sólo registro de acuerdo con su identificador.")
	public ResponseEntity<Respuesta<RecuperaraUsuario,Responses,Excepcion>> getUsuarioById(@PathVariable int id) {
		Respuesta<RecuperaraUsuario, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().getUsuario(id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.recuperarUsuario(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.recuperarUsuario(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/register" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra un usuario y devuelve mensajes de error o confirmación.")
	public ResponseEntity<Respuesta<MensajesBeans,Responses,Excepcion>> registerUsuario(@RequestBody InsertarUsuario ins) {
		InsertarUsuario inst = new InsertarUsuario(ins.getAidUsuario(), ins.getBnombre(), ins.getCapellido(),
				ins.getDcargo(), ins.getEaka(), ins.getFpass(), ins.getGemail(), ins.getHtelefono(),
				ins.getIdescripcion());

		Respuesta<MensajesBeans, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().addUsuario(inst); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.registrarUsuario(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.registrarUsuario(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/register/login" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Registra un usuario y devuelve un mensaje de error o confirmación y su identificador para el posterior acceso a su cuenta (Log In).")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> registerUsuarioLogin(@RequestBody InsertarUsuario ins) {
		InsertarUsuario inst = new InsertarUsuario(ins.getAidUsuario(), ins.getBnombre(), ins.getCapellido(),
				ins.getDcargo(), ins.getEaka(), ins.getFpass(), ins.getGemail(), ins.getHtelefono(),
				ins.getIdescripcion());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().addUsuarioLogin(inst); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.registarUsuarioLogin(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.registarUsuarioLogin(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PostMapping(value = { "/login" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Inicia sesión de un usuario, devuelve un mensaje de error o confirmación y el identificador del usuario.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> logInUsuarioAndroid(@RequestBody LoginUsuario ins) {
		LoginUsuario inst = new LoginUsuario(ins.getAaka(), ins.getBpass());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().LogInUser(inst); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.loginUsuario(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.loginUsuario(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@GetMapping(value = { "/tipo" }, produces = { "application/json" })
	@ResponseBody
	@ApiOperation("Lista a los Tipos de Usuario.")
	public ResponseEntity<Respuesta<RecuperarTipoUsuario,Responses,Excepcion>> tipoUsuario() {
		Respuesta<RecuperarTipoUsuario, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().TipoUsuario(); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.listarTipoUsuario(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.listarTipoUsuario(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/{id}/changepass" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Cambia la contraseña de un usuario, devuelve un mensaje de error o confirmación y el identificador del usuario.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> changePassUsr(@PathVariable int id, @RequestBody CambiarClave ins) {
		CambiarClave inst = new CambiarClave(ins.getApass(), ins.getBNewPass());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().changePass(inst, id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.cambiarPassUsuarios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.cambiarPassUsuarios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}

	@PutMapping(value = { "/update/{id}" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	@ApiOperation("Actualiza la información de un usuario, devuelve un mensaje de error o confirmación y el identificador del usuario.")
	public ResponseEntity<Respuesta<MessagenID,Responses,Excepcion>> updateUser(@PathVariable int id, @RequestBody RecuperaraUsuario ins) {
		RecuperaraUsuario inst = new RecuperaraUsuario(ins.getAnombre(), ins.getCapellido(), ins.getDcargo(),
				ins.getEaka(), ins.getFcorreo(), ins.getGtelefono(), ins.getHdescripcion());

		Respuesta<MessagenID, Responses, Excepcion> rpt = new Respuesta<>();
        Responses responses = null;
		List<Responses> lista = new ArrayList<>();

		rpt.lista = UsuarioRepositoryImpl.getInstance().updtUsr(inst, id); 
		
		if(rpt.lista.size()==0) 
		{
		    LOG.error("Codigo de error: "+HttpStatus.NOT_FOUND.toString().trim());
		    responses = new Responses(HttpStatus.NOT_FOUND.toString().trim());
		    rpt.excepcion=UsuarioServiceImpl.actualizarUsuarios(HttpStatus.NOT_FOUND.toString().trim());
		    lista.add(responses);
		    rpt.response = lista;
		    
		    return new ResponseEntity<>(rpt,HttpStatus.NOT_FOUND);
		}
		
		lista.add(new Responses(HttpStatus.OK.toString().trim()));
	    rpt.excepcion=UsuarioServiceImpl.actualizarUsuarios(HttpStatus.OK.toString().trim());
		rpt.response = lista;
		
		return new ResponseEntity<>(rpt,HttpStatus.OK);
	}
}
