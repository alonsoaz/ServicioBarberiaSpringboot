package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.Aidis;
import com.barberia.entity.BuscarClienteInterno;
import com.barberia.entity.CambiarClave;
import com.barberia.entity.InsertarCliente;
import com.barberia.entity.ListarClienteInterno;
import com.barberia.entity.LoginCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarClienteInterno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class ClienteModel {
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	private List<MensajesBeans> mensaje;
	private List<Aidis> aidi;
	private List<MessagenID> mesgid;
	private List<ListarClienteInterno> clienteRecords;
	private List<BuscarClienteInterno> clienteSearch;
	private List<RecuperarClienteInterno> clienteGet;
	private static ClienteModel stdregd = null;

	public ClienteModel() {
	}

	public static ClienteModel getInstance() {
		if (stdregd == null) {
			stdregd = new ClienteModel();
			return stdregd;
		}

		return stdregd;
	}

	public List<ListarClienteInterno> getClienteRecords() {
		clienteRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Cliente_Interno`";
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				clienteRecords.add(new ListarClienteInterno(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), rslt.getString(10)));
			}

			return clienteRecords;
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
		return clienteRecords;
	}

	public List<BuscarClienteInterno> getClienteByWords(String words) {
		clienteSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Cliente_Interno`(?,?)}";
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, words);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				clienteSearch.add(new BuscarClienteInterno(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), rslt.getString(10), clbl.getInt(2)));
			}

			return clienteSearch;
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
		return clienteSearch;
	}

	public List<RecuperarClienteInterno> getCliente(int id) {
		clienteGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Cliente_Interno`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				clienteGet.add(new RecuperarClienteInterno(rslt.getInt(7), rslt.getString(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getString(5), rslt.getString(6)));
			}

			return clienteGet;
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
		return clienteGet;
	}

	public List<MensajesBeans> addCliente(InsertarCliente ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Cliente`(?,?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getaNombre());
			clbl.setString(2, ins.getbApellido());
			clbl.setString(3, ins.getcTelefono());
			clbl.setString(4, ins.getdDni());
			clbl.setString(5, ins.geteEmail());
			clbl.setString(6, ins.getfDirecion());
			clbl.setString(7, ins.getPassword());
			clbl.setInt(8, idUsuario);
			clbl.registerOutParameter(9, 4);
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

	public List<Aidis> addClienteLogin(InsertarCliente ins, int idUsuario) {
		aidi = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Cliente`(?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getaNombre());
			clbl.setString(2, ins.getbApellido());
			clbl.setString(3, ins.getcTelefono());
			clbl.setString(4, ins.getdDni());
			clbl.setString(5, ins.geteEmail());
			clbl.setString(6, ins.getfDirecion());
			clbl.setInt(7, idUsuario);
			clbl.registerOutParameter(8, 4);
			rslt = clbl.executeQuery();
			rslt.beforeFirst();

			aidi.add(new Aidis(clbl.getInt(8)));

			return aidi;
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
		return aidi;
	}

	public List<MessagenID> LogInClient(LoginCliente ins) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Login_Cliente`(?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getaDni());
			clbl.setString(2, ins.getbPassword());
			clbl.registerOutParameter(3, 4);
			
			rslt = clbl.executeQuery();
			System.out.println("registra");
			int idCliente = clbl.getInt(3);
			
			rslt.beforeFirst();
			System.out.println("cursor");
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idCliente));
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
	
	public List<MessagenID> changePass(CambiarClave ins, int idCliente) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Cambiar_Clave_Cliente`(?,?,?)}";
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
			stmt.setInt(1, idCliente);
			rslt = stmt.executeQuery();
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idCliente));
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

	public List<MensajesBeans> updtClient(int idCliente, RecuperarClienteInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Cliente`(?,?,?,?,?,?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, ins.getIdEstado());
			stmt.setString(3, ins.getBnombre());
			stmt.setString(4, ins.getCapellido());
			stmt.setString(5, ins.getDtelefono());
			stmt.setString(6, ins.geteDni());
			stmt.setString(7, ins.getFcorreo());
			stmt.setString(8, ins.getGdireccion());
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

	public List<MensajesBeans> delClient(int idCliente) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Cliente`(?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idCliente);
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
