package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_parametro_tab")
public class ParametroDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5456324296500405569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_parametro")
	private Integer piIdParametro;
	
	@Column(name="clave")
	private String psClaveParametro;
	
	@Column(name="descripcion")
	private String psDescripcionParametro;
	
	@Column(name="valor")
	private String psValorParametro;
	
	@Column(name="estado")
	private Integer piEstado;

	public Integer getPiIdParametro() {
		return piIdParametro;
	}

	public void setPiIdParametro(Integer piIdParametro) {
		this.piIdParametro = piIdParametro;
	}

	public String getPsClaveParametro() {
		return psClaveParametro;
	}

	public void setPsClaveParametro(String psClaveParametro) {
		this.psClaveParametro = psClaveParametro;
	}

	public String getPsDescripcionParametro() {
		return psDescripcionParametro;
	}

	public void setPsDescripcionParametro(String psDescripcionParametro) {
		this.psDescripcionParametro = psDescripcionParametro;
	}

	public String getPsValorParametro() {
		return psValorParametro;
	}

	public void setPsValorParametro(String psValorParametro) {
		this.psValorParametro = psValorParametro;
	}

	public Integer getPiEstado() {
		return piEstado;
	}

	public void setPiEstado(Integer piEstado) {
		this.piEstado = piEstado;
	}
	
	
}
