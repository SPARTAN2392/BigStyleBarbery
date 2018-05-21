package com.big.style.barber.controlador;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
import com.big.style.barber.modelo.RegistroBarberosVO;
import com.big.style.barber.modelo.ResultadosBarberoVista;

@ManagedBean(name = "controladorAdminBarberos")
@ViewScoped
public class ControladorAdministracionBarberos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6959301781722033481L;

	CatalogoDAO catalogosDAO = new CatalogoDAO();
	List<SucursalDTO> catSucursal;
	List<PuestoDTO> catPuesto;
	
	List<ServicioDTO> servicioSource;
	List<ServicioDTO> servicioTarget;
	DualListModel<ServicioDTO> catServicio;
	private List<String> dias;
	private String[] selectedDias;
	
	BarberoDAO barberoDAO = new BarberoDAO();
	AdministracionBarberosVO barberoVO;
	ResultadosBarberoVista barberoSeleccionado;
	
	ServicioBarberoDAO servicioBarberoDAO = new ServicioBarberoDAO();
	
	@PostConstruct
	private void init() {		
		catSucursal = catalogosDAO.getCatSucursales();
		catPuesto = catalogosDAO.getCatPuestos();
		
		servicioSource = new ArrayList<ServicioDTO>();
	    servicioTarget = new ArrayList<ServicioDTO>();
	    
	    servicioSource = catalogosDAO.getCatServicios(); 
	    catServicio = new DualListModel<ServicioDTO>(servicioSource, servicioTarget);
		
	    dias = new ArrayList<String>();
        dias.add("D");
        dias.add("L");
        dias.add("Ma");
        dias.add("Mi");
        dias.add("J");
        dias.add("V");
        dias.add("S");
	    
		barberoVO = new AdministracionBarberosVO();
		barberoSeleccionado = new ResultadosBarberoVista();
	}		
	
	public void consultaBarbero() {
		System.out.println("entro controlador");
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
			
        System.out.println(barberoVO.getResultados().size());
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

	public List<ServicioDTO> getServicioTarget() {
		return servicioTarget;
	}

	public void setServicioTarget(List<ServicioDTO> servicioTarget) {
		this.servicioTarget = servicioTarget;
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
		this.barberoSeleccionado = barberoSeleccionado;
	}


}
