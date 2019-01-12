package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RecuperarBarberoInterno
{
  private int aidEstado;
  private String bNombre;
  private String cApellido;
  private String dTelefono;
  private String eDni;
  private String fEmail;
  private String gDireccion;
  
  public RecuperarBarberoInterno(int aidEstado, String bNombre, String cApellido, String dTelefono, String eDni, String fEmail, String gDireccion)
  {
    this.aidEstado = aidEstado;
    this.bNombre = bNombre;
    this.cApellido = cApellido;
    this.dTelefono = dTelefono;
    this.eDni = eDni;
    this.fEmail = fEmail;
    this.gDireccion = gDireccion;
  }
  
  public int getAidEstado() {
    return aidEstado;
  }
  
  public void setAidEstado(int aidEstado) {
    this.aidEstado = aidEstado;
  }
  
  public String getbNombre() {
    return bNombre;
  }
  
  public void setbNombre(String bNombre) {
    this.bNombre = bNombre;
  }
  
  public String getcApellido() {
    return cApellido;
  }
  
  public void setcApellido(String cApellido) {
    this.cApellido = cApellido;
  }
  
  public String getdTelefono() {
    return dTelefono;
  }
  
  public void setdTelefono(String dTelefono) {
    this.dTelefono = dTelefono;
  }
  
  public String geteDni() {
    return eDni;
  }
  
  public void seteDni(String eDni) {
    this.eDni = eDni;
  }
  
  public String getfEmail() {
    return fEmail;
  }
  
  public void setfEmail(String fEmail) {
    this.fEmail = fEmail;
  }
  
  public String getgDireccion() {
    return gDireccion;
  }
  
  public void setgDireccion(String gDireccion) {
    this.gDireccion = gDireccion;
  }
}
