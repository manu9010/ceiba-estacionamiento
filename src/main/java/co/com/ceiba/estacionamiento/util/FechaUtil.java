package co.com.ceiba.estacionamiento.util;

import java.util.Date;

public class FechaUtil {
	
	private  final static int MILLI_TO_HOUR = 1000 * 60 * 60;
	
	public static int diferenciaHoras(Date fechaInicial, Date fechaFinal) {

	    return (int) (fechaInicial.getTime() - fechaFinal.getTime()) / MILLI_TO_HOUR;
	}

}
