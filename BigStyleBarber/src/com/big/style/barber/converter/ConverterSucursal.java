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

import com.big.style.barber.dominio.SucursalDTO;

@FacesConverter(value = "sucursalConverter")
public class ConverterSucursal implements Converter{

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {		
        if(value != null && value.trim().length() > 0) {
            try {
            	SelectOneListbox object = (SelectOneListbox)uic;     
            	UISelectItems a = (UISelectItems)object.getChildren().get(0);
            	List<SucursalDTO> sucursales = (List<SucursalDTO>)a.getValue();
            	SucursalDTO resultado = null;
            	for(SucursalDTO sucursal: sucursales) {
            		if(sucursal.getPiIdSucursal().equals(Integer.valueOf(value))) {
            			resultado = sucursal;
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
            return String.valueOf(((SucursalDTO)object).getPiIdSucursal());
        }
        else {
            return null;
        }
    }   
	
}
