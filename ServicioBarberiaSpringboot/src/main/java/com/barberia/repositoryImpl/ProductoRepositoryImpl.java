package com.barberia.repositoryImpl;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscaProductoInterno;
import com.barberia.entity.BuscarProducto;
import com.barberia.entity.InsertarProducto;
import com.barberia.entity.ListarProducto;
import com.barberia.entity.ListarProductoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarProductoInterno;
import com.barberia.repository.ProductoRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@org.springframework.stereotype.Repository
public class ProductoRepositoryImpl implements ProductoRepository
{
  private ConexionBD dbCon;
  private Connection conn;
  private ResultSet rslt;
  private PreparedStatement stmt;
  private CallableStatement clbl;
  private List<MensajesBeans> mensaje;
  private List<com.barberia.entity.Aidis> aidi = new ArrayList();
  private List<com.barberia.entity.MessagenID> mesgid = new ArrayList();
  
  private List<com.barberia.entity.ListarProductoInterno> ProductoRecords;
  
  private List<ListarProducto> ProductoR;
  private List<BuscaProductoInterno> ProductoSearch;
  private List<BuscarProducto> ProductoS;
  private List<RecuperarProductoInterno> ProductoGet;
  private static ProductoRepositoryImpl stdregd = null;
  
	private final Logger LOG = Logger.getLogger(this.getClass());
  
  public ProductoRepositoryImpl() {}
  
  public static ProductoRepositoryImpl getInstance() { if (stdregd == null) {
      stdregd = new ProductoRepositoryImpl();
      return stdregd;
    }
    
    return stdregd;
  }
  

  @Override
  public List<ListarProductoInterno> getProductoRecords()
  {
    ProductoRecords = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_Producto_Interno`";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      ResultSet rslt = clbl.executeQuery();
      while (rslt.next()) {
        ProductoRecords.add(new com.barberia.entity.ListarProductoInterno(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3), rslt
          .getString(4), rslt
          .getString(5), rslt
          .getString(6), rslt
          .getInt(7), rslt
          .getDouble(8), rslt
          .getString(9), rslt
          .getString(10), rslt
          .getString(11)));
      }

    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return ProductoRecords;
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
	return ProductoRecords;
  }
 
  @Override
  public List<ListarProducto> getProductoR()
  {
    ProductoR = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "call `sp.Listar_Producto`";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
      while (rslt.next()) {
        ProductoR.add(new ListarProducto(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getDouble(3), rslt
          .getString(4)));
      }
  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
      return ProductoR;
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
	return ProductoR;
  }
  
  @Override
  public List<BuscaProductoInterno> getProductoByWords(String words)
  {
    ProductoSearch = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    String SQLQuery = "{call `sp.Buscar_Producto_Interno`(?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setString(1, words);
      clbl.registerOutParameter(2, 4);
      ResultSet rslt = clbl.executeQuery();
      while (rslt.next()) {
        ProductoSearch.add(new BuscaProductoInterno(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3), rslt
          .getString(4), rslt
          .getString(5), rslt
          .getString(6), rslt
          .getInt(7), rslt
          .getDouble(8), rslt
          .getString(9), rslt
          .getString(10), rslt
          .getString(11), clbl
          .getInt(2)));
      }
    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
        return ProductoSearch;
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
	return ProductoSearch;
  }

  @Override
  public List<BuscarProducto> getProdByWords(String words)
  {
    ProductoS = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "{call `sp.Buscar_Producto`(?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try
    {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setString(1, words);
      clbl.registerOutParameter(2, 4);
      ResultSet rslt = clbl.executeQuery();
      while (rslt.next()) {
        ProductoS.add(new BuscarProducto(rslt
          .getInt(1), rslt
          .getString(2), rslt
          .getString(3), rslt
          .getString(4), rslt
          .getString(5), rslt
          .getInt(6), rslt
          .getDouble(7), rslt
          .getString(8), clbl
          .getInt(2)));
      }
    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
        
      return ProductoS;
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
	return ProductoS;
  }
  
  @Override
  public List<RecuperarProductoInterno> getProducto(int id)
  {
    ProductoGet = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    String SQLQuery = "{call `sp.Recuperar_Producto_Interno`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    
    try
    {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareStatement(SQLQuery);
      stmt.setInt(1, id);
      ResultSet rslt = stmt.executeQuery();
      while (rslt.next()) {
        ProductoGet.add(new RecuperarProductoInterno(
        		rslt
          .getInt(1), rslt
          .getInt(2), rslt
          .getString(3), rslt
          .getInt(4), rslt
          .getInt(5), rslt
          .getDouble(6), rslt
          .getString(7)));
      }

    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
        
      return ProductoGet;
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
	return ProductoGet;
  }
  
  @Override
  public List<ListarProducto> getProd(int id)
  {
    ProductoR = new ArrayList();
    try
    {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    

    String SQLQuery = "{call `sp.Recuperar_Producto_Android`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    
    try
    {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareStatement(SQLQuery);
      stmt.setInt(1, id);
      ResultSet rslt = stmt.executeQuery();
      while (rslt.next()) {
    	  ProductoR.add(new ListarProducto(rslt
    	          .getInt(1), rslt
    	          .getString(2), rslt
    	          .getDouble(3), rslt
    	          .getString(4)));
      }
    	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
        
      return ProductoR;
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
	return ProductoR;
  }
  
  @Override
  public List<MensajesBeans> addProducto(InsertarProducto ins, int idUsuario)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Insertar_Producto`(?,?,?,?,?,?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      clbl = conn.prepareCall(SQLQuery);
      clbl.setString(1, ins.getAnombre());
      clbl.setInt(2, ins.getBidMarca());
      clbl.setInt(3, ins.getCidTipo());
      clbl.setInt(4, ins.getDStock());
      clbl.setDouble(5, ins.getEPrecio());
      clbl.setString(6, ins.getFdescripcion());
      clbl.setInt(7, idUsuario);
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
  public List<MensajesBeans> updtProducto(int idProducto, RecuperarProductoInterno ins, int idUser)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Actualizar_Producto`(?,?,?,?,?,?,?,?,?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idProducto);
      stmt.setInt(2, ins.getAIdMarca());
      stmt.setInt(3, ins.getBidTipo());
      stmt.setString(4, ins.getCNombre());
      stmt.setInt(5, ins.getDidEstado());
      stmt.setInt(6, ins.getFStock());
      stmt.setDouble(7, ins.getGPrecio());
      stmt.setString(8, ins.getHdescripcion());
      stmt.setInt(9, idUser);
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
  public List<MensajesBeans> delProducto(int idProducto)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Eliminar_Producto`(?)}";
	LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
    try {
      dbCon = new ConexionBD();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      conn = ConexionBD.setDBConnection();
      stmt = conn.prepareCall(SQLQuery);
      stmt.setInt(1, idProducto);
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
