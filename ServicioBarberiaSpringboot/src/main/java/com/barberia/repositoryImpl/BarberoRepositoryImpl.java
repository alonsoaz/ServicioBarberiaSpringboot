package com.barberia.repositoryImpl;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscarBarbero;
import com.barberia.entity.BuscarBarberoInterno;
import com.barberia.entity.InsertarBarbero;
import com.barberia.entity.ListarBarbero;
import com.barberia.entity.ListarBarberoInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarBarberoInterno;
import com.barberia.repository.BarberoRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

@org.springframework.stereotype.Repository
public class BarberoRepositoryImpl implements BarberoRepository {
	
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	private List<MensajesBeans> mensaje;
	private List<com.barberia.entity.Aidis> aidi = new ArrayList();
	private List<com.barberia.entity.MessagenID> mesgid = new ArrayList();

	private List<com.barberia.entity.ListarBarberoInterno> BarberoRecords;

	private List<ListarBarbero> BarberoR;
	private List<BuscarBarberoInterno> BarberoSearch;
	private List<BuscarBarbero> BarberoS;
	private List<RecuperarBarberoInterno> BarberoGet;
	private static BarberoRepositoryImpl stdregd = null;
	
	private final Logger LOG = Logger.getLogger(this.getClass());

	public BarberoRepositoryImpl() {
	}
	

	public static BarberoRepositoryImpl getInstance() {
		if (stdregd == null) {
			stdregd = new BarberoRepositoryImpl();
			return stdregd;
		}

		return stdregd;
	}

	@Override
	public List<ListarBarberoInterno> getBarberoRecords() {
		BarberoRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Barbero_Interno`";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				BarberoRecords.add(new com.barberia.entity.ListarBarberoInterno(rslt.getString(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7),
						rslt.getString(8), rslt.getString(9), rslt.getString(10)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return BarberoRecords;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOG.error("Error de conexión: "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return BarberoRecords;
	}

	@Override
	public List<ListarBarbero> getBarberoR() {
		BarberoR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Barbero`";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				BarberoR.add(new ListarBarbero(rslt.getInt(1), rslt.getString(2)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);

			return BarberoR;
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
		return BarberoR;
	}

	@Override
	public List<BuscarBarberoInterno> getBarberoByWords(String words) {
		BarberoSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Barbero_Interno`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				BarberoSearch.add(new BuscarBarberoInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), rslt.getString(10), clbl.getInt(2)));
			}

			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return BarberoSearch;
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
		return BarberoSearch;
	}

	@Override
	public List<BuscarBarbero> getBarbByWords(String words) {
		BarberoS = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String SQLQuery = "{call `sp.Buscar_Barbero`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				BarberoS.add(new BuscarBarbero(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), clbl.getInt(2)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);

			return BarberoS;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error en la ejecución: "+e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Error de conexión: "+e.getMessage());
					LOG.error("Error de conexión: "+e.getMessage());
				}
			}
		}
		return BarberoS;
	}

	@Override
	public List<RecuperarBarberoInterno> getBarbero(int id) {
		BarberoGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String SQLQuery = "{call `sp.Recuperar_Barbero_Interno`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				BarberoGet.add(new RecuperarBarberoInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return BarberoGet;
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
		return BarberoGet;
	}

	@Override
	public List<ListarBarbero> getBarberoA(int id) {
		BarberoR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String SQLQuery = "{call `sp.Recuperar_Barbero_Android`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				BarberoR.add(new ListarBarbero(rslt.getInt(1), rslt.getString(2)));
			}
			LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return BarberoR;
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
		return BarberoR;
	}

	@Override
	public List<MensajesBeans> addBarbero(InsertarBarbero ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Barbero`(?,?,?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getAnombre());
			clbl.setString(2, ins.getBapellido());
			clbl.setString(3, ins.getCtelefono());
			clbl.setString(4, ins.getDdni());
			clbl.setString(5, ins.getEcorreo());
			clbl.setString(6, ins.getFdireccion());
			clbl.setInt(7, idUsuario);
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
	public List<MensajesBeans> updtBarbero(int idBarbero, RecuperarBarberoInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Barbero`(?,?,?,?,?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idBarbero);
			stmt.setInt(2, ins.getAidEstado());
			stmt.setString(3, ins.getBNombre());
			stmt.setString(4, ins.getCApellido());
			stmt.setString(5, ins.getDTelefono());
			stmt.setString(6, ins.getEDni());
			stmt.setString(7, ins.getFEmail());
			stmt.setString(8, ins.getGDireccion());
			stmt.setInt(9, idUser);
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
	public List<MensajesBeans> delBarbero(int idBarbero) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Barbero`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Error de conexión: "+e.getMessage());
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idBarbero);
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
