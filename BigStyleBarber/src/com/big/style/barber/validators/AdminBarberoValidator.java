package com.big.style.barber.validators;

import com.big.style.barber.modelo.AdministracionBarberosVO;

public class AdminBarberoValidator {

	public boolean validate(AdministracionBarberosVO adminBarberoVO) {
		
		if(
			adminBarberoVO.getBarberoDTO().getPsNombreBarbero().isEmpty() &&			
			adminBarberoVO.getBarberoDTO().getPsApellidoPaterno().isEmpty() &&
			adminBarberoVO.getBarberoDTO().getPsApellidoMaterno().isEmpty() &&
			(adminBarberoVO.getBarberoDTO().getPoSucursalFk() == null || adminBarberoVO.getBarberoDTO().getPoSucursalFk().getPiIdSucursal() == null) &&
			adminBarberoVO.getBarberoDTO().getPiEdad().equals(0) &&
			(adminBarberoVO.getBarberoDTO().getPoPuestoFK() == null || adminBarberoVO.getBarberoDTO().getPoPuestoFK().getPiIdPuesto() == null) &&
			adminBarberoVO.getBarberoDTO().getPtHorarioI
				) {
			
		}
		
		return false;
	}
	
}
