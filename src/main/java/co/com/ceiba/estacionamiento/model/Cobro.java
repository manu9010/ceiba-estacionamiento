package co.com.ceiba.estacionamiento.model;

import java.util.Date;
import java.util.List;

public class Cobro {
	
	 private double total;
	 private String estado;
	 private Date fechaEntrada;
	 private Date fechaSalida;
	 private Vehiculo vehiculo;
	 private List<Tarifa> tarifas;
	 
	 
	public Cobro(double total, String estado, Date fechaEntrada, Date fechaSalida, Vehiculo vehiculo,
			List<Tarifa> tarifas) {
		this.total = total;
		this.estado = estado;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.tarifas = tarifas;
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


	public List<Tarifa> getTarifas() {
		return tarifas;
	}


	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
	
	
	 
	 
	 
	
}
