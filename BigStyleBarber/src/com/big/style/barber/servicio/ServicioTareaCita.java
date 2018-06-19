package com.big.style.barber.servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.big.style.barber.utils.ConstantesDominio;

public class ServicioTareaCita {
	
	

	DateFormat df = new SimpleDateFormat("HH:mm a");
	
	public List<String> generarHorarios(Date horaApertura, Date horaCierre) {
		
		List<String> resultado = new ArrayList<String>();
		
		Calendar c = Calendar.getInstance();
		c.setTime(horaApertura);				
				
		boolean continua = true;
		
		while(continua) {
			long horApe = c.getTimeInMillis();
			Date horaDespuesDeSuma = new Date(horApe + (45 * ConstantesDominio.UN_MINUTO));
			System.out.println(df.format(horaDespuesDeSuma));
			c.setTime(horaDespuesDeSuma);
			if(horaDespuesDeSuma.getHours() > horaCierre.getHours()) {
				continua = false;
			}else {
				resultado.add(df.format(horaDespuesDeSuma));
			}
		}		
		
		return resultado;
	}
	
	public static void main(String[] args) {
		ServicioTareaCita c = new ServicioTareaCita();
		
		Date apertura = new Date(2018, 5, 19, 8, 0);
		Date cierre = new Date(2018, 5, 19, 16, 0);
		
		c.generarHorarios(apertura, cierre);
	}
	
}
