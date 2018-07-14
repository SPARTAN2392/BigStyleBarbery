package com.big.style.barber.servicio;

import java.util.List;

import org.primefaces.model.DualListModel;

import com.big.style.barber.dao.ServicioBarberoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioBarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;

public class ServicioTareaServicios {
	
	public ServicioBarberoDAO poSerServicioBarbero = new ServicioBarberoDAO(); 
	
	public void insertarServicios(DualListModel<ServicioDTO> poDualListServicios, BarberoDTO poBarbero) {
		List<ServicioDTO> selectedServicios = poDualListServicios.getTarget();
		for(ServicioDTO servicio: selectedServicios) {
			ServicioBarberoDTO poServicioBarbero = new ServicioBarberoDTO();
			poServicioBarbero.setPoServicio(servicio);
			poServicioBarbero.setPoBarbero(poBarbero);
			poSerServicioBarbero.insertarServicioBarbero(poServicioBarbero);
		}
	}

	public void eliminarServicios(Integer idBarbero) {
		for(ServicioBarberoDTO servicio:poSerServicioBarbero.buscarServiciosBarberoEliminar(idBarbero)) {
			poSerServicioBarbero.eliminarServicio(servicio);
		}
	}
	
	public void setPoSerServicioBarbero(ServicioBarberoDAO poSerServicioBarbero) {
		this.poSerServicioBarbero = poSerServicioBarbero;
	}
	
	
}
