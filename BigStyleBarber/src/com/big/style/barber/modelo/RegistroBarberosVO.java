package com.big.style.barber.modelo;

import java.io.Serializable;
import java.util.Date;

import org.primefaces.model.UploadedFile;

import com.big.style.barber.dominio.BarberoDTO;

public class RegistroBarberosVO implements Serializable{
	public String nombreFoto;
	public byte[] foto;
	public BarberoDTO barberoDTO = new BarberoDTO();
	public Date ptHorarioIni;
	public Date ptHorarioFin;
	public String psNombre;
	public String psAPaterno;
	public String psAMaterno;
	public Integer piEdad;
	public Integer piServicio;
	public Integer piSucursal;
	public Integer piPuesto;
	public String psHorarioIni;
	public String psHorarioFin;
	public String psTelefono;
	public String psDireccion;
	public String psBiografia;
	public String psEmail;
	public boolean pbDiaDomingo;
	public boolean pbDiaLunes;
	public boolean pbDiaMartes;
	public boolean pbDiaMiercoles;
	public boolean pbDiaJueves;
	public boolean pbDiaViernes;
	public boolean pbDiaSabado;
	
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public boolean isPbDiaDomingo() {
		if(this.barberoDTO.getPiDiaDomingo() != null && this.barberoDTO.getPiDiaDomingo() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaDomingo(boolean pbDiaDomingo) {
		this.barberoDTO.setPiDiaDomingo(pbDiaDomingo ? 1 : 0);
	}
	public boolean isPbDiaLunes() {
		if(this.barberoDTO.getPiDiaDomingo() != null && this.barberoDTO.getPiDiaDomingo() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaLunes(boolean pbDiaLunes) {
		this.barberoDTO.setPiDiaLunes(pbDiaLunes ? 1 : 0);
	}
	public boolean isPbDiaMartes() {
		if(this.barberoDTO.getPiDiaMartes() != null && this.barberoDTO.getPiDiaMartes() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaMartes(boolean pbDiaMartes) {
		this.barberoDTO.setPiDiaMartes(pbDiaMartes ? 1 : 0);
	}
	public boolean isPbDiaMiercoles() {
		if(this.barberoDTO.getPiDiaMiercoles() != null && this.barberoDTO.getPiDiaMiercoles() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaMiercoles(boolean pbDiaMiercoles) {
		this.barberoDTO.setPiDiaMiercoles(pbDiaMiercoles ? 1 : 0);
	}
	public boolean isPbDiaJueves() {
		if(this.barberoDTO.getPiDiaJueves() != null && this.barberoDTO.getPiDiaJueves() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaJueves(boolean pbDiaJueves) {
		this.barberoDTO.setPiDiaJueves(pbDiaJueves ? 1 : 0);
	}
	public boolean isPbDiaViernes() {
		if(this.barberoDTO.getPiDiaViernes() != null && this.barberoDTO.getPiDiaViernes() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaViernes(boolean pbDiaViernes) {
		this.barberoDTO.setPiDiaViernes(pbDiaViernes ? 1 : 0);
	}
	public boolean isPbDiaSabado() {
		if(this.barberoDTO.getPiDiaSabado() != null && this.barberoDTO.getPiDiaSabado() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void setPbDiaSabado(boolean pbDiaSabado) {
		this.barberoDTO.setPiDiaSabado(pbDiaSabado ? 1 : 0);
	}
	
	
	public String getNombreFoto() {
		return nombreFoto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
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
	public String getPsEmail() {
		return psEmail;
	}
	public void setPsEmail(String psEmail) {
		this.psEmail = psEmail;
	}
	public String getPsBiografia() {
		return psBiografia;
	}
	public void setPsBiografia(String psBiografia) {
		this.psBiografia = psBiografia;
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
	
	public String getPsHorarioIni() {
		return psHorarioIni;
	}
	public void setPsHorarioIni(String psHorarioIni) {
		this.psHorarioIni = psHorarioIni;
	}
	public String getPsHorarioFin() {
		return psHorarioFin;
	}
	public void setPsHorarioFin(String psHorarioFin) {
		this.psHorarioFin = psHorarioFin;
	}
	
}
