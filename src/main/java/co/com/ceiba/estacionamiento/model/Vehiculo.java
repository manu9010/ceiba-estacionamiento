package co.com.ceiba.estacionamiento.model;

public class Vehiculo {
	
	String placa;
	int cilindraje;
	
	

	public Vehiculo(String placa, int cilindraje) {
		this.placa = placa;
		this.cilindraje = cilindraje;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

}
