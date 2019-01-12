package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MostrarVentaInterno
{
  private int aidVenta;
  private String bcodVenta;
  private String codCliente;
  private String dEstado;
  private String fCliente;
  private double gTotal;
  private String hFecha;
  
  public MostrarVentaInterno(int aidVenta, String bcodVenta, String codCliente, String dEstado, String fCliente, double gTotal, String hFecha)
  {
    this.aidVenta = aidVenta;
    this.bcodVenta = bcodVenta;
    this.codCliente = codCliente;
    this.dEstado = dEstado;
    this.fCliente = fCliente;
    this.gTotal = gTotal;
    this.hFecha = hFecha;
  }
  
  public int getAidVenta() { return aidVenta; }
  
  public void setAidVenta(int aidVenta) {
    this.aidVenta = aidVenta;
  }
  
  public String getBcodVenta() { return bcodVenta; }
  
  public void setBcodVenta(String bcodVenta) {
    this.bcodVenta = bcodVenta;
  }
  
  public String getCodCliente() { return codCliente; }
  
  public void setCodCliente(String codCliente) {
    this.codCliente = codCliente;
  }
  
  public String getdEstado() { return dEstado; }
  
  public void setdEstado(String dEstado) {
    this.dEstado = dEstado;
  }
  
  public String getfCliente() { return fCliente; }
  
  public void setfCliente(String fCliente) {
    this.fCliente = fCliente;
  }
  
  public double getgTotal() { return gTotal; }
  
  public void setgTotal(double gTotal) {
    this.gTotal = gTotal;
  }
  
  public String gethFecha() { return hFecha; }
  
  public void sethFecha(String hFecha) {
    this.hFecha = hFecha;
  }
}
