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
@JsonPropertyOrder({ "aidUsuario", "bnombre", "capellido", "dcargo", "eaka", "fpass", "gemail", "htelefono",
		"idescripcion" })
public class InsertarUsuario implements Serializable {

	@JsonProperty("aidUsuario")
	private int aidUsuario;
	@JsonProperty("bnombre")
	private String bnombre;
	@JsonProperty("capellido")
	private String capellido;
	@JsonProperty("dcargo")
	private String dcargo;
	@JsonProperty("eaka")
	private String eaka;
	@JsonProperty("fpass")
	private String fpass;
	@JsonProperty("gemail")
	private String gemail;
	@JsonProperty("htelefono")
	private String htelefono;
	@JsonProperty("idescripcion")
	private String idescripcion;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 2658999039287705438L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public InsertarUsuario() {
	}

	/**
	 * 
	 * @param bnombre
	 * @param gemail
	 * @param capellido
	 * @param aidUsuario
	 * @param eaka
	 * @param htelefono
	 * @param dcargo
	 * @param fpass
	 * @param idescripcion
	 */
	public InsertarUsuario(int aidUsuario, String bnombre, String capellido, String dcargo, String eaka, String fpass,
			String gemail, String htelefono, String idescripcion) {
		super();
		this.aidUsuario = aidUsuario;
		this.bnombre = bnombre;
		this.capellido = capellido;
		this.dcargo = dcargo;
		this.eaka = eaka;
		this.fpass = fpass;
		this.gemail = gemail;
		this.htelefono = htelefono;
		this.idescripcion = idescripcion;
	}

	@JsonProperty("aidUsuario")
	public int getAidUsuario() {
		return aidUsuario;
	}

	@JsonProperty("aidUsuario")
	public void setAidUsuario(int aidUsuario) {
		this.aidUsuario = aidUsuario;
	}

	public InsertarUsuario withAidUsuario(int aidUsuario) {
		this.aidUsuario = aidUsuario;
		return this;
	}

	@JsonProperty("bnombre")
	public String getBnombre() {
		return bnombre;
	}

	@JsonProperty("bnombre")
	public void setBnombre(String bnombre) {
		this.bnombre = bnombre;
	}

	public InsertarUsuario withBnombre(String bnombre) {
		this.bnombre = bnombre;
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

	public InsertarUsuario withCapellido(String capellido) {
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

	public InsertarUsuario withDcargo(String dcargo) {
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

	public InsertarUsuario withEaka(String eaka) {
		this.eaka = eaka;
		return this;
	}

	@JsonProperty("fpass")
	public String getFpass() {
		return fpass;
	}

	@JsonProperty("fpass")
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}

	public InsertarUsuario withFpass(String fpass) {
		this.fpass = fpass;
		return this;
	}

	@JsonProperty("gemail")
	public String getGemail() {
		return gemail;
	}

	@JsonProperty("gemail")
	public void setGemail(String gemail) {
		this.gemail = gemail;
	}

	public InsertarUsuario withGemail(String gemail) {
		this.gemail = gemail;
		return this;
	}

	@JsonProperty("htelefono")
	public String getHtelefono() {
		return htelefono;
	}

	@JsonProperty("htelefono")
	public void setHtelefono(String htelefono) {
		this.htelefono = htelefono;
	}

	public InsertarUsuario withHtelefono(String htelefono) {
		this.htelefono = htelefono;
		return this;
	}

	@JsonProperty("idescripcion")
	public String getIdescripcion() {
		return idescripcion;
	}

	@JsonProperty("idescripcion")
	public void setIdescripcion(String idescripcion) {
		this.idescripcion = idescripcion;
	}

	public InsertarUsuario withIdescripcion(String idescripcion) {
		this.idescripcion = idescripcion;
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

	public InsertarUsuario withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}