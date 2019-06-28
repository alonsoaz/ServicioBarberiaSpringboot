package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarBarbero {
	private int aidBarbero;
	private String bNombre;
	private String cEstado;
	private String dCelular;
	private String eMail;
	private String fDni;
	private String gDireccion;

	private String nombreCompleto;

	public ListarBarbero(int aidBarbero, String bNombre, String cEstado, String dCelular, String eMail, String fDni,
			String gDireccion) {
		this.aidBarbero = aidBarbero;
		this.bNombre = bNombre;
		this.cEstado = cEstado;
		this.dCelular = dCelular;
		this.eMail = eMail;
		this.fDni = fDni;
		this.gDireccion = gDireccion;
	}

	public ListarBarbero(int aidBarbero, String nombreCompleto) {
		this.aidBarbero = aidBarbero;
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getAidBarbero() {
		return aidBarbero;
	}

	public void setAidBarbero(int aidBarbero) {
		this.aidBarbero = aidBarbero;
	}

	public String getbNombre() {
		return bNombre;
	}

	public void setbNombre(String bNombre) {
		this.bNombre = bNombre;
	}

	public String getcEstado() {
		return cEstado;
	}

	public void setcEstado(String cEstado) {
		this.cEstado = cEstado;
	}

	public String getdCelular() {
		return dCelular;
	}

	public void setdCelular(String dCelular) {
		this.dCelular = dCelular;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getfDni() {
		return fDni;
	}

	public void setfDni(String fDni) {
		this.fDni = fDni;
	}

	public String getgDireccion() {
		return gDireccion;
	}

	public void setgDireccion(String gDireccion) {
		this.gDireccion = gDireccion;
	}
}
