package com.big.style.barber.controlador;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import com.big.style.barber.dao.PuestoDAO;
import com.big.style.barber.dominio.PuestoBarberoDTO;

@ManagedBean(name = "puestosDTO")
@ViewScoped
public class PuestoControlador {

    private List<PuestoBarberoDTO> listaPuestos;

    @PostConstruct
    private void init() {
    	System.out.println("entro");
    	this.getListaVideojuegos();
    }
    
    public List<PuestoBarberoDTO> getListaVideojuegos() {
    	listaPuestos = PuestoDAO.getPuestos();
        return listaPuestos;
    }

	public List<PuestoBarberoDTO> getListaPuestos() {
		return listaPuestos;
	}

	public void setListaPuestos(List<PuestoBarberoDTO> listaPuestos) {
		this.listaPuestos = listaPuestos;
	}
	
}
