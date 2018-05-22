package com.big.style.barber.servicio;

import org.primefaces.model.DualListModel;

import com.big.style.barber.dao.BarberoDAO;
import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.modelo.RegistroBarberosVO;
import com.big.style.barber.modelo.ResultadosBarberoVista;

public class ServicioTareaBarbero {
	
	BarberoDAO barberoDAO = new BarberoDAO();
	ServicioTareaServicios poServicioTareaServicios = new ServicioTareaServicios();
	
	public void editarBarbero(ResultadosBarberoVista poResultadoVista) {
		ajustarDiasEditar(poResultadoVista);
		if(poResultadoVista.getNombreFoto() != null && !poResultadoVista.getNombreFoto().equals("")) {
			poResultadoVista.getBarberoRes().setPoFoto(poResultadoVista.getFoto());
		}
		barberoDAO.editarBarbero(poResultadoVista.getBarberoRes());
	}
	
	public void ajustarDiasEditar(ResultadosBarberoVista poResultVista) {
		for(String dia:poResultVista.getSelectedDias()) {
			switch (dia) {
				case "D":{
					poResultVista.getBarberoRes().setPiDiaDomingo(1);
					break;
				}
				case "L":{
					poResultVista.getBarberoRes().setPiDiaLunes(1);				
					break;
				}
				case "Ma":{
					poResultVista.getBarberoRes().setPiDiaMartes(1);
					break;
				}
				case "Mi":{
					poResultVista.getBarberoRes().setPiDiaMiercoles(1);
					break;
				}
				case "J":{
					poResultVista.getBarberoRes().setPiDiaJueves(1);
					break;
				}
				case "V":{
					poResultVista.getBarberoRes().setPiDiaViernes(1);
					break;
				}
				case "S":{
					poResultVista.getBarberoRes().setPiDiaSabado(1);
					break;
				}
			}
		}
	}
	
	public void insertarBarbero(RegistroBarberosVO poRegistroBarbero, String[] dias, DualListModel<ServicioDTO> poDualListServicios) {		
		BarberoDTO res = new BarberoDTO();
		ajustarDias(poRegistroBarbero, dias);
		poRegistroBarbero.getBarberoDTO().setPoFoto(poRegistroBarbero.getFoto());
		poRegistroBarbero.getBarberoDTO().setPiEstado(1);
		res.setPiIdBarbero(barberoDAO.insertarBarbero(poRegistroBarbero));
		poServicioTareaServicios.insertarServicios(poDualListServicios, res);
	}
	
	public void ajustarDias(RegistroBarberosVO registroBarberoVO, String[] selectedDias) {
		for(String dia:selectedDias) {
			switch (dia) {
				case "D":{
					registroBarberoVO.getBarberoDTO().setPiDiaDomingo(1);
					break;
				}
				case "L":{
					registroBarberoVO.getBarberoDTO().setPiDiaLunes(1);				
					break;
				}
				case "Ma":{
					registroBarberoVO.getBarberoDTO().setPiDiaMartes(1);
					break;
				}
				case "Mi":{
					registroBarberoVO.getBarberoDTO().setPiDiaMiercoles(1);
					break;
				}
				case "J":{
					registroBarberoVO.getBarberoDTO().setPiDiaJueves(1);
					break;
				}
				case "V":{
					registroBarberoVO.getBarberoDTO().setPiDiaViernes(1);
					break;
				}
				case "S":{
					registroBarberoVO.getBarberoDTO().setPiDiaSabado(1);
					break;
				}
			}
		}
	}
	
	public void setBarberoDAO(BarberoDAO barberoDAO) {
		this.barberoDAO = barberoDAO;
	}
}
