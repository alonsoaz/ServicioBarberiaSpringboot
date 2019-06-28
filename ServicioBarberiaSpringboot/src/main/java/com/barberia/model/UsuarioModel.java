package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.BuscarUsuario;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarUsuario;
import com.barberia.entity.LoginUsuario;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarTipoUsuario;
import com.barberia.entity.RecuperaraUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class UsuarioModel {
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	private List<MensajesBeans> mensaje;
	private List<com.barberia.entity.Aidis> aidi;
	private List<MessagenID> mesgid;
	private List<com.barberia.entity.ListarUsuario> usuarioRecords;
	private List<BuscarUsuario> usuarioSearch;
	private List<RecuperaraUsuario> usuarioGet;
	private List<RecuperarTipoUsuario> tipoGet;
	private static UsuarioModel stdregd = null;

	public UsuarioModel() {
	}

	public static UsuarioModel getInstance() {
		if (stdregd == null) {
			stdregd = new UsuarioModel();
			return stdregd;
		}

		return stdregd;
	}

	public List<com.barberia.entity.ListarUsuario> getUsuarioRecords() {
		usuarioRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Usuario`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				usuarioRecords.add(new com.barberia.entity.ListarUsuario(rslt.getString(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7),
						rslt.getString(8)));
			}

			return usuarioRecords;
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
		return usuarioRecords;
	}

	public List<BuscarUsuario> getUsuarioByWords(String words) {
		usuarioSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Usuario`(?,?)}";
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				usuarioSearch.add(new BuscarUsuario(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						clbl.getInt(2)));
			}

			return usuarioSearch;
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
		return usuarioSearch;
	}

	public List<RecuperaraUsuario> getUsuario(int id) {
		usuarioGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Usuario`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				usuarioGet.add(new RecuperaraUsuario(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7)));
			}

			return usuarioGet;
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
		return usuarioGet;
	}

	public List<MensajesBeans> addUsuario(InsertarUsuario ins) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Usuario`(?,?,?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, ins.getAidUsuario());
			clbl.setString(2, ins.getBnombre());
			clbl.setString(3, ins.getCapellido());
			clbl.setString(4, ins.getDcargo());
			clbl.setString(5, ins.getEaka());
			clbl.setString(6, ins.getFpass());
			clbl.setString(7, ins.getGemail());
			clbl.setString(8, ins.getHtelefono());
			clbl.setString(9, ins.getIdescripcion());
			clbl.registerOutParameter(10, 4);
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

	public List<MessagenID> addUsuarioLogin(InsertarUsuario ins) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Usuario`(?,?,?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, ins.getAidUsuario());
			clbl.setString(2, ins.getBnombre());
			clbl.setString(3, ins.getCapellido());
			clbl.setString(4, ins.getDcargo());
			clbl.setString(5, ins.getEaka());
			clbl.setString(6, ins.getFpass());
			clbl.setString(7, ins.getGemail());
			clbl.setString(8, ins.getHtelefono());
			clbl.setString(9, ins.getIdescripcion());
			clbl.registerOutParameter(10, 4);
			rslt = clbl.executeQuery();
			rslt.beforeFirst();

			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), clbl.getInt(10)));
			}

			return mesgid;
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
		return mesgid;
	}

	public List<MessagenID> LogInUser(LoginUsuario ins) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Login_Usuario`(?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getAaka());
			clbl.setString(2, ins.getBpass());
			clbl.registerOutParameter(3, 4);

			rslt = clbl.executeQuery();

			int idUsuario = clbl.getInt(3);

			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idUsuario));
			}

			return mesgid;
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
		return mesgid;
	}

	public List<MessagenID> changePass(CambiarClave ins, int idUsuario) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Cambiar_Clave_Usuario`(?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setString(2, ins.getApass());
			stmt.setString(3, ins.getbNewPass());
			stmt.setInt(1, idUsuario);
			rslt = stmt.executeQuery();
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idUsuario));
			}

			return mesgid;
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
		return mesgid;
	}

	public List<MessagenID> updtUsr(RecuperaraUsuario ins, int idUser) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Usuario`(?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idUser);
			stmt.setString(2, ins.getAnombre());
			stmt.setString(3, ins.getCapellido());
			stmt.setString(4, ins.getDcargo());
			stmt.setString(5, ins.getEaka());
			stmt.setString(6, ins.getFcorreo());
			stmt.setString(7, ins.getGtelefono());
			stmt.setString(8, ins.getHdescripcion());
			rslt = stmt.executeQuery();
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idUser));
			}
			return mesgid;
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
		return mesgid;
	}

	public List<RecuperarTipoUsuario> TipoUsuario() {
		tipoGet = new ArrayList();

		String SQLQuery = "{CALL `sp.Recuperar_Tipo_Usuario`}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);

			rslt = clbl.executeQuery();

			rslt.beforeFirst();
			while (rslt.next()) {
				tipoGet.add(new RecuperarTipoUsuario(rslt.getString(1), rslt.getInt(2)));
			}
			return tipoGet;
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
		return tipoGet;
	}
}
