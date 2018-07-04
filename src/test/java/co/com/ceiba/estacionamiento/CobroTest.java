package co.com.ceiba.estacionamiento;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.util.Constantes;
import testdatabuilder.CobroBuilder;
import testdatabuilder.FechaBuilder;
import testdatabuilder.VehiculoBuilder;

public class CobroTest {

	private static final double TOTAL_COBRO_VEHICULO_CARRO = 11000.0;
	private static final double TOTAL_COBRO_VEHICULO_MOTO = 6000.0;
	private static final String COBRO_ESTADO_PENDIENTE = "PENDIENTE";

	@Test
	public void cobroVehiculoCarro() {

		// arrange
		TipoVehiculo tipoVehiculo = new TipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		Vehiculo vehiculo = VehiculoBuilder.unVehiculo()
				.conPlaca("ABC123")
				.conCilindraje(1200)
				.conTipoVehiculo(tipoVehiculo)
				.build();
		
		Date fechaEntrada=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(6).
				conHora(16)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		
		Date fechaSalida=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(7).
				conHora(19)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		

		Cobro cobro = CobroBuilder.unCobro()
				.conVehiculo(vehiculo)
				.conEstado(COBRO_ESTADO_PENDIENTE)
				 .conFechaEntrada(fechaEntrada)
				 .conFechaSalida(fechaSalida)
				.build();

		// act

		// assert
		assertEquals(TOTAL_COBRO_VEHICULO_CARRO, cobro.getTotal(),0);

	}

	@Test
	public void cobroVehiculoMoto() {

		// arrange

		// act

		// assert

	}

}
