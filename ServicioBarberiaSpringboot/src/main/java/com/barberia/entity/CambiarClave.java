package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CambiarClave
{
  private String apass;
  private String bNewPass;
  
  public CambiarClave(String apass, String bNewPass)
  {
    this.apass = apass;
    this.bNewPass = bNewPass;
  }
  
  public String getApass() {
    return apass;
  }
  
  public void setApass(String apass) {
    this.apass = apass;
  }
  
  public String getbNewPass() {
    return bNewPass;
  }
  
  public void setbNewPass(String bNewPass) {
    this.bNewPass = bNewPass;
  }
}
