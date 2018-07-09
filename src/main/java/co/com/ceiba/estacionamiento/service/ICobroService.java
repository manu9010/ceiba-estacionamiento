package co.com.ceiba.estacionamiento.service;

import co.com.ceiba.estacionamiento.model.Cobro;

public interface ICobroService {
	

	public Cobro cobrarParqueoPorHoras(Cobro cobro); 
	public Cobro cobrarParqueoPorDia(Cobro cobro); 
	public Cobro calularTotalTarifa(Cobro cobro);
	public void registrarCobroIngresoVehiculo(Cobro cobro);
	public Cobro obtenerCobroVehiculoPendiente(String placa);
	public void  actualizarCobroVehiculo(Cobro cobro);

	

}
