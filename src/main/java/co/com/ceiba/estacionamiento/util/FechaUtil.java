package co.com.ceiba.estacionamiento.util;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

public class FechaUtil {
	
	private  final static int MILLI_TO_HOUR = 1000 * 60 * 60;
	
	public static int diferenciaHoras(Date fechaInicial, Date fechaFinal) {

	    return (int) (fechaFinal.getTime() - fechaInicial.getTime()) / MILLI_TO_HOUR;
	}
	
	
	public static FechaDiasHoras diferenciaDiasHoras(Date fechaFinal , Date fechaInicial){
		  
		FechaDiasHoras fechaDiasHoras;

		long diferencia = fechaFinal.getTime() - fechaInicial.getTime();
			
			long segundosEnMili = 1000;
			long minutosEnMili = segundosEnMili * 60;
			long horasEnMili = minutosEnMili * 60;
			long diasEnMili = horasEnMili * 24;

			long dias = diferencia / diasEnMili;
			diferencia = diferencia % diasEnMili;
			
			long horas = diferencia / horasEnMili;
			
			fechaDiasHoras=new FechaDiasHoras(dias, horas);
			
			return  fechaDiasHoras;
		
		}
	
	
	public static boolean esDia(Date fecha,DayOfWeek dia) {
		LocalDate localDate = convertirALocalDate(fecha);
		DayOfWeek dayOfWeek = DayOfWeek.of(localDate.get(ChronoField.DAY_OF_WEEK));
			
		return dayOfWeek.equals(dia);
		
	}
	
	
	private static LocalDate convertirALocalDate(Date fecha) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = fecha.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		return localDate;
	}

}
