package com.barberia.response;

public class Excepcion {
	
	private String codigo;
	private String mensaje;
	
	public Excepcion(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public Excepcion() {

	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
