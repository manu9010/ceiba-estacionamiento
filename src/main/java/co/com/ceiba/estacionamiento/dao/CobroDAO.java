package co.com.ceiba.estacionamiento.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.entities.CobroEntity;
import co.com.ceiba.estacionamiento.entities.CobroTarifaEntity;
import co.com.ceiba.estacionamiento.entities.TarifaEntity;
import co.com.ceiba.estacionamiento.entities.VehiculoEntity;
import co.com.ceiba.estacionamiento.model.Cobro;
import co.com.ceiba.estacionamiento.model.CobroTarifa;
import co.com.ceiba.estacionamiento.testdatabuilder.CobroBuilder;
import co.com.ceiba.estacionamiento.util.Constantes;



@Repository
public class CobroDAO implements ICobroDAO {

	@PersistenceContext
	EntityManager em;

	@Autowired
	ITarifaDAO tarifaDAO;

	@Autowired
	IVehiculoDAO vehiculoDAO;

	@Override
	public int obtenerNumerosCobrosPendientePorTipoVehiculo(String tipoVehiculoCarro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registrarCobroVehiculo(Cobro cobro) {
		 em.persist(buildCobroEntity(cobro));

	}

	@Override
	public void actualizarCobroVehiculo(Cobro cobro) {
		 em.merge(buildCobroEntity(cobro));

	}
	
	
	@Override
	public Cobro obtenerCobroVehiculoPendiente(String placa) {
		Query query = em.createQuery("SELECT cobro FROM Cobro cobro WHERE cobro.vehiculo.placa=:placa AND cobro.estado=:estado");
		query.setParameter("placa", placa);
		query.setParameter("estado", Constantes.ESTADO_COBRO_PENDIENTE);
		
		CobroEntity cobroEntity =(CobroEntity) query.getSingleResult();
		
	
		return CobroBuilder.convertirADominio(cobroEntity);

	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cobro> obtenerCobrosVehiculoPorEstado(String estado) {
	
		Query query = em.createQuery("SELECT cobro FROM Cobro cobro WHERE cobro.estado=:estado",CobroEntity.class);
		query.setParameter("estado", estado);
		
		List<Cobro> cobros=new ArrayList<>();
		
		List<CobroEntity> cobrosEntity = query.getResultList();
		
		 for ( CobroEntity cobroEntity : cobrosEntity){
			 cobros.add(CobroBuilder.convertirADominio(cobroEntity));
		 }

	
		return cobros;

	}
	
	

	private CobroEntity buildCobroEntity(Cobro cobro) {

		List<CobroTarifaEntity> cobrosTarifaEntity = new ArrayList<>();

		VehiculoEntity vehiculoEntity = vehiculoDAO.buscarVehiculoEntityPorPlaca(cobro.getVehiculo().getPlaca());

		CobroEntity cobroEntity = new CobroEntity();
		cobroEntity.setEstado(cobro.getEstado());
		cobroEntity.setFechaEntrada(cobro.getFechaEntrada());
		cobroEntity.setVehiculo(vehiculoEntity);

		for (CobroTarifa cobroTarifa : cobro.getCobroTarifa()) {
			CobroTarifaEntity cobroTarifaEntity = new CobroTarifaEntity();
			TarifaEntity tarifaEntity = tarifaDAO.obtenerTarifaEntityPorTemporalidadHoras(
					cobroTarifa.getTarifa().getTemporalidad(),
					cobroTarifa.getCobro().getVehiculo().getTipoVehiculo().getDescripcion());

			cobroTarifaEntity.setTarifa(tarifaEntity);
			cobroTarifaEntity.setCantidadTarifa(cobroTarifa.getCantidadTarifa());
			cobroTarifaEntity.setCobro(cobroEntity);
			cobrosTarifaEntity.add(cobroTarifaEntity);

		}
         cobroEntity.setCobroTarifas(cobrosTarifaEntity);
		return cobroEntity;
	}

}
