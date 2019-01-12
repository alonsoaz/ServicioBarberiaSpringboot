package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MostrarDetalleVentaPagada
{
  private String cCodVenta;
  private String dCodCliente;
  private String dCodDet;
  private String eFecha;
  private String fEstado;
  private String gCliente;
  private String hTipo;
  private String iProducto;
  private String jMarca;
  private double kPrecio;
  private int lCantidad;
  private double mDescuento;
  private double nSubtotal;
  
  public MostrarDetalleVentaPagada(String cCodVenta, String dCodCliente, String dCodDet, String eFecha, String fEstado, String gCliente, String hTipo, String iProducto, String jMarca, double kPrecio, int lCantidad, double mDescuento, double nSubtotal)
  {
    this.cCodVenta = cCodVenta;
    this.dCodCliente = dCodCliente;
    this.dCodDet = dCodDet;
    this.eFecha = eFecha;
    this.fEstado = fEstado;
    this.gCliente = gCliente;
    this.hTipo = hTipo;
    this.iProducto = iProducto;
    this.jMarca = jMarca;
    this.kPrecio = kPrecio;
    this.lCantidad = lCantidad;
    this.mDescuento = mDescuento;
    this.nSubtotal = nSubtotal;
  }
  
  public String getcCodVenta() { return cCodVenta; }
  
  public void setcCodVenta(String cCodVenta) {
    this.cCodVenta = cCodVenta;
  }
  
  public String getdCodCliente() { return dCodCliente; }
  
  public void setdCodCliente(String dCodCliente) {
    this.dCodCliente = dCodCliente;
  }
  
  public String getdCodDet() { return dCodDet; }
  
  public void setdCodDet(String dCodDet) {
    this.dCodDet = dCodDet;
  }
  
  public String geteFecha() { return eFecha; }
  
  public void seteFecha(String eFecha) {
    this.eFecha = eFecha;
  }
  
  public String getfEstado() { return fEstado; }
  
  public void setfEstado(String fEstado) {
    this.fEstado = fEstado;
  }
  
  public String getgCliente() { return gCliente; }
  
  public void setgCliente(String gCliente) {
    this.gCliente = gCliente;
  }
  
  public String gethTipo() { return hTipo; }
  
  public void sethTipo(String hTipo) {
    this.hTipo = hTipo;
  }
  
  public String getiProducto() { return iProducto; }
  
  public void setiProducto(String iProducto) {
    this.iProducto = iProducto;
  }
  
  public String getjMarca() { return jMarca; }
  
  public void setjMarca(String jMarca) {
    this.jMarca = jMarca;
  }
  
  public double getkPrecio() { return kPrecio; }
  
  public void setkPrecio(double kPrecio) {
    this.kPrecio = kPrecio;
  }
  
  public int getlCantidad() { return lCantidad; }
  
  public void setlCantidad(int lCantidad) {
    this.lCantidad = lCantidad;
  }
  
  public double getmDescuento() { return mDescuento; }
  
  public void setmDescuento(double mDescuento) {
    this.mDescuento = mDescuento;
  }
  
  public double getnSubtotal() { return nSubtotal; }
  
  public void setnSubtotal(double nSubtotal) {
    this.nSubtotal = nSubtotal;
  }
}
