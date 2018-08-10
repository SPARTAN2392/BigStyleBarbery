package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bs_promocion_tab")
public class PromocionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6800977627559076140L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_promocion_pk")
	private Integer piIdPromocion;
	
	@Column(name="descripcion")
	private String psDescripcion;
	
	@Column(name="descripcion_corta")
	private String psDescripcionCorta;
	
	@Column(name="estado")
	private Integer piEstado;

	public Integer getPiIdPromocion() {
		return piIdPromocion;
	}

	public void setPiIdPromocion(Integer piIdPromocion) {
		this.piIdPromocion = piIdPromocion;
	}



	public String getPsDescripcion() {
		return psDescripcion;
	}

	public void setPsDescripcion(String psDescripcion) {
		this.psDescripcion = psDescripcion;
	}

	public String getPsDescripcionCorta() {
		return psDescripcionCorta;
	}

	public void setPsDescripcionCorta(String psDescripcionCorta) {
		this.psDescripcionCorta = psDescripcionCorta;
	}

	public Integer getPiEstado() {
		return piEstado;
	}

	public void setPiEstado(Integer piEstado) {
		this.piEstado = piEstado;
	}
	
	
}
