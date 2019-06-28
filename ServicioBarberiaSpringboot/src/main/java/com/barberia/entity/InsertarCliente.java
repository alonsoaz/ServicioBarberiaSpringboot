package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertarCliente {
	private String aNombre;
	private String bApellido;
	private String cTelefono;
	private String dDni;
	private String eEmail;
	private String fDirecion;
	private String password;

	public InsertarCliente(String aNombre, String bApellido, String cTelefono, String dDni, String eEmail,
			String fDirecion, String password) {
		super();
		this.aNombre = aNombre;
		this.bApellido = bApellido;
		this.cTelefono = cTelefono;
		this.dDni = dDni;
		this.eEmail = eEmail;
		this.fDirecion = fDirecion;
		this.password = password;
	}

	public String getaNombre() {
		return aNombre;
	}

	public void setaNombre(String aNombre) {
		this.aNombre = aNombre;
	}

	public String getbApellido() {
		return bApellido;
	}

	public void setbApellido(String bApellido) {
		this.bApellido = bApellido;
	}

	public String getcTelefono() {
		return cTelefono;
	}

	public void setcTelefono(String cTelefono) {
		this.cTelefono = cTelefono;
	}

	public String getdDni() {
		return dDni;
	}

	public void setdDni(String dDni) {
		this.dDni = dDni;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String getfDirecion() {
		return fDirecion;
	}

	public void setfDirecion(String fDirecion) {
		this.fDirecion = fDirecion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
