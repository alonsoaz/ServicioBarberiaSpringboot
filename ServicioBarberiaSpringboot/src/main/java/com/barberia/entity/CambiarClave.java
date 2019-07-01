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
@JsonPropertyOrder({ "apass", "bNewPass" })
public class CambiarClave implements Serializable {

	@JsonProperty("apass")
	private String apass;
	@JsonProperty("bNewPass")
	private String bNewPass;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 5082365685590381748L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public CambiarClave() {
	}

	/**
	 * 
	 * @param apass
	 * @param bNewPass
	 */
	public CambiarClave(String apass, String bNewPass) {
		super();
		this.apass = apass;
		this.bNewPass = bNewPass;
	}

	@JsonProperty("apass")
	public String getApass() {
		return apass;
	}

	@JsonProperty("apass")
	public void setApass(String apass) {
		this.apass = apass;
	}

	public CambiarClave withApass(String apass) {
		this.apass = apass;
		return this;
	}

	@JsonProperty("bNewPass")
	public String getBNewPass() {
		return bNewPass;
	}

	@JsonProperty("bNewPass")
	public void setBNewPass(String bNewPass) {
		this.bNewPass = bNewPass;
	}

	public CambiarClave withBNewPass(String bNewPass) {
		this.bNewPass = bNewPass;
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

	public CambiarClave withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}