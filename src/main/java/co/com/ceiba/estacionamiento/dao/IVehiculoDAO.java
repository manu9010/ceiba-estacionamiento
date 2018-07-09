package co.com.ceiba.estacionamiento.dao;

import java.util.List;

import co.com.ceiba.estacionamiento.model.Vehiculo;

public interface IVehiculoDAO {

	public Vehiculo buscarVehiculoPorPlaca(String placa);

	public void registrarVehiculo(Vehiculo vehiculo);

	public List<Vehiculo> obtenerTodosLosVehiculos();

}
