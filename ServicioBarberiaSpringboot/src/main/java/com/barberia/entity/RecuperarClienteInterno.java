package com.barberia.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bnombre", "capellido", "dtelefono", "eDni", "fcorreo", "gdireccion", "idEstado" })
public class RecuperarClienteInterno implements Serializable {

	@JsonProperty("bnombre")
	private String bnombre;
	@JsonProperty("capellido")
	private String capellido;
	@JsonProperty("dtelefono")
	private String dtelefono;
	@JsonProperty("eDni")
	private String eDni;
	@JsonProperty("fcorreo")
	private String fcorreo;
	@JsonProperty("gdireccion")
	private String gdireccion;
	@JsonProperty("idEstado")
	private int idEstado;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 184346941064664235L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperarClienteInterno() {
	}

	/**
	 * 
	 * @param bnombre
	 * @param fcorreo
	 * @param capellido
	 * @param eDni
	 * @param dtelefono
	 * @param idEstado
	 * @param gdireccion
	 */
	public RecuperarClienteInterno(String bnombre, String capellido, String dtelefono, String eDni, String fcorreo,
			String gdireccion, int idEstado) {
		super();
		this.bnombre = bnombre;
		this.capellido = capellido;
		this.dtelefono = dtelefono;
		this.eDni = eDni;
		this.fcorreo = fcorreo;
		this.gdireccion = gdireccion;
		this.idEstado = idEstado;
	}

	@JsonProperty("bnombre")
	public String getBnombre() {
		return bnombre;
	}

	@JsonProperty("bnombre")
	public void setBnombre(String bnombre) {
		this.bnombre = bnombre;
	}

	public RecuperarClienteInterno withBnombre(String bnombre) {
		this.bnombre = bnombre;
		return this;
	}

	@JsonProperty("capellido")
	public String getCapellido() {
		return capellido;
	}

	@JsonProperty("capellido")
	public void setCapellido(String capellido) {
		this.capellido = capellido;
	}

	public RecuperarClienteInterno withCapellido(String capellido) {
		this.capellido = capellido;
		return this;
	}

	@JsonProperty("dtelefono")
	public String getDtelefono() {
		return dtelefono;
	}

	@JsonProperty("dtelefono")
	public void setDtelefono(String dtelefono) {
		this.dtelefono = dtelefono;
	}

	public RecuperarClienteInterno withDtelefono(String dtelefono) {
		this.dtelefono = dtelefono;
		return this;
	}

	@JsonProperty("eDni")
	public String getEDni() {
		return eDni;
	}

	@JsonProperty("eDni")
	public void setEDni(String eDni) {
		this.eDni = eDni;
	}

	public RecuperarClienteInterno withEDni(String eDni) {
		this.eDni = eDni;
		return this;
	}

	@JsonProperty("fcorreo")
	public String getFcorreo() {
		return fcorreo;
	}

	@JsonProperty("fcorreo")
	public void setFcorreo(String fcorreo) {
		this.fcorreo = fcorreo;
	}

	public RecuperarClienteInterno withFcorreo(String fcorreo) {
		this.fcorreo = fcorreo;
		return this;
	}

	@JsonProperty("gdireccion")
	public String getGdireccion() {
		return gdireccion;
	}

	@JsonProperty("gdireccion")
	public void setGdireccion(String gdireccion) {
		this.gdireccion = gdireccion;
	}

	public RecuperarClienteInterno withGdireccion(String gdireccion) {
		this.gdireccion = gdireccion;
		return this;
	}

	@JsonProperty("idEstado")
	public int getIdEstado() {
		return idEstado;
	}

	@JsonProperty("idEstado")
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public RecuperarClienteInterno withIdEstado(int idEstado) {
		this.idEstado = idEstado;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public RecuperarClienteInterno withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}