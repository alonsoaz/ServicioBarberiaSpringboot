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
@JsonPropertyOrder({ "anombre", "bapellido", "ctelefono", "ddni", "ecorreo", "fdireccion" })
public class InsertarBarbero implements Serializable {

	@JsonProperty("anombre")
	private String anombre;
	@JsonProperty("bapellido")
	private String bapellido;
	@JsonProperty("ctelefono")
	private String ctelefono;
	@JsonProperty("ddni")
	private String ddni;
	@JsonProperty("ecorreo")
	private String ecorreo;
	@JsonProperty("fdireccion")
	private String fdireccion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -6617830529541511909L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public InsertarBarbero() {
	}

	/**
	 * 
	 * @param ecorreo
	 * @param ctelefono
	 * @param ddni
	 * @param fdireccion
	 * @param bapellido
	 * @param anombre
	 */
	public InsertarBarbero(String anombre, String bapellido, String ctelefono, String ddni, String ecorreo,
			String fdireccion) {
		super();
		this.anombre = anombre;
		this.bapellido = bapellido;
		this.ctelefono = ctelefono;
		this.ddni = ddni;
		this.ecorreo = ecorreo;
		this.fdireccion = fdireccion;
	}

	@JsonProperty("anombre")
	public String getAnombre() {
		return anombre;
	}

	@JsonProperty("anombre")
	public void setAnombre(String anombre) {
		this.anombre = anombre;
	}

	public InsertarBarbero withAnombre(String anombre) {
		this.anombre = anombre;
		return this;
	}

	@JsonProperty("bapellido")
	public String getBapellido() {
		return bapellido;
	}

	@JsonProperty("bapellido")
	public void setBapellido(String bapellido) {
		this.bapellido = bapellido;
	}

	public InsertarBarbero withBapellido(String bapellido) {
		this.bapellido = bapellido;
		return this;
	}

	@JsonProperty("ctelefono")
	public String getCtelefono() {
		return ctelefono;
	}

	@JsonProperty("ctelefono")
	public void setCtelefono(String ctelefono) {
		this.ctelefono = ctelefono;
	}

	public InsertarBarbero withCtelefono(String ctelefono) {
		this.ctelefono = ctelefono;
		return this;
	}

	@JsonProperty("ddni")
	public String getDdni() {
		return ddni;
	}

	@JsonProperty("ddni")
	public void setDdni(String ddni) {
		this.ddni = ddni;
	}

	public InsertarBarbero withDdni(String ddni) {
		this.ddni = ddni;
		return this;
	}

	@JsonProperty("ecorreo")
	public String getEcorreo() {
		return ecorreo;
	}

	@JsonProperty("ecorreo")
	public void setEcorreo(String ecorreo) {
		this.ecorreo = ecorreo;
	}

	public InsertarBarbero withEcorreo(String ecorreo) {
		this.ecorreo = ecorreo;
		return this;
	}

	@JsonProperty("fdireccion")
	public String getFdireccion() {
		return fdireccion;
	}

	@JsonProperty("fdireccion")
	public void setFdireccion(String fdireccion) {
		this.fdireccion = fdireccion;
	}

	public InsertarBarbero withFdireccion(String fdireccion) {
		this.fdireccion = fdireccion;
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

	public InsertarBarbero withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}