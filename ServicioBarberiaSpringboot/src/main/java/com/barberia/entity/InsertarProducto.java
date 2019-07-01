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
@JsonPropertyOrder({ "anombre", "bidMarca", "cidTipo", "dStock", "ePrecio", "fdescripcion" })
public class InsertarProducto implements Serializable {

	@JsonProperty("anombre")
	private String anombre;
	@JsonProperty("bidMarca")
	private int bidMarca;
	@JsonProperty("cidTipo")
	private int cidTipo;
	@JsonProperty("dStock")
	private int dStock;
	@JsonProperty("ePrecio")
	private int ePrecio;
	@JsonProperty("fdescripcion")
	private String fdescripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1023552033954990481L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public InsertarProducto() {
	}

	/**
	 * 
	 * @param fdescripcion
	 * @param ePrecio
	 * @param bidMarca
	 * @param cidTipo
	 * @param dStock
	 * @param anombre
	 */
	public InsertarProducto(String anombre, int bidMarca, int cidTipo, int dStock, int ePrecio, String fdescripcion) {
		super();
		this.anombre = anombre;
		this.bidMarca = bidMarca;
		this.cidTipo = cidTipo;
		this.dStock = dStock;
		this.ePrecio = ePrecio;
		this.fdescripcion = fdescripcion;
	}

	@JsonProperty("anombre")
	public String getAnombre() {
		return anombre;
	}

	@JsonProperty("anombre")
	public void setAnombre(String anombre) {
		this.anombre = anombre;
	}

	public InsertarProducto withAnombre(String anombre) {
		this.anombre = anombre;
		return this;
	}

	@JsonProperty("bidMarca")
	public int getBidMarca() {
		return bidMarca;
	}

	@JsonProperty("bidMarca")
	public void setBidMarca(int bidMarca) {
		this.bidMarca = bidMarca;
	}

	public InsertarProducto withBidMarca(int bidMarca) {
		this.bidMarca = bidMarca;
		return this;
	}

	@JsonProperty("cidTipo")
	public int getCidTipo() {
		return cidTipo;
	}

	@JsonProperty("cidTipo")
	public void setCidTipo(int cidTipo) {
		this.cidTipo = cidTipo;
	}

	public InsertarProducto withCidTipo(int cidTipo) {
		this.cidTipo = cidTipo;
		return this;
	}

	@JsonProperty("dStock")
	public int getDStock() {
		return dStock;
	}

	@JsonProperty("dStock")
	public void setDStock(int dStock) {
		this.dStock = dStock;
	}

	public InsertarProducto withDStock(int dStock) {
		this.dStock = dStock;
		return this;
	}

	@JsonProperty("ePrecio")
	public int getEPrecio() {
		return ePrecio;
	}

	@JsonProperty("ePrecio")
	public void setEPrecio(int ePrecio) {
		this.ePrecio = ePrecio;
	}

	public InsertarProducto withEPrecio(int ePrecio) {
		this.ePrecio = ePrecio;
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

	public InsertarProducto withFdescripcion(String fdescripcion) {
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

	public InsertarProducto withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}