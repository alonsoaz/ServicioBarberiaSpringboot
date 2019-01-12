package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RecuperarProductoInterno
{
  private int aIdMarca;
  private int bidTipo;
  private String cNombre;
  private int didEstado;
  private int fStock;
  private double gPrecio;
  private String hdescripcion;
  
  public RecuperarProductoInterno(int aIdMarca, int bidTipo, String cNombre, int didEstado, int fStock, double gPrecio, String hdescripcion)
  {
    this.aIdMarca = aIdMarca;
    this.bidTipo = bidTipo;
    this.cNombre = cNombre;
    this.didEstado = didEstado;
    this.fStock = fStock;
    this.gPrecio = gPrecio;
    this.hdescripcion = hdescripcion;
  }
  
  public int getaIdMarca() { return aIdMarca; }
  
  public void setaIdMarca(int aIdMarca) {
    this.aIdMarca = aIdMarca;
  }
  
  public int getBidTipo() { return bidTipo; }
  
  public void setBidTipo(int bidTipo) {
    this.bidTipo = bidTipo;
  }
  
  public String getcNombre() { return cNombre; }
  
  public void setcNombre(String cNombre) {
    this.cNombre = cNombre;
  }
  
  public int getDidEstado() { return didEstado; }
  
  public void setDidEstado(int didEstado) {
    this.didEstado = didEstado;
  }
  
  public int getfStock() { return fStock; }
  
  public void setfStock(int fStock) {
    this.fStock = fStock;
  }
  
  public double getgPrecio() { return gPrecio; }
  
  public void setgPrecio(double gPrecio) {
    this.gPrecio = gPrecio;
  }
  
  public String getHdescripcion() { return hdescripcion; }
  
  public void setHdescripcion(String hdescripcion) {
    this.hdescripcion = hdescripcion;
  }
}
