package co.com.ceiba.estacionamiento.dto;

import java.util.List;

import co.com.ceiba.estacionamiento.model.Cobro;


public class CobrosPendientesResponseDTO {
	
	private List<Cobro> cobrosPendientes;
	private String mensaje;

	public CobrosPendientesResponseDTO(List<Cobro> cobrosPendientes, String mensaje) {
		this.cobrosPendientes = cobrosPendientes;
		this.mensaje = mensaje;
	}

	public List<Cobro> getCobrosPendientes() {
		return cobrosPendientes;
	}

	public void setCobrosPendientes(List<Cobro> cobrosPendientes) {
		this.cobrosPendientes = cobrosPendientes;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	
	

}
