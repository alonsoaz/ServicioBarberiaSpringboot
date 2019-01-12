package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertarBarbero
{
  private String anombre;
  private String bapellido;
  private String ctelefono;
  private String ddni;
  private String ecorreo;
  private String fdireccion;
  
  public InsertarBarbero(String anombre, String bapellido, String ctelefono, String ddni, String ecorreo, String fdireccion)
  {
    this.anombre = anombre;
    this.bapellido = bapellido;
    this.ctelefono = ctelefono;
    this.ddni = ddni;
    this.ecorreo = ecorreo;
    this.fdireccion = fdireccion;
  }
  
  public String getAnombre() { return anombre; }
  
  public void setAnombre(String anombre) {
    this.anombre = anombre;
  }
  
  public String getBapellido() { return bapellido; }
  
  public void setBapellido(String bapellido) {
    this.bapellido = bapellido;
  }
  
  public String getCtelefono() { return ctelefono; }
  
  public void setCtelefono(String ctelefono) {
    this.ctelefono = ctelefono;
  }
  
  public String getDdni() { return ddni; }
  
  public void setDdni(String ddni) {
    this.ddni = ddni;
  }
  
  public String getEcorreo() { return ecorreo; }
  
  public void setEcorreo(String ecorreo) {
    this.ecorreo = ecorreo;
  }
  
  public String getFdireccion() { return fdireccion; }
  
  public void setFdireccion(String fdireccion) {
    this.fdireccion = fdireccion;
  }
}
