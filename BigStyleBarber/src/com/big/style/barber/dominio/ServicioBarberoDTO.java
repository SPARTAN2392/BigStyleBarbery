package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bs_barbero_servicio_tab")
public class ServicioBarberoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1217836236630928489L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_barbero_servicio_pk")
	public Integer piIdServicioBarbero;
	
	@ManyToOne
	@JoinColumn(name = "servicio_fk")
	public ServicioDTO poServicio; 
	
	@ManyToOne
	@JoinColumn(name = "barbero_fk")
	public BarberoDTO poBarbero;

	public Integer getPiIdServicioBarbero() {
		return piIdServicioBarbero;
	}

	public void setPiIdServicioBarbero(Integer piIdServicioBarbero) {
		this.piIdServicioBarbero = piIdServicioBarbero;
	}

	public ServicioDTO getPoServicio() {
		return poServicio;
	}

	public void setPoServicio(ServicioDTO poServicio) {
		this.poServicio = poServicio;
	}

	public BarberoDTO getPoBarbero() {
		return poBarbero;
	}

	public void setPoBarbero(BarberoDTO poBarbero) {
		this.poBarbero = poBarbero;
	}
	
	
}
