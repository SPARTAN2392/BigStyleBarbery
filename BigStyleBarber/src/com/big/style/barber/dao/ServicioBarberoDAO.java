package com.big.style.barber.dao;

import com.big.style.barber.dominio.ServicioBarberoDTO;

public class ServicioBarberoDAO {

	public void insertarServicioBarbero(ServicioBarberoDTO poServicioBarbero) {				
			try {
				GenericDAO.GuardarObjeto(poServicioBarbero);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
}
