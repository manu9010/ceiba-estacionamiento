package co.com.ceiba.estacionamiento.service;

import co.com.ceiba.estacionamiento.model.Cobro;

public interface ICobroService {
	

	Cobro cobrarParqueoPorHoras(Cobro cobro); 
	Cobro cobrarParqueoPorDia(Cobro cobro); 
    Cobro calularTotalTarifa(Cobro cobro);
	
	

}
