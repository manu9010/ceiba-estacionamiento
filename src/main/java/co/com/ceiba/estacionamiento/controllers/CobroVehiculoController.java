package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.dto.CobroTotalResponseDTO;
import co.com.ceiba.estacionamiento.dto.CobrosPendientesResponseDTO;
import co.com.ceiba.estacionamiento.dto.CobroIngresoVehiculoDTO;
import co.com.ceiba.estacionamiento.exceptions.VehiculoException;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.service.ICobroVehiculoService;
import co.com.ceiba.estacionamiento.util.Constantes;

@RestController
@RequestMapping("/api/1.0/cobro/vehiculo")
@CrossOrigin
public class CobroVehiculoController {
	
	
	@Autowired
	ICobroVehiculoService cobroVehiculoService;
	
	
	@RequestMapping(value="/ingreso", method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<CobroIngresoVehiculoDTO> registrarCobroIngresoVehiculo(@RequestBody Vehiculo vehiculo) {
		try {
			cobroVehiculoService.registrarCobroIngresoVehiculo(vehiculo);
			 return new ResponseEntity<>(new CobroIngresoVehiculoDTO("",Constantes.VEHICULO_INGRESADO_EXITO_RESPONSE), null, HttpStatus.OK);
		} catch (VehiculoException v) {
			 return new ResponseEntity<>(new CobroIngresoVehiculoDTO(v.getMessage(),Constantes.VEHICULO_NO_AUTORIZADO_INGRESO_RESPONSE), null, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			 return new ResponseEntity<>(new CobroIngresoVehiculoDTO(e.getMessage(),Constantes.ERROR_INTERNO), null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	
	@RequestMapping(value="/salida/{placa}", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<CobroTotalResponseDTO> registrarCobroSalidaVehiculo(@PathVariable String placa) {
		try {
			double cobroTotal=cobroVehiculoService.calcularCobroTotalParqueoVehiculo(placa);
			return new ResponseEntity<>(new CobroTotalResponseDTO(cobroTotal,""), null, HttpStatus.OK);
		} catch (Exception e) {
			 return new ResponseEntity<>(new CobroTotalResponseDTO(0,e.getMessage()), null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping(value="/pendientes", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<CobrosPendientesResponseDTO> obtenerCobrosVehiculoPendientes() {
		try {
			 List<Cobro> cobrosPendientes=cobroVehiculoService.obtenerCobrosVehiculoPendientes();
			return new ResponseEntity<>(new CobrosPendientesResponseDTO(cobrosPendientes,""), null, HttpStatus.OK);
		} catch (Exception e) {
			 return new ResponseEntity<>(new CobrosPendientesResponseDTO(null,e.getMessage()), null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
