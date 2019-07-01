package com.barberia.repository;

import java.util.List;

import com.barberia.entity.BuscaProductoInterno;
import com.barberia.entity.BuscarProducto;
import com.barberia.entity.InsertarProducto;
import com.barberia.entity.ListarProducto;
import com.barberia.entity.ListarProductoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarProductoInterno;

public interface ProductoRepository {
	
	public List<ListarProductoInterno> getProductoRecords();
	public List<ListarProducto> getProductoR();
	public List<BuscaProductoInterno> getProductoByWords(String words);
	public List<BuscarProducto> getProdByWords(String words);
	public List<RecuperarProductoInterno> getProducto(int id);
	public List<ListarProducto> getProd(int id);
	public List<MensajesBeans> addProducto(InsertarProducto ins, int idUsuario);
	public List<MensajesBeans> updtProducto(int idProducto, RecuperarProductoInterno ins, int idUser);
	public List<MensajesBeans> delProducto(int idProducto);
	
}
