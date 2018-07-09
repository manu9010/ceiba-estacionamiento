package co.com.ceiba.estacionamiento.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entities.TarifaEntity;
import co.com.ceiba.estacionamiento.model.Tarifa;
import co.com.ceiba.estacionamiento.testdatabuilder.TarifaBuilder;



@Repository
public class TarifaDAO implements ITarifaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ITipoVehiculoDAO tipoVehiculoDao;

	@Override
	public Tarifa obtenerTarifaPorTemporalidadHoras(int temporalidadHoras, String tipoVehiculo) {
	
		Query query = em.createQuery("SELECT tarifa FROM Tarifa tarifa WHERE tarifa.temporalidadHoras=:temporalidadHoras AND tarifa.tipoVehiculo.descripcion=:tipoVehiculo");
		query.setParameter("temporalidadHoras", temporalidadHoras);
		query.setParameter("tipoVehiculo", tipoVehiculo);

		TarifaEntity tarifaEntity= (TarifaEntity) query.getSingleResult();
		return TarifaBuilder.convertirADominio(tarifaEntity);
	}
	
	@Override
	public TarifaEntity obtenerTarifaEntityPorTemporalidadHoras(int temporalidadHoras, String tipoVehiculo) {
	
		Query query = em.createQuery("SELECT tarifa FROM Tarifa tarifa WHERE tarifa.temporalidadHoras=:temporalidadHoras AND tarifa.tipoVehiculo.descripcion=:tipoVehiculo");
		query.setParameter("temporalidadHoras", temporalidadHoras);
		query.setParameter("tipoVehiculo", tipoVehiculo);


		return (TarifaEntity) query.getSingleResult();
	}

}
