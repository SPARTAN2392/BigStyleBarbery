package com.big.style.barber.modelo;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;

import com.big.style.barber.dominio.BarberoDTO;
import com.big.style.barber.dominio.ServicioDTO;

public class ResultadosBarberoVista{
	private BarberoDTO barberoRes = new BarberoDTO();
	private StreamedContent renderFoto;
	public String nombreFoto;
	public byte[] foto;
	List<ServicioDTO> servicioSource = new ArrayList<ServicioDTO>();;
	List<ServicioDTO> servicioTarget = new ArrayList<ServicioDTO>();
	DualListModel<ServicioDTO> catServicio;	
	private String[] selectedDias = new String[7];
	
	public List<ServicioDTO> getServicioSource() {
		return servicioSource;
	}
	public void setServicioSource(List<ServicioDTO> servicioSource) {
		this.servicioSource = servicioSource;
	}
	public List<ServicioDTO> getServicioTarget() {
		return servicioTarget;
	}
	public void setServicioTarget(List<ServicioDTO> servicioTarget) {
		this.servicioTarget = servicioTarget;
	}
	public DualListModel<ServicioDTO> getCatServicio() {
		catServicio = new DualListModel<>(servicioSource, servicioTarget);
		return catServicio;
	}
	public void setCatServicio(DualListModel<ServicioDTO> catServicio) {
		this.catServicio = catServicio;
	}
	public BarberoDTO getBarberoRes() {
		return barberoRes;
	}
	public void setBarberoRes(BarberoDTO barberoRes) {
		this.barberoRes = barberoRes;
	}
	public StreamedContent getRenderFoto() {
		return renderFoto;
	}
	public void setRenderFoto(StreamedContent renderFoto) {
		this.renderFoto = renderFoto;
	}
	public String getNombreFoto() {
		return nombreFoto;
	}
	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String[] getSelectedDias() {
		return selectedDias;
	}
	public void setSelectedDias(String[] selectedDias) {
		this.selectedDias = selectedDias;
	}
	
		
}