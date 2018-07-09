package co.com.ceiba.estacionamiento.service;

import java.util.List;

import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public interface IVehiculoService {

	public void registrarVechiculo(Vehiculo vehiculo) throws VehiculoException;
	public Vehiculo consultarVechiculoPorPlaca(String placa);
	public List<Vehiculo> obtenerTodosLosVehiculos();


}
