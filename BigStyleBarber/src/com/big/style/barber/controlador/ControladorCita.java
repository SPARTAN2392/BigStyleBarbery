package com.big.style.barber.controlador;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.time.DateUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.MapModel;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dao.CatalogoDAO;
import com.big.style.barber.dao.CitaDAO;
import com.big.style.barber.dao.ServicioDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.CitaDTO;
import com.big.style.barber.dominio.ClienteDTO;
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
	CitaDAO citaDAO = new CitaDAO();
	BarberoDAO barberoDAO = new BarberoDAO();
	CitaDTO poCita;
	ClienteDTO poCliente;
	String diasTrabajoBarbero;
	boolean membresiaCliente;
	private MapModel simpleModel;
	private String coordenadasMapaSel;
	ServicioTareaCita servicioTareaCita = new ServicioTareaCita();
	
	@PostConstruct
	private void init() {		
		catSucursal = catalogosDAO.getCatSucursales();		
		poCita = new CitaDTO();
		poCliente = new ClienteDTO();
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
				break;
			}
			case "calendarioTab":{				
				ServicioTareaBarbero servicioTareaBarbero = new ServicioTareaBarbero();
				diasTrabajoBarbero = servicioTareaBarbero.obtenerDias(poCita.getPoBarbero());				
				
				
				horarios = servicioTareaCita.generarHorarios(poCita.getPoSucursal().getPtHorarioApertura(), poCita.getPoSucursal().getPtHorarioCierre(), citaDAO.buscarCitasDia(poCita, getHoy()));
				if(horarios.isEmpty()) {
					servicioTareaCita.generarFechaMinima();
				}else {
					
				}
				RequestContext.getCurrentInstance().update("agendarCitaForm:diasTrabajo");
				break;
			}
		}
		return event.getNewStep();

    }
	
	public void generarFechaMinimaYHorarios(String diasTrabajo) {
		Calendar util = Calendar.getInstance();		
		List<String> diasList = new ArrayList<String>();
		for(String a : diasTrabajo.split(",")) {
			diasList.add(a);
		}
		int diaHoy = util.getTime().getDay();
		if(!diasList.contains(String.valueOf(diaHoy))) {
			int diferenciaDias = 0;
			int diaProx = -1;
			
			if(diasList.size() > 1) {
				for(String dia : diasList) {
					int ref = Integer.parseInt(dia);
					diferenciaDias =  ref - diaHoy;
					if(diferenciaDias >= 0) {
						System.out.println("break");
						diaProx = ref;
						break;
					}
				}
				if(diaProx == -1) {
					System.out.println("-1");
					diaProx = Integer.parseInt(diasList.get(0));
				}
			}else {
				diferenciaDias =  Integer.parseInt(diasList.get(0)) - diaHoy;
				diaProx = Integer.parseInt(diasList.get(0));
			}
			
			System.out.println(diaProx + " " + diferenciaDias);
			
			if(diferenciaDias > 0) {
				util.add(Calendar.DATE, diferenciaDias);
			}else {
				util.add(Calendar.DATE, 7 +(diferenciaDias));				
			}
		}
		System.out.println(util.getTime());
	}
	
	public static void main(String[] args) {
		ControladorCita c = new ControladorCita();
		String diasTrabajo = "0,3";
		c.generarFechaMinimaYHorarios(diasTrabajo);
	}
	
	public void cambioDia(SelectEvent event) {
		Date date = (Date) event.getObject();
		horarios = servicioTareaCita.generarHorarios(poCita.getPoSucursal().getPtHorarioApertura(), poCita.getPoSucursal().getPtHorarioCierre(), citaDAO.buscarCitasDia(poCita, date));
	}
	
	public void agendar() {
		servicioTareaCita.insertarCita(poCita, poCliente);
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
		return DateUtils.truncate(c.getTime(), Calendar.DATE); 
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

	public ClienteDTO getPoCliente() {
		return poCliente;
	}

	public void setPoCliente(ClienteDTO poCliente) {
		this.poCliente = poCliente;
	}

	public boolean isMembresiaCliente() {
		return membresiaCliente;
	}

	public void setMembresiaCliente(boolean membresiaCliente) {
		this.poCliente.setPiMembresiaCliente((membresiaCliente)?1:0);
		this.membresiaCliente = membresiaCliente;
	}	
	
}
