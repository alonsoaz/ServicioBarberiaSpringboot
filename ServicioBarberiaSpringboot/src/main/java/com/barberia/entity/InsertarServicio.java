package com.barberia.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;





@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bnombser", "cidEstado", "dminutos", "eprecio", "fdescripcion"})
public class InsertarServicio
  implements Serializable
{
  @JsonProperty("bnombser")
  private String bnombser;
  @JsonProperty("cidEstado")
  private int cidEstado;
  @JsonProperty("dminutos")
  private int dminutos;
  @JsonProperty("eprecio")
  private double eprecio;
  @JsonProperty("fdescripcion")
  private String fdescripcion;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap();
  




  private static final long serialVersionUID = 1518617585260221468L;
  





  public InsertarServicio() {}
  




  public InsertarServicio(String bnombser, int cidEstado, int dminutos, double eprecio, String fdescripcion)
  {
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
  
  public InsertarServicio withBnombser(String bnombser) {
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
  
  public InsertarServicio withCidEstado(int cidEstado) {
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
  
  public InsertarServicio withDminutos(int dminutos) {
    this.dminutos = dminutos;
    return this;
  }
  
  @JsonProperty("eprecio")
  public double getEprecio() {
    return eprecio;
  }
  
  @JsonProperty("eprecio")
  public void setEprecio(double eprecio) {
    this.eprecio = eprecio;
  }
  
  public InsertarServicio withEprecio(double eprecio) {
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
  
  public InsertarServicio withFdescripcion(String fdescripcion) {
    this.fdescripcion = fdescripcion;
    return this;
  }
  
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }
  
  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
  }
  
  public InsertarServicio withAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
    return this;
  }
}
