package co.com.ceiba.estacionamiento.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entities.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.model.Tarifa;


@Repository
public class TarifaDAO implements ITarifaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ITipoVehiculoDAO tipoVehiculoDao;

	@Override
	public Tarifa obtenerTarifaPorTemporalidadHoras(int horasParqueo, String tipoVehiculo) {
	
		Query query = em.createNamedQuery("SELECT tipoVehiculo FROM TipoVehiculo tipoVehiculo WHERE tipoVehiculo.descripcion = :descripcion");
		//query.setParameter("decscripcion", descripcion);

		return null;
	}

}
