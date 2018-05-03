package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;

public class BarberoDAO {

@SuppressWarnings("unchecked")
public List<BarberoDTO> buscarBarberos(AdministracionBarberosVO poAdminBarberos) {
	
		Map<String, Object> mapa = generarMapa(poAdminBarberos);
		
        List<BarberoDTO> lista = new ArrayList<BarberoDTO>();
        
        lista = (List<BarberoDTO>) GenericDAO.buscarFiltro(BarberoDTO.class, mapa);
        
        return lista;
    }
	

	public Map<String, Object> generarMapa(AdministracionBarberosVO poAdminBarberos){
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		if(poAdminBarberos.getPsNombre() != null && !poAdminBarberos.getPsNombre().equals("")) {
			mapa.put("psNombreBarbero", poAdminBarberos.getPsNombre());
		}
		
		
		return mapa;
	}

}
