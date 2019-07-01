package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.barberia.response.Excepcion;
import com.barberia.service.RegDetVentService;
@Service
public class RegDetVentServiceImpl implements RegDetVentService{
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;

	@Override
	public List<Excepcion> regProdxPagar(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERPA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERPA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERPA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> mostrarCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EMCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EMCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EMCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> pagarCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EPCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EPCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EPCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> mostrarDetalleCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELDA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELDA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELDA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarDetalleCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERDA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERDA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERDA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> actualizarDetalleCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EUDA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EUDA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EUDA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarDetalleCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDDA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDDA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDDA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> pagarDetalleCarrito(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EDDA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EDDA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EDDA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarCompras(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELVA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELVA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELVA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarDetalleDeCompras(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELDV001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELDV000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELDV002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

}
