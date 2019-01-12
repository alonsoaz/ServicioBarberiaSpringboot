package com.barberia.entity;

public class ListarMarca {
  private int aIdMarca;
  private String bCod;
  private String cMarca;
  private String dEstado;
  
  public int getaIdMarca() {
    return aIdMarca;
  }
  
  public void setaIdMarca(int aIdMarca) { this.aIdMarca = aIdMarca; }
  
  public String getbCod() {
    return bCod;
  }
  
  public void setbCod(String bCod) { this.bCod = bCod; }
  
  public String getcMarca() {
    return cMarca;
  }
  
  public void setcMarca(String cMarca) { this.cMarca = cMarca; }
  
  public String getdEstado() {
    return dEstado;
  }
  
  public void setdEstado(String dEstado) { this.dEstado = dEstado; }
  
  public ListarMarca(int aIdMarca, String bCod, String cMarca, String dEstado)
  {
    this.aIdMarca = aIdMarca;
    this.bCod = bCod;
    this.cMarca = cMarca;
    this.dEstado = dEstado;
  }
}
