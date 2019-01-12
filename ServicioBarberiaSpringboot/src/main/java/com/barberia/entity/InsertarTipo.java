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
@JsonPropertyOrder({"tipo"})
public class InsertarTipo
  implements Serializable
{
  @JsonProperty("tipo")
  private String tipo;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap();
  



  private static final long serialVersionUID = -8955067935619671625L;
  



  public InsertarTipo() {}
  



  public InsertarTipo(String tipo)
  {
    this.tipo = tipo;
  }
  
  @JsonProperty("tipo")
  public String getTipo() {
    return tipo;
  }
  
  @JsonProperty("tipo")
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public InsertarTipo withTipo(String tipo) {
    this.tipo = tipo;
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
  
  public InsertarTipo withAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
    return this;
  }
}
