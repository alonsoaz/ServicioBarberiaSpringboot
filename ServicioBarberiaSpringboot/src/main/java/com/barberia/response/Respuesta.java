package com.barberia.response;

import java.util.ArrayList;
import java.util.List;

public class Respuesta<C,R,E> {
	
	public List<C> lista; 
	public List<R> response;
	public List<E> excepcion;
	
	public Respuesta() {
		lista = new ArrayList<>();
		response = new ArrayList<>();
		excepcion = new ArrayList<>();
	}
	
	

}
