function diasDeshabilitados(date){
	var day = date.getDay();
	var dias = $('#agendarCitaForm\\:diasTrabajo').val().split(",");		
	
	console.log(day + " " + ($.inArray(day,dias)) + " " + ($.inArray(day,dias) != -1));
	
	return [($.inArray(day+"",dias) == -1),''];
}