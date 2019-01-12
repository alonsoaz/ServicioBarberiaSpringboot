package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuscarClienteInterno
{
  private String aiDCliente;
  private String bCod;
  private String cCompleto;
  private String dni;
  private String fEsatado;
  private String gCelular;
  private String hEmail;
  private String jDireccion;
  private String kModifiedBy;
  private String ldate;
  private int mIdUnico;
  
  public BuscarClienteInterno(String aiDCliente, String bCod, String cCompleto, String dni, String fEsatado, String gCelular, String hEmail, String jDireccion, String kModifiedBy, String ldate, int mIdUnico)
  {
    this.aiDCliente = aiDCliente;
    this.bCod = bCod;
    this.cCompleto = cCompleto;
    this.dni = dni;
    this.fEsatado = fEsatado;
    this.gCelular = gCelular;
    this.hEmail = hEmail;
    this.jDireccion = jDireccion;
    this.kModifiedBy = kModifiedBy;
    this.ldate = ldate;
    this.mIdUnico = mIdUnico;
  }
  
  public String getAiDCliente() { return aiDCliente; }
  
  public void setAiDCliente(String aiDCliente) {
    this.aiDCliente = aiDCliente;
  }
  
  public String getbCod() { return bCod; }
  
  public void setbCod(String bCod) {
    this.bCod = bCod;
  }
  
  public String getcCompleto() { return cCompleto; }
  
  public void setcCompleto(String cCompleto) {
    this.cCompleto = cCompleto;
  }
  
  public String getDni() { return dni; }
  
  public void setDni(String dni) {
    this.dni = dni;
  }
  
  public String getfEsatado() { return fEsatado; }
  
  public void setfEsatado(String fEsatado) {
    this.fEsatado = fEsatado;
  }
  
  public String getgCelular() { return gCelular; }
  
  public void setgCelular(String gCelular) {
    this.gCelular = gCelular;
  }
  
  public String gethEmail() { return hEmail; }
  
  public void sethEmail(String hEmail) {
    this.hEmail = hEmail;
  }
  
  public String getjDireccion() { return jDireccion; }
  
  public void setjDireccion(String jDireccion) {
    this.jDireccion = jDireccion;
  }
  
  public String getkModifiedBy() { return kModifiedBy; }
  
  public void setkModifiedBy(String kModifiedBy) {
    this.kModifiedBy = kModifiedBy;
  }
  
  public String getLdate() { return ldate; }
  
  public void setLdate(String ldate) {
    this.ldate = ldate;
  }
  
  public int getmIdUnico() { return mIdUnico; }
  
  public void setmIdUnico(int mIdUnico) {
    this.mIdUnico = mIdUnico;
  }
}
