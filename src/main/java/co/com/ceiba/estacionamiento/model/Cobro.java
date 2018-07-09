package co.com.ceiba.estacionamiento.model;

import java.util.Date;
import java.util.List;


public class Cobro {
	
	 private double total;
	 private String estado;
	 private Date fechaEntrada;
	 private Date fechaSalida;
	 private Vehiculo vehiculo;
	 private List<CobroTarifa> cobroTarifa;
	 
	 

	public Cobro(double total, String estado, Date fechaEntrada, Date fechaSalida, Vehiculo vehiculo,
			List<CobroTarifa> cobroTarifa) {
		super();
		this.total = total;
		this.estado = estado;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.cobroTarifa = cobroTarifa;
	}


	public Cobro() {
		// TODO Auto-generated constructor stub
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public List<CobroTarifa> getCobroTarifa() {
		return cobroTarifa;
	}


	public void setCobroTarifa(List<CobroTarifa> cobroTarifa) {
		this.cobroTarifa = cobroTarifa;
	}


	 
	
}
