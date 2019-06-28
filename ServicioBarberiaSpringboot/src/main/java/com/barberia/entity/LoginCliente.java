package com.barberia.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginCliente {
	public String aDni;
	public String bPassword;

	public LoginCliente(String aDni, String bPassword) {
		super();
		this.aDni = aDni;
		this.bPassword = bPassword;
	}

	public String getaDni() {
		return aDni;
	}

	public void setaDni(String aDni) {
		this.aDni = aDni;
	}

	public String getbPassword() {
		return bPassword;
	}

	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}

}
