package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuscarBarberoInterno
{
  private int aidBarbero;
  private String bcod;
  private String eCompleto;
  private String fEstado;
  private String hcelular;
  private String iDni;
  private String jEmail;
  private String kDireccion;
  private String lModifiedBy;
  private String mdate;
  private int lIdUnico;
  
  public BuscarBarberoInterno(int aidBarbero, String bcod, String eCompleto, String fEstado, String hcelular, String iDni, String jEmail, String kDireccion, String lModifiedBy, String mdate, int lIdUnico)
  {
    this.aidBarbero = aidBarbero;
    this.bcod = bcod;
    this.eCompleto = eCompleto;
    this.fEstado = fEstado;
    this.hcelular = hcelular;
    this.iDni = iDni;
    this.jEmail = jEmail;
    this.kDireccion = kDireccion;
    this.lModifiedBy = lModifiedBy;
    this.mdate = mdate;
    this.lIdUnico = lIdUnico;
  }
  
  public int getAidBarbero() { return aidBarbero; }
  
  public void setAidBarbero(int aidBarbero) {
    this.aidBarbero = aidBarbero;
  }
  
  public String getBcod() { return bcod; }
  
  public void setBcod(String bcod) {
    this.bcod = bcod;
  }
  
  public String geteCompleto() { return eCompleto; }
  
  public void seteCompleto(String eCompleto) {
    this.eCompleto = eCompleto;
  }
  
  public String getfEstado() { return fEstado; }
  
  public void setfEstado(String fEstado) {
    this.fEstado = fEstado;
  }
  
  public String getHcelular() { return hcelular; }
  
  public void setHcelular(String hcelular) {
    this.hcelular = hcelular;
  }
  
  public String getiDni() { return iDni; }
  
  public void setiDni(String iDni) {
    this.iDni = iDni;
  }
  
  public String getjEmail() { return jEmail; }
  
  public void setjEmail(String jEmail) {
    this.jEmail = jEmail;
  }
  
  public String getkDireccion() { return kDireccion; }
  
  public void setkDireccion(String kDireccion) {
    this.kDireccion = kDireccion;
  }
  
  public String getlModifiedBy() { return lModifiedBy; }
  
  public void setlModifiedBy(String lModifiedBy) {
    this.lModifiedBy = lModifiedBy;
  }
  
  public String getMdate() { return mdate; }
  
  public void setMdate(String mdate) {
    this.mdate = mdate;
  }
  
  public int getlIdUnico() { return lIdUnico; }
  
  public void setlIdUnico(int lIdUnico) {
    this.lIdUnico = lIdUnico;
  }
}
