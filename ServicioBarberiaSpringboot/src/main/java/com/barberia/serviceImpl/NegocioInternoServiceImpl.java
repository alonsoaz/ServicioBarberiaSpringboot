package com.barberia.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.barberia.response.Excepcion;
import com.barberia.service.NegocioInternoService;

@Service
public class NegocioInternoServiceImpl implements NegocioInternoService {

	private final Logger LOG = Logger.getLogger(this.getClass());
	private List<Excepcion> lstExcepcion;

	@Override
	public List<Excepcion> listarVentas(String cod) {

		lstExcepcion = new ArrayList<>();

		Excepcion excepcion = null;

		if (cod.equals("404")) {

			excepcion = new Excepcion("ELVI001", "No se encontraron datos para listar.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("200")) {

			excepcion = new Excepcion("ELVI000", "No se encontraron excepciones.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("401")) {

			excepcion = new Excepcion("ELVI002", "No tiene autorización.");
			lstExcepcion.add(excepcion);

		}

		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarDetalleVentas(String cod) {

		lstExcepcion = new ArrayList<>();

		Excepcion excepcion = null;

		if (cod.equals("404")) {

			excepcion = new Excepcion("ELDI001", "No se encontraron datos para listar.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("200")) {

			excepcion = new Excepcion("ELDI000", "No se encontraron excepciones.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("401")) {

			excepcion = new Excepcion("ELDI002", "No tiene autorización.");
			lstExcepcion.add(excepcion);

		}

		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarReservasPorBarbero(String cod) {

		lstExcepcion = new ArrayList<>();

		Excepcion excepcion = null;

		if (cod.equals("404")) {

			excepcion = new Excepcion("ELRB001", "No se encontraron datos para listar.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("200")) {

			excepcion = new Excepcion("ELRB000", "No se encontraron excepciones.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("401")) {

			excepcion = new Excepcion("ELRB002", "No tiene autorización.");
			lstExcepcion.add(excepcion);

		}

		return lstExcepcion;
	}

	@Override
	public List<Excepcion> listarReservasPorCliente(String cod) {

		lstExcepcion = new ArrayList<>();

		Excepcion excepcion = null;

		if (cod.equals("404")) {

			excepcion = new Excepcion("ELRC001", "No se encontraron datos para listar.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("200")) {

			excepcion = new Excepcion("ELRC000", "No se encontraron excepciones.");
			lstExcepcion.add(excepcion);

		} else if (cod.equals("401")) {

			excepcion = new Excepcion("ELRC002", "No tiene autorización.");
			lstExcepcion.add(excepcion);

		}

		return lstExcepcion;
	}

}
