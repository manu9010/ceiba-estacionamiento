package co.com.ceiba.estacionamiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Vehiculo")
public class VehiculoEntity {

	@Id
	private String placa;
	
	@Column(nullable = false)
	private Integer cilindraje;
	
	@Column(nullable = false)
	@OneToOne
	//@JoinColumn(name="ID_TIPO_VEHICULO",referencedColumnName="id")
    private TipoVehiculoEntity tipoVehiculo;

	public VehiculoEntity(String placa, Integer cilindraje, TipoVehiculoEntity tipoVehiculo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipoVehiculo = tipoVehiculo;
	}

	public VehiculoEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
	
	

}
