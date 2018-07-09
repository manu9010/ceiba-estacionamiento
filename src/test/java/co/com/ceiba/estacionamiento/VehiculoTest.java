package co.com.ceiba.estacionamiento;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.dao.IVehiculoDAO;
import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.service.IVehiculoService;
import co.com.ceiba.estacionamiento.service.VehiculoService;
import co.com.ceiba.estacionamiento.testdatabuilder.VehiculoBuilder;
import co.com.ceiba.estacionamiento.util.Constantes;


public class VehiculoTest {
	
	private static final String PLACA = "QWE123";
	private static final String PLACA_EMPIEZA_CON_A = "ABC123";
	private static final String PLACA_EMPIEZA_NO_CON_A = "CBA23";
	private static final int CILINDRAJE = 1500;

	
   	@InjectMocks
	IVehiculoService vehiculoService;
   	
    @Mock
    IVehiculoDAO vehiculoDaoMock;
    
    


 @Before
    public void setUp()  {
	 vehiculoService=new VehiculoService(vehiculoDaoMock);
      MockitoAnnotations.initMocks(this);
    }

	

    @Test
	public void ingresarVehiculoNoExistente() throws VehiculoException {
		
		// arrange
		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);
		
		  Vehiculo vehiculo = vehiculoBuilder.build();
		
		   when(vehiculoDaoMock.buscarVehiculoPorPlaca(vehiculo.getPlaca())).thenReturn(null);
		   
		   

		// act
		
		 vehiculoService.registrarVechiculo(vehiculo);
	
               
		// assert
		
	}
    
    

	
	
	@Test
	public void ingresarVehiculoEmpieceConA() throws VehiculoException {
		
		// arrange

		TipoVehiculo  tipoVehiculo= new TipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
		VehiculoBuilder vehiculoBuilder = new VehiculoBuilder().
				conPlaca(PLACA_EMPIEZA_CON_A).
				conCilindraje(CILINDRAJE).
				conTipoVehiculo(tipoVehiculo);

		// act
		Vehiculo vehiculo = vehiculoBuilder.build();

		   when(vehiculoDaoMock.buscarVehiculoPorPlaca(vehiculo.getPlaca())).thenReturn(null);
		   
		  	 
			try {
				//act
				 vehiculoService.registrarVechiculo(vehiculo);
				fail();
				
			} catch (VehiculoException e) {
				// assert
				Assert.assertEquals(Constantes.VEHICULO_NO_AUTORIZADO_INGRESO, e.getMessage());
			}
	}
	
	
	

}
