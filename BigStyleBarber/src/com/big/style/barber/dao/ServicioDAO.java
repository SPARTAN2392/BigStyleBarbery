package com.big.style.barber.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.ServicioDTO;

public class ServicioDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4778078672081267268L;
	GenericDAO generico = new GenericDAO();
	
	public List<ServicioDTO> obtenerServiciosPorSucursal(Integer idSucursal){
		Map<String,Object> mapa = new HashMap<String,Object>();
		mapa.put("poSucursalFk.piIdSucursal", idSucursal);
		List<ServicioDTO> resultado = (List<ServicioDTO>)generico.buscarFiltro(ServicioDTO.class, mapa);
		return resultado;
	}
}
