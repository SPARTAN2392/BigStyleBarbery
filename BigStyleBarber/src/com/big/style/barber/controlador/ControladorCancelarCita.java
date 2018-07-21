package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import com.big.style.barber.Mail.EmailSender;
import com.big.style.barber.dao.CitaDAO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.servicio.ServicioHTMLTemplate;
import com.big.style.barber.utils.MailEvent;
import com.big.style.barber.utils.MessageFactory;
import com.big.style.barber.validators.ValidatorCancelarCita;

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
	ValidatorCancelarCita validador = new ValidatorCancelarCita();
	
	@PostConstruct
	public void init() {
		poCita = new CitaDTO();
		resultados = new ArrayList<CitaDTO>();
		citaSelectEliminar = new CitaDTO();
	}
	
	public void cancelarCita() {
		citaSelectEliminar.setEstado(0);
		CitaDAO.EditarObjeto(citaSelectEliminar);
		MailEvent event = new MailEvent();
		event.setDireccionDestino(citaSelectEliminar.getPoCliente().getPsCorreoCliente());
		event.setAsunto("Cita Cancelada");
		ServicioHTMLTemplate serHtml = new ServicioHTMLTemplate();
		event.setCuerpoMensaje(serHtml.generarHTMLCancelarCita(citaSelectEliminar));
		try {
			EmailSender.generateAndSendEmail(event);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
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
		if(validador.validate(poCita)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe introducir al menos un Filtro"));
		}else {
			resultados = citaDAO.buscarCitasAliasMail(poCita);
		}				
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
