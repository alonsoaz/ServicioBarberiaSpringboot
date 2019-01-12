package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarReservasPorClienteInterno
{
  private String aCod;
  private String bCliente;
  private String cServicio;
  private String dBarbero;
  private String eInicio;
  private String fFin;
  private String gEstado;
  
  public ListarReservasPorClienteInterno(String aCod, String bCliente, String cServicio, String dBarbero, String eInicio, String fFin, String gEstado)
  {
    this.aCod = aCod;
    this.bCliente = bCliente;
    this.cServicio = cServicio;
    this.dBarbero = dBarbero;
    this.eInicio = eInicio;
    this.fFin = fFin;
    this.gEstado = gEstado;
  }
  


  public ListarReservasPorClienteInterno(String aCod)
  {
    this.aCod = aCod;
  }
  

  public String getaCod()
  {
    return aCod;
  }
  
  public void setaCod(String aCod) { this.aCod = aCod; }
  
  public String getbCliente() {
    return bCliente;
  }
  
  public void setbCliente(String bCliente) { this.bCliente = bCliente; }
  
  public String getcServicio() {
    return cServicio;
  }
  
  public void setcServicio(String cServicio) { this.cServicio = cServicio; }
  
  public String getdBarbero() {
    return dBarbero;
  }
  
  public void setdBarbero(String dBarbero) { this.dBarbero = dBarbero; }
  
  public String geteInicio() {
    return eInicio;
  }
  
  public void seteInicio(String eInicio) { this.eInicio = eInicio; }
  
  public String getfFin() {
    return fFin;
  }
  
  public void setfFin(String fFin) { this.fFin = fFin; }
  
  public String getgEstado() {
    return gEstado;
  }
  
  public void setgEstado(String gEstado) { this.gEstado = gEstado; }
}
