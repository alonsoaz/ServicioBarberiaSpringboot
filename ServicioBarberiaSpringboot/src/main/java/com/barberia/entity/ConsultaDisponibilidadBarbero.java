package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ConsultaDisponibilidadBarbero
{
  private int bYear;
  private int cMonth;
  private int dDay;
  private int eHour;
  private int fMinut;
  private int gSeconds;
  
  public String toString()
  {
    String day = dDay + "";
    String month = cMonth + "";
    if (dDay < 10)
      day = "0" + dDay;
    if (cMonth < 10) {
      month = "" + cMonth;
    }
    return bYear + "/" + month + "/" + day + " " + eHour + ":" + fMinut + ":00";
  }
  

  public ConsultaDisponibilidadBarbero(int bYear, int cMonth, int dDay, int eHour, int fMinut)
  {
    this.bYear = bYear;
    this.cMonth = cMonth;
    this.dDay = dDay;
    this.eHour = eHour;
    this.fMinut = fMinut;
  }
  
  public int getbYear() {
    return bYear;
  }
  
  public void setbYear(int bYear) {
    this.bYear = bYear;
  }
  
  public int getcMonth() {
    return cMonth;
  }
  
  public void setcMonth(int cMonth) {
    this.cMonth = cMonth;
  }
  
  public int getdDay() {
    return dDay;
  }
  
  public void setdDay(int dDay) {
    this.dDay = dDay;
  }
  
  public int geteHour() {
    return eHour;
  }
  
  public void seteHour(int eHour) {
    this.eHour = eHour;
  }
  
  public int getfMinut() {
    return fMinut;
  }
  
  public void setfMinut(int fMinut) {
    this.fMinut = fMinut;
  }
  
  public int getgSeconds() {
    return gSeconds;
  }
  
  public void setgSeconds(int gSeconds) {
    this.gSeconds = gSeconds;
  }
}
