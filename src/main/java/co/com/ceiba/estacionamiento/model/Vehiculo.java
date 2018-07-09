package co.com.ceiba.estacionamiento.model;

public class Vehiculo {
	
	private String placa;
	private int cilindraje;
    private TipoVehiculo tipoVehiculo;
	

	public Vehiculo(String placa, int cilindraje, TipoVehiculo tipoVehiculo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}



	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Vehiculo(String placa) {
		this.placa = placa;
	}

	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
