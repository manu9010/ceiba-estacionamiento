package co.com.ceiba.estacionamiento.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.estacionamiento.util.IValidadorVehiculo;
import co.com.ceiba.estacionamiento.util.ValidadorVehiculoPlacaIniciaA;

@Configuration
public class ConfiguracionValidacionesIngreso {

	
	@Bean
	public List<IValidadorVehiculo> getValidacionesVehiculo(){
		
		List<IValidadorVehiculo> validacionesVehiculo = new ArrayList<>();
		 validacionesVehiculo.add(new ValidadorVehiculoPlacaIniciaA());
		 
		 return validacionesVehiculo;
	}
}
