package testdatabuilder;

import java.util.Calendar;
import java.util.Date;

public class FechaBuilder {
	
	private int dia;
	private int mes;
	private int anio;
	private int hora;
	private int minuto;
	private int segundo;
	
	
	public FechaBuilder() {
		this.dia = 0;
		this.mes = 0;
		this.anio = 0;
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
	}
	
	
	public FechaBuilder conDia(int dia) {
		this.dia =dia;
		return this;
	}
	
	
	public FechaBuilder conMes(int mes) {
		this.mes =mes;
		return this;
	}
	
	
	public FechaBuilder conAnio(int anio) {
		this.anio =anio;
		return this;
	}
	
	
	public FechaBuilder conHora(int hora) {
		this.hora =hora;
		return this;
	}
	
	
	public FechaBuilder conMinuto(int minuto) {
		this.minuto =minuto;
		return this;
	}
	
	public FechaBuilder conSegundo(int segundo) {
		this.segundo =segundo;
		return this;
	}
	
	
	public Date build() {
		
		Date date = new Calendar.Builder()
			    .setDate(this.anio, this.mes, this.dia)
			    .setTimeOfDay(this.hora, this.minuto,this.segundo)
			    .build().getTime();

		return date;
	}
	
	
	
	public static FechaBuilder unaFecha() {
		return new FechaBuilder();
	}
	

}
