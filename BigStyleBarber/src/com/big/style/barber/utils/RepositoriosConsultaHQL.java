package com.big.style.barber.utils;

public interface RepositoriosConsultaHQL {
		
	public static final String BUSQUEDA_BARBERO_SELECT = "FROM BarberoDTO bar WHERE ";
	public static final String BUSQUEDA_BARBERO_WHERE_NOMBRE= " bar.psNombreBarbero LIKE :psNombreBarbero";
	public static final String BUSQUEDA_BARBERO_WHERE_APATERNO = " bar.psApellidoPaterno LIKE :psApellidoPaterno";
	public static final String BUSQUEDA_BARBERO_WHERE_AMATERNO= "  bar.psApellidoMaterno LIKE :psApellidoMaterno";
	public static final String BUSQUEDA_BARBERO_WHERE_EDAD = " bar.piEdad = :piEdad";
	public static final String BUSQUEDA_BARBERO_WHERE_SUCURSAL = " bar.poSucursalFk.piIdSucursal = :piIdSucursal";
	public static final String BUSQUEDA_BARBERO_WHERE_PUESTO = " bar.poPuestoFK.piIdPuesto = :piIdPuesto";
	public static final String BUSQUEDA_BARBERO_HORARIO_INI = " bar.";
	public static final String BUSQUEDA_BARBERO_HORARIO_FIN = "";
	public static final String BUSQUEDA_BARBERO_WHERE_DOMINGO = " bar.piDiaDomingo = 1 ";
	public static final String BUSQUEDA_BARBERO_WHERE_LUNES = " bar.piDiaLunes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_MARTES = " bar.piDiaMartes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_MIERCOLES = " bar.piDiaMiercoles = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_JUEVES = " bar.piDiaJueves = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_VIERNES = " bar.piDiaViernes = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_SABADO = " bar.piDiaSabado = 1";
	public static final String BUSQUEDA_BARBERO_WHERE_SERVICIO = " bar.piIdBarbero IN (FROM ServicioBarberoDTO serBar WHERE serBar.poServicio.piIdServicioPk IN (";

	public static final String BUSQUEDA_SERVICIOS_BARBERO = "SELECT ser FROM ServicioDTO ser, ServicioBarberoDTO serBar WHERE"
			+ " ser.piIdServicioPk = serBar.piIdServicioBarbero AND serBar.poBarbero.piIdBarbero = :piBarbero ";
}
