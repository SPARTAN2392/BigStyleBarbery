package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.List;

import com.big.style.barber.dominio.PuestoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;

@SuppressWarnings("unchecked")
public class CatalogoDAO {

GenericDAO generico = new GenericDAO();
	
	public List<SucursalDTO> getCatSucursales() {
		
        List<SucursalDTO> lista = new ArrayList<SucursalDTO>();
        
        lista = (List<SucursalDTO>) GenericDAO.buscarTodos(SucursalDTO.class);
        
        return lista;
    }
	
	public List<ServicioDTO> getCatServicios() {
		
        List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
        
        lista = (List<ServicioDTO>) GenericDAO.buscarTodos(ServicioDTO.class);
        
        return lista;
    }

	public List<PuestoDTO> getCatPuestos() {
		
	    List<PuestoDTO> lista = new ArrayList<PuestoDTO>();
	    
	    lista = (List<PuestoDTO>) GenericDAO.buscarTodos(PuestoDTO.class);
	    
	    return lista;
	}
	
}
