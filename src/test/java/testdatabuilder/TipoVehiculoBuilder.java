package testdatabuilder;

import co.com.ceiba.estacionamiento.entities.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;

public class TipoVehiculoBuilder {
	
	
	public static TipoVehiculo convertirADominio(TipoVehiculoEntity tipoVehiculoEntity) {
		TipoVehiculo tipoVehiculo = null;
		if(tipoVehiculoEntity != null) {
			tipoVehiculo = new TipoVehiculo(tipoVehiculoEntity.getDescripcion());
		}
		return tipoVehiculo;
		
	}


}
