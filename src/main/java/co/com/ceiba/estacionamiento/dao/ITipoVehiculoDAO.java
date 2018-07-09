package co.com.ceiba.estacionamiento.dao;

import co.com.ceiba.estacionamiento.entities.TipoVehiculoEntity;

public interface ITipoVehiculoDAO {
	

	public TipoVehiculoEntity obtenerTipoVehiculoEntityPorDescripcion(String descripcion);

}
