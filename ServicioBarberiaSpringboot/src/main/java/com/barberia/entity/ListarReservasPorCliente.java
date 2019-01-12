package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarReservasPorCliente
{
  private int aidReserva;
  private String bCLiente;
  private String cServicio;
  private String dcodBarbero;
  private String fBarbero;
  private String gInicio;
  private String hFin;
  private String iEstado;
  
  public ListarReservasPorCliente(int aidReserva, String bCLiente, String cServicio, String dcodBarbero, String fBarbero, String gInicio, String hFin, String iEstado)
  {
    this.aidReserva = aidReserva;
    this.bCLiente = bCLiente;
    this.cServicio = cServicio;
    this.dcodBarbero = dcodBarbero;
    this.fBarbero = fBarbero;
    this.gInicio = gInicio;
    this.hFin = hFin;
    this.iEstado = iEstado;
  }
  
  public int getAidReserva() { return aidReserva; }
  
  public void setAidReserva(int aidReserva) {
    this.aidReserva = aidReserva;
  }
  
  public String getbCLiente() { return bCLiente; }
  
  public void setbCLiente(String bCLiente) {
    this.bCLiente = bCLiente;
  }
  
  public String getcServicio() { return cServicio; }
  
  public void setcServicio(String cServicio) {
    this.cServicio = cServicio;
  }
  
  public String getDcodBarbero() { return dcodBarbero; }
  
  public void setDcodBarbero(String dcodBarbero) {
    this.dcodBarbero = dcodBarbero;
  }
  
  public String getfBarbero() { return fBarbero; }
  
  public void setfBarbero(String fBarbero) {
    this.fBarbero = fBarbero;
  }
  
  public String getgInicio() { return gInicio; }
  
  public void setgInicio(String gInicio) {
    this.gInicio = gInicio;
  }
  
  public String gethFin() { return hFin; }
  
  public void sethFin(String hFin) {
    this.hFin = hFin;
  }
  
  public String getiEstado() { return iEstado; }
  
  public void setiEstado(String iEstado) {
    this.iEstado = iEstado;
  }
}
