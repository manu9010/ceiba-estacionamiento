package co.com.ceiba.estacionamiento.model;

public class CobroTarifa {
	
	private Cobro cobro;
	private Tarifa tarifa;
	private int cantidadTarifa;
    private double subtotal;
    
	
	
	public CobroTarifa(Cobro cobro, Tarifa tarifa, int cantidadTarifa, double subtotal) {
		this.cobro = cobro;
		this.tarifa = tarifa;
		this.cantidadTarifa = cantidadTarifa;
		this.subtotal = subtotal;
	}



	public Cobro getCobro() {
		return cobro;
	}
	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}



	public double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public int getCantidadTarifa() {
		return cantidadTarifa;
	}



	public void setCantidadTarifa(int cantidadTarifa) {
		this.cantidadTarifa = cantidadTarifa;
	}
	
	
	

}
