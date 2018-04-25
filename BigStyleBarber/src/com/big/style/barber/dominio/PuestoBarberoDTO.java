package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_puesto_barbero_cat")
public class PuestoBarberoDTO implements Serializable{
	
	@Id
	@Column(name = "ID_PUESTO_PK")
	public Integer piIdPuesto;
	
	@Column(name = "PUESTO")
	public String psPuesto;

	public Integer getPiIdPuesto() {
		return piIdPuesto;
	}

	public void setPiIdPuesto(Integer piIdPuesto) {
		this.piIdPuesto = piIdPuesto;
	}

	public String getPsPuesto() {
		return psPuesto;
	}

	public void setPsPuesto(String psPuesto) {
		this.psPuesto = psPuesto;
	}

	
}
