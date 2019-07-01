package com.barberia.repository;

import java.util.List;

import com.barberia.entity.BuscarBarbero;
import com.barberia.entity.BuscarBarberoInterno;
import com.barberia.entity.InsertarBarbero;
import com.barberia.entity.ListarBarbero;
import com.barberia.entity.ListarBarberoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarBarberoInterno;

public interface BarberoRepository {
	
	public List<ListarBarberoInterno> getBarberoRecords();
	public List<ListarBarbero> getBarberoR();
	public List<BuscarBarberoInterno> getBarberoByWords(String words);
	public List<BuscarBarbero> getBarbByWords(String words);
	public List<RecuperarBarberoInterno> getBarbero(int id);
	public List<ListarBarbero> getBarberoA(int id);
	public List<MensajesBeans> addBarbero(InsertarBarbero ins, int idUsuario);
	public List<MensajesBeans> updtBarbero(int idBarbero, RecuperarBarberoInterno ins, int idUser);
	public List<MensajesBeans> delBarbero(int idBarbero);
	
}
