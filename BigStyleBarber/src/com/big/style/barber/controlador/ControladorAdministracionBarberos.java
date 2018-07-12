package com.big.style.barber.controlador;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.extensions.event.CloseEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dao.ServicioBarberoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.PuestoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;
import com.big.style.barber.modelo.ResultadosBarberoVista;
import com.big.style.barber.servicio.ServicioTareaBarbero;
import com.big.style.barber.validators.ValidatorAdminBarbero;

@ManagedBean(name = "controladorAdminBarberos")
@ViewScoped
public class ControladorAdministracionBarberos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6959301781722033481L;

	ValidatorAdminBarbero validadorAdminBar = new ValidatorAdminBarbero();
	
	CatalogoDAO catalogosDAO = new CatalogoDAO();
	List<SucursalDTO> catSucursal;
	List<PuestoDTO> catPuesto;
	
	List<ServicioDTO> servicioSource;
	
	DualListModel<ServicioDTO> catServicio;
	private List<String> dias;
	
	
	BarberoDAO barberoDAO = new BarberoDAO();
	AdministracionBarberosVO barberoVO;
	ResultadosBarberoVista barberoSeleccionado;
	ServicioTareaBarbero servicioTareaBarbero = new ServicioTareaBarbero();
	
	ServicioBarberoDAO servicioBarberoDAO = new ServicioBarberoDAO();
	
	@PostConstruct
	private void init() {		
		barberoVO = new AdministracionBarberosVO();
		barberoSeleccionado = new ResultadosBarberoVista();
		
		catSucursal = catalogosDAO.getCatSucursales();
		catPuesto = catalogosDAO.getCatPuestos();
		
		servicioSource = new ArrayList<ServicioDTO>();
	    
	    
	    servicioSource = catalogosDAO.getCatServicios(); 
	    catServicio = new DualListModel<ServicioDTO>(servicioSource, barberoVO.getServicioTarget());
		
	    dias = new ArrayList<String>();
        dias.add("D");
        dias.add("L");
        dias.add("Ma");
        dias.add("Mi");
        dias.add("J");
        dias.add("V");
        dias.add("S");	    		
	}		
	
	public void limpiarBusquedaForm() {
		barberoVO = new AdministracionBarberosVO();
		barberoSeleccionado = new ResultadosBarberoVista();	
		catServicio = new DualListModel<ServicioDTO>(servicioSource, barberoVO.getServicioTarget());
	}
	
	public void editarBarbero() {
		System.out.println("editar barbero");
		servicioTareaBarbero.editarBarbero(barberoSeleccionado);
		consultarBarberos();
	}
	
	public void consultaBarbero() {
		consultarBarberos();
	}
	
	public void consultarBarberos() {
		if(validadorAdminBar.validate(barberoVO,catServicio.getTarget())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe introducir al menos un Filtro"));
		}else {
			barberoVO.setResultConsultaBarbero(barberoDAO.buscarBarberos(barberoVO, catServicio.getTarget()));
			barberoVO.setResultados((new ArrayList<ResultadosBarberoVista>()));
			for(BarberoDTO barbero : barberoVO.getResultConsultaBarbero()) {
				ResultadosBarberoVista res = new ResultadosBarberoVista();
				res.setBarberoRes(barbero);
				if(barbero.getPoFoto() != null) {
					res.setRenderFoto(new DefaultStreamedContent(new ByteArrayInputStream(barbero.getPoFoto())));
				}else {
					res.setRenderFoto(new DefaultStreamedContent(FacesContext.getCurrentInstance()
					.getExternalContext()
					.getResourceAsStream("images/FotoDefault.png")));
				}
				barberoVO.getResultados().add(res);
			}	
		}
		
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		System.out.println("archivo");
		System.out.println(event.getFile().getFileName());
		barberoSeleccionado.setNombreFoto(event.getFile().getFileName());
		barberoSeleccionado.setFoto(event.getFile().getContents());
    }		
	
	 public void closeListener(CloseEvent closeEvent) {  
	      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Close fired",  
	               "Component id: " + closeEvent.getComponent().getId());  
	      FacesContext.getCurrentInstance().addMessage(null, msg);  
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

	public AdministracionBarberosVO getBarberoVO() {
		return barberoVO;
	}

	public void setBarberoVO(AdministracionBarberosVO barberoVO) {
		this.barberoVO = barberoVO;
	}

	public List<ServicioDTO> getServicioSource() {
		return servicioSource;
	}

	public void setServicioSource(List<ServicioDTO> servicioSource) {
		this.servicioSource = servicioSource;
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

	public ResultadosBarberoVista getBarberoSeleccionado() {
		return barberoSeleccionado;
	}

	public void setBarberoSeleccionado(ResultadosBarberoVista barberoSeleccionado) {
		barberoSeleccionado.setServicioTarget(servicioBarberoDAO.buscarServiciosBarbero(barberoSeleccionado.getBarberoRes().getPiIdBarbero()));
		List<ServicioDTO> serTarSel = new ArrayList<ServicioDTO>();
		
		for(ServicioDTO serSour : servicioSource) {
			for(ServicioDTO serTar :barberoSeleccionado.getServicioTarget()) {
				if(serSour.getPiIdServicioPk() != serTar.getPiIdServicioPk()) {
					serTarSel.add(serSour);
				}
			}
		}
		barberoSeleccionado.setServicioSource(serTarSel);
		if(barberoSeleccionado.getBarberoRes().getPiDiaDomingo() != null && barberoSeleccionado.getBarberoRes().getPiDiaDomingo() == 1) {
			barberoSeleccionado.getSelectedDias()[0] = "D";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaLunes() != null && barberoSeleccionado.getBarberoRes().getPiDiaLunes() == 1) {
			barberoSeleccionado.getSelectedDias()[1] = "L";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaMartes() != null && barberoSeleccionado.getBarberoRes().getPiDiaMartes() == 1) {
			barberoSeleccionado.getSelectedDias()[2] = "Ma";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaMiercoles() != null && barberoSeleccionado.getBarberoRes().getPiDiaMiercoles() == 1) {
			barberoSeleccionado.getSelectedDias()[3] = "Mi";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaJueves() != null && barberoSeleccionado.getBarberoRes().getPiDiaJueves() == 1) {
			barberoSeleccionado.getSelectedDias()[4] = "J";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaViernes() != null && barberoSeleccionado.getBarberoRes().getPiDiaViernes() == 1) {
			barberoSeleccionado.getSelectedDias()[5] = "V";
		}
		if(barberoSeleccionado.getBarberoRes().getPiDiaSabado() != null && barberoSeleccionado.getBarberoRes().getPiDiaSabado() == 1) {
			barberoSeleccionado.getSelectedDias()[6] = "S";
		}
		
		this.barberoSeleccionado = barberoSeleccionado;
	}


}
