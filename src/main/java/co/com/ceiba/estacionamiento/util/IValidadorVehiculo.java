package co.com.ceiba.estacionamiento.util;

import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public interface IValidadorVehiculo {
	

   public void validar(Vehiculo vehiculo) throws VehiculoException;

}
