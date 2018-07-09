package co.com.ceiba.estacionamiento.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Cobro")
public class CobroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = true)
	 private Double total;
	
	@Column(nullable = false)
	 private String estado;
	
	@Column(nullable = false)
	 private Date fechaEntrada;
	
	@Column(nullable = true)
	 private Date fechaSalida;
	
	 @OneToOne
	 @JoinColumn(name="ID_VEHICULO",nullable = false) 
	 private VehiculoEntity vehiculo;
	
	 @Column(nullable = true)
	 @OneToMany( targetEntity=CobroTarifaEntity.class )
	 private List<CobroTarifaEntity> cobroTarifas;
	 
	 

	public CobroEntity(Long id, Double total, String estado, Date fechaEntrada, Date fechaSalida, VehiculoEntity vehiculo,
			List<CobroTarifaEntity> cobroTarifas) {
		this.id = id;
		this.total = total;
		this.estado = estado;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.cobroTarifas = cobroTarifas;
	}



	public CobroEntity() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}



	public List<CobroTarifaEntity> getCobroTarifas() {
		return cobroTarifas;
	}



	public void setCobroTarifas(List<CobroTarifaEntity> cobroTarifas) {
		this.cobroTarifas = cobroTarifas;
	}
	
	
	 
	

}
