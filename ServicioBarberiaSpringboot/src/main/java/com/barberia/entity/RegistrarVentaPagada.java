package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrarVentaPagada
{
  private int aidCliente;
  private int bidventa;
  
  public RegistrarVentaPagada(int aidCliente, int bidventa) {
    this.aidCliente = aidCliente;
    this.bidventa = bidventa;
  }
  
  public int getAidCliente() { return aidCliente; }
  
  public void setAidCliente(int aidCliente) {
    this.aidCliente = aidCliente;
  }
  
  public int getBidventa() { return bidventa; }
  
  public void setBidventa(int bidventa) {
    this.bidventa = bidventa;
  }
}
