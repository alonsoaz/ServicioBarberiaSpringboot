package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RecuperarMarcaInterno
{
  private String cmarca;
  private int didEstado;
  
  public RecuperarMarcaInterno(String cmarca, int didEstado)
  {
    this.cmarca = cmarca;
    this.didEstado = didEstado;
  }
  
  public String getCmarca() {
    return cmarca;
  }
  
  public void setCmarca(String cmarca) { this.cmarca = cmarca; }
  
  public int getDidEstado() {
    return didEstado;
  }
  
  public void setDidEstado(int didEstado) { this.didEstado = didEstado; }
}
