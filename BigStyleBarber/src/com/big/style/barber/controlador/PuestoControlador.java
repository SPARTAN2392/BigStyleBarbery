package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.big.style.barber.dao.PuestoDAO;
import com.big.style.barber.dominio.PuestoDTO;

@ManagedBean(name = "puestosDTO")
@ViewScoped
public class PuestoControlador implements Serializable{

    private List<PuestoDTO> listaPuestos;

    PuestoDAO puestoDAO;
    
    @PostConstruct
    private void init() {
    	System.out.println("entro");
    	puestoDAO = new PuestoDAO();
    	this.getListaVideojuegos();
    }
    
    public List<PuestoDTO> getListaVideojuegos() {
    	listaPuestos = puestoDAO.getPuestos();
        return listaPuestos;
    }

	public List<PuestoDTO> getListaPuestos() {
		return listaPuestos;
	}

	public void setListaPuestos(List<PuestoDTO> listaPuestos) {
		this.listaPuestos = listaPuestos;
	}
	
}
