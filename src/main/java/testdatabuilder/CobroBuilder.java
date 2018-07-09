package testdatabuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.ceiba.estacionamiento.entities.CobroEntity;
import co.com.ceiba.estacionamiento.entities.CobroTarifaEntity;
import co.com.ceiba.estacionamiento.entities.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;

public class CobroBuilder {

	private static final double TOTAL = 0.0;
	private static final String ESTADO = "";
	private static final Date FECHA_ENTRADA = null;
	private static final Date FECHA_SALIDA = null;
	private static final Vehiculo VEHICULO = null;
	private static final List<CobroTarifa> COBRO_TARIFA = null;

	private double total;
	private String estado;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Vehiculo vehiculo;
	private List<CobroTarifa> cobroTarifa;

	public CobroBuilder() {
		this.total = TOTAL;
		this.estado = ESTADO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.vehiculo = VEHICULO;
		this.cobroTarifa = COBRO_TARIFA;
	}

	public CobroBuilder conTotal(double total) {
		this.total = total;
		return this;
	}

	public CobroBuilder conEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public CobroBuilder conFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public CobroBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public CobroBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public Cobro build() {
		return new Cobro(this.total, this.estado, this.fechaEntrada, this.fechaSalida, this.vehiculo, this.cobroTarifa);
	}

	public CobroBuilder con(CobroTarifaBuilder... cobroTarifaBuilders) {
		this.cobroTarifa = new ArrayList<CobroTarifa>();
		for (CobroTarifaBuilder cobroTarifaBuilder : cobroTarifaBuilders) {
			this.cobroTarifa.add(cobroTarifaBuilder.build());
		}
		return this;
	}

	public static CobroBuilder unCobro() {
		return new CobroBuilder();
	}

	public static Cobro convertirADominio(CobroEntity cobroEntity) {

		Vehiculo vehiculo = new Vehiculo();
		List<CobroTarifa> cobrosTarifa = new ArrayList<>();

		vehiculo.setPlaca(cobroEntity.getVehiculo().getPlaca());
		vehiculo.setCilindraje(cobroEntity.getVehiculo().getCilindraje());
		vehiculo.setTipoVehiculo(new TipoVehiculo(cobroEntity.getVehiculo().getTipoVehiculo().getDescripcion()));

		Cobro cobro = new Cobro();
		cobro.setEstado(cobroEntity.getEstado());
		cobro.setFechaEntrada(cobroEntity.getFechaEntrada());
		cobro.setFechaSalida(cobroEntity.getFechaSalida());
		cobro.setTotal(cobroEntity.getTotal());
		cobro.setVehiculo(vehiculo);

		for (CobroTarifaEntity cobroTarifaEntity : cobroEntity.getCobroTarifas()) {
			CobroTarifa cobroTarifa = new CobroTarifa();

			cobroTarifa.setCantidadTarifa(cobroTarifaEntity.getCantidadTarifa());
			cobroTarifa.setCobro(cobro);
			cobroTarifa.setTarifa(
					new Tarifa(cobroTarifa.getTarifa().getPrecio(), cobroTarifa.getTarifa().getTemporalidad(),
							new TipoVehiculo(cobro.getVehiculo().getTipoVehiculo().getDescripcion())));
			cobrosTarifa.add(cobroTarifa);
		}
		cobro.setCobroTarifa(cobrosTarifa);

		return cobro;
	}

}
