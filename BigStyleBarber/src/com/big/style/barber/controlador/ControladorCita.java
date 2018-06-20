package com.big.style.barber.controlador;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.map.MapModel;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dao.ServicioDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.dominio.SucursalDTO;
import com.big.style.barber.servicio.ServicioTareaBarbero;
import com.big.style.barber.servicio.ServicioTareaCita;

@ManagedBean(name = "controladorCita")
@ViewScoped
public class ControladorCita implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4019250179250642680L;
	
	String horarioCita;
	List<String> horarios;
	List<SucursalDTO> catSucursal;
	List<ServicioDTO> listaServicio;
	List<BarberoDTO> listaBarbero;
	CatalogoDAO catalogosDAO = new CatalogoDAO();
	ServicioDAO servicioDAO = new ServicioDAO();
	BarberoDAO barberoDAO = new BarberoDAO();
	CitaDTO poCita;
	String diasTrabajoBarbero;
	private MapModel simpleModel;
	private String coordenadasMapaSel;
	
	@PostConstruct
	private void init() {		
		System.out.println("init");
		catSucursal = catalogosDAO.getCatSucursales();		
		poCita = new CitaDTO();
	}
	
	public String onFlowProcess(FlowEvent event) {
		String newTab = event.getNewStep();
		switch (newTab) {
			case "servicioTab":{
				listaServicio = servicioDAO.obtenerServiciosPorSucursal(poCita.getPoSucursal().getPiIdSucursal());
				break;
			}
			case "barberoTab":{
				listaBarbero = barberoDAO.buscarBarberosSucursalServicio(poCita.getPoSucursal().piIdSucursal, poCita.getPoServicio().getPiIdServicioPk());
			}
			case "calendarioTab":{
				ServicioTareaCita servicioTareaCita = new ServicioTareaCita();
				ServicioTareaBarbero servicioTareaBarbero = new ServicioTareaBarbero();
				horarios = servicioTareaCita.generarHorarios(poCita.getPoSucursal().getPtHorarioApertura(), poCita.getPoSucursal().getPtHorarioCierre());
				diasTrabajoBarbero = servicioTareaBarbero.obtenerDias(poCita.getPoBarbero());
				RequestContext.getCurrentInstance().update("agendarCitaForm:diasTrabajo");
			}
		}
		return event.getNewStep();

    }
	
	public List<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
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

	public List<ServicioDTO> getListaServicio() {
		return listaServicio;
	}

	public void setListaServicio(List<ServicioDTO> listaServicio) {
		this.listaServicio = listaServicio;
	}

	public List<BarberoDTO> getListaBarbero() {
		return listaBarbero;
	}

	public void setListaBarbero(List<BarberoDTO> listaBarbero) {
		this.listaBarbero = listaBarbero;
	}

	public Date getHoy() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	public String getHorarioCita() {
		return horarioCita;
	}

	public void setHorarioCita(String horarioCita) {
		DateFormat df = new SimpleDateFormat("HH:mm a");
		try {
			this.poCita.setPtHora(df.parse(horarioCita));
		} catch (ParseException e) {
		}
	}

	public String getDiasTrabajoBarbero() {
		return diasTrabajoBarbero;
	}

	public void setDiasTrabajoBarbero(String diasTrabajoBarbero) {
		this.diasTrabajoBarbero = diasTrabajoBarbero;
	}	
	
	
}
