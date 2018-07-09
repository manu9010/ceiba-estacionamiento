package co.com.ceiba.estacionamiento.model;

public class CobroTarifa {
	
	private Cobro cobro;
	private Tarifa tarifa;
	private int cantidadTarifa;

	
	
	public CobroTarifa(Cobro cobro, Tarifa tarifa, int cantidadTarifa) {
		this.cobro = cobro;
		this.tarifa = tarifa;
		this.cantidadTarifa = cantidadTarifa;
	}



	public CobroTarifa() {
		// TODO Auto-generated constructor stub
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




	public int getCantidadTarifa() {
		return cantidadTarifa;
	}



	public void setCantidadTarifa(int cantidadTarifa) {
		this.cantidadTarifa = cantidadTarifa;
	}
	
	
	

}
