package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecuperarDetalleVenta
{
  private int aStock;
  private double bPrecio;
  private int cantidad;
  private double descuento;
  private double fSubtotal;
  
  public RecuperarDetalleVenta(int aStock, double bPrecio, int cantidad, double descuento, double fSubtotal) {
    this.aStock = aStock;
    this.bPrecio = bPrecio;
    this.cantidad = cantidad;
    this.descuento = descuento;
    this.fSubtotal = fSubtotal;
  }
  
  public int getaStock() { return aStock; }
  
  public void setaStock(int aStock) {
    this.aStock = aStock;
  }
  
  public double getbPrecio() { return bPrecio; }
  
  public void setbPrecio(double bPrecio) {
    this.bPrecio = bPrecio;
  }
  
  public int getCantidad() { return cantidad; }
  
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
  public double getDescuento() { return descuento; }
  
  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }
  
  public double getfSubtotal() { return fSubtotal; }
  
  public void setfSubtotal(double fSubtotal) {
    this.fSubtotal = fSubtotal;
  }
}
