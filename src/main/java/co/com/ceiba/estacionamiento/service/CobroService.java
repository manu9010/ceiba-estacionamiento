package co.com.ceiba.estacionamiento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dao.ICobroDAO;
import co.com.ceiba.estacionamiento.dao.ITarifaDAO;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.util.Constantes;
import co.com.ceiba.estacionamiento.util.FechaDiasHoras;
import co.com.ceiba.estacionamiento.util.FechaUtil;
import testdatabuilder.CobroTarifaBuilder;



@Service
public class CobroService implements ICobroService {

	@Autowired
	private ITarifaDAO tarifaDao;
	
	@Autowired
	private ICobroDAO cobroDao;

	public CobroService(ITarifaDAO tarifaDao, ICobroDAO cobroDao) {
		this.tarifaDao=tarifaDao;
		this.cobroDao=cobroDao;;
	}

	@Override
	public Cobro cobrarParqueoPorHoras(Cobro cobro) {
		int horasParqueo = FechaUtil.diferenciaHoras(cobro.getFechaEntrada(), cobro.getFechaSalida());
		List<CobroTarifa> cobroTarifas = new ArrayList<>();
		CobroTarifa cobroTarifa;

		Tarifa tarifa = tarifaDao.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
				cobro.getVehiculo().getTipoVehiculo().getDescripcion());
		

		  cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(horasParqueo).conCobro(cobro)
				.conTarifa(tarifa).build();

		cobroTarifas.add(cobroTarifa);

		cobro.setCobroTarifa(cobroTarifas);
		
	    cobro=calularTotalTarifa(cobro);
		
		cobro.setEstado(Constantes.ESTADO_COBRO_PAGADO);

		return calularTotalTarifa(cobro);
	}

	@Override
	public Cobro cobrarParqueoPorDia(Cobro cobro) {
		FechaDiasHoras fechasDiasHoras = FechaUtil.diferenciaDiasHoras(cobro.getFechaSalida(),cobro.getFechaEntrada());
		List<CobroTarifa> cobroTarifas = new ArrayList<>();
		CobroTarifa cobroTarifa;

		if (fechasDiasHoras.getDias()==0 && fechasDiasHoras.getHoras()>9 ) {
			cobroTarifa = crearCobroTarifaTemporalidadHoras(cobro, 1,Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA);

			cobroTarifas.add(cobroTarifa);

		} else {

			cobroTarifa = crearCobroTarifaTemporalidadHoras(cobro, (int)fechasDiasHoras.getDias(),Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA);
			cobroTarifas.add(cobroTarifa);

			cobroTarifa = crearCobroTarifaTemporalidadHoras(cobro, (int)fechasDiasHoras.getHoras(),Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA);
			cobroTarifas.add(cobroTarifa);

		}

		cobro.setCobroTarifa(cobroTarifas);

		cobro=calularTotalTarifa(cobro);
		
		cobro.setEstado(Constantes.ESTADO_COBRO_PAGADO);

		return calularTotalTarifa(cobro);
	}


	
	@Override
	public Cobro calularTotalTarifa(Cobro cobro) {
		double toltalCobroTarifa = 0;
		
		for (CobroTarifa cobroTarifa : cobro.getCobroTarifa()) {
			toltalCobroTarifa += cobroTarifa.getCantidadTarifa() * cobroTarifa.getTarifa().getPrecio();
		}
		
		String tipoVehiculo=cobro.getVehiculo().getTipoVehiculo().getDescripcion();
		int cilindrajeVehiculo=cobro.getVehiculo().getCilindraje();
		
		if (tipoVehiculo==Constantes.TIPO_VEHICULO_MOTO && cilindrajeVehiculo>Constantes.CILINDRAJE_MOTO_AUMENTO ) {
			toltalCobroTarifa+=2000;
		} 
		cobro.setTotal(toltalCobroTarifa);
		return cobro;

	}
	
	
	private CobroTarifa crearCobroTarifaTemporalidadHoras(Cobro cobro, int cantidadTarifa,int temporalidadHoras) {
		CobroTarifa cobroTarifa=null;
	
		Tarifa tarifa = tarifaDao.obtenerTarifaPorTemporalidadHoras(temporalidadHoras,
				cobro.getVehiculo().getTipoVehiculo().getDescripcion());
	
		
		cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(cantidadTarifa).conCobro(cobro)
				.conTarifa(tarifa).build();
		return cobroTarifa;
	}
	

	public boolean validarCapacidadCobroParqueo() { 
		
		int cobrosPendienteCarro=cobroDao.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		int cobrosPendienteMoto=cobroDao.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		

		return cobrosPendienteCarro>Constantes.TOPE_MAXIMO_PARQUQEO_CARRO && cobrosPendienteMoto>Constantes.TOPE_MAXIMO_PARQUQEO_CARRO;
	
	}


}
