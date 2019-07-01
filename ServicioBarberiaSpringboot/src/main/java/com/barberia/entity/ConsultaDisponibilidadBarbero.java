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
@JsonPropertyOrder({ "bYear", "cMonth", "dDay", "eHour", "fMinut", "gSeconds" })
public class ConsultaDisponibilidadBarbero implements Serializable {

	@JsonProperty("bYear")
	private int bYear;
	@JsonProperty("cMonth")
	private int cMonth;
	@JsonProperty("dDay")
	private int dDay;
	@JsonProperty("eHour")
	private int eHour;
	@JsonProperty("fMinut")
	private int fMinut;
	@JsonProperty("gSeconds")
	private int gSeconds;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -1902845977391160999L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ConsultaDisponibilidadBarbero() {
	}

	/**
	 * 
	 * @param dDay
	 * @param fMinut
	 * @param cMonth
	 * @param eHour
	 * @param gSeconds
	 * @param bYear
	 */
	public ConsultaDisponibilidadBarbero(int bYear, int cMonth, int dDay, int eHour, int fMinut, int gSeconds) {
		super();
		this.bYear = bYear;
		this.cMonth = cMonth;
		this.dDay = dDay;
		this.eHour = eHour;
		this.fMinut = fMinut;
		this.gSeconds = gSeconds;
	}

	@JsonProperty("bYear")
	public int getBYear() {
		return bYear;
	}

	@JsonProperty("bYear")
	public void setBYear(int bYear) {
		this.bYear = bYear;
	}

	public ConsultaDisponibilidadBarbero withBYear(int bYear) {
		this.bYear = bYear;
		return this;
	}

	@JsonProperty("cMonth")
	public int getCMonth() {
		return cMonth;
	}

	@JsonProperty("cMonth")
	public void setCMonth(int cMonth) {
		this.cMonth = cMonth;
	}

	public ConsultaDisponibilidadBarbero withCMonth(int cMonth) {
		this.cMonth = cMonth;
		return this;
	}

	@JsonProperty("dDay")
	public int getDDay() {
		return dDay;
	}

	@JsonProperty("dDay")
	public void setDDay(int dDay) {
		this.dDay = dDay;
	}

	public ConsultaDisponibilidadBarbero withDDay(int dDay) {
		this.dDay = dDay;
		return this;
	}

	@JsonProperty("eHour")
	public int getEHour() {
		return eHour;
	}

	@JsonProperty("eHour")
	public void setEHour(int eHour) {
		this.eHour = eHour;
	}

	public ConsultaDisponibilidadBarbero withEHour(int eHour) {
		this.eHour = eHour;
		return this;
	}

	@JsonProperty("fMinut")
	public int getFMinut() {
		return fMinut;
	}

	@JsonProperty("fMinut")
	public void setFMinut(int fMinut) {
		this.fMinut = fMinut;
	}

	public ConsultaDisponibilidadBarbero withFMinut(int fMinut) {
		this.fMinut = fMinut;
		return this;
	}

	@JsonProperty("gSeconds")
	public int getGSeconds() {
		return gSeconds;
	}

	@JsonProperty("gSeconds")
	public void setGSeconds(int gSeconds) {
		this.gSeconds = gSeconds;
	}

	public ConsultaDisponibilidadBarbero withGSeconds(int gSeconds) {
		this.gSeconds = gSeconds;
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

	public ConsultaDisponibilidadBarbero withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}