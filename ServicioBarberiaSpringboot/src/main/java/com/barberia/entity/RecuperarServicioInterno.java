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
@JsonPropertyOrder({ "bnombser", "cidEstado", "dminutos", "eprecio", "fdescripcion" })
public class RecuperarServicioInterno implements Serializable {

	@JsonProperty("bnombser")
	private String bnombser;
	@JsonProperty("cidEstado")
	private int cidEstado;
	@JsonProperty("dminutos")
	private int dminutos;
	@JsonProperty("eprecio")
	private Double eprecio;
	@JsonProperty("fdescripcion")
	private String fdescripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7036742571233454594L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperarServicioInterno() {
	}

	/**
	 * 
	 * @param bnombser
	 * @param fdescripcion
	 * @param eprecio
	 * @param dminutos
	 * @param cidEstado
	 */
	public RecuperarServicioInterno(String bnombser, int cidEstado, int dminutos, Double eprecio, String fdescripcion) {
		super();
		this.bnombser = bnombser;
		this.cidEstado = cidEstado;
		this.dminutos = dminutos;
		this.eprecio = eprecio;
		this.fdescripcion = fdescripcion;
	}

	@JsonProperty("bnombser")
	public String getBnombser() {
		return bnombser;
	}

	@JsonProperty("bnombser")
	public void setBnombser(String bnombser) {
		this.bnombser = bnombser;
	}

	public RecuperarServicioInterno withBnombser(String bnombser) {
		this.bnombser = bnombser;
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

	public RecuperarServicioInterno withCidEstado(int cidEstado) {
		this.cidEstado = cidEstado;
		return this;
	}

	@JsonProperty("dminutos")
	public int getDminutos() {
		return dminutos;
	}

	@JsonProperty("dminutos")
	public void setDminutos(int dminutos) {
		this.dminutos = dminutos;
	}

	public RecuperarServicioInterno withDminutos(int dminutos) {
		this.dminutos = dminutos;
		return this;
	}

	@JsonProperty("eprecio")
	public Double getEprecio() {
		return eprecio;
	}

	@JsonProperty("eprecio")
	public void setEprecio(Double eprecio) {
		this.eprecio = eprecio;
	}

	public RecuperarServicioInterno withEprecio(Double eprecio) {
		this.eprecio = eprecio;
		return this;
	}

	@JsonProperty("fdescripcion")
	public String getFdescripcion() {
		return fdescripcion;
	}

	@JsonProperty("fdescripcion")
	public void setFdescripcion(String fdescripcion) {
		this.fdescripcion = fdescripcion;
	}

	public RecuperarServicioInterno withFdescripcion(String fdescripcion) {
		this.fdescripcion = fdescripcion;
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

	public RecuperarServicioInterno withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}