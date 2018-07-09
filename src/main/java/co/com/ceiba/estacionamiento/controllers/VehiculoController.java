package co.com.ceiba.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.dto.VehiculoResponseDTO;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import co.com.ceiba.estacionamiento.service.IVehiculoService;

@RestController
@RequestMapping("/api/1.0/vehiculo")
@CrossOrigin
public class VehiculoController {

	@Autowired
	IVehiculoService VehiculoService;

	@RequestMapping(value = "/{placa}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<VehiculoResponseDTO> obtenerVehiculo(@PathVariable String placa) {
		try {
			Vehiculo vehiculo = VehiculoService.consultarVechiculoPorPlaca(placa);
			if (vehiculo != null) {
				return new ResponseEntity<>(new VehiculoResponseDTO(vehiculo, "", 0), null, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new VehiculoResponseDTO(null, "", 0), null, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(new VehiculoResponseDTO(null, e.getMessage(), 0), null,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
