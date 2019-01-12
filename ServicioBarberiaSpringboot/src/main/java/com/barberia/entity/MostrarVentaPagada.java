package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MostrarVentaPagada
{
  private int aidVenta;
  private String bCodVenta;
  private String cCodCliente;
  private String dEstado;
  private String eCliente;
  private double fTotal;
  private String gFecha;
  
  public MostrarVentaPagada(int aidVenta, String bCodVenta, String cCodCliente, String dEstado, String eCliente, double fTotal, String gFecha)
  {
    this.aidVenta = aidVenta;
    this.bCodVenta = bCodVenta;
    this.cCodCliente = cCodCliente;
    this.dEstado = dEstado;
    this.eCliente = eCliente;
    this.fTotal = fTotal;
    this.gFecha = gFecha;
  }
  
  public int getAidVenta() { return aidVenta; }
  
  public void setAidVenta(int aidVenta) {
    this.aidVenta = aidVenta;
  }
  
  public String getbCodVenta() { return bCodVenta; }
  
  public void setbCodVenta(String bCodVenta) {
    this.bCodVenta = bCodVenta;
  }
  
  public String getcCodCliente() { return cCodCliente; }
  
  public void setcCodCliente(String cCodCliente) {
    this.cCodCliente = cCodCliente;
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
}
