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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	

}
