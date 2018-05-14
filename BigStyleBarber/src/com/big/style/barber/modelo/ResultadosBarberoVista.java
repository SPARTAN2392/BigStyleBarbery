package com.big.style.barber.modelo;

import org.primefaces.model.StreamedContent;

import com.big.style.barber.dominio.BarberoDTO;

public class ResultadosBarberoVista{
	private BarberoDTO barberoRes;
	private StreamedContent renderFoto;
	
	
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
	
		
}