package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecuperarClienteInterno
{
  private String bnombre;
  private String capellido;
  private String dtelefono;
  private String eDni;
  private String fcorreo;
  private String gdireccion;
  private int idEstado;
  
  public RecuperarClienteInterno(int idEstado, String bnombre, String capellido, String dtelefono, String eDni, String fcorreo, String gdireccion)
  {
    this.bnombre = bnombre;
    this.capellido = capellido;
    this.dtelefono = dtelefono;
    this.eDni = eDni;
    this.fcorreo = fcorreo;
    this.gdireccion = gdireccion;
    this.idEstado = idEstado;
  }
  
  public String getBnombre() { return bnombre; }
  
  public void setBnombre(String bnombre) {
    this.bnombre = bnombre;
  }
  
  public String getCapellido() { return capellido; }
  
  public void setCapellido(String capellido) {
    this.capellido = capellido;
  }
  
  public String getDtelefono() { return dtelefono; }
  
  public void setDtelefono(String dtelefono) {
    this.dtelefono = dtelefono;
  }
  
  public String geteDni() { return eDni; }
  
  public void seteDni(String eDni) {
    this.eDni = eDni;
  }
  
  public String getFcorreo() { return fcorreo; }
  
  public void setFcorreo(String fcorreo) {
    this.fcorreo = fcorreo;
  }
  
  public String getGdireccion() { return gdireccion; }
  
  public void setGdireccion(String gdireccion) {
    this.gdireccion = gdireccion;
  }
  
  public int getIdEstado() { return idEstado; }
  
  public void setIdEstado(int idEstado) {
    this.idEstado = idEstado;
  }
}
