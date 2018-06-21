package com.big.style.barber.dao;

import com.big.style.barber.dominio.ClienteDTO;

public class ClienteDAO {
	
	public Integer insertarCliente(ClienteDTO poCliente) {		
		try {			
			return (Integer)GenericDAO.GuardarObjeto(poCliente);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
