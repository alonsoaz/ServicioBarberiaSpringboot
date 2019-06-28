package com.barberia.controller;

import com.barberia.entity.BuscarUsuario;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarUsuario;
import com.barberia.entity.LoginUsuario;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperaraUsuario;
import com.barberia.model.UsuarioModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
	@Autowired
	private UsuarioModel UsuarioModel;

	public UserController(UsuarioModel UsuarioModel) {
		this.UsuarioModel = UsuarioModel;
	}

	@GetMapping(value = { "/allusuarios" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.ListarUsuario> getUsuarios() {
		return UsuarioModel.getInstance().getUsuarioRecords();
	}

	@GetMapping(value = { "/allusuarios" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	public List<BuscarUsuario> getUsuarioByWords(@RequestParam String words) {
		return UsuarioModel.getInstance().getUsuarioByWords(words);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody 
	public List<RecuperaraUsuario> getUsuarioById(@PathVariable int id) {
		return UsuarioModel.getInstance().getUsuario(id);
	}

	@PostMapping(value = { "/register" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> registerUsuario(@RequestBody InsertarUsuario ins) {
		InsertarUsuario inst = new InsertarUsuario(ins.getAidUsuario(), ins.getBnombre(), ins.getCapellido(),
				ins.getDcargo(), ins.getEaka(), ins.getFpass(), ins.getGemail(), ins.getHtelefono(),
				ins.getIdescripcion());

		return UsuarioModel.getInstance().addUsuario(inst);
	}

	@PostMapping(value = { "/register/login" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MessagenID> registerUsuarioAndroid(@RequestBody InsertarUsuario ins) {
		InsertarUsuario inst = new InsertarUsuario(ins.getAidUsuario(), ins.getBnombre(), ins.getCapellido(),
				ins.getDcargo(), ins.getEaka(), ins.getFpass(), ins.getGemail(), ins.getHtelefono(),
				ins.getIdescripcion());

		return UsuarioModel.getInstance().addUsuarioLogin(inst);
	}

	@PostMapping(value = { "/login" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MessagenID> logInUsuarioAndroid(@RequestBody LoginUsuario ins) {
		LoginUsuario inst = new LoginUsuario(ins.getAaka(), ins.getBpass());

		return UsuarioModel.getInstance().LogInUser(inst);
	}

	@GetMapping(value = { "/tipo" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.RecuperarTipoUsuario> tipoUsuario() {
		return UsuarioModel.getInstance().TipoUsuario();
	}

	@PutMapping(value = { "/{id}/changepass" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MessagenID> changePassUsr(@PathVariable int id, @RequestBody CambiarClave ins) {
		CambiarClave inst = new CambiarClave(ins.getApass(), ins.getbNewPass());

		return UsuarioModel.getInstance().changePass(inst, id);
	}

	@PutMapping(value = { "/update/{id}" }, produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MessagenID> updateUser(@PathVariable int id, @RequestBody RecuperaraUsuario ins) {
		RecuperaraUsuario inst = new RecuperaraUsuario(ins.getAnombre(), ins.getCapellido(), ins.getDcargo(),
				ins.getEaka(), ins.getFcorreo(), ins.getGtelefono(), ins.getHdescripcion());

		return UsuarioModel.getInstance().updtUsr(inst, id);
	}
}
