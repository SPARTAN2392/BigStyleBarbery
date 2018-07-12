package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.big.style.barber.dao.CitaDAO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.utils.MessageFactory;

@ManagedBean(name="controladorCancelCita")
@ViewScoped
public class ControladorCancelarCita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5441772206308808485L;
	CitaDAO citaDAO = new CitaDAO();
	CitaDTO poCita;
	CitaDTO citaSelectEliminar;
	List<CitaDTO> resultados;
	
	@PostConstruct
	public void init() {
		poCita = new CitaDTO();
		resultados = new ArrayList<CitaDTO>();
		citaSelectEliminar = new CitaDTO();
	}
	
	public void cancelarCita() {
		citaSelectEliminar.setEstado(0);
		CitaDAO.EditarObjeto(citaSelectEliminar);
		consultaCitas();
		poCita = new CitaDTO();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Cita Cancelada Exitosamente"));
	}

	public void limpiarPantalla() {
		poCita = new CitaDTO();
		citaSelectEliminar = new CitaDTO();
		resultados = new ArrayList<CitaDTO>();
	}
	
	public void consultaCitas() {
		resultados = citaDAO.buscarCitasAliasMail(poCita);
	}
	
	public CitaDTO getPoCita() {
		return poCita;
	}

	public void setPoCita(CitaDTO poCita) {
		this.poCita = poCita;
	}

	public List<CitaDTO> getResultados() {
		return resultados;
	}

	public void setResultados(List<CitaDTO> resultados) {
		this.resultados = resultados;
	}

	public CitaDTO getCitaSelectEliminar() {
		return citaSelectEliminar;
	}

	public void setCitaSelectEliminar(CitaDTO citaSelectEliminar) {
		this.citaSelectEliminar = citaSelectEliminar;
	}		
}
