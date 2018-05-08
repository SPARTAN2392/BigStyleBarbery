package com.big.style.barber.utils;

import java.text.MessageFormat;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
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
	
    public static void addMessage(Severity severidad,String claveMsg,Object... params){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidad, getMessage(claveMsg,params),""));
        if(severidad==FacesMessage.SEVERITY_ERROR)
            FacesContext.getCurrentInstance().validationFailed();            
    }
    
    public static String getMessage(String claveMsg,Object params[]){        
        MessageFormat messageFormat = new MessageFormat(getMessage(claveMsg));
        return messageFormat.format(params);
    }
    
    public static String getMessage(String claveMsg){
        FacesContext context = FacesContext.getCurrentInstance();   
        try{
            return context.getApplication().getResourceBundle(context, "msg").getString(claveMsg);
        }catch(Exception e){
            return claveMsg;
        }            
    }
}
