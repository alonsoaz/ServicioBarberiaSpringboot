package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MostrarDetalleVentaInterno
{
  private int aidDEtVenta;
  private int bidVenta;
  private String cCodVenta;
  private String dCodCliente;
  private String eCodCDetalle;
  private String fecha;
  private String gEstado;
  private String hCliente;
  private String iTipo;
  private String jProducto;
  private String kMarca;
  private double lPrecio;
  private int mCantidad;
  private double nDescuento;
  private double oSubtotal;
  
  public MostrarDetalleVentaInterno(int aidDEtVenta, int bidVenta, String cCodVenta, String dCodCliente, String eCodCDetalle, String fecha, String gEstado, String hCliente, String iTipo, String jProducto, String kMarca, double lPrecio, int mCantidad, double nDescuento, double oSubtotal)
  {
    this.aidDEtVenta = aidDEtVenta;
    this.bidVenta = bidVenta;
    this.cCodVenta = cCodVenta;
    this.dCodCliente = dCodCliente;
    this.eCodCDetalle = eCodCDetalle;
    this.fecha = fecha;
    this.gEstado = gEstado;
    this.hCliente = hCliente;
    this.iTipo = iTipo;
    this.jProducto = jProducto;
    this.kMarca = kMarca;
    this.lPrecio = lPrecio;
    this.mCantidad = mCantidad;
    this.nDescuento = nDescuento;
    this.oSubtotal = oSubtotal;
  }
  
  public int getAidDEtVenta() { return aidDEtVenta; }
  
  public void setAidDEtVenta(int aidDEtVenta) {
    this.aidDEtVenta = aidDEtVenta;
  }
  
  public int getBidVenta() { return bidVenta; }
  
  public void setBidVenta(int bidVenta) {
    this.bidVenta = bidVenta;
  }
  
  public String getcCodVenta() { return cCodVenta; }
  
  public void setcCodVenta(String cCodVenta) {
    this.cCodVenta = cCodVenta;
  }
  
  public String getdCodCliente() { return dCodCliente; }
  
  public void setdCodCliente(String dCodCliente) {
    this.dCodCliente = dCodCliente;
  }
  
  public String geteCodCDetalle() { return eCodCDetalle; }
  
  public void seteCodCDetalle(String eCodCDetalle) {
    this.eCodCDetalle = eCodCDetalle;
  }
  
  public String getFecha() { return fecha; }
  
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  
  public String getgEstado() { return gEstado; }
  
  public void setgEstado(String gEstado) {
    this.gEstado = gEstado;
  }
  
  public String gethCliente() { return hCliente; }
  
  public void sethCliente(String hCliente) {
    this.hCliente = hCliente;
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
