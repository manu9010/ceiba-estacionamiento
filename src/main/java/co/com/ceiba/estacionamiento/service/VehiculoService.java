package co.com.ceiba.estacionamiento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.util.IValidadorVehiculo;
import co.com.ceiba.estacionamiento.util.ValidadorVehiculoPlacaIniciaA;


@Service
public class VehiculoService implements IVehiculoService {
	
	@Autowired
	private IVehiculoDAO vehiculoDao;
	
	

	public VehiculoService(IVehiculoDAO vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}




	@Override
	public void registrarVechiculo(Vehiculo vehiculo) throws VehiculoException {
		
		
     	 List<IValidadorVehiculo> validacionesVehiculo = new ArrayList<>();
		 validacionesVehiculo.add(new ValidadorVehiculoPlacaIniciaA());
		 

		 for ( IValidadorVehiculo validadorVehiculo : validacionesVehiculo){
			 validadorVehiculo.validar(vehiculo);
		 }
		 
		 
		 vehiculoDao.registrarVehiculo(vehiculo);
		 
		
	}



	@Override
	public Vehiculo consultarVechiculoPorPlaca(String placa) {
	
	  return vehiculoDao.buscarVehiculoPorPlaca(placa);
	}




	@Override
	public List<Vehiculo> obtenerTodosLosVehiculos() {

		return vehiculoDao.obtenerTodosLosVehiculos();
	}

}
