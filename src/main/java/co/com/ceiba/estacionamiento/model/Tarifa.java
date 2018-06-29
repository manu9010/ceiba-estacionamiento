package co.com.ceiba.estacionamiento.model;

public class Tarifa {
	
	double precio;
	String temporalidad;
	TipoVehiculo tipoVehiculo;
	
	
	
	public Tarifa(double precio, String temporalidad, TipoVehiculo tipoVehiculo) {
		this.precio = precio;
		this.temporalidad = temporalidad;
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTemporalidad() {
		return temporalidad;
	}
	public void setTemporalidad(String temporalidad) {
		this.temporalidad = temporalidad;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
}
