package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.dominio.SucursalDTO;

@ManagedBean(name = "controladorCita")
@ViewScoped
public class ControladorCita implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4019250179250642680L;
	
	List<SucursalDTO> catSucursal;
	CatalogoDAO catalogosDAO = new CatalogoDAO();
	CitaDTO poCita;
	private MapModel simpleModel;
	
	@PostConstruct
	private void init() {				
		catSucursal = catalogosDAO.getCatSucursales();		
		poCita = new CitaDTO();
		poCita.setPoSucursal(catSucursal.get(0));
	}

	public List<SucursalDTO> getCatSucursal() {
		return catSucursal;
	}

	public void setCatSucursal(List<SucursalDTO> catSucursal) {
		this.catSucursal = catSucursal;
	}

	public CitaDTO getPoCita() {
		return poCita;
	}

	public void setPoCita(CitaDTO poCita) {
		this.poCita = poCita;
	}

}
