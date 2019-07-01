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
@JsonPropertyOrder({ "aDni", "bPassword" })
public class LoginCliente implements Serializable {

	@JsonProperty("aDni")
	private String aDni;
	@JsonProperty("bPassword")
	private String bPassword;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -9205075806267198936L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public LoginCliente() {
	}

	/**
	 * 
	 * @param aDni
	 * @param bPassword
	 */
	public LoginCliente(String aDni, String bPassword) {
		super();
		this.aDni = aDni;
		this.bPassword = bPassword;
	}

	@JsonProperty("aDni")
	public String getADni() {
		return aDni;
	}

	@JsonProperty("aDni")
	public void setADni(String aDni) {
		this.aDni = aDni;
	}

	public LoginCliente withADni(String aDni) {
		this.aDni = aDni;
		return this;
	}

	@JsonProperty("bPassword")
	public String getBPassword() {
		return bPassword;
	}

	@JsonProperty("bPassword")
	public void setBPassword(String bPassword) {
		this.bPassword = bPassword;
	}

	public LoginCliente withBPassword(String bPassword) {
		this.bPassword = bPassword;
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

	public LoginCliente withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}