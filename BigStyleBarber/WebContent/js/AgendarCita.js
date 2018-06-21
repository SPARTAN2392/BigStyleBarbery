function diasDeshabilitados(date){
	var day = date.getDay();
	var dias = $('#agendarCitaForm\\:diasTrabajo').val().split(",");				
	
	return [($.inArray(day+"",dias) == -1),''];
}