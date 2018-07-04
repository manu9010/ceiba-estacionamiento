package testdatabuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
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
		return new Cobro(this.total, this.estado, this.fechaEntrada,this.fechaSalida,this.vehiculo,this.cobroTarifa);
	}
	 
	
	
	 
    public CobroBuilder con(CobroTarifaBuilder... cobroTarifaBuilders){
       this.cobroTarifa  =  new ArrayList<CobroTarifa>();
        for(CobroTarifaBuilder cobroTarifaBuilder: cobroTarifaBuilders){
        	this.cobroTarifa.add(cobroTarifaBuilder.build());
        }
        return this;
    }
    
    
    public static CobroBuilder unCobro(){
        return new CobroBuilder();
    }
	 

}
