package com.big.style.barber.planificador;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.big.style.barber.Mail.EmailSender;
import com.big.style.barber.dao.CitaDAO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.servicio.ServicioHTMLTemplate;
import com.big.style.barber.utils.MailEvent;

@Component
public class PlanificadorCorreosRecodatorio{

	public void monitorCorreoRecordatorio() {
		CitaDAO citaDAO = new CitaDAO();
		ServicioHTMLTemplate htmlSer = new ServicioHTMLTemplate();
		List<CitaDTO> list = citaDAO.buscarCitasRecordatorio(new Date());
		for(CitaDTO c : list) {
			MailEvent event = new MailEvent();
			event.setDireccionDestino(c.getPoCliente().getPsCorreoCliente());
			event.setAsunto("Recordatorio Cita Big Style Barbery");
			event.setCuerpoMensaje(htmlSer.generarHTMLRecordatorioCita(c));
			try {
				EmailSender.generateAndSendEmail(event);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Se ejecuto cron recordatorio");
	}
		
}
