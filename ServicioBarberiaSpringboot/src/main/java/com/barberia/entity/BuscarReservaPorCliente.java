package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement
public class BuscarReservaPorCliente
{
  private int aidReserva;
  private String bCod;
  private String cCLient;
  private String dServicio;
  private String eBarbero;
  private String fInicio;
  private String gFin;
  private String eEstado;
  
  public BuscarReservaPorCliente(int aidReserva, String bCod, String cCLient, String dServicio, String eBarbero, String fInicio, String gFin, String eEstado)
  {
    this.aidReserva = aidReserva;
    this.bCod = bCod;
    this.cCLient = cCLient;
    this.dServicio = dServicio;
    this.eBarbero = eBarbero;
    this.fInicio = fInicio;
    this.gFin = gFin;
    this.eEstado = eEstado;
  }
  
  public int getAidReserva() { return aidReserva; }
  
  public void setAidReserva(int aidReserva) {
    this.aidReserva = aidReserva;
  }
  
  public String getbCod() { return bCod; }
  
  public void setbCod(String bCod) {
    this.bCod = bCod;
  }
  
  public String getcCLient() { return cCLient; }
  
  public void setcCLient(String cCLient) {
    this.cCLient = cCLient;
  }
  
  public String getdServicio() { return dServicio; }
  
  public void setdServicio(String dServicio) {
    this.dServicio = dServicio;
  }
  
  public String geteBarbero() { return eBarbero; }
  
  public void seteBarbero(String eBarbero) {
    this.eBarbero = eBarbero;
  }
  
  public String getfInicio() { return fInicio; }
  
  public void setfInicio(String fInicio) {
    this.fInicio = fInicio;
  }
  
  public String getgFin() { return gFin; }
  
  public void setgFin(String gFin) {
    this.gFin = gFin;
  }
  
  public String geteEstado() { return eEstado; }
  
  public void seteEstado(String eEstado) {
    this.eEstado = eEstado;
  }
}
