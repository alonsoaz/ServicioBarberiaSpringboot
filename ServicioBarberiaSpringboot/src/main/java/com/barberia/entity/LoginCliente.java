package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginCliente
{
  public String aDni;
  public String bTelf;
  
  public LoginCliente(String aDni, String bTelf) {
    this.aDni = aDni;
    this.bTelf = bTelf;
  }
  
  public String getaDni() { return aDni; }
  
  public void setaDni(String aDni) {
    this.aDni = aDni;
  }
  
  public String getbTelf() { return bTelf; }
  
  public void setbTelf(String bTelf) {
    this.bTelf = bTelf;
  }
}
