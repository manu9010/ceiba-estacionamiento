package co.com.ceiba.estacionamiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "Tarifa")
public class TarifaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Double precio;
	
	@Column(nullable = false)
	private Integer temporalidadHoras;
	
	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name="ID_TIPO_VEHICULO",referencedColumnName="id")
	private TipoVehiculoEntity tipoVehiculoEntity;

	public TarifaEntity(Long id, Double precio, Integer temporalidadHoras, TipoVehiculoEntity tipoVehiculo) {
		this.id = id;
		this.precio = precio;
		this.temporalidadHoras = temporalidadHoras;
		this.tipoVehiculoEntity = tipoVehiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getTemporalidadHoras() {
		return temporalidadHoras;
	}

	public void setTemporalidadHoras(Integer temporalidadHoras) {
		this.temporalidadHoras = temporalidadHoras;
	}

	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculoEntity;
	}

	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculoEntity = tipoVehiculo;
	}
	
	
	
	

}
