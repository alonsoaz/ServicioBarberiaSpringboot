package com.barberia.repository;

import java.util.List;

import com.barberia.entity.BuscarServicioInterno;
import com.barberia.entity.InsertarServicio;
import com.barberia.entity.ListarServicio;
import com.barberia.entity.ListarServicioInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarServicioInterno;

public interface ServicioRepository {
	
	public List<ListarServicioInterno> getServicioRecords();
	public List<ListarServicio> getServicioR();
	public List<BuscarServicioInterno> getServicioByWords(String words);
	public List<com.barberia.entity.BuscarServicio> getServByWords(String words);
	public List<RecuperarServicioInterno> getServicio(int id);
	public List<ListarServicio> getServicioA(int id);
	public List<MensajesBeans> addServicio(InsertarServicio ins, int idUsuario);
	public List<MensajesBeans> updtServicio(int idServicio, RecuperarServicioInterno ins, int idUser);
	public List<MensajesBeans> delServicio(int idServicio);
	
}
