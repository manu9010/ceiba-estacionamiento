package co.com.ceiba.estacionamiento.util;

import java.time.DayOfWeek;
import java.util.Date;

import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public class ValidadorVehiculoPlacaIniciaA implements IValidadorVehiculo {



	@Override
	public void validar(Vehiculo vehiculo) throws VehiculoException {
		
		char c = vehiculo.getPlaca().toUpperCase().charAt(0);
        boolean placaIniciaConA =c == 'A';
        boolean esDomingo=FechaUtil.esDia(new Date(), DayOfWeek.SUNDAY);
        boolean esLunes=FechaUtil.esDia(new Date(), DayOfWeek.MONDAY);
		
		 if (placaIniciaConA && (esDomingo || esLunes)) {
			   throw new VehiculoException(Constantes.VEHICULO_NO_AUTORIZADO_INGRESO);
			 }
		
	}

}
