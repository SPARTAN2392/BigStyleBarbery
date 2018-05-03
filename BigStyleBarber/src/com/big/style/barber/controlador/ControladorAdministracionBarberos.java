package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.PuestoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;

@ManagedBean(name = "adminBarberosControlador")
@ViewScoped
public class ControladorAdministracionBarberos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6959301781722033481L;

	CatalogoDAO catalogosDAO = new CatalogoDAO();
	List<SucursalDTO> catSucursal;
	List<PuestoDTO> catPuesto;
	List<ServicioDTO> catServicio;
	List<BarberoDTO> resultConsultaBarbero;
	
	BarberoDAO barberoDAO = new BarberoDAO();
	AdministracionBarberosVO barberoVO;
	
	@PostConstruct
	private void init() {
		catSucursal = catalogosDAO.getCatSucursales();
		catPuesto = catalogosDAO.getCatPuestos();
		catServicio = catalogosDAO.getCatServicios();
		barberoVO = new AdministracionBarberosVO();
	}
	
	public void consultaBarbero() {
		System.out.println("entro controlador");
		resultConsultaBarbero = barberoDAO.buscarBarberos(barberoVO);
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

	public List<ServicioDTO> getCatServicio() {
		return catServicio;
	}

	public void setCatServicio(List<ServicioDTO> catServicio) {
		this.catServicio = catServicio;
	}

	public List<BarberoDTO> getResultConsultaBarbero() {
		return resultConsultaBarbero;
	}

	public void setResultConsultaBarbero(List<BarberoDTO> resultConsultaBarbero) {
		this.resultConsultaBarbero = resultConsultaBarbero;
	}

	
	
	
}
