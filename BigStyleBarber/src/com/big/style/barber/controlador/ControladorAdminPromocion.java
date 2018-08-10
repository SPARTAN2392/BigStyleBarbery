package com.big.style.barber.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.big.style.barber.dao.PromocionDAO;
import com.big.style.barber.dominio.PromocionDTO;

@ManagedBean(name="controladorAdminPromo")
@ViewScoped
public class ControladorAdminPromocion implements Serializable{

	private PromocionDTO poPromo;
	private List<PromocionDTO> promoList;
	
	@PostConstruct
	public void init() {
		poPromo = new PromocionDTO();
		consultar();
	}
	
	public void agregarPromo() {
		System.out.println("llega controlador");
		PromocionDAO promoDAO = new PromocionDAO();
		promoDAO.insertarPromo(poPromo);
	}
	
	public void consultar() {
		PromocionDAO dao = new PromocionDAO();
		promoList = dao.buscarPromos();
	}
	
	public void limpiarPantalla() {
		System.out.println("limpiar");
		poPromo = new PromocionDTO();	
	}

	public void editarPromo(RowEditEvent event) {
		PromocionDTO obj = (PromocionDTO)event.getObject();
		PromocionDAO dao = new PromocionDAO();
		dao.editarPromo(obj);
		consultar();
	}
	
	public PromocionDTO getPoPromo() {
		return poPromo;
	}

	public void setPoPromo(PromocionDTO poPromo) {
		this.poPromo = poPromo;
	}

	public List<PromocionDTO> getPromoList() {
		return promoList;
	}

	public void setPromoList(List<PromocionDTO> promoList) {
		this.promoList = promoList;
	}
	
	
}
