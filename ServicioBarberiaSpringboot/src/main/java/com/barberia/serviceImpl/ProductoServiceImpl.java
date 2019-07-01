package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.barberia.response.Excepcion;
import com.barberia.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;

	@Override
	public List<Excepcion> listarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarProductosA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELPA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELPA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELPA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarProductosA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBPA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBPA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBPA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarProductosA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGPA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGPA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGPA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> registrarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> actualizarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EAPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EAPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EAPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarProductos(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDPI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDPI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDPI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

}
