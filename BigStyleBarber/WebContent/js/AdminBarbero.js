function onCloseHoraEntrada(){
	PF('entradaFinTimeWidget').setTime(PF('entradaIniTimeWidget').getTime());
} 

function onCloseHoraSalida(){
	PF('salidaFinTimeWidget').setTime(PF('salidaIniTimeWidget').getTime());
} 

function tpEntradaFinOnHourShowCallback(hour) {  
    if (!PrimeFaces.widgets['entradaIniTimeWidget']) {  
        return false;  
    }  
  
    var tpStartHour = parseInt(PF('entradaIniTimeWidget').getHours());  
  
    // Check if proposed hour is after or equal to selected start time hour  
    if (parseInt(hour) >= tpStartHour) {  
        return true;  
    }  
  
    // if hour did not match, it can not be selected  
    return false;  
}  
  
function tpEntradaFinOnMinuteShowCallback(hour, minute) {  
    if (!PrimeFaces.widgets['entradaIniTimeWidget']) {  
        return false;  
    }  
  
    var tpStartHour = parseInt(PF('entradaIniTimeWidget').getHours());  
    var tpStartMinute = parseInt(PF('entradaIniTimeWidget').getMinutes());  
  
    // Check if proposed hour is after selected start time hour  
    if (parseInt(hour) > tpStartHour) {  
        return true;  
    }  
  
    // Check if proposed hour is equal to selected start time hour and minutes is after  
    if ((parseInt(hour) == tpStartHour) && (parseInt(minute) > tpStartMinute)) {  
        return true;  
    }  
  
    // if minute did not match, it can not be selected  
    return false;  
}  

function tpSalidaFinOnHourShowCallback(hour) {  
    if (!PrimeFaces.widgets['salidaIniTimeWidget']) {  
        return false;  
    }  
  
    var tpStartHour = parseInt(PF('salidaIniTimeWidget').getHours());  
  
    // Check if proposed hour is after or equal to selected start time hour  
    if (parseInt(hour) >= tpStartHour) {  
        return true;  
    }  
  
    // if hour did not match, it can not be selected  
    return false;  
}  
  
function tpSalidaFinOnMinuteShowCallback(hour, minute) {  
    if (!PrimeFaces.widgets['salidaIniTimeWidget']) {  
        return false;  
    }  
  
    var tpStartHour = parseInt(PF('salidaIniTimeWidget').getHours());  
    var tpStartMinute = parseInt(PF('salidaIniTimeWidget').getMinutes());  
  
    // Check if proposed hour is after selected start time hour  
    if (parseInt(hour) > tpStartHour) {  
        return true;  
    }  
  
    // Check if proposed hour is equal to selected start time hour and minutes is after  
    if ((parseInt(hour) == tpStartHour) && (parseInt(minute) > tpStartMinute)) {  
        return true;  
    }  
  
    // if minute did not match, it can not be selected  
    return false;  
}  