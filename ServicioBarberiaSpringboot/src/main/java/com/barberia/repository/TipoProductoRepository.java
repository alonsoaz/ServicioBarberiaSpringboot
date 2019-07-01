package com.barberia.repository;

import java.util.List;

import com.barberia.entity.InsertarTipo;
import com.barberia.entity.ListarTipoProducto;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarTipoProducto;

public interface TipoProductoRepository {

	  public List<ListarTipoProducto> getTipoProductoR();
	  public List<RecuperarTipoProducto> getTipoProducto(int id);
	  public List<MensajesBeans> addTipoProducto(InsertarTipo ins, int idUsuario);
	  public List<MensajesBeans> updtTipoProducto(int idTipoProducto, RecuperarTipoProducto ins);
	  public List<MensajesBeans> delTipoProducto(int idTipoProducto);
	
}
