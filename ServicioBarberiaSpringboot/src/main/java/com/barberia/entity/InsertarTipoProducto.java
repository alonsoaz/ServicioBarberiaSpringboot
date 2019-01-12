package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertarTipoProducto
{
  private String tipo;
  
  public InsertarTipoProducto(String tipo)
  {
    this.tipo = tipo;
  }
  
  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
