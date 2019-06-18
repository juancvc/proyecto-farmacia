package hnch.referencia.core.repository.implementacion.seguridad;
 
import hnch.referencia.core.bean.seguridad.PerfilBean; 
import hnch.referencia.core.entity.seguridad.Perfil;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.PerfilDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("perfilDAO")
public class PerfilDAOImp implements PerfilDAO {

	//@PersistenceContext(unitName = "emfSeguridad")
	//private EntityManager em;
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext//(unitName = "emfSeguridad")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public boolean insertar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.insertar");
			spq.setParameter("NOMBPERF", t.getNombrePerfil());
			spq.setParameter("AUCDUSCR", t.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", t.getIpCreacion());
			spq.execute();

			id = spq.getOutputParameterValue(1);
			if (id != null) {
				// t.setCodigo(Integer.valueOf(id.toString()));
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			getEntityManager().close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub

		boolean sw = false;
		try {
			StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.actualizar");
			spq.setParameter("CODIPERF", t.getCodigo());
			spq.setParameter("NOMBPERF", t.getNombrePerfil());
			spq.setParameter("AUCDUSMO", t.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", t.getIpModificacion());

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			getEntityManager().close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw = false;
		try {
			StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.eliminar");
			spq.setParameter("CODIPERF", t.getCodigo());
			spq.setParameter("AUCDUSMO", t.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", t.getIpModificacion());

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			getEntityManager().close();
		}
		return sw;
	}

	@Override
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws DAOException {
		PerfilBean oRePerfilBean = null;
		List<Perfil> lstPerfil = null;

		System.out.println("PerfilBean getBuscarPorObjecto " + t.getCodigo());
		try {
			StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.buscarObjeto");
			spq.setParameter("CODIPERF", t.getCodigo());

			if (spq.execute()) {
				lstPerfil = spq.getResultList();
			}

			if (lstPerfil != null && lstPerfil.size() > 0) {

				oRePerfilBean = dePerfilToPerfilBean(lstPerfil.get(0));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			getEntityManager().close();
		}
		return oRePerfilBean;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t) throws DAOException {
		  
		System.out.println("PerfilBean getBuscarPorFiltros");
		List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		List<Perfil> lstPerfil = null;

		StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.listar");

		spq.setParameter("NOMBPERF", t.getNombrePerfil());

		if (spq.execute()) {
			lstPerfil = spq.getResultList();
		}

		if (lstPerfil != null && lstPerfil.size() > 0) {
			for ( Perfil p : lstPerfil ) {
				System.out.println("perfil.getNombPerf :: " + p.getNombPerf());
			}
			lstPerfilBean = deListaPerfilAListaPerfilBean(lstPerfil);
		}
		getEntityManager().close();

		return lstPerfilBean;
	}

	@Override
	public boolean existe(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	private List<PerfilBean> deListaPerfilAListaPerfilBean(List<Perfil> lstHorarioExcepcion) {

		List<PerfilBean> lstPerfilBean = null;

		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {

			lstPerfilBean = new ArrayList<PerfilBean>();

			for (int i = 0; i < lstHorarioExcepcion.size(); i++) {
				Perfil entity = lstHorarioExcepcion.get(i);
				PerfilBean bean = dePerfilToPerfilBean(entity);

				lstPerfilBean.add(bean);
			}
		}

		return lstPerfilBean;
	}

	private PerfilBean dePerfilToPerfilBean(Perfil entity) {
		PerfilBean bean = new PerfilBean();
		if (entity != null) {
			bean.setCodigo(entity.getCodiPerf());
			bean.setNombrePerfil(entity.getNombPerf());

		}
		return bean;
	}

	@Transactional
	@Override
	public List<PerfilBean> listado() throws  DAOException {
		System.out.println("PerfilBean listado");
		System.out.println(" getEntityManager() " +  getEntityManager()); 
		List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		
			Query query = getEntityManager().createNativeQuery("SELECT * FROM [SIGEHOV2SEGU].RECO.PERFIL as p  WHERE p.ESTADORG = 1 ",Perfil.class);
			List<Perfil> resultList = query.getResultList();
			if (resultList != null && resultList.size() > 0) {
				for ( Perfil p : resultList ) {
					System.out.println("perfil.getNombPerf :: " + p.getNombPerf());
				}
				lstPerfilBean = deListaPerfilAListaPerfilBean(resultList);
			}
			getEntityManager().close();
			return lstPerfilBean;
		 
		
	/***	List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		List<Perfil> lstPerfil = null;

		StoredProcedureQuery spq = getEntityManager().createNamedStoredProcedureQuery("perfil.listado"); 

		if (spq.execute()) {
			lstPerfil = spq.getResultList();
		}

		if (lstPerfil != null && lstPerfil.size() > 0) {
			for ( Perfil p : lstPerfil ) {
				System.out.println("perfil.getNombPerf :: " + p.getNombPerf());
			}
			lstPerfilBean = deListaPerfilAListaPerfilBean(lstPerfil);
		}
		getEntityManager().close();

		return lstPerfilBean;*/
	}

}
