package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginUsuario
{
  private String aaka;
  private String bpass;
  
  public LoginUsuario(String aaka, String bpass)
  {
    this.aaka = aaka;
    this.bpass = bpass;
  }
  
  public String getAaka() {
    return aaka;
  }
  
  public void setAaka(String aaka) { this.aaka = aaka; }
  
  public String getBpass() {
    return bpass;
  }
  
  public void setBpass(String bpass) { this.bpass = bpass; }
}
