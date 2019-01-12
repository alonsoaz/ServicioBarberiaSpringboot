package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarClienteInterno {
  private String aidCliente;
  private String bCodigo;
  private String completo;
  private String dni;
  private String estado;
  private String gCelular;
  private String hEmail;
  private String jDireccion;
  private String kModifiedBy;
  private String ldate;
  
  public String getAidCliente() {
    return aidCliente;
  }
  
  public void setAidCliente(String aidCliente) { this.aidCliente = aidCliente; }
  
  public String getbCodigo() {
    return bCodigo;
  }
  
  public void setbCodigo(String bCodigo) { this.bCodigo = bCodigo; }
  
  public String getCompleto() {
    return completo;
  }
  
  public void setCompleto(String completo) { this.completo = completo; }
  
  public String getDni() {
    return dni;
  }
  
  public void setDni(String dni) { this.dni = dni; }
  
  public String getEstado() {
    return estado;
  }
  
  public void setEstado(String estado) { this.estado = estado; }
  
  public String getgCelular() {
    return gCelular;
  }
  
  public void setgCelular(String gCelular) { this.gCelular = gCelular; }
  
  public String gethEmail() {
    return hEmail;
  }
  
  public void sethEmail(String hEmail) { this.hEmail = hEmail; }
  
  public String getjDireccion() {
    return jDireccion;
  }
  
  public void setjDireccion(String jDireccion) { this.jDireccion = jDireccion; }
  
  public String getkModifiedBy() {
    return kModifiedBy;
  }
  
  public void setkModifiedBy(String kModifiedBy) { this.kModifiedBy = kModifiedBy; }
  
  public String getLdate() {
    return ldate;
  }
  
  public void setLdate(String ldate) { this.ldate = ldate; }
  

  public ListarClienteInterno(String aidCliente, String bCodigo, String completo, String dni, String estado, String gCelular, String hEmail, String jDireccion, String kModifiedBy, String ldate)
  {
    this.aidCliente = aidCliente;
    this.bCodigo = bCodigo;
    this.completo = completo;
    this.dni = dni;
    this.estado = estado;
    this.gCelular = gCelular;
    this.hEmail = hEmail;
    this.jDireccion = jDireccion;
    this.kModifiedBy = kModifiedBy;
    this.ldate = ldate;
  }
}
