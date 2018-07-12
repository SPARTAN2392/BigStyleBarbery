package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bs_servicio_tab")
public class ServicioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4068030211851044997L;

	@Id
	@Column(name = "id_servicio_pk")
	public Integer piIdServicioPk;
	
	@Column(name = "nombre")
	public String psNombreServicio;
	
	@Column(name = "costo")
	public Integer piCosto; 
	
	@Column(name = "descripcion")
	public String psDescripcion;
	
	@Column(name = "tiempo")
	public Integer piTiempo;
	
	@ManyToOne
	@JoinColumn(name = "tipo_servicio_fk")
	public TipoServicioDTO poTipoServicioFk;
	
	@Column(name = "estado")
	public Integer piEstado;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_fk")
	public SucursalDTO poSucursalFk;

	public Integer getPiIdServicioPk() {
		return piIdServicioPk;
	}

	public void setPiIdServicioPk(Integer piIdServicioPk) {
		this.piIdServicioPk = piIdServicioPk;
	}

	public String getPsNombreServicio() {
		return psNombreServicio;
	}

	public void setPsNombreServicio(String psNombreServicio) {
		this.psNombreServicio = psNombreServicio;
	}

	public Integer getPiCosto() {
		return piCosto;
	}

	public void setPiCosto(Integer piCosto) {
		this.piCosto = piCosto;
	}

	public String getPsDescripcion() {
		return psDescripcion;
	}

	public void setPsDescripcion(String psDescripcion) {
		this.psDescripcion = psDescripcion;
	}

	public Integer getPiTiempo() {
		return piTiempo;
	}

	public void setPiTiempo(Integer piTiempo) {
		this.piTiempo = piTiempo;
	}

	public TipoServicioDTO getPoTipoServicioFk() {
		return poTipoServicioFk;
	}

	public void setPoTipoServicioFk(TipoServicioDTO poTipoServicioFk) {
		this.poTipoServicioFk = poTipoServicioFk;
	}

	public Integer getPiEstado() {
		return piEstado;
	}

	public void setPiEstado(Integer piEstado) {
		this.piEstado = piEstado;
	}

	public SucursalDTO getPoSucursalFk() {
		return poSucursalFk;
	}

	public void setPoSucursalFk(SucursalDTO poSucursalFk) {
		this.poSucursalFk = poSucursalFk;
	}
	
	
	
}
