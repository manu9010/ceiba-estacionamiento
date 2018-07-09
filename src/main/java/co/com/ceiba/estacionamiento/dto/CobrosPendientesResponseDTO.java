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


	
	

}
