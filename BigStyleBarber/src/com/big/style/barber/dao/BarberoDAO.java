package com.big.style.barber.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;
import com.big.style.barber.modelo.RegistroBarberosVO;
import com.big.style.barber.servicio.ServicioTareaServicios;
import com.big.style.barber.utils.RepositoriosConsultaHQL;
import com.sun.org.apache.bcel.internal.generic.IUSHR;

public class BarberoDAO {

@SuppressWarnings("unchecked")
public List<BarberoDTO> buscarBarberos(AdministracionBarberosVO poAdminBarberos, List<ServicioDTO> servicios) {
	
		String hql = generaBusqueda(poAdminBarberos, servicios);
	
		Map<String, Object> mapa = generarMapa(poAdminBarberos);
		
        List<BarberoDTO> lista = new ArrayList<BarberoDTO>();
        
        System.out.println(hql);
        
        lista = (List<BarberoDTO>) GenericDAO.buscarQuery(BarberoDTO.class, mapa, hql);
        
        return lista;
    }
	
	public String generaBusqueda(AdministracionBarberosVO poAdminBarberos, List<ServicioDTO> servicios) {
		String hql = RepositoriosConsultaHQL.BUSQUEDA_BARBERO_SELECT;
		
		if(poAdminBarberos.getPsNombre() != null && !poAdminBarberos.getPsNombre().equals("")) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_NOMBRE;
		}		
		if(poAdminBarberos.getPsAPaterno() != null && !poAdminBarberos.getPsAPaterno().equals("")) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_APATERNO;
		}
		if(poAdminBarberos.getPsAMaterno() != null && !poAdminBarberos.getPsAMaterno().equals("")) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_AMATERNO;
		}
		if(poAdminBarberos.getPiEdad() != null && poAdminBarberos.getPiEdad() != 0) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_EDAD;
		}
		if(poAdminBarberos.getPiSucursal() != null && poAdminBarberos.getPiSucursal() != 0) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_SUCURSAL;
		}
		if(poAdminBarberos.getPiPuesto() != null && poAdminBarberos.getPiPuesto() != 0) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_PUESTO;
		}
		if(servicios != null && !servicios.isEmpty()) {
			String idServicios = "";
			for(ServicioDTO ser : servicios) {
				idServicios += ser.getPiIdServicioPk() + ",";
			}
			idServicios = idServicios.substring(0, idServicios.length() - 1) + "))";
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_SERVICIO + idServicios;
		}
		
		return hql;
	}

	public Map<String, Object> generarMapa(AdministracionBarberosVO poAdminBarberos){
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		if(poAdminBarberos.getPsNombre() != null && !poAdminBarberos.getPsNombre().equals("")) {
			mapa.put("psNombreBarbero", "%"+poAdminBarberos.getPsNombre()+"%");
		}		
		if(poAdminBarberos.getPsAPaterno() != null && !poAdminBarberos.getPsAPaterno().equals("")) {
			mapa.put("psApellidoPaterno", "%"+poAdminBarberos.getPsAPaterno()+"%");
		}
		if(poAdminBarberos.getPsAMaterno() != null && !poAdminBarberos.getPsAMaterno().equals("")) {
			mapa.put("psApellidoMaterno", "%"+poAdminBarberos.getPsAMaterno()+"%");
		}
		if(poAdminBarberos.getPiEdad() != null && poAdminBarberos.getPiEdad() != 0) {
			mapa.put("piEdad", poAdminBarberos.getPiEdad());
		}
		if(poAdminBarberos.getPiSucursal() != null && poAdminBarberos.getPiSucursal() != 0) {
			mapa.put("piIdSucursal", poAdminBarberos.getPiSucursal());
		}
		if(poAdminBarberos.getPiPuesto() != null && poAdminBarberos.getPiPuesto() != 0) {
			mapa.put("piIdSucursal", poAdminBarberos.getPiPuesto());
		}
		
		return mapa;
	}
	
	public Integer insertarBarbero(RegistroBarberosVO poRegistroBarbero) {
		try {			
			return (Integer)GenericDAO.GuardarObjeto(poRegistroBarbero.getBarberoDTO());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
	}

}
