package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.big.style.barber.dominio.PuestoDTO;

@ManagedBean
public class PuestoDAO {

	GenericDAO generico = new GenericDAO();
	
	public List<PuestoDTO> getPuestos() {
		
        List<PuestoDTO> listaPuestos = new ArrayList<PuestoDTO>();
        
        listaPuestos = (List<PuestoDTO>) GenericDAO.buscarTodos(PuestoDTO.class);
        
        return listaPuestos;
    }
	
}
