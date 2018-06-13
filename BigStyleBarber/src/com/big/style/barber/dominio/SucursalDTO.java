package com.big.style.barber.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_sucursal_cat")
public class SucursalDTO implements Serializable{

	@Id
	@Column(name = "id_sucursal_pk")
	public Integer piIdSucursal;
	
	@Column(name = "nombre_barberia")
	public String psNombreBarberia; 
	
	@Column(name = "direccion")
	public String psDireccion;
	
	@Column(name = "telefono")
	public String psTelefono;
	
	@Column(name = "horario")
	public String psHorario;
	
	@Column(name = "estado")
	public Integer piEstado;

	@Column(name = "coordenadas")
	public String psCoordenadas;
	
	public Integer getPiIdSucursal() {
		return piIdSucursal;
	}

	public void setPiIdSucursal(Integer piIdSucursal) {
		this.piIdSucursal = piIdSucursal;
	}

	public String getPsNombreBarberia() {
		return psNombreBarberia;
	}

	public void setPsNombreBarberia(String psNombreBarberia) {
		this.psNombreBarberia = psNombreBarberia;
	}

	public String getPsDireccion() {
		return psDireccion;
	}

	public void setPsDireccion(String psDireccion) {
		this.psDireccion = psDireccion;
	}

	public String getPsTelefono() {
		return psTelefono;
	}

	public void setPsTelefono(String psTelefono) {
		this.psTelefono = psTelefono;
	}

	public String getPsHorario() {
		return psHorario;
	}

	public void setPsHorario(String psHorario) {
		this.psHorario = psHorario;
	}

	public Integer getPiEstado() {
		return piEstado;
	}

	public void setPiEstado(Integer piEstado) {
		this.piEstado = piEstado;
	}

	public String getPsCoordenadas() {
		return psCoordenadas;
	}

	public void setPsCoordenadas(String psCoordenadas) {
		this.psCoordenadas = psCoordenadas;
	}
	
}
