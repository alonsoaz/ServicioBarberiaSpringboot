package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrarDetalleVentaXpAgar
{
  private int aIdCliente;
  private int bIdProducto;
  private int cantidad;
  
  public RegistrarDetalleVentaXpAgar(int cantidad)
  {
    this.cantidad = cantidad;
  }
  
  public int getaIdCliente() { return aIdCliente; }
  
  public void setaIdCliente(int aIdCliente) {
    this.aIdCliente = aIdCliente;
  }
  
  public int getbIdProducto() { return bIdProducto; }
  
  public void setbIdProducto(int bIdProducto) {
    this.bIdProducto = bIdProducto;
  }
  
  public int getCantidad() { return cantidad; }
  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
