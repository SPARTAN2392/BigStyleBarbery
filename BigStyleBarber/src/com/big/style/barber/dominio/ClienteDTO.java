package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_cliente_tab")
public class ClienteDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6458366361937298175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente_pk")
	Integer piIdCliente;
	
	@Column(name = "nombre")
	public String psNombreCliente;
	
	@Column(name = "correo")
	public String psCorreoCliente;
	
	@Column(name = "telefono")
	public String psTelefonoCliente;
	
	@Column(name = "membresia")
	public Integer piMembresiaCliente;
	
	@Column(name = "ALIAS")
	public String psAliasCliente;
	
	@Column(name = "estado")
	public Integer piEstadoCliente;

	public Integer getPiIdCliente() {
		return piIdCliente;
	}

	public void setPiIdCliente(Integer piIdCliente) {
		this.piIdCliente = piIdCliente;
	}

	public String getPsNombreCliente() {
		return psNombreCliente;
	}

	public void setPsNombreCliente(String psNombreCliente) {
		this.psNombreCliente = psNombreCliente;
	}

	public String getPsCorreoCliente() {
		return psCorreoCliente;
	}

	public void setPsCorreoCliente(String psCorreoCliente) {
		this.psCorreoCliente = psCorreoCliente;
	}

	public String getPsTelefonoCliente() {
		return psTelefonoCliente;
	}

	public void setPsTelefonoCliente(String psTelefonoCliente) {
		this.psTelefonoCliente = psTelefonoCliente;
	}

	public Integer getPiMembresiaCliente() {
		return piMembresiaCliente;
	}

	public void setPiMembresiaCliente(Integer piMembresiaCliente) {
		this.piMembresiaCliente = piMembresiaCliente;
	}

	public String getPsAliasCliente() {
		return psAliasCliente;
	}

	public void setPsAliasCliente(String psAliasCliente) {
		this.psAliasCliente = psAliasCliente;
	}

	public Integer getPiEstadoCliente() {
		return piEstadoCliente;
	}

	public void setPiEstadoCliente(Integer piEstadoCliente) {
		this.piEstadoCliente = piEstadoCliente;
	}
	
	
}
