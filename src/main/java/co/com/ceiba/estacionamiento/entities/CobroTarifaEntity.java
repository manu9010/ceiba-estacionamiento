package co.com.ceiba.estacionamiento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name = "CobroTarifa")
public class CobroTarifaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name="ID_COBRO") 
	private CobroEntity cobro;
	

	@OneToOne
	@JoinColumn(name="ID_TARIFA",nullable = false) 
	private TarifaEntity tarifa;
	
	@Column(nullable = false)
	private Integer cantidadTarifa;

	public CobroTarifaEntity(Long id, CobroEntity cobro, TarifaEntity tarifa, Integer cantidadTarifa) {
		super();
		this.id = id;
		this.cobro = cobro;
		this.tarifa = tarifa;
		this.cantidadTarifa = cantidadTarifa;
	}

	public CobroTarifaEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CobroEntity getCobro() {
		return cobro;
	}

	public void setCobro(CobroEntity cobro) {
		this.cobro = cobro;
	}

	public TarifaEntity getTarifa() {
		return tarifa;
	}

	public void setTarifa(TarifaEntity tarifa) {
		this.tarifa = tarifa;
	}

	public Integer getCantidadTarifa() {
		return cantidadTarifa;
	}

	public void setCantidadTarifa(Integer cantidadTarifa) {
		this.cantidadTarifa = cantidadTarifa;
	}

	
	
	

}
