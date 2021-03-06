package com.big.style.barber.utils;

public interface RepositoriosConsultaHQL {
		
	public static final String BUSQUEDA_BARBERO_SELECT = "FROM BarberoDTO bar WHERE 1 = 1 ";
	public static final String BUSQUEDA_BARBERO_WHERE_NOMBRE= " AND bar.psNombreBarbero LIKE :psNombreBarbero";
	public static final String BUSQUEDA_BARBERO_WHERE_APATERNO = " AND bar.psApellidoPaterno LIKE :psApellidoPaterno";
	public static final String BUSQUEDA_BARBERO_WHERE_AMATERNO= " AND bar.psApellidoMaterno LIKE :psApellidoMaterno";
	public static final String BUSQUEDA_BARBERO_WHERE_EDAD = " AND bar.piEdad = :piEdad";
	public static final String BUSQUEDA_BARBERO_WHERE_SUCURSAL = " AND bar.poSucursalFk.piIdSucursal = :piIdSucursal";
	public static final String BUSQUEDA_BARBERO_WHERE_PUESTO = " AND bar.poPuestoFK.piIdPuesto = :piIdPuesto";
	public static final String BUSQUEDA_BARBERO_HORARIO_ENTRADA = " AND bar.ptHorarioInicio BETWEEN :horaEntradaIni AND :horaEntradaFin";
	public static final String BUSQUEDA_BARBERO_HORARIO_SALIDA = " AND bar.ptHorarioSalida BETWEEN :horaSalidaIni AND :horaSalidaFin";
	public static final String BUSQUEDA_BARBERO_WHERE_DOMINGO = " AND bar.piDiaDomingo = 1 ";
	public static final String BUSQUEDA_BARBERO_WHERE_LUNES = " AND bar.piDiaLunes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_MARTES = " AND bar.piDiaMartes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_MIERCOLES = " AND bar.piDiaMiercoles = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_JUEVES = " AND bar.piDiaJueves = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_VIERNES = " AND bar.piDiaViernes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_SABADO = " AND bar.piDiaSabado = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_SERVICIO = " AND bar.piIdBarbero IN (SELECT serBar.poBarbero FROM ServicioBarberoDTO serBar WHERE serBar.poServicio.piIdServicioPk IN (";

	public static final String BUSQUEDA_SERVICIOS_BARBERO = "SELECT ser FROM ServicioDTO ser, ServicioBarberoDTO serBar WHERE"
			+ " ser.piIdServicioPk = serBar.poServicio.piIdServicioPk AND serBar.poBarbero.piIdBarbero = :piBarbero ";
	
	public static final String BUSQUEDA_SERVICIOS_BARBERO_ELIMINAR = "SELECT serBar FROM ServicioBarberoDTO serBar WHERE serBar.poBarbero.piIdBarbero = :piBarbero ";
	
	public static final String BUSQUEDA_BARBEROS_POR_SUCURSAL_SERVICIO = "FROM BarberoDTO bar WHERE bar.poSucursalFk.piIdSucursal = :idSucursal AND bar.piIdBarbero IN "
			+ "(SELECT poBarbero FROM ServicioBarberoDTO serBar WHERE serBar.poServicio.piIdServicioPk = :idServicio)"; 
	
	public static final String BUSQUEDA_CITAS = "SELECT cita FROM CitaDTO cita WHERE cita.poBarbero.piIdBarbero = :idBarbero "
												+ " AND cita.poSucursal.piIdSucursal = :idSucursal"
												+ " AND cita.ptDia = :dia";
	
	public static final String BUSQUEDA_CLIENTES = "FROM ClienteDTO cliente WHERE cliente.psCorreoCliente = :emailCliente";
	
	public static final String BUSQUEDA_CITAS_RECORDATORIO = "SELECT cita FROM CitaDTO cita WHERE cita.estado = 1 AND cita.ptDia = :dia";
	
	public static final String BUSQUEDA_CITAS_CANCELAR = "SELECT cita FROM CitaDTO cita WHERE cita.estado = 1 ";
	public static final String BUSQUEDA_CITAS_ALIAS = " AND cita.poCliente.psAliasCliente = :alias ";
	public static final String BUSQUEDA_CITAS_MAIL = " AND cita.poCliente.psCorreoCliente = :mail ";
	
	public static final String BUSQUEDA_PARAMETRO = "FROM ParametroDTO para WHERE para.psClaveParametro = :claveParametro";
}
