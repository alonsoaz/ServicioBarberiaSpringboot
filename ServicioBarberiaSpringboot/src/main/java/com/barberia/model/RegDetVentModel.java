package com.barberia.model;

import com.barberia.config.ConexionBD;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.MostrarDetalleVentaPagada;
import com.barberia.entity.MostrarVentaPagada;
import com.barberia.entity.RecuperarDetalleVenta;
import com.barberia.entity.RegistrarDetalleVentaXpAgar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class RegDetVentModel {
	private ConexionBD dbCon;
	private Connection conn;
	private ResultSet rslt;
	private PreparedStatement stmt;
	private CallableStatement clbl;
	private List<MensajesBeans> mensaje = new ArrayList();
	private List<com.barberia.entity.Aidis> aidi = new ArrayList();

	private List<MessagenID> mesgid;

	private List<com.barberia.entity.MostrarVentaPorPagar> ShowVxPagar;
	private List<com.barberia.entity.MostrarDetalleVenta> ShowDVxPagar;
	private List<RecuperarDetalleVenta> getDetVenta;
	private List<MostrarVentaPagada> ShowVpagada;
	private List<MostrarDetalleVentaPagada> ShowDVpagada;
	private static RegDetVentModel stdregd = null;

	public RegDetVentModel() {
	}

	public static RegDetVentModel getInstance() {
		if (stdregd == null) {
			stdregd = new RegDetVentModel();
			return stdregd;
		}

		return stdregd;
	}

	public List<MessagenID> regDetVent(RegistrarDetalleVentaXpAgar ins, int idClient, int idProd) {
		mesgid = new ArrayList();

		String SQLQuery = "{call `sp.Registrar_Detalle_Venta_Por_Pagar`(?,?,?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idClient);
			clbl.setInt(2, idProd);
			clbl.setInt(3, ins.getCantidad());
			clbl.registerOutParameter(4, 4);
			rslt = clbl.executeQuery();
			rslt.beforeFirst();
			while (rslt.next()) {
				mesgid.add(new MessagenID(rslt.getString(1), clbl.getInt(4)));
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

	public List<com.barberia.entity.MostrarVentaPorPagar> showVentaXpagar(int idClient) {
		ShowVxPagar = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Mostrar_Venta_Por_Pagar`(?,?)}";
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idClient);
			clbl.registerOutParameter(2, 4);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				ShowVxPagar.add(new com.barberia.entity.MostrarVentaPorPagar(rslt.getString(1), rslt.getString(2),
						rslt.getString(3), rslt.getString(4), rslt.getDouble(5), rslt.getString(6), clbl.getInt(2)));
			}

			return ShowVxPagar;
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
		return ShowVxPagar;
	}

	public List<MensajesBeans> delVenta(int idCliente) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Venta`(?)}";
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

	public List<MensajesBeans> payVenta(int idCliente) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Registrar_Venta_Pagada`(?)}";
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

	public List<com.barberia.entity.MostrarDetalleVenta> ShowDVxPagar(int idCliente) {
		ShowDVxPagar = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Mostrar_Detalle_Venta`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, idCliente);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				ShowDVxPagar.add(new com.barberia.entity.MostrarDetalleVenta(rslt.getInt(1), rslt.getInt(2),
						rslt.getString(3), rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7),
						rslt.getString(8), rslt.getString(9), rslt.getString(10), rslt.getString(11),
						rslt.getDouble(12), rslt.getInt(13), rslt.getDouble(14), rslt.getDouble(15)));
			}

			return ShowDVxPagar;
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
		return ShowDVxPagar;
	}

	public List<RecuperarDetalleVenta> getDV(int id) {
		getDetVenta = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Recuperar_Detalle_Venta`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareStatement(SQLQuery);
			stmt.setInt(1, id);
			ResultSet rslt = stmt.executeQuery();
			while (rslt.next()) {
				getDetVenta.add(new RecuperarDetalleVenta(rslt.getInt(1), rslt.getDouble(2), rslt.getInt(3),
						rslt.getDouble(4), rslt.getDouble(5)));
			}

			return getDetVenta;
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
		return getDetVenta;
	}

	public List<MensajesBeans> updtDetVent(int idDetVent, RegistrarDetalleVentaXpAgar ins) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Actualizar_Detalle_Venta`(?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idDetVent);
			stmt.setInt(2, ins.getCantidad());
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

	public List<MensajesBeans> delDV(int idDetVent) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Eliminar_Detalle_Venta`(?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idDetVent);
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

	public List<MensajesBeans> payDetVenta(int idCliente, int idDetVenta) {
		mensaje = new ArrayList();

		String SQLQuery = "{call `sp.Registrar_Detalle_Venta_Pagada`(?,?)}";
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn = ConexionBD.setDBConnection();
			stmt = conn.prepareCall(SQLQuery);
			stmt.setInt(1, idCliente);
			stmt.setInt(2, idDetVenta);
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

	public List<MostrarVentaPagada> showVentaPagada(int idClient) {
		ShowVpagada = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Mostrar_Venta_Pagada`(?)}";
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idClient);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				ShowVpagada.add(new MostrarVentaPagada(rslt.getInt(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getDouble(6), rslt.getString(7)));
			}

			return ShowVpagada;
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
		return ShowVpagada;
	}

	public List<MostrarDetalleVentaPagada> showDetVentaPagada(int idClient, int idVenta) {
		ShowDVpagada = new ArrayList();
		try {
			dbCon = new ConexionBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String SQLQuery = "{call `sp.Mostrar_Detalle_Venta_Pagada`(?,?)}";
		try {
			conn = ConexionBD.setDBConnection();
			clbl = conn.prepareCall(SQLQuery);
			clbl.setInt(1, idClient);
			clbl.setInt(2, idVenta);
			ResultSet rslt = clbl.executeQuery();
			while (rslt.next()) {
				ShowDVpagada.add(new MostrarDetalleVentaPagada(rslt.getString(1), rslt.getString(2), rslt.getString(3),
						rslt.getString(4), rslt.getString(5), rslt.getString(6), rslt.getString(7), rslt.getString(8),
						rslt.getString(9), rslt.getDouble(10), rslt.getInt(11), rslt.getDouble(12),
						rslt.getDouble(13)));
			}
			return ShowDVpagada;
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
		return ShowDVpagada;
	}
}
