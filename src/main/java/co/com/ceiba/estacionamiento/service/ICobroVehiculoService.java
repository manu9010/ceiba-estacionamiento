package co.com.ceiba.estacionamiento.service;

import java.util.List;

import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public interface ICobroVehiculoService {
	
	public void registrarCobroIngresoVehiculo(Vehiculo vehiculo) throws VehiculoException; 
	public double calcularCobroTotalParqueoVehiculo(String placa);
	
	public List<Cobro> obtenerCobrosVehiculoPendientes();
	
	public List<Cobro> obtenerCobrosVehiculoPagados();

}
