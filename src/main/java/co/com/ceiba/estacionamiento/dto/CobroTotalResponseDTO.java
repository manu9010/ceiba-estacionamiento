package co.com.ceiba.estacionamiento.dto;

public class CobroTotalResponseDTO {
	
	private double cobroTotal;
	private String mensaje;

	public CobroTotalResponseDTO(double cobroTotal, String mensaje) {
		this.cobroTotal = cobroTotal;
		this.mensaje = mensaje;
	}

	public double getCobroTotal() {
		return cobroTotal;
	}

	public void setCobroTotal(double cobroTotal) {
		this.cobroTotal = cobroTotal;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	
	

}
