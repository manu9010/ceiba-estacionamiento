package co.com.ceiba.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.dao.ITarifaDAO;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.service.CobroCarroService;
import co.com.ceiba.estacionamiento.util.Constantes;
import testdatabuilder.CobroBuilder;
import testdatabuilder.FechaBuilder;
import testdatabuilder.TarifaBuilder;
import testdatabuilder.VehiculoBuilder;

public class CobroTest {
	
	
	private static final double TOTAL_COBRO_VEHICULO_CARRO = 11000.0;
	private static final double TOTAL_COBRO_VEHICULO_MOTO = 6000.0;
	private static final String COBRO_ESTADO_PENDIENTE = "PENDIENTE";
	
    	@InjectMocks
    	CobroCarroService cobroCarroService;
	
	    @Mock
	    ITarifaDAO tarifaDaoMock;
	    

	
	 @Before
	    public void setUp() throws Exception {
		  cobroCarroService=new CobroCarroService(tarifaDaoMock);
          MockitoAnnotations.initMocks(this);
	    }

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
		
		   Tarifa tarifaDiaCarro=TarifaBuilder.unaTarifa()
				   .conPrecio(8000).
				   conTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA)
				   .conTipoVehiculo(tipoVehiculo).build();
		   
		   Tarifa tarifaHoraCarro=TarifaBuilder.unaTarifa()
				   .conPrecio(1000).
				   conTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA)
				   .conTipoVehiculo(tipoVehiculo).build();
		
		
		   when(tarifaDaoMock.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA,
					Constantes.TIPO_VEHICULO_CARRO)).thenReturn(tarifaDiaCarro);
		   
		   
		   when(tarifaDaoMock.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
					Constantes.TIPO_VEHICULO_CARRO)).thenReturn(tarifaHoraCarro);


		// act

	     cobro=cobroCarroService.cobrarParqueoPorDia(cobro);

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
