package co.com.ceiba.estacionamiento.dto;

import co.com.ceiba.estacionamiento.model.Vehiculo;

public class VehiculoResponseDTO {
	
	private Vehiculo vehiculo;
	private String mensaje;
	private int codigo;
	
	public VehiculoResponseDTO(Vehiculo vehiculo, String mensaje, int codigo) {
		this.vehiculo = vehiculo;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	

}
