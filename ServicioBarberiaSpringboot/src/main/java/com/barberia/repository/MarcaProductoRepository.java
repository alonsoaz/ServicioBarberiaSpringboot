package com.barberia.repository;

import java.util.List;

import com.barberia.entity.InsertarMarca;
import com.barberia.entity.ListarMarca;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarMarcaInterno;

public interface MarcaProductoRepository {
	
	public List<ListarMarca> getMarcaProductoR();
	public List<RecuperarMarcaInterno> getMarcaProducto(int id);
	public List<MensajesBeans> addMarcaProducto(InsertarMarca ins, int idUsuario);
	public List<MensajesBeans> updtMarcaProducto(int idMarcaProducto, RecuperarMarcaInterno ins);
	public List<MensajesBeans> delMarcaProducto(int idMarcaProducto);
	
}
