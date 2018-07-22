package com.big.style.barber.utils;

public class ConstantesDominio {

	public static final long UN_MINUTO=60000;
	
	public static final String MAIL_HOST = "MAIL_HOST";
	public static final String MAIL_FROM = "MAIL_FROM";
	public static final String MAIL_PASSWORD = "MAIL_PASSWORD";
	public static final String MAIL_PORT = "MAIL_PORT";

	public static final String templateMailAgendarCita = "<!doctype html ><html><head><meta charset='utf-8'><title>Template</title><style type='text/css'>.Lucida {	font-family: Segoe Segoe, 'Segoe UI Light', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}Correo {	font-family: Segoe Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}</style></head><body ><table  width='800' height='700' border='1' align='center' cellpadding='0' cellspacing='0'  bordercolor='#484848'  ><tr><td><table><tr><td width=\"100%\"><blockquote class='Lucida'><h3 align='center'><strong><font color='#0F4B7D'> Big Style Barbery</font></strong></h3><h1 align='center'><font color='#2180D8' ><strong>  Cita Agendada</strong></font></h1></blockquote></td></tr>							</table></td></tr>				<tr><td width='927' height='400'>		<blockquote class='Lucida'><p align='left'><font color='#0F4B7D'>	Estimado cliente,</font></p><p align='left'><font color='#0F4B7D'>	Se ha agendado exitosamente su cita con los siguientes datos:</font></p><table  width='400' height='200' align='center' cellpadding='0' cellspacing='0' ><tr><td><strong><font color='#0F4B7D'>Sucursal:</font></strong></td><td>SucursalCita</td></tr><tr><td><strong><font color='#0F4B7D'>Barbero:</font></strong></td><td>BarberoCita</td></tr><tr><td><strong><font color='#0F4B7D'>Servicio:</font></strong></td><td>ServicioCita</td></tr><tr><td><strong><font color='#0F4B7D'>Dia:</font></strong></td><td>DiaCita</td></tr><tr><td><strong><font color='#0F4B7D'>Horario:</font></strong></td><td>HorarioCita</td></tr></table></blockquote>					</td></tr></table></body></html>";
	public static final String templateMailCancelarCita = "<!doctype html ><html><head><meta charset='utf-8'><title>Template</title><style type='text/css'>.Lucida {	font-family: Segoe Segoe, 'Segoe UI Light', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}Correo {	font-family: Segoe Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}</style></head><body ><table  width='800' height='300' border='1' align='center' cellpadding='0' cellspacing='0'  bordercolor='#484848'  ><tr><td><table><tr><td width=\"100%\"><blockquote class='Lucida'><h3 align='center'><strong><font color='#0F4B7D'> Big Style Barbery</font></strong></h3><h1 align='center'><font color='#2180D8' ><strong>  Cita Cancelada</strong></font></h1></blockquote></td></tr>							</table></td></tr>				<tr><td width='927' height='200'>		<blockquote class='Lucida'><p align='left'><font color='#0F4B7D'>	Estimado cliente,</font></p><p align='left'><font color='#0F4B7D'>	Se cita con fecha <strong><font color='#0F4B7D'>diaCita</font></strong> y hora <strong><font color='#0F4B7D'>horarioCita</font></strong> ha sido cancelada exitosamente</font></p></blockquote>					</td></tr></table></body></html>";
	public static final String templateMailRecordatorioCita = "<!doctype html ><html><head><meta charset='utf-8'><title>Template</title><style type='text/css'>.Lucida {	font-family: Segoe Segoe, 'Segoe UI Light', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}Correo {	font-family: Segoe Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;}</style></head><body ><table  width='800' height='700' border='1' align='center' cellpadding='0' cellspacing='0'  bordercolor='#484848'  ><tr><td><table><tr><td width=\\\"100%\\\"><blockquote class='Lucida'><h3 align='center'><strong><font color='#0F4B7D'> Big Style Barbery</font></strong></h3><h1 align='center'><font color='#2180D8' ><strong>Recordatorio de Cita</strong></font></h1></blockquote></td></tr></table></td></tr><tr><td width='927' height='400'><blockquote class='Lucida'><p align='left'><font color='#0F4B7D'>Estimado cliente,</font></p><p align='left'><font color='#0F4B7D'>Le recordamos que el d�a de hoy tiene agendada una cita con los siguientes datos:</font></p><table  width='400' height='200' align='center' cellpadding='0' cellspacing='0' ><tr><td><strong><font color='#0F4B7D'>Sucursal:</font></strong></td><td>SucursalCita</td></tr><tr><td><strong><font color='#0F4B7D'>Barbero:</font></strong></td><td>BarberoCita</td></tr><tr><td><strong><font color='#0F4B7D'>Servicio:</font></strong></td><td>ServicioCita</td></tr><tr><td><strong><font color='#0F4B7D'>Dia:</font></strong></td><td>DiaCita</td></tr><tr><td><strong><font color='#0F4B7D'>Horario:</font></strong></td><td>HorarioCita</td></tr></table></blockquote></td></tr></table></body></html>";
}
