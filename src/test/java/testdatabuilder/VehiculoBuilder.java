package testdatabuilder;

import co.com.ceiba.estacionamiento.entities.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.TipoVehiculo;
import co.com.ceiba.estacionamiento.model.Vehiculo;


public class VehiculoBuilder {
	
	private static final String PLACA = "12345";
	private static final int CILINDRAJE = 0;
	private static final TipoVehiculo TIPO_VEHICULO = null;
	
	private String placa;
	private int cilindraje;
    private TipoVehiculo tipoVehiculo;
	
    
    public VehiculoBuilder(){
        this.placa = PLACA;
        this.cilindraje = CILINDRAJE;
        this.tipoVehiculo=TIPO_VEHICULO;
    }
    
    
	public VehiculoBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	
	public VehiculoBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.cilindraje, this.tipoVehiculo);
	}
	
	public static VehiculoBuilder unVehiculo() {
		return new VehiculoBuilder();
	}


	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), TipoVehiculoBuilder.convertirADominio(vehiculoEntity.getTipoVehiculo()));
		}
		return vehiculo;
		
	}






}
