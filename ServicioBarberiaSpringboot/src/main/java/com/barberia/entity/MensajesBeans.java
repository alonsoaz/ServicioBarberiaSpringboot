package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MensajesBeans
{
  private String mensaje;
  
  public MensajesBeans(String mensaje)
  {
    this.mensaje = mensaje;
  }
  
  public String getMensaje() {
    return mensaje;
  }
  
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
  
  public String toString()
  {
    return "mensaje";
  }
}
