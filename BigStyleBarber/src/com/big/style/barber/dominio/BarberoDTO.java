package com.big.style.barber.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bs_barbero_tab")
public class BarberoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -67430180436373073L;

	@Id
	@Column(name = "id_barbero_pk")
	public Integer piIdBarbero;
	
	@Column(name = "nombre")
	public String psNombreBarbero;
	
	@Column(name = "biografia")
	public String psBiografia;
	
//	@Column(name = "fotografia")
	
	@Column(name = "estado")
	public Integer piEstado; 
	
	@ManyToOne
	@JoinColumn(name = "puesto_fk")
	public PuestoDTO poPuestoFK;
	
	@Column(name = "apellido_paterno")
	public String psApellidoPaterno;
	
	@Column(name = "apellido_materno")
	public String psApellidoMaterno;
	
	@Column(name = "edad")
	public Integer piEdad;
	
	@Column(name = "telefono")
	public String psTelefono;
	
	@Column(name = "direccion")
	public String psDireccion;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_fk")
	public SucursalDTO poSucursalFk;
	
	@Column(name = "horario_inicio")
	public Date ptHorarioInicio; 
	
	@Column(name = "horario_fin")
	public Date ptHorarioFin;
	
	@Column(name = "email")
	public String psEmail;
	
	@Column(name = "dia_domingo")
	public Integer piDiaDomingo;
	
	@Column(name = "dia_lunes")
	public Integer piDiaLunes;
	
	@Column(name = "dia_martes")
	public Integer piDiaMartes;
	
	@Column(name = "dia_miercoles")
	public Integer piDiaMiercoles;
	
	@Column(name = "dia_jueves")
	public Integer piDiaJueves;
	
	@Column(name = "dia_viernes")
	public Integer piDiaViernes;
	
	@Column(name = "dia_sabado")
	public Integer piDiaSabado;

	public Integer getPiIdBarbero() {
		return piIdBarbero;
	}

	public void setPiIdBarbero(Integer piIdBarbero) {
		this.piIdBarbero = piIdBarbero;
	}

	public String getPsNombreBarbero() {
		return psNombreBarbero;
	}

	public void setPsNombreBarbero(String psNombreBarbero) {
		this.psNombreBarbero = psNombreBarbero;
	}

	public String getPsBiografia() {
		return psBiografia;
	}

	public void setPsBiografia(String psBiografia) {
		this.psBiografia = psBiografia;
	}

	public Integer getPiEstado() {
		return piEstado;
	}

	public void setPiEstado(Integer piEstado) {
		this.piEstado = piEstado;
	}

	public PuestoDTO getPoPuestoFK() {
		return poPuestoFK;
	}

	public void setPoPuestoFK(PuestoDTO poPuestoFK) {
		this.poPuestoFK = poPuestoFK;
	}

	public String getPsApellidoPaterno() {
		return psApellidoPaterno;
	}

	public void setPsApellidoPaterno(String psApellidoPaterno) {
		this.psApellidoPaterno = psApellidoPaterno;
	}

	public String getPsApellidoMaterno() {
		return psApellidoMaterno;
	}

	public void setPsApellidoMaterno(String psApellidoMaterno) {
		this.psApellidoMaterno = psApellidoMaterno;
	}

	public Integer getPiEdad() {
		return piEdad;
	}

	public void setPiEdad(Integer piEdad) {
		this.piEdad = piEdad;
	}

	public String getPsTelefono() {
		return psTelefono;
	}

	public void setPsTelefono(String psTelefono) {
		this.psTelefono = psTelefono;
	}

	public String getPsDireccion() {
		return psDireccion;
	}

	public void setPsDireccion(String psDireccion) {
		this.psDireccion = psDireccion;
	}

	public SucursalDTO getPoSucursalFk() {
		return poSucursalFk;
	}

	public void setPoSucursalFk(SucursalDTO poSucursalFk) {
		this.poSucursalFk = poSucursalFk;
	}

	public Date getPtHorarioInicio() {
		return ptHorarioInicio;
	}

	public void setPtHorarioInicio(Date ptHorarioInicio) {
		this.ptHorarioInicio = ptHorarioInicio;
	}

	public Date getPtHorarioFin() {
		return ptHorarioFin;
	}

	public void setPtHorarioFin(Date ptHorarioFin) {
		this.ptHorarioFin = ptHorarioFin;
	}

	public String getPsEmail() {
		return psEmail;
	}

	public void setPsEmail(String psEmail) {
		this.psEmail = psEmail;
	}

	public Integer getPiDiaDomingo() {
		return piDiaDomingo;
	}

	public void setPiDiaDomingo(Integer piDiaDomingo) {
		this.piDiaDomingo = piDiaDomingo;
	}

	public Integer getPiDiaLunes() {
		return piDiaLunes;
	}

	public void setPiDiaLunes(Integer piDiaLunes) {
		this.piDiaLunes = piDiaLunes;
	}

	public Integer getPiDiaMartes() {
		return piDiaMartes;
	}

	public void setPiDiaMartes(Integer piDiaMartes) {
		this.piDiaMartes = piDiaMartes;
	}

	public Integer getPiDiaMiercoles() {
		return piDiaMiercoles;
	}

	public void setPiDiaMiercoles(Integer piDiaMiercoles) {
		this.piDiaMiercoles = piDiaMiercoles;
	}

	public Integer getPiDiaJueves() {
		return piDiaJueves;
	}

	public void setPiDiaJueves(Integer piDiaJueves) {
		this.piDiaJueves = piDiaJueves;
	}

	public Integer getPiDiaViernes() {
		return piDiaViernes;
	}

	public void setPiDiaViernes(Integer piDiaViernes) {
		this.piDiaViernes = piDiaViernes;
	}

	public Integer getPiDiaSabado() {
		return piDiaSabado;
	}

	public void setPiDiaSabado(Integer piDiaSabado) {
		this.piDiaSabado = piDiaSabado;
	}
	
	
}
