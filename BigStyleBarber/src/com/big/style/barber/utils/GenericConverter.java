package com.big.style.barber.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "genericConverter")
public class GenericConverter implements Converter {

    private static Map<Object, String> entities = new WeakHashMap<Object, String>();

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object entity) {
        synchronized (entities) {
            if (!entities.containsKey(entity)) {
                String uuid = UUID.randomUUID().toString();
                entities.put(entity, uuid);
                return uuid;
            } else {
                return entities.get(entity);
            }
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String uuid) {
    	System.out.println("converter" + " " + uuid);
        for (Entry<Object, String> entry : entities.entrySet()) {
        	System.out.println(entry.getValue() + " " + entry.getKey());
            if (entry.getValue().equals(uuid)) {
            	System.out.println("if");
                return entry.getKey();
            }
        }
        return null;
    }

}