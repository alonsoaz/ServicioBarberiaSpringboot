package com.barberia.controller;

import com.barberia.entity.BuscaProductoInterno;
import com.barberia.entity.BuscarProducto;
import com.barberia.entity.InsertarProducto;
import com.barberia.entity.ListarProducto;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarProductoInterno;
import com.barberia.model.ProductoModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path = { "/producto" })
public class ProductoController {
	@Autowired
	private ProductoModel ProductoModel;

	public ProductoController(ProductoModel ProductoModel) {
		this.ProductoModel = ProductoModel;
	}

	@GetMapping(value = { "/allproductos" }, produces = { "application/json" })
	@ResponseBody
	public List<com.barberia.entity.ListarProductoInterno> getProductos() {
		return ProductoModel.getInstance().getProductoRecords();
	}

	@GetMapping(value = { "/allproductos" }, params = { "words" }, produces = { "application/json" })
	@ResponseBody
	public List<BuscaProductoInterno> getProductoByWords(@RequestParam String words) {
		return ProductoModel.getInstance().getProductoByWords(words);
	}

	@GetMapping(value = { "/android/allproductos" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarProducto> getProdA() {
		return ProductoModel.getInstance().getProductoR();
	}

	@GetMapping(value = { "/android/allproductos" }, params = { "words" }, produces = {
			"application/json" })
	@ResponseBody
	public List<BuscarProducto> getServByWords(@RequestParam String words) {
		return ProductoModel.getInstance().getProdByWords(words);
	}

	@GetMapping(value = { "/android/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<ListarProducto> getServById(@PathVariable int id) {
		return ProductoModel.getInstance().getProd(id);
	}

	@GetMapping(value = { "/get/{id}" }, produces = { "application/json" })
	@ResponseBody
	public List<RecuperarProductoInterno> getServicioById(@PathVariable int id) {
		return ProductoModel.getInstance().getProducto(id);
	}

	@PostMapping(value = { "/{idUser}/register" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> registerProducto(@PathVariable int idUser, @RequestBody InsertarProducto ins) {
		InsertarProducto inst = new InsertarProducto(ins.getAnombre(), ins.getBidMarca(), ins.getCidTipo(),
				ins.getdStock(), ins.getePrecio(), ins.getFdescripcion());

		return ProductoModel.getInstance().addProducto(inst, idUser);
	}

	@PutMapping(value = { "/{idUser}/update/{id}" }, produces = { "application/json" }, consumes = {
			"application/json" })
	@ResponseBody
	public List<MensajesBeans> updateProducto(@PathVariable int idUser, @PathVariable int id,
			@RequestBody RecuperarProductoInterno ins) {
		RecuperarProductoInterno inst = new RecuperarProductoInterno(ins.getaIdMarca(), ins.getBidTipo(),
				ins.getcNombre(), ins.getDidEstado(), ins.getfStock(), ins.getgPrecio(), ins.getHdescripcion());

		return ProductoModel.getInstance().updtProducto(id, inst, idUser);
	}

	@DeleteMapping(value = { "/{idUser}/delete/{id}" }, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseBody
	public List<MensajesBeans> deleteProducto(@PathVariable int idUser, @PathVariable int id) {
		return ProductoModel.getInstance().delProducto(id);
	}
}
