package co.com.ceiba.estacionamiento.model;

public class Tarifa {
	
	private double precio;
	private int temporalidadHoras;
	private TipoVehiculo tipoVehiculo;
	
	
	
	public Tarifa(double precio, int temporalidad, TipoVehiculo tipoVehiculo) {
		this.precio = precio;
		this.temporalidadHoras = temporalidad;
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getTemporalidad() {
		return temporalidadHoras;
	}
	public void setTemporalidad(int temporalidad) {
		this.temporalidadHoras = temporalidad;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
}
