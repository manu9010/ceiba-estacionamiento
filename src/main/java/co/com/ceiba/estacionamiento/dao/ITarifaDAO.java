package co.com.ceiba.estacionamiento.dao;

import co.com.ceiba.estacionamiento.entities.TarifaEntity;
import co.com.ceiba.estacionamiento.model.Tarifa;

public interface ITarifaDAO {
	

	public Tarifa obtenerTarifaPorTemporalidadHoras(int temporalidadHoras, String tipoVehiculo);

	public TarifaEntity obtenerTarifaEntityPorTemporalidadHoras(int temporalidadHoras, String tipoVehiculo); 

}
