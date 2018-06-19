package com.big.style.barber.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bs_cita_tab")
public class CitaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9212427188290979786L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita_pk")
	public Integer piIdCita;
	
	@ManyToOne
	@JoinColumn(name = "barbero_fk")
	public BarberoDTO poBarbero = new BarberoDTO();
	
	@ManyToOne
	@JoinColumn(name = "servicio_fk")
	public ServicioDTO poServicio = new ServicioDTO();
	
	@ManyToOne
	@JoinColumn(name = "sucursal_fk")
	public SucursalDTO poSucursal = new SucursalDTO();

	@Column(name = "dia")
	public Date ptDia;
	
	@Column(name = "hora")
	public Date ptHora;
	
	public Integer getPiIdCita() {
		return piIdCita;
	}

	public void setPiIdCita(Integer piIdCita) {
		this.piIdCita = piIdCita;
	}

	public BarberoDTO getPoBarbero() {
		return poBarbero;
	}

	public void setPoBarbero(BarberoDTO poBarbero) {
		this.poBarbero = poBarbero;
	}

	public ServicioDTO getPoServicio() {
		return poServicio;
	}

	public void setPoServicio(ServicioDTO poServicio) {
		this.poServicio = poServicio;
	}

	public SucursalDTO getPoSucursal() {
		return poSucursal;
	}

	public void setPoSucursal(SucursalDTO poSucursal) {
		this.poSucursal = poSucursal;
	}

	public Date getPtDia() {
		return ptDia;
	}

	public void setPtDia(Date ptDia) {
		this.ptDia = ptDia;
	}

	public Date getPtHora() {
		return ptHora;
	}

	public void setPtHora(Date ptHora) {
		this.ptHora = ptHora;
	}
	
}
