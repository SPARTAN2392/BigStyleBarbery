package com.big.style.barber.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.primefaces.model.StreamedContent;

import com.big.style.barber.dominio.BarberoDTO;

public class AdministracionBarberosVO implements Serializable{

	public String psNombre;
	public String psAPaterno;
	public String psAMaterno;
	public Integer piEdad;
	public Integer piServicio;
	public Integer piSucursal;
	public Integer piPuesto;
	public Date ptHorarioIni;
	public Date ptHorarioFin;	
	public BarberoDTO barberoDTO = new BarberoDTO();
	List<BarberoDTO> resultConsultaBarbero;
	public String nombreFoto;
	public byte[] foto;
	
	List<ResultadosBarberoVista> resultados;
	
	
	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<ResultadosBarberoVista> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadosBarberoVista> resultados) {
		this.resultados = resultados;
	}
	
	public String getPsNombre() {
		return psNombre;
	}
	public void setPsNombre(String psNombre) {
		this.psNombre = psNombre;
	}
	public String getPsAPaterno() {
		return psAPaterno;
	}
	public void setPsAPaterno(String psAPaterno) {
		this.psAPaterno = psAPaterno;
	}
	public String getPsAMaterno() {
		return psAMaterno;
	}
	public void setPsAMaterno(String psAMaterno) {
		this.psAMaterno = psAMaterno;
	}
	public Integer getPiEdad() {
		return piEdad;
	}
	public void setPiEdad(Integer piEdad) {
		this.piEdad = piEdad;
	}
	public Integer getPiServicio() {
		return piServicio;
	}
	public void setPiServicio(Integer piServicio) {
		this.piServicio = piServicio;
	}
	public Integer getPiSucursal() {
		return piSucursal;
	}
	public void setPiSucursal(Integer piSucursal) {
		this.piSucursal = piSucursal;
	}
	public Integer getPiPuesto() {
		return piPuesto;
	}
	public void setPiPuesto(Integer piPuesto) {
		this.piPuesto = piPuesto;
	}
	public Date getPtHorarioIni() {
		return ptHorarioIni;
	}
	public void setPtHorarioIni(Date ptHorarioIni) {
		this.ptHorarioIni = ptHorarioIni;
	}
	public Date getPtHorarioFin() {
		return ptHorarioFin;
	}
	public void setPtHorarioFin(Date ptHorarioFin) {
		this.ptHorarioFin = ptHorarioFin;
	}

	public BarberoDTO getBarberoDTO() {
		return barberoDTO;
	}
	public void setBarberoDTO(BarberoDTO barberoDTO) {
		this.barberoDTO = barberoDTO;
	}
	public List<BarberoDTO> getResultConsultaBarbero() {
		return resultConsultaBarbero;
	}
	public void setResultConsultaBarbero(List<BarberoDTO> resultConsultaBarbero) {
		this.resultConsultaBarbero = resultConsultaBarbero;
	}
	
}
