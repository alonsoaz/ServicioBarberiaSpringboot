package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarProducto {
	private int aidProducto;
	private String cTipo;
	private String dProducto;
	private String eMarca;
	private String Estado;
	private int fCant;
	private double gPrecio;
	private String hDescrip;

	public ListarProducto(int aidProducto, String cTipo, String dProducto, String eMarca, String estado, int fCant,
			double gPrecio, String hDescrip) {
		this.aidProducto = aidProducto;
		this.cTipo = cTipo;
		this.dProducto = dProducto;
		this.eMarca = eMarca;
		Estado = estado;
		this.fCant = fCant;
		this.gPrecio = gPrecio;
		this.hDescrip = hDescrip;
	}

	public ListarProducto(int aidProducto, String dProducto, double gPrecio, String hDescrip) {
		super();
		this.aidProducto = aidProducto;
		this.dProducto = dProducto;
		this.gPrecio = gPrecio;
		this.hDescrip = hDescrip;
	}

	public int getAidProducto() {
		return aidProducto;
	}

	public void setAidProducto(int aidProducto) {
		this.aidProducto = aidProducto;
	}

	public String getcTipo() {
		return cTipo;
	}

	public void setcTipo(String cTipo) {
		this.cTipo = cTipo;
	}

	public String getdProducto() {
		return dProducto;
	}

	public void setdProducto(String dProducto) {
		this.dProducto = dProducto;
	}

	public String geteMarca() {
		return eMarca;
	}

	public void seteMarca(String eMarca) {
		this.eMarca = eMarca;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public int getfCant() {
		return fCant;
	}

	public void setfCant(int fCant) {
		this.fCant = fCant;
	}

	public double getgPrecio() {
		return gPrecio;
	}

	public void setgPrecio(double gPrecio) {
		this.gPrecio = gPrecio;
	}

	public String gethDescrip() {
		return hDescrip;
	}

	public void sethDescrip(String hDescrip) {
		this.hDescrip = hDescrip;
	}
}
