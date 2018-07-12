package com.big.style.barber.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.ClienteDTO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class ClienteDAO implements Serializable{
	
	public Integer insertarCliente(ClienteDTO poCliente) {		
		try {			
			return (Integer)GenericDAO.GuardarObjeto(poCliente);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ClienteDTO> buscarClientePorEmail(String emailCliente){
		try {
			List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
			Map<String, Object> mapa = new HashMap<String, Object>();
			
			mapa.put("emailCliente", emailCliente);
			
			lista = (List<ClienteDTO>)GenericDAO.buscarQuery(ClienteDTO.class, mapa, RepositoriosConsultaHQL.BUSQUEDA_CLIENTES);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
