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
@JsonPropertyOrder({ "aIdCliente", "bIdProducto", "cantidad" })
public class RegistrarDetalleVentaXpAgar implements Serializable {

	@JsonProperty("aIdCliente")
	private int aIdCliente;
	@JsonProperty("bIdProducto")
	private int bIdProducto;
	@JsonProperty("cantidad")
	private int cantidad;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 2934454814684547370L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RegistrarDetalleVentaXpAgar() {
	}

	/**
	 * 
	 * @param aIdCliente
	 * @param cantidad
	 * @param bIdProducto
	 */
	public RegistrarDetalleVentaXpAgar(int aIdCliente, int bIdProducto, int cantidad) {
		super();
		this.aIdCliente = aIdCliente;
		this.bIdProducto = bIdProducto;
		this.cantidad = cantidad;
	}
	
	

	public RegistrarDetalleVentaXpAgar(int cantidad) {
		super();
		this.cantidad = cantidad;
	}

	@JsonProperty("aIdCliente")
	public int getAIdCliente() {
		return aIdCliente;
	}

	@JsonProperty("aIdCliente")
	public void setAIdCliente(int aIdCliente) {
		this.aIdCliente = aIdCliente;
	}

	public RegistrarDetalleVentaXpAgar withAIdCliente(int aIdCliente) {
		this.aIdCliente = aIdCliente;
		return this;
	}

	@JsonProperty("bIdProducto")
	public int getBIdProducto() {
		return bIdProducto;
	}

	@JsonProperty("bIdProducto")
	public void setBIdProducto(int bIdProducto) {
		this.bIdProducto = bIdProducto;
	}

	public RegistrarDetalleVentaXpAgar withBIdProducto(int bIdProducto) {
		this.bIdProducto = bIdProducto;
		return this;
	}

	@JsonProperty("cantidad")
	public int getCantidad() {
		return cantidad;
	}

	@JsonProperty("cantidad")
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public RegistrarDetalleVentaXpAgar withCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public RegistrarDetalleVentaXpAgar withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}