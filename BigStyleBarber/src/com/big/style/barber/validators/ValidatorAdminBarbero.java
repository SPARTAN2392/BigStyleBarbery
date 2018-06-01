package com.big.style.barber.validators;

import com.big.style.barber.modelo.AdministracionBarberosVO;

public class ValidatorAdminBarbero {

	public boolean validate(AdministracionBarberosVO adminBarberoVO) {
		
		if(
			(adminBarberoVO.getBarberoDTO().getPsNombreBarbero() == null || adminBarberoVO.getBarberoDTO().getPsNombreBarbero().isEmpty()) &&			
			(adminBarberoVO.getBarberoDTO().getPsApellidoPaterno() == null || adminBarberoVO.getBarberoDTO().getPsApellidoPaterno().isEmpty()) &&
			(adminBarberoVO.getBarberoDTO().getPsApellidoMaterno() == null || adminBarberoVO.getBarberoDTO().getPsApellidoMaterno().isEmpty()) &&
			(adminBarberoVO.getPiSucursal() == null || adminBarberoVO.getPiSucursal() == 0) &&
			(adminBarberoVO.getBarberoDTO().getPiEdad() == null || adminBarberoVO.getBarberoDTO().getPiEdad().equals(0)) &&
			(adminBarberoVO.getPiPuesto() == null || adminBarberoVO.getPiPuesto() == 0) &&
			adminBarberoVO.getPtHorarioEntradaIni() == null &&
			adminBarberoVO.getPtHorarioEntradaFin() == null &&
			adminBarberoVO.getPtHorarioSalidaIni() == null &&
			adminBarberoVO.getPtHorarioSalidaFin() == null &&
			adminBarberoVO.getSelectedDias().length == 0
				) {
			return true;
		}
		
		return false;
	}
	
}
