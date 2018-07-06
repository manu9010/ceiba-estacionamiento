package co.com.ceiba.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.dao.ICobroDAO;
import co.com.ceiba.estacionamiento.dao.ITarifaDAO;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.service.CobroService;
import co.com.ceiba.estacionamiento.util.Constantes;
import testdatabuilder.CobroBuilder;
import testdatabuilder.FechaBuilder;
import testdatabuilder.TarifaBuilder;
import testdatabuilder.VehiculoBuilder;

public class CobroTest {
	
	
	private static final double TOTAL_COBRO_VEHICULO_CARRO_DIA = 11000.0;
	private static final double TOTAL_COBRO_VEHICULO_CARRO_HORA = 8000.0;
	private static final double TOTAL_COBRO_VEHICULO_MOTO_DIA = 6000.0;
	private static final String COBRO_ESTADO_PENDIENTE = "PENDIENTE";
	
    	@InjectMocks
    	CobroService cobroService;
	
	    @Mock
	    ITarifaDAO tarifaDaoMock;
	    

	    @Mock
	    ICobroDAO cobroDaoMock;
	    
	
	 @Before
	    public void setUp() throws Exception {
		  cobroService=new CobroService(tarifaDaoMock,cobroDaoMock);
          MockitoAnnotations.initMocks(this);
	    }

	@Test
	public void cobroParqueoPorDiaVehiculoCarro() {

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
				.conEstado(Constantes.ESTADO_COBRO_PENDIENTE)
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

	     cobro=cobroService.cobrarParqueoPorDia(cobro);

		// assert
		assertEquals(TOTAL_COBRO_VEHICULO_CARRO_DIA, cobro.getTotal(),0);

	}

	@Test
	public void cobroParqueoPorDiaVehiculoMoto() {

		// arrange

		TipoVehiculo tipoVehiculo = new TipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		
		Vehiculo vehiculo = VehiculoBuilder.unVehiculo()
				.conPlaca("CBA123")
				.conCilindraje(1200)
				.conTipoVehiculo(tipoVehiculo)
				.build();
		
		Date fechaEntrada=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(6).
				conHora(12)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		
		Date fechaSalida=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(6).
				conHora(22)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		

		Cobro cobro = CobroBuilder.unCobro()
				.conVehiculo(vehiculo)
				.conEstado(Constantes.ESTADO_COBRO_PENDIENTE)
				 .conFechaEntrada(fechaEntrada)
				 .conFechaSalida(fechaSalida)
				.build();
		
	
		   Tarifa tarifaDiaMoto=TarifaBuilder.unaTarifa()
				   .conPrecio(4000).
				   conTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA)
				   .conTipoVehiculo(tipoVehiculo).build();
		   
		   Tarifa tarifaHoraMoto=TarifaBuilder.unaTarifa()
				   .conPrecio(500).
				   conTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA)
				   .conTipoVehiculo(tipoVehiculo).build();
		
		
		   
		   when(tarifaDaoMock.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_DIA,
					Constantes.TIPO_VEHICULO_MOTO)).thenReturn(tarifaDiaMoto);
		   
		   when(tarifaDaoMock.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
					Constantes.TIPO_VEHICULO_MOTO)).thenReturn(tarifaHoraMoto);


		// act

	     cobro=cobroService.cobrarParqueoPorDia(cobro);

		// assert
		assertEquals(TOTAL_COBRO_VEHICULO_MOTO_DIA, cobro.getTotal(),0);

	}

	
	@Test
	public void cobroParqueoPorHoraVehiculoCarro() {

		// arrange

		TipoVehiculo tipoVehiculo = new TipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		
		Vehiculo vehiculo = VehiculoBuilder.unVehiculo()
				.conPlaca("CBA123")
				.conCilindraje(1200)
				.conTipoVehiculo(tipoVehiculo)
				.build();
		
		Date fechaEntrada=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(6).
				conHora(12)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		
		Date fechaSalida=FechaBuilder.unaFecha().
				conAnio(2018).
				conMes(6).
				conDia(6).
				conHora(20)
				.conMinuto(0)
				.conSegundo(0)
				.build();
		

		Cobro cobro = CobroBuilder.unCobro()
				.conVehiculo(vehiculo)
				.conEstado(Constantes.ESTADO_COBRO_PENDIENTE)
				 .conFechaEntrada(fechaEntrada)
				 .conFechaSalida(fechaSalida)
				.build();
		
	

		   Tarifa tarifaHoraCarro=TarifaBuilder.unaTarifa()
				   .conPrecio(1000).
				   conTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA)
				   .conTipoVehiculo(tipoVehiculo).build();
		
		
		   
		   when(tarifaDaoMock.obtenerTarifaPorTemporalidadHoras(Constantes.TEMPORALIDAD_HORAS_TARIFA_HORA,
					Constantes.TIPO_VEHICULO_CARRO)).thenReturn(tarifaHoraCarro);


		// act

	     cobro=cobroService.cobrarParqueoPorHoras(cobro);

		// assert
		assertEquals(TOTAL_COBRO_VEHICULO_CARRO_HORA, cobro.getTotal(),0);

	}
	
	
	
	
	@Test
	public void capacidadValidaCobroParqueo() {
		
		
		// arrange

		 when(cobroDaoMock.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(20);
		 when(cobroDaoMock.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(10);
		
		// act

	    boolean resultado=cobroService.validarCapacidadCobroParqueo();
		
		// assert
		assertEquals(false,resultado);
	}
	
	
	@Test
	public void capacidadInValidaCobroParqueo() {
		
		// arrange

		 when(cobroDaoMock.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(30);
		 when(cobroDaoMock.obtenerNumerosCobrosPendientePorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(10);
		
		// act

	    boolean resultado=cobroService.validarCapacidadCobroParqueo();
		
		// assert
		assertEquals(false,resultado);
	}
	
}
