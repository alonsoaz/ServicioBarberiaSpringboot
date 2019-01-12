package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessagenID
{
  private String message;
  private int id;
  
  public MessagenID(String message, int id) {
    this.message = message;
    this.id = id;
  }
  
  public String getMessage() { return message; }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public int getId() { return id; }
  
  public void setId(int id) {
    this.id = id;
  }
}
