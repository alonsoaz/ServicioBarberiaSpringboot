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
@JsonPropertyOrder({"marca"})
public class InsertarMarca
  implements Serializable
{
  @JsonProperty("marca")
  private String marca;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap();
  



  private static final long serialVersionUID = -466828180091301716L;
  



  public InsertarMarca() {}
  



  public InsertarMarca(String marca)
  {
    this.marca = marca;
  }
  
  @JsonProperty("marca")
  public String getMarca() {
    return marca;
  }
  
  @JsonProperty("marca")
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  public InsertarMarca withMarca(String marca) {
    this.marca = marca;
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
  
  public InsertarMarca withAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
    return this;
  }
}
