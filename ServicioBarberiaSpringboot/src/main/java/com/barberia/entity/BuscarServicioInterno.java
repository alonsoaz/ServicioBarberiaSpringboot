package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuscarServicioInterno
{
  private int aidServicio;
  private String bCod;
  private String cNombre;
  private String eEstado;
  private int fDuracion;
  private double gPrecio;
  private String hDescripcion;
  private String jUser;
  private String kDate;
  private int lidUnico;
  
  public BuscarServicioInterno(int aidServicio, String bCod, String cNombre, String eEstado, int fDuracion, double gPrecio, String hDescripcion, String jUser, String kDate, int lidUnico)
  {
    this.aidServicio = aidServicio;
    this.bCod = bCod;
    this.cNombre = cNombre;
    this.eEstado = eEstado;
    this.fDuracion = fDuracion;
    this.gPrecio = gPrecio;
    this.hDescripcion = hDescripcion;
    this.jUser = jUser;
    this.kDate = kDate;
    this.lidUnico = lidUnico;
  }
  
  public int getAidServicio() { return aidServicio; }
  
  public void setAidServicio(int aidServicio) {
    this.aidServicio = aidServicio;
  }
  
  public String getbCod() { return bCod; }
  
  public void setbCod(String bCod) {
    this.bCod = bCod;
  }
  
  public String getcNombre() { return cNombre; }
  
  public void setcNombre(String cNombre) {
    this.cNombre = cNombre;
  }
  
  public String geteEstado() { return eEstado; }
  
  public void seteEstado(String eEstado) {
    this.eEstado = eEstado;
  }
  
  public int getfDuracion() { return fDuracion; }
  
  public void setfDuracion(int fDuracion) {
    this.fDuracion = fDuracion;
  }
  
  public double getgPrecio() { return gPrecio; }
  
  public void setgPrecio(double gPrecio) {
    this.gPrecio = gPrecio;
  }
  
  public String gethDescripcion() { return hDescripcion; }
  
  public void sethDescripcion(String hDescripcion) {
    this.hDescripcion = hDescripcion;
  }
  
  public String getjUser() { return jUser; }
  
  public void setjUser(String jUser) {
    this.jUser = jUser;
  }
  
  public String getkDate() { return kDate; }
  
  public void setkDate(String kDate) {
    this.kDate = kDate;
  }
  
  public int getLidUnico() { return lidUnico; }
  
  public void setLidUnico(int lidUnico) {
    this.lidUnico = lidUnico;
  }
}
