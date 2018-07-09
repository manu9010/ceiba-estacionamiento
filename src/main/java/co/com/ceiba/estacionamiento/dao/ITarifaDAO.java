package co.com.ceiba.estacionamiento.dao;

import co.com.ceiba.estacionamiento.model.Tarifa;

public interface ITarifaDAO {
	

	public Tarifa obtenerTarifaPorTemporalidadHoras(int horasParqueo, String tipoVehiculo); 

}
