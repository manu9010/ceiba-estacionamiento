package co.com.ceiba.estacionamiento.util;

import co.com.ceiba.estacionamiento.exceptions.CobroException;
import co.com.ceiba.estacionamiento.model.Cobro;

public interface IValidadorCobro {
	
	
	  public void validar(Cobro cobro) throws CobroException;

}
