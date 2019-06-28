package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarServicio {
	private int aidServicio;
	private String bcodServicio;
	private String cServicio;
	private String dEstado;
	private int eDuracion;
	private double fPrecio;
	private String gDescripcion;

	public ListarServicio(int aidServicio, String bcodServicio, String cServicio, String dEstado, int eDuracion,
			double fPrecio, String gDescripcion) {
		this.aidServicio = aidServicio;
		this.bcodServicio = bcodServicio;
		this.cServicio = cServicio;
		this.dEstado = dEstado;
		this.eDuracion = eDuracion;
		this.fPrecio = fPrecio;
		this.gDescripcion = gDescripcion;
	}

	public ListarServicio(int aidServicio, String cServicio, int eDuracion, double fPrecio) {
		super();
		this.aidServicio = aidServicio;
		this.cServicio = cServicio;
		this.eDuracion = eDuracion;
		this.fPrecio = fPrecio;
	}

	public int getAidServicio() {
		return aidServicio;
	}

	public void setAidServicio(int aidServicio) {
		this.aidServicio = aidServicio;
	}

	public String getBcodServicio() {
		return bcodServicio;
	}

	public void setBcodServicio(String bcodServicio) {
		this.bcodServicio = bcodServicio;
	}

	public String getcServicio() {
		return cServicio;
	}

	public void setcServicio(String cServicio) {
		this.cServicio = cServicio;
	}

	public String getdEstado() {
		return dEstado;
	}

	public void setdEstado(String dEstado) {
		this.dEstado = dEstado;
	}

	public int geteDuracion() {
		return eDuracion;
	}

	public void seteDuracion(int eDuracion) {
		this.eDuracion = eDuracion;
	}

	public double getfPrecio() {
		return fPrecio;
	}

	public void setfPrecio(double fPrecio) {
		this.fPrecio = fPrecio;
	}

	public String getgDescripcion() {
		return gDescripcion;
	}

	public void setgDescripcion(String gDescripcion) {
		this.gDescripcion = gDescripcion;
	}
}
