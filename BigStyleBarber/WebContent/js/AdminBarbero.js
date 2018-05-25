function tpEntradaInicioOnHourShowCallback(hour) {  
    if (!PrimeFaces.widgets['entradaFinTimeWidget']) {  
        return false;  
    }  
  
    var tpEndHour = parseInt(PF('entradaFinTimeWidget').getHours());  
  
    // Check if proposed hour is prior or equal to selected end time hour  
    if (parseInt(hour) <= tpEndHour) {  
        return true;  
    }  
  
    // if hour did not match, it can not be selected  
    return false;  
}  
  
function tpEntradaInicioOnMinuteShowCallback(hour, minute) {  
    if (!PrimeFaces.widgets['entradaFinTimeWidget']) {  
        return false;  
    }  
  
    var tpEndHour = parseInt(PF('entradaFinTimeWidget').getHours());  
    var tpEndMinute = parseInt(PF('entradaFinTimeWidget').getMinutes());  
  
    // Check if proposed hour is prior to selected end time hour  
    if (parseInt(hour) < tpEndHour) {  
        return true;  
    }  
  
    // Check if proposed hour is equal to selected end time hour and minutes is prior  
    if ((parseInt(hour) == tpEndHour) && (parseInt(minute) < tpEndMinute)) {  
        return true;  
    }  
  
    // if minute did not match, it can not be selected  
    return false;  
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