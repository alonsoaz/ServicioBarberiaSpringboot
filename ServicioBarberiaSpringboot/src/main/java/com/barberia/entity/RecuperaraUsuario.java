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
@JsonPropertyOrder({ "anombre", "capellido", "dcargo", "eaka", "fcorreo", "gtelefono", "hdescripcion" })
public class RecuperaraUsuario implements Serializable {

	@JsonProperty("anombre")
	private String anombre;
	@JsonProperty("capellido")
	private String capellido;
	@JsonProperty("dcargo")
	private String dcargo;
	@JsonProperty("eaka")
	private String eaka;
	@JsonProperty("fcorreo")
	private String fcorreo;
	@JsonProperty("gtelefono")
	private String gtelefono;
	@JsonProperty("hdescripcion")
	private String hdescripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 8652235400281358368L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public RecuperaraUsuario() {
	}

	/**
	 * 
	 * @param gtelefono
	 * @param fcorreo
	 * @param capellido
	 * @param hdescripcion
	 * @param eaka
	 * @param dcargo
	 * @param anombre
	 */
	public RecuperaraUsuario(String anombre, String capellido, String dcargo, String eaka, String fcorreo,
			String gtelefono, String hdescripcion) {
		super();
		this.anombre = anombre;
		this.capellido = capellido;
		this.dcargo = dcargo;
		this.eaka = eaka;
		this.fcorreo = fcorreo;
		this.gtelefono = gtelefono;
		this.hdescripcion = hdescripcion;
	}

	@JsonProperty("anombre")
	public String getAnombre() {
		return anombre;
	}

	@JsonProperty("anombre")
	public void setAnombre(String anombre) {
		this.anombre = anombre;
	}

	public RecuperaraUsuario withAnombre(String anombre) {
		this.anombre = anombre;
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

	public RecuperaraUsuario withCapellido(String capellido) {
		this.capellido = capellido;
		return this;
	}

	@JsonProperty("dcargo")
	public String getDcargo() {
		return dcargo;
	}

	@JsonProperty("dcargo")
	public void setDcargo(String dcargo) {
		this.dcargo = dcargo;
	}

	public RecuperaraUsuario withDcargo(String dcargo) {
		this.dcargo = dcargo;
		return this;
	}

	@JsonProperty("eaka")
	public String getEaka() {
		return eaka;
	}

	@JsonProperty("eaka")
	public void setEaka(String eaka) {
		this.eaka = eaka;
	}

	public RecuperaraUsuario withEaka(String eaka) {
		this.eaka = eaka;
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

	public RecuperaraUsuario withFcorreo(String fcorreo) {
		this.fcorreo = fcorreo;
		return this;
	}

	@JsonProperty("gtelefono")
	public String getGtelefono() {
		return gtelefono;
	}

	@JsonProperty("gtelefono")
	public void setGtelefono(String gtelefono) {
		this.gtelefono = gtelefono;
	}

	public RecuperaraUsuario withGtelefono(String gtelefono) {
		this.gtelefono = gtelefono;
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

	public RecuperaraUsuario withHdescripcion(String hdescripcion) {
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

	public RecuperaraUsuario withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}