package com.barberia.repositoryImpl;

import com.barberia.config.ConexionBD;
import com.barberia.entity.InsertarTipo;
import com.barberia.entity.ListarTipoProducto;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarTipoProducto;
import com.barberia.repository.TipoProductoRepository;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@org.springframework.stereotype.Repository
public class TipoProductoRepositoryImpl implements TipoProductoRepository
{
  private ConexionBD dbCon;
  private Connection conn;
  private ResultSet rslt;
  private PreparedStatement stmt;
  private CallableStatement clbl;
  private List<MensajesBeans> mensaje;
  private MensajesBeans mensaj;
  private List<com.barberia.entity.Aidis> aidi = new ArrayList();
  private List<MessagenID> mesgid = new ArrayList();
  
  private List<ListarTipoProducto> TipoProductoR;
  
  private List<RecuperarTipoProducto> TipoProductoGet;
  private static TipoProductoRepositoryImpl stdregd = null;

	private final Logger LOG = Logger.getLogger(this.getClass());
  
  public TipoProductoRepositoryImpl() {}
  
  public static TipoProductoRepositoryImpl getInstance() { if (stdregd == null) {
      stdregd = new TipoProductoRepositoryImpl();
      return stdregd;
    }
    
    return stdregd;
  }
  
  @Override
  public List<ListarTipoProducto> getTipoProductoR()
  {
    TipoProductoR = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_TipoProducto_Interno`";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
      while (rslt.next()) {
        TipoProductoR.add(new ListarTipoProducto(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3)));
      }
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return TipoProductoR;
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
	return TipoProductoR;
  }

  @Override
  public List<RecuperarTipoProducto> getTipoProducto(int id)
  {
    TipoProductoGet = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    String SQLQuery = "{call `sp.Recuperar_TipoProducto_Interno`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareStatement(SQLQuery);
      stmt.setInt(1, id);
      ResultSet rslt = stmt.executeQuery();
      while (rslt.next()) {
        TipoProductoGet.add(new RecuperarTipoProducto(rslt
          .getString(1), rslt
          .getInt(2)));
      }
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return TipoProductoGet;
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
	return TipoProductoGet;
  }
  
  @Override
  public List<MensajesBeans> addTipoProducto(InsertarTipo ins, int idUsuario)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Insertar_Tipo_Producto`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setString(1, ins.getTipo());
      rslt = clbl.executeQuery();
      
      rslt.beforeFirst();
      while (rslt.next()) {
      
      mensaje.add(new MensajesBeans(rslt.getString(1)));
      
      }
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return mensaje;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
		LOG.error("Error de conexión: "+e.getMessage());
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
	return mensaje;
  }
   
  @Override
  public List<MensajesBeans> updtTipoProducto(int idTipoProducto, RecuperarTipoProducto ins)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Actualizar_Tipo_Producto`(?,?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idTipoProducto);
      stmt.setString(2, ins.getBTipo());
      stmt.setInt(3, ins.getCidEstado());
      rslt = stmt.executeQuery();
      rslt.beforeFirst();
      while (rslt.next()) {
        mensaje.add(new MensajesBeans(rslt.getString(1)));
      } 
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return mensaje;
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
	return mensaje;
  }
   
  @Override
  public List<MensajesBeans> delTipoProducto(int idTipoProducto)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Eliminar_Tipo_Producto`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idTipoProducto);
      rslt = stmt.executeQuery();
      rslt.beforeFirst();
      while (rslt.next()) {
        mensaje.add(new MensajesBeans(rslt.getString(1)));
      }
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return mensaje;
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
	return mensaje;
  }
}
