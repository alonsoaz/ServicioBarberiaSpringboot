package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecuperarTipoProducto
{
  private String bTipo;
  private int cidEstado;
  
  public RecuperarTipoProducto(String bTipo, int cidEstado) {
    this.bTipo = bTipo;
    this.cidEstado = cidEstado;
  }
  
  public String getbTipo() { return bTipo; }
  
  public void setbTipo(String bTipo) {
    this.bTipo = bTipo;
  }
  
  public int getCidEstado() { return cidEstado; }
  
  public void setCidEstado(int cidEstado) {
    this.cidEstado = cidEstado;
  }
}
