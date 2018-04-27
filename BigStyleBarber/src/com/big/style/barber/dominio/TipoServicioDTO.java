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
	public Integer pÌIdTipoServicioPk;
	
	@Column(name = "tipo_servicio")
	public String psTipoServicio;

	public Integer getPÌIdTipoServicioPk() {
		return pÌIdTipoServicioPk;
	}

	public void setPÌIdTipoServicioPk(Integer pÌIdTipoServicioPk) {
		this.pÌIdTipoServicioPk = pÌIdTipoServicioPk;
	}

	public String getPsTipoServicio() {
		return psTipoServicio;
	}

	public void setPsTipoServicio(String psTipoServicio) {
		this.psTipoServicio = psTipoServicio;
	}
	
	
	
}
