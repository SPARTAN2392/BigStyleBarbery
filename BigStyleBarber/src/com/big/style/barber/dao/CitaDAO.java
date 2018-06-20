package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class CitaDAO {

	@SuppressWarnings("unchecked")
	public Map<Date,Integer> buscarCitasDia(CitaDTO poCita, Date dia){
		List<CitaDTO> lista = new ArrayList<CitaDTO>();
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("idBarbero", poCita.getPoBarbero().getPiIdBarbero());
		mapa.put("idSucursal", poCita.getPoSucursal().getPiIdSucursal());
		mapa.put("dia", dia);
		
		lista = (List<CitaDTO>) GenericDAO.buscarQuery(CitaDTO.class, mapa, RepositoriosConsultaHQL.BUSQUEDA_CITAS);
		
		Map<Date,Integer> horarioDuracion = new HashMap<Date,Integer>();
		
		for(CitaDTO cita: lista) {
			horarioDuracion.put(cita.getPtHora(), cita.getPoServicio().getPiTiempo());
		}
		
		return horarioDuracion;
	}
	
}
