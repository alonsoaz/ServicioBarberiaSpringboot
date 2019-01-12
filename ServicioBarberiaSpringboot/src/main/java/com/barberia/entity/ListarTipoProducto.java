package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarTipoProducto
{
  private int aidTipoProducto;
  private String ctipo;
  private String dEstado;
  
  public ListarTipoProducto(int aidTipoProducto, String ctipo, String dEstado) {
    this.aidTipoProducto = aidTipoProducto;
    this.ctipo = ctipo;
    this.dEstado = dEstado;
  }
  
  public int getAidTipoProducto() { return aidTipoProducto; }
  
  public void setAidTipoProducto(int aidTipoProducto) {
    this.aidTipoProducto = aidTipoProducto;
  }
  
  public String getCtipo() { return ctipo; }
  
  public void setCtipo(String ctipo) {
    this.ctipo = ctipo;
  }
  
  public String getdEstado() { return dEstado; }
  
  public void setdEstado(String dEstado) {
    this.dEstado = dEstado;
  }
}
