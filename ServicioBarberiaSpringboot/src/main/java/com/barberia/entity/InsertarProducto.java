package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertarProducto
{
  private String anombre;
  private int bidMarca;
  private int cidTipo;
  private int dStock;
  private double ePrecio;
  private String fdescripcion;
  
  public InsertarProducto(String anombre, int bidMarca, int cidTipo, int dStock, double ePrecio, String fdescripcion)
  {
    this.anombre = anombre;
    this.bidMarca = bidMarca;
    this.cidTipo = cidTipo;
    this.dStock = dStock;
    this.ePrecio = ePrecio;
    this.fdescripcion = fdescripcion;
  }
  
  public String getAnombre() { return anombre; }
  
  public void setAnombre(String anombre) {
    this.anombre = anombre;
  }
  
  public int getBidMarca() { return bidMarca; }
  
  public void setBidMarca(int bidMarca) {
    this.bidMarca = bidMarca;
  }
  
  public int getCidTipo() { return cidTipo; }
  
  public void setCidTipo(int cidTipo) {
    this.cidTipo = cidTipo;
  }
  
  public int getdStock() { return dStock; }
  
  public void setdStock(int dStock) {
    this.dStock = dStock;
  }
  
  public double getePrecio() { return ePrecio; }
  
  public void setePrecio(double ePrecio) {
    this.ePrecio = ePrecio;
  }
  
  public String getFdescripcion() { return fdescripcion; }
  
  public void setFdescripcion(String fdescripcion) {
    this.fdescripcion = fdescripcion;
  }
}
