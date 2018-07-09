package co.com.ceiba.estacionamiento.testdatabuilder;

import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
import co.com.ceiba.estacionamiento.model.Tarifa;

public class CobroTarifaBuilder {
	
	
	private static final Cobro COBRO = null;
	private static final Tarifa TARIFA = null;
	private static final int CANTIDAD_TARIFA = 0;
	private static final double SUBTOTAL = 0.0;

	
	private Cobro cobro;
	private Tarifa tarifa;
	private int cantidadTarifa;
    private double subtotal;
    
	public CobroTarifaBuilder() {
		this.cobro = COBRO;
		this.tarifa = TARIFA;
		this.cantidadTarifa = CANTIDAD_TARIFA;
		this.subtotal = SUBTOTAL;
	}
	
	
	public CobroTarifaBuilder conCobro(Cobro cobro) {
		this.cobro = cobro;
		return this;
	}
	
	public CobroTarifaBuilder conTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
		return this;
	}
    
	
	public CobroTarifaBuilder conCantidadTarifa(int  cantidadTarifa) {
		this.cantidadTarifa = cantidadTarifa;
		return this;
	}
    
	
	public CobroTarifaBuilder conSubtotal(int  subtotal) {
		this.subtotal = subtotal;
		return this;
	}
    
	 
	public CobroTarifa build() {
		return new CobroTarifa(this.cobro, this.tarifa, this.cantidadTarifa);
	}
	
	
	public static CobroTarifaBuilder unCobroTarifa(){
        return new CobroTarifaBuilder();
    }
	 
	
	
    
    
    

}
