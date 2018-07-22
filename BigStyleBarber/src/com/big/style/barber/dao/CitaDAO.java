package com.big.style.barber.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class CitaDAO extends GenericDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4259233269178038043L;

	@SuppressWarnings("unchecked")
	public List<CitaDTO> buscarCitasRecordatorio(Date dia){
		Date diaT = DateUtils.truncate(dia, Calendar.DATE);
		List<CitaDTO> lista = new ArrayList<CitaDTO>();
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("dia", diaT);
		
		lista = (List<CitaDTO>) GenericDAO.buscarQuery(CitaDTO.class, mapa, RepositoriosConsultaHQL.BUSQUEDA_CITAS_RECORDATORIO);
		
		return lista;
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<CitaDTO> buscarCitasAliasMail(CitaDTO poCita){
		List<CitaDTO> lista = new ArrayList<CitaDTO>();
		
		String query = RepositoriosConsultaHQL.BUSQUEDA_CITAS_CANCELAR;
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		if(poCita.getPoCliente().getPsAliasCliente() != null && !poCita.getPoCliente().getPsAliasCliente().equals("")) {
			query += RepositoriosConsultaHQL.BUSQUEDA_CITAS_ALIAS;
			mapa.put("alias", poCita.getPoCliente().getPsAliasCliente());
		}
		if(poCita.getPoCliente().getPsCorreoCliente() != null && !poCita.getPoCliente().getPsCorreoCliente().equals("")) {
			query += RepositoriosConsultaHQL.BUSQUEDA_CITAS_MAIL;
			mapa.put("mail", poCita.getPoCliente().getPsCorreoCliente());
		}				
		
		
		
		lista = (List<CitaDTO>) GenericDAO.buscarQuery(CitaDTO.class, mapa, query);

		return lista;
	}
	
	public Integer insertarCita(CitaDTO poCita) {
		try {			
			return (Integer)GenericDAO.GuardarObjeto(poCita);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;	
	}
	
}
