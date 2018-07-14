package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;

import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.PuestoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;
import com.big.style.barber.modelo.RegistroBarberosVO;
import com.big.style.barber.servicio.ServicioTareaBarbero;
import com.big.style.barber.utils.MessageFactory;

@ManagedBean(name = "controladorRegistroBarberos")
@ViewScoped
public class ControladorRegistroBarbero implements Serializable{

	ServicioTareaBarbero poServicioBarbero = new ServicioTareaBarbero();
	CatalogoDAO catalogosDAO = new CatalogoDAO();
	List<SucursalDTO> catSucursal;
	List<PuestoDTO> catPuesto;
	DualListModel<ServicioDTO> catServicio;
	List<BarberoDTO> resultConsultaBarbero;	
	RegistroBarberosVO registroBarberoVO = new RegistroBarberosVO();
	private List<String> dias;
	List<ServicioDTO> servicioSource;
	List<ServicioDTO> servicioTarget;
	
	private String[] selectedDias;
	
	@PostConstruct
	private void init() {
		
		servicioSource = new ArrayList<ServicioDTO>();
	    servicioTarget = new ArrayList<ServicioDTO>();
	    
	    servicioSource = catalogosDAO.getCatServicios(); 
	    
	    dias = new ArrayList<String>();
        dias.add("D");
        dias.add("L");
        dias.add("Ma");
        dias.add("Mi");
        dias.add("J");
        dias.add("V");
        dias.add("S");
	    
	    catServicio = new DualListModel<ServicioDTO>(servicioSource, servicioTarget);	  
	    catSucursal = catalogosDAO.getCatSucursales();
		catPuesto = catalogosDAO.getCatPuestos();
	}

	public void handleFileUpload(FileUploadEvent event) {
		System.out.println("archivo");
		System.out.println(event.getFile().getFileName());
		registroBarberoVO.setNombreFoto(event.getFile().getFileName());
		registroBarberoVO.setFoto(event.getFile().getContents());
    }
	
	public void limpiarCamposBarbero() {
		catServicio = new DualListModel<ServicioDTO>(servicioSource, servicioTarget);
		registroBarberoVO = new RegistroBarberosVO();
		selectedDias = new String[] {};
	}		
	
	public void registrarBarbero() {
		poServicioBarbero.insertarBarbero(registroBarberoVO, selectedDias, catServicio);
		limpiarCamposBarbero();
		MessageFactory.addMessage(FacesMessage.SEVERITY_INFO, "global_msg_creado", "Barbero");
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

	public DualListModel<ServicioDTO> getCatServicio() {
		return catServicio;
	}

	public void setCatServicio(DualListModel<ServicioDTO> catServicio) {
		this.catServicio = catServicio;
	}

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public String[] getSelectedDias() {
		return selectedDias;
	}

	public void setSelectedDias(String[] selectedDias) {
		this.selectedDias = selectedDias;
	}
	
	
}
