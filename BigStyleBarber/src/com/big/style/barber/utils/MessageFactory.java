package com.big.style.barber.utils;

import java.text.MessageFormat;

import javax.faces.context.FacesContext;

public final class MessageFactory {
	
	public static String getMessageReq(String claveMsg,String param){ 
		System.out.println("message");
        Object params[]=new Object[1];
        params[0]=param;
        MessageFormat messageFormat = new MessageFormat(getMessageBoundle(claveMsg));
        System.out.println(messageFormat.format(params));
        return messageFormat.format(params);
    }
        
    public static String getMessageBoundle(String claveMsg){
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, claveMsg, String.class);         
    }
	
}
