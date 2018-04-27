package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_tipo_servicio_cat")
public class TipoServicioDTO implements Serializable{

	@Id
	@Column(name = "id_tipo_servicio_pk")
	public Integer p�IdTipoServicioPk;
	
	@Column(name = "tipo_servicio")
	public String psTipoServicio;

	public Integer getP�IdTipoServicioPk() {
		return p�IdTipoServicioPk;
	}

	public void setP�IdTipoServicioPk(Integer p�IdTipoServicioPk) {
		this.p�IdTipoServicioPk = p�IdTipoServicioPk;
	}

	public String getPsTipoServicio() {
		return psTipoServicio;
	}

	public void setPsTipoServicio(String psTipoServicio) {
		this.psTipoServicio = psTipoServicio;
	}
	
	
	
}
