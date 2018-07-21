package com.big.style.barber.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonelistbox.SelectOneListbox;

import com.big.style.barber.dominio.ServicioDTO;

@FacesConverter(value = "servicioListConverter")
public class ConverterServicioList implements Converter{
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {		
        if(value != null && value.trim().length() > 0) {
            try {
            	SelectOneListbox object = (SelectOneListbox)uic;     
            	UISelectItems a = (UISelectItems)object.getChildren().get(0);
            	@SuppressWarnings("unchecked")
				List<ServicioDTO> servicios = (List<ServicioDTO>)a.getValue();
            	ServicioDTO resultado = null;
            	for(ServicioDTO servicio: servicios) {
            		if(servicio.getPiIdServicioPk().equals(Integer.valueOf(value))) {
            			resultado = servicio;
            		}
            	}
            	            	
                return resultado;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((ServicioDTO)object).getPiIdServicioPk());
        }
        else {
            return null;
        }
    }   
}
