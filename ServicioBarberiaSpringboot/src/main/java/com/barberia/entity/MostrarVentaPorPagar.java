package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MostrarVentaPorPagar
{
  private String bcodVenta;
  private String ccodCliente;
  private String dEstado;
  private String eCliente;
  private double fTotal;
  private String gFecha;
  private int aidVenta;
  
  public MostrarVentaPorPagar(String bcodVenta, String ccodCliente, String dEstado, String eCliente, double fTotal, String gFecha, int aidVenta)
  {
    this.bcodVenta = bcodVenta;
    this.ccodCliente = ccodCliente;
    this.dEstado = dEstado;
    this.eCliente = eCliente;
    this.fTotal = fTotal;
    this.gFecha = gFecha;
    this.aidVenta = aidVenta;
  }
  
  public String getBcodVenta() { return bcodVenta; }
  
  public void setBcodVenta(String bcodVenta) {
    this.bcodVenta = bcodVenta;
  }
  
  public String getCcodCliente() { return ccodCliente; }
  
  public void setCcodCliente(String ccodCliente) {
    this.ccodCliente = ccodCliente;
  }
  
  public String getdEstado() { return dEstado; }
  
  public void setdEstado(String dEstado) {
    this.dEstado = dEstado;
  }
  
  public String geteCliente() { return eCliente; }
  
  public void seteCliente(String eCliente) {
    this.eCliente = eCliente;
  }
  
  public double getfTotal() { return fTotal; }
  
  public void setfTotal(double fTotal) {
    this.fTotal = fTotal;
  }
  
  public String getgFecha() { return gFecha; }
  
  public void setgFecha(String gFecha) {
    this.gFecha = gFecha;
  }
  
  public int getAidVenta() { return aidVenta; }
  
  public void setAidVenta(int aidVenta) {
    this.aidVenta = aidVenta;
  }
}
