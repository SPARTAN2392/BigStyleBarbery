package com.big.style.barber.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.big.style.barber.Mail.EmailSender;
import com.big.style.barber.dao.CitaDAO;
import com.big.style.barber.dao.ClienteDAO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.dominio.ClienteDTO;
import com.big.style.barber.utils.ConstantesDominio;
import com.big.style.barber.utils.MailEvent;

public class ServicioTareaCita {
		
	DateFormat df = new SimpleDateFormat("HH:mm a");
	ClienteDAO clienteDAO = new ClienteDAO();
	CitaDAO citaDAO = new CitaDAO();
	Date fechaMinima;		
	
	public Date generarFechaMinima() {		
		return null;
	}
	
	public boolean insertarCita(CitaDTO poCita, ClienteDTO poCliente) {				
		
		Integer respuestaCliente = 0;
		
		if(clienteDAO.buscarClientePorEmail(poCliente.getPsCorreoCliente()).isEmpty()) {			
			poCliente.setPiEstadoCliente(1);
			respuestaCliente = clienteDAO.insertarCliente(poCliente);
		}else {
			respuestaCliente = 1;
		}
				
		if(respuestaCliente != 0) {
			poCliente.setPiIdCliente(respuestaCliente);
			poCita.setPoCliente(poCliente);
			poCita.setEstado(1);
			citaDAO.insertarCita(poCita);
		}
		
		MailEvent event = new MailEvent();
		ServicioHTMLTemplate htmlSer = new ServicioHTMLTemplate();
		event.setDireccionDestino(poCliente.getPsCorreoCliente());
		event.setAsunto("Correo Cita");
		event.setCuerpoMensaje(htmlSer.generarHTMLAgendarCita(poCita));
		
		try {
			EmailSender.generateAndSendEmail(event);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return false;
	}
	
	public List<String> generarHorarios(Date horaApertura, Date horaCierre, Map<Date,Integer> citasOcupadas) {
		
		List<String> resultado = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, horaApertura.getHours());
		c.set(Calendar.MINUTE, horaApertura.getMinutes());
		
		System.out.println(c.getTime());
				
		boolean continua = true;
		boolean compruebaContinuidad = false;
		Integer duracionCita = 0;
		Date horaDespuesDeSuma = horaApertura;	
		
		while(continua) {
			long horApe = c.getTimeInMillis();			
			
			if(compruebaContinuidad) {
				Calendar horaCita = Calendar.getInstance();
				horaCita.setTime(new Date(horApe + (duracionCita * ConstantesDominio.UN_MINUTO)));

				if(c.before(horaCita)) {
					duracionCita -= 45;
					compruebaContinuidad = true;
					continue;
				}else {
					compruebaContinuidad = false;
					horaDespuesDeSuma = new Date(horApe + ((citasOcupadas.get(horaDespuesDeSuma)) * ConstantesDominio.UN_MINUTO));
					citasOcupadas.remove(horaDespuesDeSuma);										
				}
			}						
			
			if(citasOcupadas.containsKey(horaDespuesDeSuma)) {
				duracionCita = citasOcupadas.get(horaDespuesDeSuma);
				compruebaContinuidad = true;
				continue;
			}					
			if(horaDespuesDeSuma.getTime() >= horaCierre.getTime()) {
				continua = false;
			}else {				
				resultado.add(df.format(horaDespuesDeSuma));
				horaDespuesDeSuma = new Date(horaDespuesDeSuma.getTime() + (45 * ConstantesDominio.UN_MINUTO));
			}
			
						
			c.setTime(horaDespuesDeSuma);
		}		
		
		return resultado;
	}
	
	
}
