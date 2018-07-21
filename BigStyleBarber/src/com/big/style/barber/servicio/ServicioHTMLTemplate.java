package com.big.style.barber.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.utils.ConstantesDominio;

public class ServicioHTMLTemplate {

	public String generarHTMLAgendarCita(CitaDTO poCita) {
		
		DateFormat dia = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm a");
		
		String html = ConstantesDominio.templateMailAgendarCita;
		
		html = html.replace("SucursalCita", poCita.getPoSucursal().getPsNombreBarberia());
		html = html.replace("BarberoCita", poCita.getPoBarbero().getPsNombreBarbero() + " " + poCita.getPoBarbero().getPsApellidoPaterno() + " " + poCita.getPoBarbero().getPsApellidoMaterno());
		html = html.replace("ServicioCita", poCita.getPoServicio().getPsNombreServicio());
		html = html.replace("DiaCita", dia.format(poCita.getPtDia()));
		html = html.replace("HorarioCita", hora.format(poCita.getPtHora()));
						
		return html;
	}
	
	public String generarHTMLCancelarCita(CitaDTO poCita) {
		
		DateFormat dia = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hora = new SimpleDateFormat("HH:mm a");
		
		String html = ConstantesDominio.templateMailCancelarCita;
		
		html = html.replace("diaCita", dia.format(poCita.getPtDia()));
		html = html.replace("horarioCita", hora.format(poCita.getPtHora()));
						
		return html;
	}
}
