package co.com.ceiba.estacionamiento.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entities.TipoVehiculoEntity;


@Repository
public class TipoVehiculoDAO implements ITipoVehiculoDAO {
	
	private static final String TIPO_VEHICULO_FIND_BY_DESCRIPCION = "TipoVehiculo.findByDescripcion";
	
	@PersistenceContext
	EntityManager em;


	@Override
	@Transactional
	public TipoVehiculoEntity obtenerTipoVehiculoEntityPorDescripcion(String descripcion) {
		Query query = em.createNamedQuery(TIPO_VEHICULO_FIND_BY_DESCRIPCION);
		query.setParameter("decscripcion", descripcion);

		return (TipoVehiculoEntity) query.getSingleResult();
	}

}
