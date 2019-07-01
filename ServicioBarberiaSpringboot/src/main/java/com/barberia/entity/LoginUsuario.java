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
@JsonPropertyOrder({
"aaka",
"bpass"
})
public class LoginUsuario implements Serializable
{

@JsonProperty("aaka")
private String aaka;
@JsonProperty("bpass")
private String bpass;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -6050472325799354626L;

/**
* No args constructor for use in serialization
* 
*/
public LoginUsuario() {
}

/**
* 
* @param aaka
* @param bpass
*/
public LoginUsuario(String aaka, String bpass) {
super();
this.aaka = aaka;
this.bpass = bpass;
}

@JsonProperty("aaka")
public String getAaka() {
return aaka;
}

@JsonProperty("aaka")
public void setAaka(String aaka) {
this.aaka = aaka;
}

public LoginUsuario withAaka(String aaka) {
this.aaka = aaka;
return this;
}

@JsonProperty("bpass")
public String getBpass() {
return bpass;
}

@JsonProperty("bpass")
public void setBpass(String bpass) {
this.bpass = bpass;
}

public LoginUsuario withBpass(String bpass) {
this.bpass = bpass;
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

public LoginUsuario withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

}