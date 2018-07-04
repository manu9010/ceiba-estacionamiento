package testdatabuilder;

import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;

public class TarifaBuilder {
	
	private static final double PRECIO = 0.0;
	private static final int TEMPORALIDAD_HORAS = 0;
	private static final TipoVehiculo TIPO_VEHICULO = null;

	
	private double precio;
	private int temporalidadHoras;
	private TipoVehiculo tipoVehiculo;
	
	

	
	
	 public TarifaBuilder() {
		this.precio = PRECIO;
		this.temporalidadHoras = TEMPORALIDAD_HORAS;
		this.tipoVehiculo = TIPO_VEHICULO;
	}




		public TarifaBuilder conPrecio(double precio) {
			this.precio =precio;
			return this;
		}
		
		public TarifaBuilder conTemporalidadHoras(int temporalidadHoras) {
			this.temporalidadHoras =temporalidadHoras;
			return this;
		}
		
		
		public TarifaBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
			this.tipoVehiculo =tipoVehiculo;
			return this;
		}
		


	
	public Tarifa build() {
		return new Tarifa(this.precio, this.temporalidadHoras, this.tipoVehiculo);
	}

}
