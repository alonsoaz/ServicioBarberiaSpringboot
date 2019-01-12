package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;





@XmlRootElement
public class BuscarUsuario
{
  private String aidUsuario;
  private String bCod;
  private String cnombre;
  private String dargo;
  private String eaka;
  private String fmail;
  private String gcelular;
  private String hDescripcion;
  private int IdUnico;
  
  public BuscarUsuario(String aidUsuario, String bCod, String cnombre, String dargo, String eaka, String fmail, String gcelular, String hDescripcion, int idUnico)
  {
    this.aidUsuario = aidUsuario;
    this.bCod = bCod;
    this.cnombre = cnombre;
    this.dargo = dargo;
    this.eaka = eaka;
    this.fmail = fmail;
    this.gcelular = gcelular;
    this.hDescripcion = hDescripcion;
    IdUnico = idUnico;
  }
  
  public String getAidUsuario() { return aidUsuario; }
  
  public void setAidUsuario(String aidUsuario) {
    this.aidUsuario = aidUsuario;
  }
  
  public String getbCod() { return bCod; }
  
  public void setbCod(String bCod) {
    this.bCod = bCod;
  }
  
  public String getCnombre() { return cnombre; }
  
  public void setCnombre(String cnombre) {
    this.cnombre = cnombre;
  }
  
  public String getDargo() { return dargo; }
  
  public void setDargo(String dargo) {
    this.dargo = dargo;
  }
  
  public String getEaka() { return eaka; }
  
  public void setEaka(String eaka) {
    this.eaka = eaka;
  }
  
  public String getFmail() { return fmail; }
  
  public void setFmail(String fmail) {
    this.fmail = fmail;
  }
  
  public String getGcelular() { return gcelular; }
  
  public void setGcelular(String gcelular) {
    this.gcelular = gcelular;
  }
  
  public String gethDescripcion() { return hDescripcion; }
  
  public void sethDescripcion(String hDescripcion) {
    this.hDescripcion = hDescripcion;
  }
  
  public int getIdUnico() { return IdUnico; }
  
  public void setIdUnico(int idUnico) {
    IdUnico = idUnico;
  }
}
