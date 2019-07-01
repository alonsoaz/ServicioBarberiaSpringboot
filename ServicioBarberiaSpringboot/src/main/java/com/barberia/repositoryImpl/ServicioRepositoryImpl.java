package com.barberia.repositoryImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscarServicioInterno;
import com.barberia.entity.InsertarServicio;
import com.barberia.entity.ListarServicio;
import com.barberia.entity.ListarServicioInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarServicioInterno;
import com.barberia.repository.ServicioRepository;

@org.springframework.stereotype.Repository
public class ServicioRepositoryImpl implements ServicioRepository{
	
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	private List<MensajesBeans> mensaje;
	private List<com.barberia.entity.Aidis> aidi = new ArrayList();
	private List<com.barberia.entity.MessagenID> mesgid = new ArrayList();

	private List<ListarServicioInterno> ServicioRecords;

	private List<ListarServicio> ServicioR;
	private List<BuscarServicioInterno> ServicioSearch;
	private List<com.barberia.entity.BuscarServicio> ServicioS;
	private List<RecuperarServicioInterno> ServicioGet;
	private static ServicioRepositoryImpl stdregd = null;

	private final Logger LOG = Logger.getLogger(this.getClass());

	public ServicioRepositoryImpl() {
	}

	public static ServicioRepositoryImpl getInstance() {
		if (stdregd == null) {
			stdregd = new ServicioRepositoryImpl();
			return stdregd;
		}

		return stdregd;
	}

	@Override
	public List<ListarServicioInterno> getServicioRecords() {
		ServicioRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Servicio_Interno`";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				ServicioRecords.add(new ListarServicioInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getInt(5), rslt.getDouble(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return ServicioRecords;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LOG.error("Error de conexión: "+e.getMessage());
				}
			}
		}
		return ServicioRecords;
	}

	@Override
	public List<ListarServicio> getServicioR() {
		ServicioR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Servicio`";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				ServicioR.add(new ListarServicio(rslt.getInt(1), rslt.getString(2), rslt.getInt(3), rslt.getDouble(4)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return ServicioR;
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
		return ServicioR;
	}

	@Override
	public List<BuscarServicioInterno> getServicioByWords(String words) {
		ServicioSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Servicio_Interno`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				ServicioSearch.add(new BuscarServicioInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getInt(5), rslt.getDouble(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), clbl.getInt(2)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);

			return ServicioSearch;
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
		return ServicioSearch;
	}

	@Override
	public List<com.barberia.entity.BuscarServicio> getServByWords(String words) {
		ServicioS = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Servicio`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				ServicioS.add(new com.barberia.entity.BuscarServicio(rslt.getInt(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), rslt.getDouble(6), rslt.getString(7),
						clbl.getInt(2)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);

			return ServicioS;
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
		return ServicioS;
	}

	@Override
	public List<RecuperarServicioInterno> getServicio(int id) {
		ServicioGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Servicio_Interno`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				ServicioGet.add(new RecuperarServicioInterno(
						rslt.getString(1), 
						rslt.getInt(2), 
						rslt.getInt(3),
						rslt.getDouble(4), 
						rslt.getString(5)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return ServicioGet;
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
		return ServicioGet;
	}

	@Override
	public List<ListarServicio> getServicioA(int id) {
		ServicioR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Servicio_Android`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				ServicioR.add(new ListarServicio(
						rslt.getInt(1), 
						rslt.getString(2),
						rslt.getInt(3), 
						rslt.getDouble(4)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return ServicioR;
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
		return ServicioR;
	}
	
	@Override
	public List<MensajesBeans> addServicio(InsertarServicio ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Servicio`(?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getBnombser());
			clbl.setInt(2, ins.getDminutos());
			clbl.setDouble(3, ins.getEprecio());
			clbl.setString(4, ins.getFdescripcion());
			clbl.setInt(5, idUsuario);
			rslt = clbl.executeQuery();
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
	public List<MensajesBeans> updtServicio(int idServicio, RecuperarServicioInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Servicio`(?,?,?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idServicio);
			stmt.setString(2, ins.getBnombser());
			stmt.setInt(3, ins.getCidEstado());
			stmt.setInt(4, ins.getDminutos());
			stmt.setDouble(5, ins.getEprecio());
			stmt.setString(6, ins.getFdescripcion());
			stmt.setInt(7, idUser);
			rslt = stmt.executeQuery();
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
				}
			}
		}
		return mensaje;
	}

	@Override
	public List<MensajesBeans> delServicio(int idServicio) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Servicio`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idServicio);
			rslt = stmt.executeQuery();
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
}
