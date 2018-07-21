package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.ParametroDTO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class ParametroDAO {

	@SuppressWarnings("unchecked")
	public ParametroDTO consultarParametro(String parametro) {
		
		List<ParametroDTO> resList = new ArrayList<ParametroDTO>();
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("claveParametro", parametro);
		
		resList = (List<ParametroDTO>)GenericDAO.buscarQuery(ParametroDTO.class, mapa, RepositoriosConsultaHQL.BUSQUEDA_PARAMETRO);
		
		if(!resList.isEmpty()) {
			return resList.get(0);
		}else{
			return null;
		}
		
	}
	
}
