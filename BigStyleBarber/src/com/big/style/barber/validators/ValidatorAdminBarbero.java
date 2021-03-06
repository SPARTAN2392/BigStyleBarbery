package com.big.style.barber.validators;

import java.util.List;

import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;

public class ValidatorAdminBarbero {

	public boolean validate(AdministracionBarberosVO adminBarberoVO, List<ServicioDTO> servicio) {
		
		if(
			(adminBarberoVO.getPsNombre() == null || adminBarberoVO.getPsNombre().isEmpty()) &&			
			(adminBarberoVO.getPsAPaterno() == null || adminBarberoVO.getPsAPaterno().isEmpty()) &&
			(adminBarberoVO.getPsAMaterno() == null || adminBarberoVO.getPsAMaterno().isEmpty()) &&
			(adminBarberoVO.getPiSucursal() == null || adminBarberoVO.getPiSucursal() == 0) &&
			(adminBarberoVO.getPiEdad() == null || adminBarberoVO.getPiEdad().equals(0)) &&
			(adminBarberoVO.getPiPuesto() == null || adminBarberoVO.getPiPuesto() == 0) &&
			adminBarberoVO.getPtHorarioEntradaIni() == null &&
			adminBarberoVO.getPtHorarioEntradaFin() == null &&
			adminBarberoVO.getPtHorarioSalidaIni() == null &&
			adminBarberoVO.getPtHorarioSalidaFin() == null &&
			adminBarberoVO.getSelectedDias().length == 0 &&
			servicio.size() == 0
				) {
			return true;
		}
		
		return false;
	}
	
}
