package com.big.style.barber.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GaleriaImages {

	     
	    List<String> images;
	     
	    @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 2; i++) {
	            images.add("Barberia_" + i +".jpg");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }
}
