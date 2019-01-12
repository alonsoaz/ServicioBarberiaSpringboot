package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuscarServicio
{
  private int aidServicio;
  private String bcodServicio;
  private String cServicio;
  private String destado;
  private int eDuracion;
  private double fPrecio;
  private String gdescripcion;
  private int hIdunico;
  
  public BuscarServicio(int aidServicio, String bcodServicio, String cServicio, String destado, int eDuracion, double fPrecio, String gdescripcion, int hIdunico)
  {
    this.aidServicio = aidServicio;
    this.bcodServicio = bcodServicio;
    this.cServicio = cServicio;
    this.destado = destado;
    this.eDuracion = eDuracion;
    this.fPrecio = fPrecio;
    this.gdescripcion = gdescripcion;
    this.hIdunico = hIdunico;
  }
  
  public int getAidServicio() { return aidServicio; }
  
  public void setAidServicio(int aidServicio) {
    this.aidServicio = aidServicio;
  }
  
  public String getBcodServicio() { return bcodServicio; }
  
  public void setBcodServicio(String bcodServicio) {
    this.bcodServicio = bcodServicio;
  }
  
  public String getcServicio() { return cServicio; }
  
  public void setcServicio(String cServicio) {
    this.cServicio = cServicio;
  }
  
  public String getDestado() { return destado; }
  
  public void setDestado(String destado) {
    this.destado = destado;
  }
  
  public int geteDuracion() { return eDuracion; }
  
  public void seteDuracion(int eDuracion) {
    this.eDuracion = eDuracion;
  }
  
  public double getfPrecio() { return fPrecio; }
  
  public void setfPrecio(double fPrecio) {
    this.fPrecio = fPrecio;
  }
  
  public String getGdescripcion() { return gdescripcion; }
  
  public void setGdescripcion(String gdescripcion) {
    this.gdescripcion = gdescripcion;
  }
  
  public int gethIdunico() { return hIdunico; }
  
  public void sethIdunico(int hIdunico) {
    this.hIdunico = hIdunico;
  }
}
