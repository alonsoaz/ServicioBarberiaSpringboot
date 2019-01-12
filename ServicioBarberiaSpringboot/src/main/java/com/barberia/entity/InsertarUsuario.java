package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;










@XmlRootElement
public class InsertarUsuario
{
  private int aidUsuario;
  private String bnombre;
  private String capellido;
  private String dcargo;
  private String eaka;
  private String fpass;
  private String gemail;
  private String htelefono;
  private String idescripcion;
  
  public InsertarUsuario(int aidUsuario, String bnombre, String capellido, String dcargo, String eaka, String fpass, String gemail, String htelefono, String idescripcion)
  {
    this.aidUsuario = aidUsuario;
    this.bnombre = bnombre;
    this.capellido = capellido;
    this.dcargo = dcargo;
    this.eaka = eaka;
    this.fpass = fpass;
    this.gemail = gemail;
    this.htelefono = htelefono;
    this.idescripcion = idescripcion;
  }
  
  public int getAidUsuario() { return aidUsuario; }
  
  public void setAidUsuario(int aidUsuario) {
    this.aidUsuario = aidUsuario;
  }
  
  public String getBnombre() { return bnombre; }
  
  public void setBnombre(String bnombre) {
    this.bnombre = bnombre;
  }
  
  public String getCapellido() { return capellido; }
  
  public void setCapellido(String capellido) {
    this.capellido = capellido;
  }
  
  public String getDcargo() { return dcargo; }
  
  public void setDcargo(String dcargo) {
    this.dcargo = dcargo;
  }
  
  public String getEaka() { return eaka; }
  
  public void setEaka(String eaka) {
    this.eaka = eaka;
  }
  
  public String getFpass() { return fpass; }
  
  public void setFpass(String fpass) {
    this.fpass = fpass;
  }
  
  public String getGemail() { return gemail; }
  
  public void setGemail(String gemail) {
    this.gemail = gemail;
  }
  
  public String getHtelefono() { return htelefono; }
  
  public void setHtelefono(String htelefono) {
    this.htelefono = htelefono;
  }
  
  public String getIdescripcion() { return idescripcion; }
  
  public void setIdescripcion(String idescripcion) {
    this.idescripcion = idescripcion;
  }
}
