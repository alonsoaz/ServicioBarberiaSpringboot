package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscarServicioInterno;
import com.barberia.entity.InsertarServicio;
import com.barberia.entity.ListarServicio;
import com.barberia.entity.ListarServicioInterno;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarServicioInterno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class ServicioModel {
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
	private static ServicioModel stdregd = null;

	public ServicioModel() {
	}

	public static ServicioModel getInstance() {
		if (stdregd == null) {
			stdregd = new ServicioModel();
			return stdregd;
		}

		return stdregd;
	}

	public List<ListarServicioInterno> getServicioRecords() {
		ServicioRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Servicio_Interno`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				ServicioRecords.add(new ListarServicioInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getInt(5), rslt.getDouble(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9)));
			}

			return ServicioRecords;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioRecords;
	}

	public List<ListarServicio> getServicioR() {
		ServicioR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Servicio`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				ServicioR.add(new ListarServicio(rslt.getInt(1), rslt.getString(2), rslt.getInt(3), rslt.getDouble(4)));
			}

			return ServicioR;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioR;
	}

	public List<BuscarServicioInterno> getServicioByWords(String words) {
		ServicioSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Servicio_Interno`(?,?)}";
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

			return ServicioSearch;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioSearch;
	}

	public List<com.barberia.entity.BuscarServicio> getServByWords(String words) {
		ServicioS = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Servicio`(?,?)}";
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

			return ServicioS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioS;
	}

	public List<RecuperarServicioInterno> getServicio(int id) {
		ServicioGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Servicio_Interno`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				ServicioGet.add(new RecuperarServicioInterno(rslt.getString(1), rslt.getInt(2), rslt.getInt(3),
						rslt.getDouble(4), rslt.getString(5)));
			}

			return ServicioGet;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioGet;
	}

	public List<ListarServicio> getServicioA(int id) {
		ServicioR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Servicio_Android`(?)}";
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

			return ServicioR;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ServicioR;
	}
	
	public List<MensajesBeans> addServicio(InsertarServicio ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Servicio`(?,?,?,?,?)}";
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
			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
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

	public List<MensajesBeans> updtServicio(int idServicio, RecuperarServicioInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Servicio`(?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
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
			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
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

	public List<MensajesBeans> delServicio(int idServicio) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Servicio`(?)}";
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
			return mensaje;
		} catch (SQLException e) {
			e.printStackTrace();
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
}
