package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListarReservasPorBarberoInterno
{
  private String acod;
  private String barbero;
  private String cservicio;
  private String dCliente;
  private String eInicio;
  private String fin;
  private String estado;
  
  public ListarReservasPorBarberoInterno(String acod, String barbero, String cservicio, String dCliente, String eInicio, String fin, String estado)
  {
    this.acod = acod;
    this.barbero = barbero;
    this.cservicio = cservicio;
    this.dCliente = dCliente;
    this.eInicio = eInicio;
    this.fin = fin;
    this.estado = estado;
  }
  


  public ListarReservasPorBarberoInterno(String acod)
  {
    this.acod = acod;
  }
  

  public String getAcod()
  {
    return acod;
  }
  
  public void setAcod(String acod) { this.acod = acod; }
  
  public String getBarbero() {
    return barbero;
  }
  
  public void setBarbero(String barbero) { this.barbero = barbero; }
  
  public String getCservicio() {
    return cservicio;
  }
  
  public void setCservicio(String cservicio) { this.cservicio = cservicio; }
  
  public String getdCliente() {
    return dCliente;
  }
  
  public void setdCliente(String dCliente) { this.dCliente = dCliente; }
  
  public String geteInicio() {
    return eInicio;
  }
  
  public void seteInicio(String eInicio) { this.eInicio = eInicio; }
  
  public String getFin() {
    return fin;
  }
  
  public void setFin(String fin) { this.fin = fin; }
  
  public String getEstado() {
    return estado;
  }
  
  public void setEstado(String estado) { this.estado = estado; }
}
