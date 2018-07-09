package co.com.ceiba.estacionamiento.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entities.TipoVehiculoEntity;
import co.com.ceiba.estacionamiento.entities.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.Vehiculo;
import testdatabuilder.VehiculoBuilder;


@Repository
public class VehiculoDAO implements IVehiculoDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ITipoVehiculoDAO tipoVehiculoDao;

	@Override
	public Vehiculo buscarVehiculoPorPlaca(String placa) {
		
		VehiculoEntity vehiculoEntity=em.find(VehiculoEntity.class, placa);
	    return VehiculoBuilder.convertirADominio(vehiculoEntity);
	}

	@Override
	@Transactional
	public void registrarVehiculo(Vehiculo vehiculo) {
		
		em.persist(buildVehiculoEntity(vehiculo));
		
	}

	@Override
	public List<Vehiculo> obtenerTodosLosVehiculos() {
		List<Vehiculo> vehiculos=new ArrayList<>();
		List<VehiculoEntity> vehiculosEntity = em.createQuery("FROM Vehiculo", VehiculoEntity.class).getResultList();
		
		 for ( VehiculoEntity vehiculoEntity : vehiculosEntity){
			 vehiculos.add(VehiculoBuilder.convertirADominio(vehiculoEntity));
		 }
		 
		return vehiculos;
	}

	
	private VehiculoEntity buildVehiculoEntity(Vehiculo vehiculo) {

		TipoVehiculoEntity tipoVehiculoEntity = tipoVehiculoDao.obtenerTipoVehiculoEntityPorDescripcion(vehiculo.getTipoVehiculo().getDescripcion());

		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipoVehiculo(tipoVehiculoEntity);
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());

		return vehiculoEntity;
	}
}
