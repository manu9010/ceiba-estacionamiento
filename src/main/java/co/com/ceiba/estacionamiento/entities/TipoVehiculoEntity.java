package co.com.ceiba.estacionamiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity(name = "TipoVehiculo")
@NamedQuery(name = "TipoVehiculo.findByDescripcion", query = "SELECT tipoVehiculo FROM TipoVehiculo tipoVehiculo WHERE tipoVehiculo.descripcion = :descripcion")
public class TipoVehiculoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false)
	private String descripcion;


	public TipoVehiculoEntity(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
