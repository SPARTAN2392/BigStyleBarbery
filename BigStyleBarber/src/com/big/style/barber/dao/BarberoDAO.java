package com.big.style.barber.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;
import com.big.style.barber.modelo.AdministracionBarberosVO;
import com.big.style.barber.modelo.RegistroBarberosVO;
import com.big.style.barber.utils.RepositoriosConsultaHQL;

public class BarberoDAO implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5039346566599925953L;

	@SuppressWarnings("unchecked")
	public List<BarberoDTO> buscarBarberosSucursalServicio(Integer idSucursal, Integer idServicio){
		List<BarberoDTO> lista = new ArrayList<BarberoDTO>();
		
		Map<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("idSucursal", idSucursal);
		mapa.put("idServicio", idServicio);
		
		lista = (List<BarberoDTO>) GenericDAO.buscarQuery(BarberoDTO.class, mapa, RepositoriosConsultaHQL.BUSQUEDA_BARBEROS_POR_SUCURSAL_SERVICIO);
		
		return lista;
	}
	
	
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
		
		if(poAdminBarberos.getPtHorarioEntradaIni() != null && poAdminBarberos.getPtHorarioEntradaFin() != null) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_HORARIO_ENTRADA;
		}
		
		if(poAdminBarberos.getPtHorarioSalidaIni() != null && poAdminBarberos.getPtHorarioSalidaFin() != null) {
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_HORARIO_SALIDA;
		}
		
		if(servicios != null && !servicios.isEmpty()) {
			String idServicios = "";
			for(ServicioDTO ser : servicios) {
				idServicios += ser.getPiIdServicioPk() + ",";
			}
			idServicios = idServicios.substring(0, idServicios.length() - 1) + "))";
			hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_SERVICIO + idServicios;
		}
		if(poAdminBarberos.getSelectedDias() != null && poAdminBarberos.getSelectedDias().length > 0) {
			for(String dia:poAdminBarberos.getSelectedDias()) {
				switch (dia) {
					case "D":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_DOMINGO;
						break;
					}
					case "L":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_LUNES;				
						break;
					}
					case "Ma":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_MARTES;
						break;
					}
					case "Mi":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_MIERCOLES;
						break;
					}
					case "J":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_JUEVES;
						break;
					}
					case "V":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_VIERNES;
						break;
					}
					case "S":{
						hql += RepositoriosConsultaHQL.BUSQUEDA_BARBERO_WHERE_SABADO;
						break;
					}
				}
			}
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
		
		if(poAdminBarberos.getPtHorarioEntradaIni() != null && poAdminBarberos.getPtHorarioEntradaFin() != null) {
			mapa.put("horaEntradaIni", poAdminBarberos.getPtHorarioEntradaIni());
			mapa.put("horaEntradaFin", poAdminBarberos.getPtHorarioEntradaFin());
		}
		
		if(poAdminBarberos.getPtHorarioSalidaIni() != null && poAdminBarberos.getPtHorarioSalidaFin() != null) {
			mapa.put("horaSalidaIni", poAdminBarberos.getPtHorarioSalidaIni());
			mapa.put("horaSalidaFin", poAdminBarberos.getPtHorarioSalidaFin());
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
	
	public void editarBarbero(BarberoDTO poResultBarbero) {
		GenericDAO.EditarObjeto(poResultBarbero);
	}

}
