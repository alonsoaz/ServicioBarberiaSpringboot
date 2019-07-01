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
@JsonPropertyOrder({ "bTipo", "cidEstado" })
public class RecuperarTipoProducto implements Serializable {

	@JsonProperty("bTipo")
	private String bTipo;
	@JsonProperty("cidEstado")
	private int cidEstado;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 4284911619514436797L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperarTipoProducto() {
	}

	/**
	 * 
	 * @param bTipo
	 * @param cidEstado
	 */
	public RecuperarTipoProducto(String bTipo, int cidEstado) {
		super();
		this.bTipo = bTipo;
		this.cidEstado = cidEstado;
	}

	@JsonProperty("bTipo")
	public String getBTipo() {
		return bTipo;
	}

	@JsonProperty("bTipo")
	public void setBTipo(String bTipo) {
		this.bTipo = bTipo;
	}

	public RecuperarTipoProducto withBTipo(String bTipo) {
		this.bTipo = bTipo;
		return this;
	}

	@JsonProperty("cidEstado")
	public int getCidEstado() {
		return cidEstado;
	}

	@JsonProperty("cidEstado")
	public void setCidEstado(int cidEstado) {
		this.cidEstado = cidEstado;
	}

	public RecuperarTipoProducto withCidEstado(int cidEstado) {
		this.cidEstado = cidEstado;
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

	public RecuperarTipoProducto withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}