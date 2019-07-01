package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.barberia.response.Excepcion;
import com.barberia.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;

	@Override
	public List<Excepcion> listarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELSI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELSI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELSI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBSI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBSI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBSI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarServiciosA(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELSA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELSA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELSA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarServiciosA(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBSA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBSA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBSA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarServiciosA(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGSA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGSA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGSA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGSI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGSI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGSI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> registrarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERSI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERSI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERSI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> actualizarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EASI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EASI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EASI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarServicios(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDSI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDSI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDSI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

}
