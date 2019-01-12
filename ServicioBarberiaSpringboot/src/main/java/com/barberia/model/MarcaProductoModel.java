package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.InsertarMarca;
import com.barberia.entity.ListarMarca;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarMarcaInterno;
import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class MarcaProductoModel
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
  private static MarcaProductoModel stdregd = null;
  
  public MarcaProductoModel() {}
  
  public static MarcaProductoModel getInstance() { if (stdregd == null) {
      stdregd = new MarcaProductoModel();
      return stdregd;
    }
    
    return stdregd;
  }
  

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
      
















      return MarcaProductoR;
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
	return MarcaProductoR;
  }
  




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
      
















      return MarcaProductoGet;
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
	return MarcaProductoGet;
  }
  




  public MensajesBeans addMarcaProducto(InsertarMarca ins, int idUsuario)
  {
    String SQLQuery = "{call `sp.Insertar_Marca_Producto`(?)}";
    String p = "";
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
      System.out.println(rslt.next());
      

      mensaj = new MensajesBeans(rslt.getString(1));
      
















      return mensaj;
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
	return mensaj;
  }
  





  public List<MensajesBeans> updtMarcaProducto(int idMarcaProducto, RecuperarMarcaInterno ins)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Actualizar_Marca_Producto`(?,?,?)}";
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
      















      return mensaje;
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
	return mensaje;
  }
  





  public List<MensajesBeans> delMarcaProducto(int idMarcaProducto)
  {
    mensaje = new ArrayList();
    
    String SQLQuery = "{call `sp.Eliminar_MarcaProducto`(?)}";
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
       return mensaje;
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
	return mensaje;
  }
}
