package com.barberia.entity;

public class RecuperaraUsuario
{
  private String anombre;
  private String capellido;
  private String dcargo;
  private String eaka;
  private String fcorreo;
  private String gtelefono;
  private String hdescripcion;
  
  public RecuperaraUsuario(String anombre, String capellido, String dcargo, String eaka, String fcorreo, String gtelefono, String hdescripcion)
  {
    this.anombre = anombre;
    this.capellido = capellido;
    this.dcargo = dcargo;
    this.eaka = eaka;
    this.fcorreo = fcorreo;
    this.gtelefono = gtelefono;
    this.hdescripcion = hdescripcion;
  }
  
  public String getAnombre() { return anombre; }
  
  public void setAnombre(String anombre) {
    this.anombre = anombre;
  }
  
  public String getCapellido() { return capellido; }
  
  public void setCapellido(String capellido) {
    this.capellido = capellido;
  }
  
  public String getDcargo() { return dcargo; }
  
  public void setDcargo(String dcargo) {
    this.dcargo = dcargo;
  }
  
  public String getEaka() { return eaka; }
  
  public void setEaka(String eaka) {
    this.eaka = eaka;
  }
  
  public String getFcorreo() { return fcorreo; }
  
  public void setFcorreo(String fcorreo) {
    this.fcorreo = fcorreo;
  }
  
  public String getGtelefono() { return gtelefono; }
  
  public void setGtelefono(String gtelefono) {
    this.gtelefono = gtelefono;
  }
  
  public String getHdescripcion() { return hdescripcion; }
  
  public void setHdescripcion(String hdescripcion) {
    this.hdescripcion = hdescripcion;
  }
}
