package co.com.ceiba.estacionamiento.util;

public class ValidadorVehiculo {

	public boolean placaConA(String placa) {

		char c = placa.toUpperCase().charAt(0);
        return c == 'A' ? true : false;

	}

}
