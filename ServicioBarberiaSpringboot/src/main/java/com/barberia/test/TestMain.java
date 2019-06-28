package com.barberia.test;

import com.barberia.entity.InsertarServicio;
import com.barberia.entity.MensajesBeans;
import com.barberia.model.ServicioModel;
import java.io.PrintStream;
import java.util.List;

public class TestMain {
	public TestMain() {
	}

	public static void main(String[] args) {
		InsertarServicio ins = new InsertarServicio("aNombre", 1, 28, 14.6D, "edescripcion");

		System.out.println(

				((MensajesBeans) ServicioModel.getInstance().addServicio(ins, 1).get(0)).getMensaje());
	}
}
