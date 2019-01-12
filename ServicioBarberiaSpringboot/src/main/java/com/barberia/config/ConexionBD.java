package com.barberia.config;

import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConexionBD
{
  public static Connection dbCon;
  public PreparedStatement dbPs;
  public CallableStatement dbCs;
  public ResultSet dbRst;
  
  public ConexionBD() throws SQLException
  {
    setDBConnection();
  }
  
  public static Connection setDBConnection()
    throws SQLException
  {
    String bd = "barberia?autoReconnect=true&useSSL=false&noAccessToProcedureBodies=true";
    String login = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    
    System.out.println("Dentro de DBConnection");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      dbCon = java.sql.DriverManager.getConnection(url, login, password);
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    
    return dbCon;
  }
  
  public ResultSet getResultSet(String sqlQuery, Connection conn) throws SQLException
  {
    System.out.println("Dentro de getResultSet");
    System.out.println(sqlQuery);
    String sqlquery = sqlQuery;
    dbCon = setDBConnection();
    try {
      dbPs = dbCon.prepareStatement(sqlquery);
      dbRst = dbPs.executeQuery();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return dbRst;
  }
  
  public ResultSet getResultSet1(String sqlQuery, Connection conn) throws SQLException {
    System.out.println("Dentro de getResultSet");
    System.out.println(sqlQuery);
    String sqlquery = sqlQuery;
    dbCon = setDBConnection();
    try {
      dbCs = dbCon.prepareCall(sqlquery);
      dbRst = dbCs.executeQuery();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return dbRst;
  }
  

  public static String[][] getRegistros(Connection conn, String value)
    throws SQLException
  {
    String[][] mRegistros = (String[][])null;
    try {
      CallableStatement pstm = conn.prepareCall("{CALL barberia.`sp.Buscar_Usuario`(?,?)}");
      pstm.setString(1, value);
      pstm.registerOutParameter(2, 4);
      ResultSet dbRst1 = pstm.executeQuery();
      int fila = -1;
      if (dbRst1.last()) {
        mRegistros = new String[dbRst1.getRow()][dbRst1.getMetaData().getColumnCount()];
      }
      dbRst1.beforeFirst();
      int columnas = dbRst1.getMetaData().getColumnCount();
      while (dbRst1.next()) { fila++; if (fila <= -1) break;
        for (int i = 0; i < columnas; i++)
        {
          mRegistros[fila][i] = dbRst1.getString(i + 1);
          System.out.println(dbRst1.getString(i + 1));
        }
      }
      
      dbRst1.close();
      return (String[][])null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mRegistros;
  }
  

  public boolean SQLchckingData(Connection conn, String row, String value)
    throws SQLException
  {
    try
    {
      System.out.println("Antes de hacer preparedstatement");
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE " + row + "= ?");
      stmt.setString(1, value);
      System.out.println(stmt);
      
      ResultSet dbRst1 = stmt.executeQuery();
      
      if (dbRst1.next()) {
        return true;
      }
      return false;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    
    return true;
  }
  
  public static void main(String[] args) throws SQLException
  {
    ConexionBD c = new ConexionBD();
    try {
      getRegistros(setDBConnection(), "U");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
