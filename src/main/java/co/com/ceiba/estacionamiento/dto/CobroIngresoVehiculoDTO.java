package co.com.ceiba.estacionamiento.dto;

public class CobroIngresoVehiculoDTO {
	
	private String mensaje;
	private int codigo;
	
	public CobroIngresoVehiculoDTO(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	
	
	
	

}
