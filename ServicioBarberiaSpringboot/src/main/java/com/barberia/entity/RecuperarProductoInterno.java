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
@JsonPropertyOrder({ "aIdMarca", "bidTipo", "cNombre", "didEstado", "fStock", "gPrecio", "hdescripcion" })
public class RecuperarProductoInterno implements Serializable {

	@JsonProperty("aIdMarca")
	private int aIdMarca;
	@JsonProperty("bidTipo")
	private int bidTipo;
	@JsonProperty("cNombre")
	private String cNombre;
	@JsonProperty("didEstado")
	private int didEstado;
	@JsonProperty("fStock")
	private int fStock;
	@JsonProperty("gPrecio")
	private Double gPrecio;
	@JsonProperty("hdescripcion")
	private String hdescripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 3140575151657108762L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperarProductoInterno() {
	}

	/**
	 * 
	 * @param aIdMarca
	 * @param hdescripcion
	 * @param fStock
	 * @param cNombre
	 * @param gPrecio
	 * @param didEstado
	 * @param bidTipo
	 */
	public RecuperarProductoInterno(int aIdMarca, int bidTipo, String cNombre, int didEstado, int fStock, Double gPrecio,
			String hdescripcion) {
		super();
		this.aIdMarca = aIdMarca;
		this.bidTipo = bidTipo;
		this.cNombre = cNombre;
		this.didEstado = didEstado;
		this.fStock = fStock;
		this.gPrecio = gPrecio;
		this.hdescripcion = hdescripcion;
	}

	@JsonProperty("aIdMarca")
	public int getAIdMarca() {
		return aIdMarca;
	}

	@JsonProperty("aIdMarca")
	public void setAIdMarca(int aIdMarca) {
		this.aIdMarca = aIdMarca;
	}

	public RecuperarProductoInterno withAIdMarca(int aIdMarca) {
		this.aIdMarca = aIdMarca;
		return this;
	}

	@JsonProperty("bidTipo")
	public int getBidTipo() {
		return bidTipo;
	}

	@JsonProperty("bidTipo")
	public void setBidTipo(int bidTipo) {
		this.bidTipo = bidTipo;
	}

	public RecuperarProductoInterno withBidTipo(int bidTipo) {
		this.bidTipo = bidTipo;
		return this;
	}

	@JsonProperty("cNombre")
	public String getCNombre() {
		return cNombre;
	}

	@JsonProperty("cNombre")
	public void setCNombre(String cNombre) {
		this.cNombre = cNombre;
	}

	public RecuperarProductoInterno withCNombre(String cNombre) {
		this.cNombre = cNombre;
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

	public RecuperarProductoInterno withDidEstado(int didEstado) {
		this.didEstado = didEstado;
		return this;
	}

	@JsonProperty("fStock")
	public int getFStock() {
		return fStock;
	}

	@JsonProperty("fStock")
	public void setFStock(int fStock) {
		this.fStock = fStock;
	}

	public RecuperarProductoInterno withFStock(int fStock) {
		this.fStock = fStock;
		return this;
	}

	@JsonProperty("gPrecio")
	public Double getGPrecio() {
		return gPrecio;
	}

	@JsonProperty("gPrecio")
	public void setGPrecio(Double gPrecio) {
		this.gPrecio = gPrecio;
	}

	public RecuperarProductoInterno withGPrecio(Double gPrecio) {
		this.gPrecio = gPrecio;
		return this;
	}

	@JsonProperty("hdescripcion")
	public String getHdescripcion() {
		return hdescripcion;
	}

	@JsonProperty("hdescripcion")
	public void setHdescripcion(String hdescripcion) {
		this.hdescripcion = hdescripcion;
	}

	public RecuperarProductoInterno withHdescripcion(String hdescripcion) {
		this.hdescripcion = hdescripcion;
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

	public RecuperarProductoInterno withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}