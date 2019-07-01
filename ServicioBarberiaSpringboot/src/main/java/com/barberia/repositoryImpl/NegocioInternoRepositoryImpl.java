package com.barberia.repositoryImpl;

import com.barberia.config.ConexionBD;
import com.barberia.entity.ListarReservasPorBarberoInterno;
import com.barberia.entity.ListarReservasPorClienteInterno;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVentaInterno;
import com.barberia.entity.MostrarVentaInterno;
import com.barberia.repository.NegocioInternoRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@org.springframework.stereotype.Repository
public class NegocioInternoRepositoryImpl implements NegocioInternoRepository
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
  private static NegocioInternoRepositoryImpl stdregd = null;
	private final Logger LOG = Logger.getLogger(this.getClass());
  
  public NegocioInternoRepositoryImpl() {}
  
  public static NegocioInternoRepositoryImpl getInstance() { if (stdregd == null) {
      stdregd = new NegocioInternoRepositoryImpl();
      return stdregd;
    }
    
    return stdregd;
  }
  

  @Override
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
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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


  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      return ShowVenta;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
		LOG.error("Error en la ejecución: "+e.getMessage());
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
        }
      }
    }
	return ShowVenta;
  }
  




  @Override
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
    LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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

  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      return ShowDetVenta;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
		LOG.error("Error en la ejecución: "+e.getMessage());
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
        }
      }
    }
	return ShowDetVenta;
  }
  




  @Override
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
    LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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

  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      return ShowResCliente;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
		LOG.error("Error en la ejecución: "+e.getMessage());
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
        }
      }
    }
	return ShowResCliente;
  }
  




  @Override
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
    LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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

    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      } return ShowResBarbero;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
		LOG.error("Error en la ejecución: "+e.getMessage());
    }
    finally {
      if (conn != null) {
        try
        {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
        }
      }
    }
	return ShowResBarbero;
  }
}
