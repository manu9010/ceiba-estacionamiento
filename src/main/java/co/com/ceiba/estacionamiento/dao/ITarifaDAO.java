package co.com.ceiba.estacionamiento.dao;

import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Tarifa;

public interface ITarifaDAO {
	
	public double obtenerTarifaPorTemporalidadHoras(Cobro cobro);

	public Tarifa obtenerTarifaPorTemporalidadHoras(int horasParqueo, String tipoVehiculo); 

}
