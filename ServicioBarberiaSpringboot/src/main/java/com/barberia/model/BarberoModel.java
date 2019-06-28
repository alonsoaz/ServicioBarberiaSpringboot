package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscarBarbero;
import com.barberia.entity.BuscarBarberoInterno;
import com.barberia.entity.InsertarBarbero;
import com.barberia.entity.ListarBarbero;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.RecuperarBarberoInterno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class BarberoModel {
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
	private static BarberoModel stdregd = null;

	public BarberoModel() {
	}

	public static BarberoModel getInstance() {
		if (stdregd == null) {
			stdregd = new BarberoModel();
			return stdregd;
		}

		return stdregd;
	}

	public List<com.barberia.entity.ListarBarberoInterno> getBarberoRecords() {
		BarberoRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Barbero_Interno`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				BarberoRecords.add(new com.barberia.entity.ListarBarberoInterno(rslt.getString(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7),
						rslt.getString(8), rslt.getString(9), rslt.getString(10)));
			}

			return BarberoRecords;
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
		return BarberoRecords;
	}

	public List<ListarBarbero> getBarberoR() {
		BarberoR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Barbero`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				BarberoR.add(new ListarBarbero(rslt.getInt(1), rslt.getString(2)));
			}

			return BarberoR;
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
		return BarberoR;
	}

	public List<BuscarBarberoInterno> getBarberoByWords(String words) {
		BarberoSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Barbero_Interno`(?,?)}";
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

			return BarberoSearch;
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
		return BarberoSearch;
	}

	public List<BuscarBarbero> getBarbByWords(String words) {
		BarberoS = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Barbero`(?,?)}";
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

			return BarberoS;
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
		return BarberoS;
	}

	public List<RecuperarBarberoInterno> getBarbero(int id) {
		BarberoGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Barbero_Interno`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				BarberoGet.add(new RecuperarBarberoInterno(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7)));
			}

			return BarberoGet;
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
		return BarberoGet;
	}
	
	public List<ListarBarbero> getBarberoA(int id) {
		BarberoR = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Barbero_Android`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				BarberoR.add(new ListarBarbero(rslt.getInt(1), rslt.getString(2)));
			}

			return BarberoR;
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
		return BarberoR;
	}

	public List<MensajesBeans> addBarbero(InsertarBarbero ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Barbero`(?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
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

	public List<MensajesBeans> updtBarbero(int idBarbero, RecuperarBarberoInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Barbero`(?,?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idBarbero);
			stmt.setInt(2, ins.getAidEstado());
			stmt.setString(3, ins.getbNombre());
			stmt.setString(4, ins.getcApellido());
			stmt.setString(5, ins.getdTelefono());
			stmt.setString(6, ins.geteDni());
			stmt.setString(7, ins.getfEmail());
			stmt.setString(8, ins.getgDireccion());
			stmt.setInt(9, idUser);
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

	public List<MensajesBeans> delBarbero(int idBarbero) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Barbero`(?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
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
