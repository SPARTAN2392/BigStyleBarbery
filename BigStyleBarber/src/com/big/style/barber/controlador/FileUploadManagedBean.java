package com.big.style.barber.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadManagedBean")
@SessionScoped
public class FileUploadManagedBean {
	UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String dummyAction(){
		System.out.println("entro");
		System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
		return "";
	}
}
