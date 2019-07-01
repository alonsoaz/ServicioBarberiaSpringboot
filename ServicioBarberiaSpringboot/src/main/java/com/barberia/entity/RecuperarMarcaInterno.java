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
@JsonPropertyOrder({ "cmarca", "didEstado" })
public class RecuperarMarcaInterno implements Serializable {

	@JsonProperty("cmarca")
	private String cmarca;
	@JsonProperty("didEstado")
	private int didEstado;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -2507113153176299973L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperarMarcaInterno() {
	}

	/**
	 * 
	 * @param cmarca
	 * @param didEstado
	 */
	public RecuperarMarcaInterno(String cmarca, int didEstado) {
		super();
		this.cmarca = cmarca;
		this.didEstado = didEstado;
	}

	@JsonProperty("cmarca")
	public String getCmarca() {
		return cmarca;
	}

	@JsonProperty("cmarca")
	public void setCmarca(String cmarca) {
		this.cmarca = cmarca;
	}

	public RecuperarMarcaInterno withCmarca(String cmarca) {
		this.cmarca = cmarca;
		return this;
	}

	@JsonProperty("didEstado")
	public int getDidEstado() {
		return didEstado;
	}

	@JsonProperty("didEstado")
	public void setDidEstado(int didEstado) {
		this.didEstado = didEstado;
	}

	public RecuperarMarcaInterno withDidEstado(int didEstado) {
		this.didEstado = didEstado;
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

	public RecuperarMarcaInterno withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}