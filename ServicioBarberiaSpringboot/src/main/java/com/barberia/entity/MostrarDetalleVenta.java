package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MostrarDetalleVenta
{
  private int aidDetalleventa;
  private int bidVenta;
  private String cCodVenta;
  private String dCodClient;
  private String eCodDet;
  private String fecha;
  private String gEstado;
  private String hCLiente;
  private String iTipo;
  private String jProducto;
  private String kMarca;
  private double lPrecio;
  private int mCantidad;
  private double nDescuento;
  private double oSubtotal;
  
  public MostrarDetalleVenta(int aidDetalleventa, int bidVenta, String cCodVenta, String dCodClient, String eCodDet, String fecha, String gEstado, String hCLiente, String iTipo, String jProducto, String kMarca, double lPrecio, int mCantidad, double nDescuento, double oSubtotal)
  {
    this.aidDetalleventa = aidDetalleventa;
    this.bidVenta = bidVenta;
    this.cCodVenta = cCodVenta;
    this.dCodClient = dCodClient;
    this.eCodDet = eCodDet;
    this.fecha = fecha;
    this.gEstado = gEstado;
    this.hCLiente = hCLiente;
    this.iTipo = iTipo;
    this.jProducto = jProducto;
    this.kMarca = kMarca;
    this.lPrecio = lPrecio;
    this.mCantidad = mCantidad;
    this.nDescuento = nDescuento;
    this.oSubtotal = oSubtotal;
  }
  
  public int getAidDetalleventa() { return aidDetalleventa; }
  
  public void setAidDetalleventa(int aidDetalleventa) {
    this.aidDetalleventa = aidDetalleventa;
  }
  
  public int getBidVenta() { return bidVenta; }
  
  public void setBidVenta(int bidVenta) {
    this.bidVenta = bidVenta;
  }
  
  public String getcCodVenta() { return cCodVenta; }
  
  public void setcCodVenta(String cCodVenta) {
    this.cCodVenta = cCodVenta;
  }
  
  public String getdCodClient() { return dCodClient; }
  
  public void setdCodClient(String dCodClient) {
    this.dCodClient = dCodClient;
  }
  
  public String geteCodDet() { return eCodDet; }
  
  public void seteCodDet(String eCodDet) {
    this.eCodDet = eCodDet;
  }
  
  public String getFecha() { return fecha; }
  
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  
  public String getgEstado() { return gEstado; }
  
  public void setgEstado(String gEstado) {
    this.gEstado = gEstado;
  }
  
  public String gethCLiente() { return hCLiente; }
  
  public void sethCLiente(String hCLiente) {
    this.hCLiente = hCLiente;
  }
  
  public String getiTipo() { return iTipo; }
  
  public void setiTipo(String iTipo) {
    this.iTipo = iTipo;
  }
  
  public String getjProducto() { return jProducto; }
  
  public void setjProducto(String jProducto) {
    this.jProducto = jProducto;
  }
  
  public String getkMarca() { return kMarca; }
  
  public void setkMarca(String kMarca) {
    this.kMarca = kMarca;
  }
  
  public double getlPrecio() { return lPrecio; }
  
  public void setlPrecio(double lPrecio) {
    this.lPrecio = lPrecio;
  }
  
  public int getmCantidad() { return mCantidad; }
  
  public void setmCantidad(int mCantidad) {
    this.mCantidad = mCantidad;
  }
  
  public double getnDescuento() { return nDescuento; }
  
  public void setnDescuento(double nDescuento) {
    this.nDescuento = nDescuento;
  }
  
  public double getoSubtotal() { return oSubtotal; }
  
  public void setoSubtotal(double oSubtotal) {
    this.oSubtotal = oSubtotal;
  }
}
