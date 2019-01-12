package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrarDetalleVentaPagada
{
  private int aidVenta;
  private int bidDetVenta;
  
  public RegistrarDetalleVentaPagada(int aidVenta, int bidDetVenta) {
    this.aidVenta = aidVenta;
    this.bidDetVenta = bidDetVenta;
  }
  
  public int getAidVenta() { return aidVenta; }
  
  public void setAidVenta(int aidVenta) {
    this.aidVenta = aidVenta;
  }
  
  public int getBidDetVenta() { return bidDetVenta; }
  
  public void setBidDetVenta(int bidDetVenta) {
    this.bidDetVenta = bidDetVenta;
  }
}
