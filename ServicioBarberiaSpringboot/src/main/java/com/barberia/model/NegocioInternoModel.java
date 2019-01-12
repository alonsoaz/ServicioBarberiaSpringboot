package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.ListarReservasPorBarberoInterno;
import com.barberia.entity.ListarReservasPorClienteInterno;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVentaInterno;
import com.barberia.entity.MostrarVentaInterno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class NegocioInternoModel
{
  private ConexionBD dbCon;
  private Connection conn;
  private ResultSet rslt;
  private PreparedStatement stmt;
  private CallableStatement clbl;
  private List<com.barberia.entity.MensajesBeans> mensaje = new ArrayList();
  private List<com.barberia.entity.Aidis> aidi = new ArrayList();
  private List<MessagenID> mesgid = new ArrayList();
  
  private List<MostrarVentaInterno> ShowVenta;
  
  private List<MostrarDetalleVentaInterno> ShowDetVenta;
  private List<ListarReservasPorClienteInterno> ShowResCliente;
  private List<ListarReservasPorBarberoInterno> ShowResBarbero;
  private static NegocioInternoModel stdregd = null;
  
  public NegocioInternoModel() {}
  
  public static NegocioInternoModel getInstance() { if (stdregd == null) {
      stdregd = new NegocioInternoModel();
      return stdregd;
    }
    
    return stdregd;
  }
  

  public List<MostrarVentaInterno> getVenta()
  {
    ShowVenta = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Mostrar_Venta_Interno`";
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      ResultSet rslt = clbl.executeQuery();
      while (rslt.next()) {
        ShowVenta.add(new MostrarVentaInterno(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3), rslt
          .getString(4), rslt
          .getString(5), rslt
          .getDouble(6), rslt
          .getString(7)));
      }
      
















      return ShowVenta;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
	return ShowVenta;
  }
  




  public List<MostrarDetalleVentaInterno> getDetVenta(int idVenta)
  {
    ShowDetVenta = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Mostrar_Detalle_Venta_Interno`(?)";
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setInt(1, idVenta);
      ResultSet rslt = clbl.executeQuery();
      while (rslt.next()) {
        ShowDetVenta.add(new MostrarDetalleVentaInterno(rslt
          .getInt(1), rslt
          .getInt(2), rslt
          .getString(3), rslt
          .getString(4), rslt
          .getString(5), rslt
          .getString(6), rslt
          .getString(7), rslt
          .getString(8), rslt
          .getString(9), rslt
          .getString(10), rslt
          .getString(11), rslt
          .getDouble(12), rslt
          .getInt(13), rslt
          .getDouble(14), rslt
          .getDouble(15)));
      }
      
















      return ShowDetVenta;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
	return ShowDetVenta;
  }
  




  public List<ListarReservasPorClienteInterno> getResCliente(int idCliente)
  {
    ShowResCliente = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_Reservas_Por_Cliente_Interno`(?)";
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setInt(1, idCliente);
      ResultSet rslt = clbl.executeQuery();
      int res = 0;
      if (rslt.last()) {
        res = rslt.getMetaData().getColumnCount();
        if (res == 1) {
          rslt.beforeFirst();
          while (rslt.next()) ShowResCliente.add(new ListarReservasPorClienteInterno(rslt.getString(1)));
        }
        rslt.beforeFirst();
        while (rslt.next()) {
          ShowResCliente.add(new ListarReservasPorClienteInterno(rslt
            .getString(1), rslt
            .getString(2), rslt
            .getString(3), rslt
            .getString(4), rslt
            .getString(5), rslt
            .getString(6), rslt
            .getString(7)));
        }
      }
      


















      return ShowResCliente;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
	return ShowResCliente;
  }
  




  public List<ListarReservasPorBarberoInterno> getResBarbero(int idBarbero)
  {
    ShowResBarbero = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_Reservas_Por_Barbero_Interno`(?)";
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setInt(1, idBarbero);
      ResultSet rslt = clbl.executeQuery();
      int res = 0;
      if (rslt.last()) {
        res = rslt.getMetaData().getColumnCount();
        if (res == 1) {
          rslt.beforeFirst();
          while (rslt.next()) ShowResBarbero.add(new ListarReservasPorBarberoInterno(rslt.getString(1)));
        }
        rslt.beforeFirst();
        while (rslt.next()) {
          ShowResBarbero.add(new ListarReservasPorBarberoInterno(rslt
            .getString(1), rslt
            .getString(2), rslt
            .getString(3), rslt
            .getString(4), rslt
            .getString(5), rslt
            .getString(6), rslt
            .getString(7)));
        }
      } return ShowResBarbero;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
	return ShowResBarbero;
  }
}
