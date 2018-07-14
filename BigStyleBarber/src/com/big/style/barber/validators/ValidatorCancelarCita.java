package com.big.style.barber.validators;

import com.big.style.barber.dominio.CitaDTO;

public class ValidatorCancelarCita {

	public boolean validate(CitaDTO poCita) {
		if(
			(poCita.getPoCliente().getPsAliasCliente() == null || poCita.getPoCliente().getPsAliasCliente().isEmpty()) &&
			(poCita.getPoCliente().getPsCorreoCliente() == null || poCita.getPoCliente().getPsCorreoCliente().isEmpty())
				)
		{
			return true;
		}
		return false;
	}
	
}
