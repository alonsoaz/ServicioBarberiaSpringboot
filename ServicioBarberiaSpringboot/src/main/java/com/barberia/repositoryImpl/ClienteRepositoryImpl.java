package com.barberia.repositoryImpl;

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
import com.barberia.repository.ClienteRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@org.springframework.stereotype.Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
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
	private static ClienteRepositoryImpl stdregd = null;
	private final Logger LOG = Logger.getLogger(this.getClass());

	public ClienteRepositoryImpl() {
	}

	public static ClienteRepositoryImpl getInstance() {
		if (stdregd == null) {
			stdregd = new ClienteRepositoryImpl();
			return stdregd;
		}

		return stdregd;
	}

	@Override
	public List<ListarClienteInterno> getClienteRecords() {
		clienteRecords = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "call `sp.Listar_Cliente_Interno`";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			ResultSet rslt = dbCon.getResultSet(SQLQuery, conn);
			while (rslt.next()) {
				clienteRecords.add(new ListarClienteInterno(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), rslt.getString(10)));
			}

		  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return clienteRecords;
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
		return clienteRecords;
	}

	@Override
	public List<BuscarClienteInterno> getClienteByWords(String words) {
		clienteSearch = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Buscar_Cliente_Interno`(?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
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

		  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return clienteSearch;
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
		return clienteSearch;
	}

	@Override
	public List<RecuperarClienteInterno> getCliente(int id) {
		clienteGet = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Cliente_Interno`(?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				clienteGet.add(new RecuperarClienteInterno(
						rslt.getString(1), 
						rslt.getString(2),
						rslt.getString(3), 
						rslt.getString(4), 
						rslt.getString(5), 
						rslt.getString(6),
						rslt.getInt(7)));
			}

		  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return clienteGet;
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
		return clienteGet;
	}

	@Override
	public List<MensajesBeans> addCliente(InsertarCliente ins, int idUsuario) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Cliente`(?,?,?,?,?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getANombre());
			clbl.setString(2, ins.getBApellido());
			clbl.setString(3, ins.getCTelefono());
			clbl.setString(4, ins.getDDni());
			clbl.setString(5, ins.getEEmail());
			clbl.setString(6, ins.getFDirecion());
			clbl.setString(7, ins.getPassword());
			clbl.setInt(8, idUsuario);
			clbl.registerOutParameter(9, 4);
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
	public List<Aidis> addClienteLogin(InsertarCliente ins, int idUsuario) {
		aidi = new ArrayList();

		String SQLQuery = "{call `sp.Insertar_Cliente`(?,?,?,?,?,?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getANombre());
			clbl.setString(2, ins.getBApellido());
			clbl.setString(3, ins.getCTelefono());
			clbl.setString(4, ins.getDDni());
			clbl.setString(5, ins.getEEmail());
			clbl.setString(6, ins.getFDirecion());
			clbl.setInt(7, idUsuario);
			clbl.registerOutParameter(8, 4);
			rslt = clbl.executeQuery();
			rslt.beforeFirst();

			aidi.add(new Aidis(clbl.getInt(8)));

		  	LOG.info("Fin de la ejecución del procedimiento almacenado: "+SQLQuery);
			return aidi;
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
		return aidi;
	}

	@Override
	public List<MessagenID> LogInClient(LoginCliente ins) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Login_Cliente`(?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setString(1, ins.getADni());
			clbl.setString(2, ins.getBPassword());
			clbl.registerOutParameter(3, 4);
			
			rslt = clbl.executeQuery();
			System.out.println("registra");
			int idCliente = clbl.getInt(3);
			
			rslt.beforeFirst();
			System.out.println("cursor");
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idCliente));
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
	public List<MessagenID> changePass(CambiarClave ins, int idCliente) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Cambiar_Clave_Cliente`(?,?,?)}";
		LOG.info("Ejecutando el procedimiento almacenado: "+SQLQuery);
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setString(2, ins.getApass());
			stmt.setString(3, ins.getBNewPass());
			stmt.setInt(1, idCliente);
			rslt = stmt.executeQuery();
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), idCliente));
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
	public List<MensajesBeans> updtClient(int idCliente, RecuperarClienteInterno ins, int idUser) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Cliente`(?,?,?,?,?,?,?,?,?)}";
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
			stmt.setInt(2, ins.getIdEstado());
			stmt.setString(3, ins.getBnombre());
			stmt.setString(4, ins.getCapellido());
			stmt.setString(5, ins.getDtelefono());
			stmt.setString(6, ins.getEDni());
			stmt.setString(7, ins.getFcorreo());
			stmt.setString(8, ins.getGdireccion());
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
	public List<MensajesBeans> delClient(int idCliente) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Cliente`(?)}";
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
