package co.com.ceiba.estacionamiento.dao;

import java.util.List;

import co.com.ceiba.estacionamiento.model.Cobro;

public interface ICobroDAO {

	public int obtenerNumerosCobrosPendientePorTipoVehiculo(String tipoVehiculoCarro);

	public void registrarCobroVehiculo(Cobro cobro);

	public void actualizarCobroVehiculo(Cobro cobro);

	public List<Cobro> obtenerCobrosVehiculoPorEstado(String estado);

	public Cobro obtenerCobroVehiculoPendiente(String placa);

}
