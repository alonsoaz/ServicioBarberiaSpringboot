package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecuperarServicioInterno
{
  private String bnombser;
  private int cidEstado;
  private int dminutos;
  private double eprecio;
  private String fdescripcion;
  
  public RecuperarServicioInterno(String bnombser, int cidEstado, int dminutos, double eprecio, String fdescripcion) {
    this.bnombser = bnombser;
    this.cidEstado = cidEstado;
    this.dminutos = dminutos;
    this.eprecio = eprecio;
    this.fdescripcion = fdescripcion;
  }
  
  public String getBnombser() { return bnombser; }
  
  public void setBnombser(String bnombser) {
    this.bnombser = bnombser;
  }
  
  public int getCidEstado() { return cidEstado; }
  
  public void setCidEstado(int cidEstado) {
    this.cidEstado = cidEstado;
  }
  
  public int getDminutos() { return dminutos; }
  
  public void setDminutos(int dminutos) {
    this.dminutos = dminutos;
  }
  
  public double getEprecio() { return eprecio; }
  
  public void setEprecio(double eprecio) {
    this.eprecio = eprecio;
  }
  
  public String getFdescripcion() { return fdescripcion; }
  
  public void setFdescripcion(String fdescripcion) {
    this.fdescripcion = fdescripcion;
  }
}
