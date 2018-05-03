package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.model.DualListModel;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.PuestoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;
import com.big.style.barber.modelo.RegistroBarberosVO;

@ManagedBean(name = "controladorRegistroBarberos")
@ViewScoped
public class ControladorRegistroBarbero implements Serializable{

	CatalogoDAO catalogosDAO = new CatalogoDAO();
	List<SucursalDTO> catSucursal;
	List<PuestoDTO> catPuesto;
	DualListModel<ServicioDTO> catServicio;
	List<BarberoDTO> resultConsultaBarbero;
	BarberoDAO barberoDAO = new BarberoDAO();
	RegistroBarberosVO registroBarberoVO = new RegistroBarberosVO();
	private List<SelectItem> dias;
	
	@PostConstruct
	private void init() {
		List<ServicioDTO> servicioSource = new ArrayList<ServicioDTO>();
	    List<ServicioDTO> servicioTarget = new ArrayList<ServicioDTO>();
	    
	    servicioSource = catalogosDAO.getCatServicios(); 
	    
	    catServicio = new DualListModel<ServicioDTO>(servicioSource, servicioTarget);	  
	    catSucursal = catalogosDAO.getCatSucursales();
		catPuesto = catalogosDAO.getCatPuestos();
	}

	public void registrarBarbero() {
		System.out.println("registrar");
		barberoDAO.insertarBarbero(registroBarberoVO);
		
	}
	
	public List<SucursalDTO> getCatSucursal() {
		return catSucursal;
	}

	public void setCatSucursal(List<SucursalDTO> catSucursal) {
		this.catSucursal = catSucursal;
	}

	public List<PuestoDTO> getCatPuesto() {
		return catPuesto;
	}

	public void setCatPuesto(List<PuestoDTO> catPuesto) {
		this.catPuesto = catPuesto;
	}

	public List<BarberoDTO> getResultConsultaBarbero() {
		return resultConsultaBarbero;
	}

	public void setResultConsultaBarbero(List<BarberoDTO> resultConsultaBarbero) {
		this.resultConsultaBarbero = resultConsultaBarbero;
	}

	public void setCatalogosDAO(CatalogoDAO catalogosDAO) {
		this.catalogosDAO = catalogosDAO;
	}

	public RegistroBarberosVO getRegistroBarberoVO() {
		return registroBarberoVO;
	}

	public void setRegistroBarberoVO(RegistroBarberosVO registroBarberoVO) {
		this.registroBarberoVO = registroBarberoVO;
	}

	public void setBarberoDAO(BarberoDAO barberoDAO) {
		this.barberoDAO = barberoDAO;
	}

	public DualListModel<ServicioDTO> getCatServicio() {
		return catServicio;
	}

	public void setCatServicio(DualListModel<ServicioDTO> catServicio) {
		this.catServicio = catServicio;
	}
	
	
}
