package com.big.style.barber.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioBarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class ServicioBarberoDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2499250153956518756L;

	public void eliminarServicio(ServicioBarberoDTO poServicioBarbero) {
		GenericDAO.EliminarObjeto(poServicioBarbero);
	}
	
	public void insertarServicioBarbero(ServicioBarberoDTO poServicioBarbero) {				
			try {
				GenericDAO.GuardarObjeto(poServicioBarbero);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	public List<ServicioBarberoDTO> buscarServiciosBarberoEliminar(Integer piBarbero){
		String hql = RepositoriosConsultaHQL.BUSQUEDA_SERVICIOS_BARBERO_ELIMINAR;
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("piBarbero", piBarbero);
		
        List<ServicioBarberoDTO> lista = new ArrayList<ServicioBarberoDTO>();
        
        System.out.println(hql);
        
        lista = (List<ServicioBarberoDTO>) GenericDAO.buscarQuery(ServicioBarberoDTO.class, mapa, hql);               
        
        return lista;
	}		
	
	public List<ServicioDTO> buscarServiciosBarbero(Integer piBarbero){
		String hql = RepositoriosConsultaHQL.BUSQUEDA_SERVICIOS_BARBERO;
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("piBarbero", piBarbero);
		
        List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
        
        System.out.println(hql);
        
        lista = (List<ServicioDTO>) GenericDAO.buscarQuery(BarberoDTO.class, mapa, hql);               
        
        return lista;
	}		

}
