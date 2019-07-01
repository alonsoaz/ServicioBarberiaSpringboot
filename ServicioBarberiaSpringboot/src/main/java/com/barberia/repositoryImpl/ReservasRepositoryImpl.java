package com.barberia.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.barberia.config.ConexionBD;
import com.barberia.entity.*;
import com.barberia.repository.ReservasRepository;

@Repository
public class ReservasRepositoryImpl implements ReservasRepository{

	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;

	private List<MensajesBeans> mensaje;
	private List<Aidis> aidi;
	private List<MessagenID> mesgid;

	private List<BuscarReservaPorCliente> SearchReserva;
	private List<ListarReservasPorCliente> ListReserva;

	private static ReservasRepositoryImpl stdregd = null;

	private final Logger LOG = Logger.getLogger(this.getClass());

	public static ReservasRepositoryImpl getInstance() {

		if (stdregd == null) {
			stdregd = new ReservasRepositoryImpl();
			return stdregd;
		} else {
			return stdregd;
		}
	}

	@Override
	public List<MensajesBeans> askBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idServicio) {
		mensaje = new ArrayList<MensajesBeans>();
		String SQLQuery = "{call `sp.Consultar_Disponibilidad_Barbero`(?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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
			while (rslt.next()) {
				mensaje.add(new MensajesBeans(rslt.getString(1)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);

			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
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
	public List<MessagenID> tryBarbero(ConsultaDisponibilidadBarbero ins, int idBarbero, int idCliente,
			int idServicio) {
		mesgid = new ArrayList<MessagenID>();
		String SQLQuery = "{call `sp.Generar_Reserva_Barbero`(?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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
			clbl.registerOutParameter(5, 4);

			rslt = clbl.executeQuery();

			int idReserva = clbl.getInt(5);
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idReserva));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return mesgid;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LOG.error("Error de conexión: "+e.getMessage());
				}

			}

		}

		return mesgid;

	}

	@Override
	public List<ListarReservasPorCliente> getReservas(int idCliente) {
		ListReserva = new ArrayList<ListarReservasPorCliente>();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rslt;
		String SQLQuery = "{call `sp.Listar_Reservas_Por_Cliente`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);

		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, idCliente);
			rslt = stmt.executeQuery();
			if (rslt.next()) {
				rslt.beforeFirst();
				while (rslt.next()) {

					ListReserva.add(new ListarReservasPorCliente(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
							rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7),
							rslt.getString(8)));
				}
				LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
				return ListReserva;
			} else {
				rslt.beforeFirst();
				ListReserva.add(new ListarReservasPorCliente(0, null, null, null, null, null, null,
						"NO EXISTEN RESERVAS PENDIENTES."));


				LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
				return ListReserva;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LOG.error("Error de conexión: "+e.getMessage());
				}

			}

		}
		return ListReserva;
	}

	@Override
	public List<BuscarReservaPorCliente> getReserva(int idCliente, int idReserva) {
		SearchReserva = new ArrayList<BuscarReservaPorCliente>();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rslt;
		String SQLQuery = "{call `sp.Recuperar_Reserva_Por_Cliente`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);

		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, idReserva);
			rslt = stmt.executeQuery();
			while (rslt.next()) {
				SearchReserva.add(new BuscarReservaPorCliente(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LOG.error("Error de conexión: "+e.getMessage());
				}

			}

		}

		return SearchReserva;
	}

	@Override
	public List<MensajesBeans> delReserva(int idCliente, int idReserva) {
		mensaje = new ArrayList<MensajesBeans>();
		String SQLQuery = "{call `sp.Eliminar_Reserva_Por_Cliente`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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
			while (rslt.next()) {
				mensaje.add(new MensajesBeans(rslt.getString(1)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
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
	public List<MensajesBeans> payReserva(int idCliente, int idReserva) {
		mensaje = new ArrayList<MensajesBeans>();
		String SQLQuery = "{call `sp.Pagar_Reserva_Por_Cliente`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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
			while (rslt.next()) {
				mensaje.add(new MensajesBeans(rslt.getString(1)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {

			if (conn != null) {

				try {
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