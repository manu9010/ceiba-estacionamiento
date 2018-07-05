package co.com.ceiba.estacionamiento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.dao.ITarifaDAO;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.util.Constantes;
import co.com.ceiba.estacionamiento.util.FechaUtil;
import testdatabuilder.CobroTarifaBuilder;



@Service
public class CobroCarroService implements ICobroService {

	@Autowired
	private ITarifaDAO tarifaDao;

	public CobroCarroService(ITarifaDAO tarifaDao) {
		this.tarifaDao=tarifaDao;
	}

	@Override
	public Cobro cobrarParqueoPorHoras(Cobro cobro) {
		int horasParqueo = FechaUtil.diferenciaHoras(cobro.getFechaEntrada(), cobro.getFechaSalida());

		Tarifa tarifa = tarifaDao.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA,
				cobro.getVehiculo().getTipoVehiculo().getDescripcion());
		List<CobroTarifa> cobroTarifas = new ArrayList<>();

		CobroTarifa cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(horasParqueo).conCobro(cobro)
				.conTarifa(tarifa).build();

		cobroTarifas.add(cobroTarifa);

		cobro.setCobroTarifa(cobroTarifas);

		return calularTotalTarifa(cobro);
	}

	@Override
	public Cobro cobrarParqueoPorDia(Cobro cobro) {
		int horasParqueo = FechaUtil.diferenciaHoras(cobro.getFechaSalida(),cobro.getFechaEntrada());
		List<CobroTarifa> cobroTarifas = new ArrayList<>();
		CobroTarifa cobroTarifa;

		if (horasParqueo % 24 == 0) {
			Tarifa tarifa = tarifaDao.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
					cobro.getVehiculo().getTipoVehiculo().getDescripcion());
			int cantidadTarifa = horasParqueo / 24;
			cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(cantidadTarifa).conCobro(cobro)
					.conTarifa(tarifa).build();

			cobroTarifas.add(cobroTarifa);

		} else {

			Tarifa tarifaDia = tarifaDao.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA,
					cobro.getVehiculo().getTipoVehiculo().getDescripcion());
			int cantidadTarifaDias = horasParqueo / 24;
			cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(cantidadTarifaDias).conCobro(cobro)
					.conTarifa(tarifaDia).build();
			cobroTarifas.add(cobroTarifa);

			Tarifa tarifaHora = tarifaDao.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
					cobro.getVehiculo().getTipoVehiculo().getDescripcion());
			int cantidadTarifaHoras = horasParqueo % 24;
			cobroTarifa = CobroTarifaBuilder.unCobroTarifa().conCantidadTarifa(cantidadTarifaHoras).conCobro(cobro)
					.conTarifa(tarifaHora).build();
			cobroTarifas.add(cobroTarifa);

		}

		cobro.setCobroTarifa(cobroTarifas);


		return calularTotalTarifa(cobro);
	}

	
	@Override
	public Cobro calularTotalTarifa(Cobro cobro) {
		double toltalCobroTarifa = 0;
		for (CobroTarifa cobroTarifa : cobro.getCobroTarifa()) {
			toltalCobroTarifa += cobroTarifa.getCantidadTarifa() * cobroTarifa.getTarifa().getPrecio();
		}
		cobro.setTotal(toltalCobroTarifa);
		return cobro;

	}

}
