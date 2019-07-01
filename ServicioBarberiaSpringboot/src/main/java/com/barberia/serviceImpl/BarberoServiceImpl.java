package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.controller.BarberoController;
import com.barberia.repositoryImpl.BarberoRepositoryImpl;
import com.barberia.response.Excepcion;
import com.barberia.service.BarberoService;

@Service
public class BarberoServiceImpl implements BarberoService{
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;
	
	@Autowired
	private BarberoController barberoController;
	
	@Override
	public List<Excepcion> listarBarberoInterno(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELBI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELBI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELBI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
		
	}
	
	@Override
	public List<Excepcion> buscarBarberoInterno(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBBI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBBI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBBI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
		
	}

	@Override
	public List<Excepcion> listarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELBM001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELBM000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELBM002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBBM001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBBM000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBBM002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGBI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGBMI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGBM002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> registrarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERBI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELBI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERBI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> actualizarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EABI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EABI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EABI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarBarbero(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;

		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDBI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDBI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDBI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}
	
	
	
	

}
