package co.com.ceiba.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.util.Constantes;
import co.com.ceiba.estacionamiento.util.ValidadorVehiculoPlacaIniciaA;
import testdatabuilder.VehiculoBuilder;

public class VehiculoTest {
	
	private static final String PLACA = "QWE123";
	private static final String PLACA_EMPIEZA_CON_A = "ABC123";
	private static final String PLACA_EMPIEZA_NO_CON_A = "CBA23";
	private static final int CILINDRAJE = 1500;
	

	@Test
	public void crearVehiculoCarro() {
		
		// arrange
		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);
		
		Vehiculo vehiculo = vehiculoBuilder.build();

		// act
	

		// assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
		assertEquals(Constantes.TIPO_VEHICULO_CARRO, vehiculo.getTipoVehiculo().getDescripcion());
	}
	
	
	@Test
	public void crearVehiculoMoto() {
		
		// arrange
		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);

		// act
		Vehiculo vehiculo = vehiculoBuilder.build();

		// assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
		assertEquals(Constantes.TIPO_VEHICULO_MOTO, vehiculo.getTipoVehiculo().getDescripcion());
	}
	
	
	@Test
	public void ingresarVehiculoEmpieceConA() {
		
		// arrange
		ValidadorVehiculoPlacaIniciaA validadorVehiculo= new ValidadorVehiculoPlacaIniciaA();
		
		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA_EMPIEZA_CON_A).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);

		// act
		Vehiculo vehiculo = vehiculoBuilder.build();

		// assert
		
	    boolean siIngresa=validadorVehiculo.placaConA(vehiculo.getPlaca());
	
	    assertTrue(siIngresa);
	}
	
	
	
	@Test
	public void ingresarVehiculoNoEmpieceConA() {
		
		// arrange
		ValidadorVehiculoPlacaIniciaA validadorVehiculo= new ValidadorVehiculoPlacaIniciaA();
		
		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA_EMPIEZA_NO_CON_A).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);

		// act
		Vehiculo vehiculo = vehiculoBuilder.build();

		// assert
		
	    boolean siIngresa=validadorVehiculo.placaConA(vehiculo.getPlaca());
	
	    assertFalse(siIngresa);
	}

}
