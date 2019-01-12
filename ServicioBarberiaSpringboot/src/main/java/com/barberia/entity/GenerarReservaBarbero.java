package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenerarReservaBarbero
{
  private int aidBarbero;
  private int bidCliente;
  private int cYear;
  private int dMonth;
  private int eDay;
  private int fHour;
  private int gMinut;
  private int hSeconds;
  private int iidServicio;
  
  public GenerarReservaBarbero(int aidBarbero, int bidCliente, int cYear, int dMonth, int eDay, int fHour, int gMinut, int hSeconds, int iidServicio)
  {
    this.aidBarbero = aidBarbero;
    this.bidCliente = bidCliente;
    this.cYear = cYear;
    this.dMonth = dMonth;
    this.eDay = eDay;
    this.fHour = fHour;
    this.gMinut = gMinut;
    this.hSeconds = hSeconds;
    this.iidServicio = iidServicio;
  }
  
  public int getAidBarbero() { return aidBarbero; }
  
  public void setAidBarbero(int aidBarbero) {
    this.aidBarbero = aidBarbero;
  }
  
  public int getBidCliente() { return bidCliente; }
  
  public void setBidCliente(int bidCliente) {
    this.bidCliente = bidCliente;
  }
  
  public int getcYear() { return cYear; }
  
  public void setcYear(int cYear) {
    this.cYear = cYear;
  }
  
  public int getdMonth() { return dMonth; }
  
  public void setdMonth(int dMonth) {
    this.dMonth = dMonth;
  }
  
  public int geteDay() { return eDay; }
  
  public void seteDay(int eDay) {
    this.eDay = eDay;
  }
  
  public int getfHour() { return fHour; }
  
  public void setfHour(int fHour) {
    this.fHour = fHour;
  }
  
  public int getgMinut() { return gMinut; }
  
  public void setgMinut(int gMinut) {
    this.gMinut = gMinut;
  }
  
  public int gethSeconds() { return hSeconds; }
  
  public void sethSeconds(int hSeconds) {
    this.hSeconds = hSeconds;
  }
  
  public int getIidServicio() { return iidServicio; }
  
  public void setIidServicio(int iidServicio) {
    this.iidServicio = iidServicio;
  }
}
