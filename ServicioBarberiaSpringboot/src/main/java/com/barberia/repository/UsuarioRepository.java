package com.barberia.repository;

import java.util.List;

import com.barberia.entity.BuscarUsuario;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarUsuario;
import com.barberia.entity.LoginUsuario;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarTipoUsuario;
import com.barberia.entity.RecuperaraUsuario;

public interface UsuarioRepository {
	
	public List<com.barberia.entity.ListarUsuario> getUsuarioRecords();
	public List<BuscarUsuario> getUsuarioByWords(String words);
	public List<RecuperaraUsuario> getUsuario(int id);
	public List<MensajesBeans> addUsuario(InsertarUsuario ins);
	public List<MessagenID> addUsuarioLogin(InsertarUsuario ins);
	public List<MessagenID> LogInUser(LoginUsuario ins);
	public List<MessagenID> changePass(CambiarClave ins, int idUsuario);
	public List<MessagenID> updtUsr(RecuperaraUsuario ins, int idUser);
	public List<RecuperarTipoUsuario> TipoUsuario();

}
