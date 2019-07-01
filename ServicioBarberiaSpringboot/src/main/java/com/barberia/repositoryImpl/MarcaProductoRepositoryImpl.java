package com.barberia.repositoryImpl;

import com.barberia.config.ConexionBD;
import com.barberia.entity.InsertarMarca;
import com.barberia.entity.ListarMarca;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarMarcaInterno;
import com.barberia.repository.MarcaProductoRepository;

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
public class MarcaProductoRepositoryImpl implements MarcaProductoRepository
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
  
  private List<ListarMarca> MarcaProductoR;
  
  private List<RecuperarMarcaInterno> MarcaProductoGet;
  private static MarcaProductoRepositoryImpl stdregd = null;
	private final Logger LOG = Logger.getLogger(this.getClass());
  
  public MarcaProductoRepositoryImpl() {}
  
  public static MarcaProductoRepositoryImpl getInstance() { if (stdregd == null) {
      stdregd = new MarcaProductoRepositoryImpl();
      return stdregd;
    }
    
    return stdregd;
  }
  
  @Override
  public List<ListarMarca> getMarcaProductoR()
  {
    MarcaProductoR = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_Marca_Interno`";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
      while (rslt.next()) {
        MarcaProductoR.add(new ListarMarca(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3), rslt
          .getString(4)));
      }


  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      return MarcaProductoR;
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
	return MarcaProductoR;
  }
  



  @Override
  public List<RecuperarMarcaInterno> getMarcaProducto(int id)
  {
    MarcaProductoGet = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "{call `sp.Recuperar_Marca_Interno`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareStatement(SQLQuery);
      stmt.setInt(1, id);
      ResultSet rslt = stmt.executeQuery();
      while (rslt.next()) {
        MarcaProductoGet.add(new RecuperarMarcaInterno(rslt
          .getString(1), rslt
          .getInt(2)));
      }

  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		
      return MarcaProductoGet;
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
	return MarcaProductoGet;
  }
  



  @Override
  public List<MensajesBeans> addMarcaProducto(InsertarMarca ins, int idUsuario)
  {
	    mensaje = new ArrayList();
	    
    String SQLQuery = "{call `sp.Insertar_Marca_Producto`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
	
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setString(1, ins.getMarca());
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
  public List<MensajesBeans> updtMarcaProducto(int idMarcaProducto, RecuperarMarcaInterno ins)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Actualizar_Marca_Producto`(?,?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idMarcaProducto);
      stmt.setString(2, ins.getCmarca());
      stmt.setInt(3, ins.getDidEstado());
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
  public List<MensajesBeans> delMarcaProducto(int idMarcaProducto)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Eliminar_MarcaProducto`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idMarcaProducto);
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
