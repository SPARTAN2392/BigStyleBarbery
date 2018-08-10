package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.List;

import com.big.style.barber.dominio.PromocionDTO;

public class PromocionDAO {

	public Integer insertarPromo(PromocionDTO poPromo) {		
		try {			
			poPromo.setPiEstado(1);
			return (Integer)GenericDAO.GuardarObjeto(poPromo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<PromocionDTO> buscarPromos() {
		
        List<PromocionDTO> listaPromo = new ArrayList<PromocionDTO>();
        
        listaPromo = (List<PromocionDTO>) GenericDAO.buscarTodos(PromocionDTO.class);
        
        return listaPromo;
    }
	
	public void editarPromo(PromocionDTO poPromo) {
		GenericDAO.EditarObjeto(poPromo);
	}
}
