package co.com.ceiba.estacionamiento.util;

public final class  Constantes {
	
	  //Vehiculo
	  public static final String TIPO_VEHICULO_CARRO = "CARRO";
	  public static final String TIPO_VEHICULO_MOTO = "MOTO";
	  public static final int CILINDRAJE_MOTO_AUMENTO = 500;
	  public static final String VEHICULO_NO_AUTORIZADO_INGRESO = "Vehiculo no autorizado para ingresar";
	  public static final String VEHICULO_EXISTENTE = "Vehiculo existe en base de datos";
	  
	  //Cobro
	  public static final int TEMPORALIDAD_HORAS_TARIFA_HORA =1;
	  public static final int TEMPORALIDAD_HORAS_TARIFA_DIA =24;
	  public static final int HORAS_MAXIMA_PARQUEO_POR_HORA =9;
	  public static final int HORAS_MININA_PARQUEO_POR_DIA =9;
	  public static final int HORAS_MAXIMA_PARQUEO_POR_DIA =24;
	  public static final String ESTADO_COBRO_PENDIENTE ="PENDIENTE";
	  public static final String ESTADO_COBRO_PAGADO ="PAGADO";
	  public static final int TOPE_MAXIMO_PARQUQEO_CARRO =20;
	  public static final int TOPE_MAXIMO_PARQUQEO_MOTO =10;
	  
	  //Error reponse
	  
	  public static final int ERROR_INTERNO = 0;
	  public static final int VEHICULO_INGRESADO_EXITO_RESPONSE = 1;
	  public static final int VEHICULO_NO_AUTORIZADO_INGRESO_RESPONSE = 2;
	  

}
