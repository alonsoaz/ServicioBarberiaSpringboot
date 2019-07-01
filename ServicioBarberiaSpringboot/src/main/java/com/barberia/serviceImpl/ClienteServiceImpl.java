package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.barberia.response.Excepcion;
import com.barberia.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;

	@Override
	public List<Excepcion> listarClientes(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ELCI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ELCI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ELCI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> buscarClientes(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EBCI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EBCI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EBCI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarCliente(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGCI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGCI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGCI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> registrarCliente(String cod) {
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERCI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERCI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERCI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> loginCliente(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EICI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EICI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EICI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> registrarClienteA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"ERCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"ERCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"ERCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> recuperarClienteA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EGCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EGCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EGCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> actualizarClienteA(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EUCA001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EUCA000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EUCA002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> cambairPassCliente(String cod) {
		
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
	public List<Excepcion> actualizarCliente(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EACI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EACI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EACI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

	@Override
	public List<Excepcion> eliminarCliente(String cod) {
		
		lstExcepcion = new ArrayList<>();
		
		Excepcion excepcion = null;
		
		if(cod.equals("404")) {
			
			excepcion = new Excepcion(
					"EECI001",
					"No se encontraron datos para listar."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("200")) {
			
			excepcion = new Excepcion(
					"EECI000",
					"No se encontraron excepciones."
					);
			lstExcepcion.add(excepcion);
			
		}else if(cod.equals("401")) {
			
			excepcion = new Excepcion(
					"EECI002",
					"No tiene autorización."
					);
			lstExcepcion.add(excepcion);	
			
		}
		
		return lstExcepcion;
	}

}
