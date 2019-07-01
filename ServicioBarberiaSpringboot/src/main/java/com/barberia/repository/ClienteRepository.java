package com.barberia.repository;

import java.util.List;

import com.barberia.entity.Aidis;
import com.barberia.entity.BuscarClienteInterno;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarCliente;
import com.barberia.entity.ListarClienteInterno;
import com.barberia.entity.LoginCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarClienteInterno;

public  interface ClienteRepository {
	
	public List<ListarClienteInterno> getClienteRecords();
	public List<BuscarClienteInterno> getClienteByWords(String words);
	public List<RecuperarClienteInterno> getCliente(int id);
	public List<MensajesBeans> addCliente(InsertarCliente ins, int idUsuario);
	public List<Aidis> addClienteLogin(InsertarCliente ins, int idUsuario);
	public List<MessagenID> LogInClient(LoginCliente ins);
	public List<MessagenID> changePass(CambiarClave ins, int idCliente);
	public List<MensajesBeans> updtClient(int idCliente, RecuperarClienteInterno ins, int idUser);
	public List<MensajesBeans> delClient(int idCliente);
	
}
