package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuscarProducto
{
  private int aidProducto;
  private String bTipo;
  private String cProducto;
  private String dMarca;
  private String estado;
  private int fCant;
  private double gPrecio;
  private String hDescrip;
  private int idUnik;
  
  public BuscarProducto(int aidProducto, String bTipo, String cProducto, String dMarca, String estado, int fCant, double gPrecio, String hDescrip, int idUnik)
  {
    this.aidProducto = aidProducto;
    this.bTipo = bTipo;
    this.cProducto = cProducto;
    this.dMarca = dMarca;
    this.estado = estado;
    this.fCant = fCant;
    this.gPrecio = gPrecio;
    this.hDescrip = hDescrip;
    this.idUnik = idUnik;
  }
  
  public int getAidProducto() { return aidProducto; }
  
  public void setAidProducto(int aidProducto) {
    this.aidProducto = aidProducto;
  }
  
  public String getbTipo() { return bTipo; }
  
  public void setbTipo(String bTipo) {
    this.bTipo = bTipo;
  }
  
  public String getcProducto() { return cProducto; }
  
  public void setcProducto(String cProducto) {
    this.cProducto = cProducto;
  }
  
  public String getdMarca() { return dMarca; }
  
  public void setdMarca(String dMarca) {
    this.dMarca = dMarca;
  }
  
  public String getEstado() { return estado; }
  
  public void setEstado(String estado) {
    this.estado = estado;
  }
  
  public int getfCant() { return fCant; }
  
  public void setfCant(int fCant) {
    this.fCant = fCant;
  }
  
  public double getgPrecio() { return gPrecio; }
  
  public void setgPrecio(double gPrecio) {
    this.gPrecio = gPrecio;
  }
  
  public String gethDescrip() { return hDescrip; }
  
  public void sethDescrip(String hDescrip) {
    this.hDescrip = hDescrip;
  }
  
  public int getIdUnik() { return idUnik; }
  
  public void setIdUnik(int idUnik) {
    this.idUnik = idUnik;
  }
}
