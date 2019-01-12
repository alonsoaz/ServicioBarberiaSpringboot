package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BuscaProductoInterno
{
  private int aidProducto;
  private String bcodigo;
  private String dTipo;
  private String eProd;
  private String gMarca;
  private String iEstado;
  private int jCantidad;
  private double kPrecio;
  private String lDescripcion;
  private String nUser;
  private String odate;
  private int pIdUnik;
  
  public BuscaProductoInterno(int aidProducto, String bcodigo, String dTipo, String eProd, String gMarca, String iEstado, int jCantidad, double kPrecio, String lDescripcion, String nUser, String odate, int pIdUnik)
  {
    this.aidProducto = aidProducto;
    this.bcodigo = bcodigo;
    this.dTipo = dTipo;
    this.eProd = eProd;
    this.gMarca = gMarca;
    this.iEstado = iEstado;
    this.jCantidad = jCantidad;
    this.kPrecio = kPrecio;
    this.lDescripcion = lDescripcion;
    this.nUser = nUser;
    this.odate = odate;
    this.pIdUnik = pIdUnik;
  }
  
  public int getAidProducto() { return aidProducto; }
  
  public void setAidProducto(int aidProducto) {
    this.aidProducto = aidProducto;
  }
  
  public String getBcodigo() { return bcodigo; }
  
  public void setBcodigo(String bcodigo) {
    this.bcodigo = bcodigo;
  }
  
  public String getdTipo() { return dTipo; }
  
  public void setdTipo(String dTipo) {
    this.dTipo = dTipo;
  }
  
  public String geteProd() { return eProd; }
  
  public void seteProd(String eProd) {
    this.eProd = eProd;
  }
  
  public String getgMarca() { return gMarca; }
  
  public void setgMarca(String gMarca) {
    this.gMarca = gMarca;
  }
  
  public String getiEstado() { return iEstado; }
  
  public void setiEstado(String iEstado) {
    this.iEstado = iEstado;
  }
  
  public int getjCantidad() { return jCantidad; }
  
  public void setjCantidad(int jCantidad) {
    this.jCantidad = jCantidad;
  }
  
  public double getkPrecio() { return kPrecio; }
  
  public void setkPrecio(double kPrecio) {
    this.kPrecio = kPrecio;
  }
  
  public String getlDescripcion() { return lDescripcion; }
  
  public void setlDescripcion(String lDescripcion) {
    this.lDescripcion = lDescripcion;
  }
  
  public String getnUser() { return nUser; }
  
  public void setnUser(String nUser) {
    this.nUser = nUser;
  }
  
  public String getOdate() { return odate; }
  
  public void setOdate(String odate) {
    this.odate = odate;
  }
  
  public int getpIdUnik() { return pIdUnik; }
  
  public void setpIdUnik(int pIdUnik) {
    this.pIdUnik = pIdUnik;
  }
}
