package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertarMarcaProducto
{
  private String marca;
  
  public InsertarMarcaProducto(String marca)
  {
    this.marca = marca;
  }
  
  public String getMarca() {
    return marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }
}
