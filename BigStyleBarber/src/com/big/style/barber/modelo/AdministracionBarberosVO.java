package com.big.style.barber.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.primefaces.model.StreamedContent;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;

public class AdministracionBarberosVO implements Serializable{

	public String psNombre;
	public String psAPaterno;
	public String psAMaterno;
	public Integer piEdad;
	public Integer piServicio;
	public Integer piSucursal;
	public Integer piPuesto;
	public Date ptHorarioEntradaIni;
	public Date ptHorarioEntradaFin;
	public Date ptHorarioSalidaIni;
	public Date ptHorarioSalidaFin;
	public BarberoDTO barberoDTO = new BarberoDTO();
	List<BarberoDTO> resultConsultaBarbero;
	public String nombreFoto;
	public byte[] foto;
	private String[] selectedDias = new String[] {};
	List<ServicioDTO> servicioTarget = new ArrayList<ServicioDTO>();
	
	List<ResultadosBarberoVista> resultados;
	
	
	
	public String[] getSelectedDias() {
		return selectedDias;
	}

	public void setSelectedDias(String[] selectedDias) {
		this.selectedDias = selectedDias;
	}

	public List<ServicioDTO> getServicioTarget() {
		return servicioTarget;
	}

	public void setServicioTarget(List<ServicioDTO> servicioTarget) {
		this.servicioTarget = servicioTarget;
	}

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

	public Date getPtHorarioEntradaIni() {
		return ptHorarioEntradaIni;
	}

	public void setPtHorarioEntradaIni(Date ptHorarioEntradaIni) {
		this.ptHorarioEntradaIni = ptHorarioEntradaIni;
	}

	public Date getPtHorarioEntradaFin() {
		return ptHorarioEntradaFin;
	}

	public void setPtHorarioEntradaFin(Date ptHorarioEntradaFin) {
		this.ptHorarioEntradaFin = ptHorarioEntradaFin;
	}

	public Date getPtHorarioSalidaIni() {
		return ptHorarioSalidaIni;
	}

	public void setPtHorarioSalidaIni(Date ptHorarioSalidaIni) {
		this.ptHorarioSalidaIni = ptHorarioSalidaIni;
	}

	public Date getPtHorarioSalidaFin() {
		return ptHorarioSalidaFin;
	}

	public void setPtHorarioSalidaFin(Date ptHorarioSalidaFin) {
		this.ptHorarioSalidaFin = ptHorarioSalidaFin;
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
