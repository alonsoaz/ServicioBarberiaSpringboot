package com.barberia.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.barberia.config.ConexionBD;
import com.barberia.entity.*;

@Repository
public class ReservasModel {
	
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	
	private List<MensajesBeans> mensaje = new ArrayList<MensajesBeans>();
	private List<Aidis> aidi = new ArrayList<Aidis>();
	private List<MessagenID> mesgid = new ArrayList<MessagenID>();
	
	private List<BuscarReservaPorCliente> SearchReserva = new ArrayList<BuscarReservaPorCliente>();
	private List<ListarReservasPorCliente> ListReserva = new ArrayList<ListarReservasPorCliente>();
	
	private static ReservasModel stdregd = null;
	
	public static ReservasModel getInstance() {
		
		if(stdregd == null) {
			stdregd = new ReservasModel();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}
	
	public List<MensajesBeans> askBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idServicio) {
		
		String SQLQuery = "{call `sp.Consultar_Disponibilidad_Barbero`(?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idBarbero);
			clbl.setString(2, ins.toString());
			clbl.setInt(3, idServicio);
			rslt = clbl.executeQuery();
            rslt.beforeFirst();
			while(rslt.next()) {
				mensaje.add( new MensajesBeans(rslt.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return mensaje;
		
	}
	
	public List<MensajesBeans> tryBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idCliente, int idServicio) {
		
		String SQLQuery = "{call `sp.Generar_Reserva_Barbero`(?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idBarbero);
			clbl.setInt(2, idCliente);			
			clbl.setString(3, ins.toString());
			clbl.setInt(4, idServicio);
			rslt = clbl.executeQuery();
            rslt.beforeFirst();
			while(rslt.next()) {
				mensaje.add( new MensajesBeans(rslt.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return mensaje;
		
	}
	
	public List<ListarReservasPorCliente> getReservas(int idCliente) {
		
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet rslt;
		String SQLQuery = "{call `sp.Listar_Reservas_Por_Cliente`(?)}";
		
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, idCliente);
			rslt = stmt.executeQuery();
			if(rslt.next()) {
				rslt.beforeFirst();
				while(rslt.next()) {
					
					ListReserva.add(new ListarReservasPorCliente(
							rslt.getInt(1), 
							rslt.getString(2),						
							rslt.getString(3), 
							rslt.getString(4), 
							rslt.getString(5), 
							rslt.getString(6),
							rslt.getString(7), 
							rslt.getString(8)
							));
				}
				
			}else {
				rslt.beforeFirst();
				ListReserva.add(new ListarReservasPorCliente(
						0, 
						null,						
						null, 
						null, 
						null, 
						null,
						null, 
						"NO EXISTEN RESERVAS PENDIENTES."
						));
				
				return ListReserva;
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return ListReserva;
	}
	
	public List<BuscarReservaPorCliente> getReserva(int idCliente, int idReserva) {
		
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet rslt;
		String SQLQuery = "{call `sp.Recuperar_Reserva_Por_Cliente`(?,?)}";
		
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, idCliente);			
			rslt = stmt.executeQuery();
			while(rslt.next()) {
				SearchReserva.add(new BuscarReservaPorCliente(
						rslt.getInt(1), 
						rslt.getString(2),						
						rslt.getString(3), 
						rslt.getString(4), 
						rslt.getString(5), 
						rslt.getString(6),
						rslt.getString(7), 
						rslt.getString(8)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return SearchReserva;
	}
	
	public List<MensajesBeans> delReserva(int idCliente, int idReserva) {

		String SQLQuery = "{call `sp.Eliminar_Reserva_Por_Cliente`(?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, idReserva);
			rslt = stmt.executeQuery();
            rslt.beforeFirst();
			while(rslt.next()) {
				mensaje.add(new MensajesBeans(rslt.getString(1)));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return mensaje;
		
	}
	
	public List<MensajesBeans> payReserva(int idCliente, int idReserva) {

		String SQLQuery = "{call `sp.Pagar_Reserva_Por_Cliente`(?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, idReserva);
			rslt = stmt.executeQuery();
            rslt.beforeFirst();
			while(rslt.next()) {
				mensaje.add(new MensajesBeans(rslt.getString(1)));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn != null ) {
				
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		return mensaje;
		
	}

}