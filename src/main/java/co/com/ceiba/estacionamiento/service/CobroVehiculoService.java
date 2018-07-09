package co.com.ceiba.estacionamiento.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.util.Constantes;
import co.com.ceiba.estacionamiento.util.FechaUtil;
import testdatabuilder.CobroBuilder;


@Service
public class CobroVehiculoService implements ICobroVehiculoService {
	
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	
	@Autowired
	private ICobroService cobroService;
	
	

	@Override
	public void registrarCobroIngresoVehiculo(Vehiculo vehiculo) throws VehiculoException {
		
		Cobro cobro = CobroBuilder.unCobro()
				.conVehiculo(vehiculo)
				.conEstado(Constantes.ESTADO_COBRO_PENDIENTE)
				 .conFechaEntrada(new Date())
				.build();
		
		Vehiculo vehiculoEncontrado=vehiculoService.consultarVechiculoPorPlaca(vehiculo.getPlaca());
		
		if (vehiculoEncontrado==null) {
			vehiculoService.registrarVechiculo(vehiculo);
			cobro.setVehiculo(vehiculo);
		}else{
			cobro.setVehiculo(vehiculoEncontrado);
		}
		
		cobroService.registrarCobroIngresoVehiculo(cobro);

		
	}



	@Override
	public double calcularCobroTotalParqueoVehiculo(String placa) {
		Cobro cobro= cobroService.obtenerCobroVehiculoPendiente(placa);
	
		cobro.setFechaSalida(new Date());
		
		int horasParqueo = FechaUtil.diferenciaHoras(cobro.getFechaEntrada(), cobro.getFechaSalida());
		if (horasParqueo<9) {
			cobro= cobroService.cobrarParqueoPorHoras(cobro);
		} else {
			cobro= cobroService.cobrarParqueoPorDia(cobro);
		}
		
		cobro.setEstado(Constantes.ESTADO_COBRO_PAGADO);
		
	    cobroService.actualizarCobroVehiculo(cobro);
		
		return cobro.getTotal();
	}



	@Override
	public List<Cobro> obtenerCobrosVehiculoPendientes() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Cobro> obtenerCobrosVehiculoPagados() {
		// TODO Auto-generated method stub
		return null;
	}

}
