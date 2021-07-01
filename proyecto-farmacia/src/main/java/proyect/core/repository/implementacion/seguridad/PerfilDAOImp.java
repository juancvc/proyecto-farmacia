package proyect.core.repository.implementacion.seguridad;
 
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

import proyect.base.repository.DAOException;
import proyect.core.bean.general.AlmacenBean;
import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.entity.seguridad.Perfil;
import proyect.core.repository.interfaces.seguridad.PerfilDAO;
import proyect.web.utilitarios.VO;

@Transactional
@Repository("perfilDAO")
public class PerfilDAOImp implements PerfilDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean insertar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.insertar");
			System.out.println("t.getNombrePerfil() " + t.getNombrePerfil());
			spq.setParameter("nombrePerfil", t.getNombrePerfil()); 
			spq.setParameter("descripcion", t.getDescripcion());
			spq.setParameter("usuarioRegistro", t.getUsuarioRegistro());
			spq.setParameter("ipRegistro", t.getIpRegistro());
			spq.execute();
			id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setCodigo(id.toString());
				sw = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub

		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.actualizar");
			spq.setParameter("CODIPERF", t.getCodigo());
			spq.setParameter("NOMBPERF", t.getNombrePerfil()); 
			spq.setParameter("AUPCIPMO", t.getIpModificacion());

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PerfilBean t) throws DAOException {
		// TODO Auto-generated method stub
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.eliminar");
			spq.setParameter("CODIPERF", t.getCodigo()); 
			spq.setParameter("AUPCIPMO", t.getIpModificacion());

			spq.execute();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
		} finally {
			em.close();
		}
		return sw;
	}

	@Override
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws DAOException {
		PerfilBean oRePerfilBean = null;
		List<Perfil> lstPerfil = null;

		System.out.println("PerfilBean getBuscarPorObjecto " + t.getCodigo());
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.buscarxid");
			spq.setParameter("codigo", t.getCodigo());

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
			em.close();
		}
		return oRePerfilBean;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t) throws DAOException {
		  
		System.out.println("PerfilBean getBuscarPorFiltros");
		List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		List<Perfil> lstPerfil = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.buscarxcriterios");

		spq.setParameter("nombrePerfil", t.getNombrePerfil());

		if (spq.execute()) {
			lstPerfil = spq.getResultList();
		}

		if (lstPerfil != null && lstPerfil.size() > 0) {
			for ( Perfil p : lstPerfil ) {
				System.out.println("perfil.getNombreCorto :: " + p.getNombrePerfil());
			}
			lstPerfilBean = deListaPerfilAListaPerfilBean(lstPerfil);
		}
		em.close();

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
			bean.setCodigo(entity.getIdPerfil());
			bean.setNombrePerfil(entity.getNombrePerfil());
			bean.setDescripcion(entity.getDescripcion());
		}
		return bean;
	}

	@Transactional
	@Override
	public List<PerfilBean> listado() throws  DAOException {
		System.out.println("PerfilBean listado");
		System.out.println(" em " +  em); 
		List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		
			Query query = em.createNativeQuery("SELECT * FROM PERFIL as p  WHERE estado = 1 ",Perfil.class);
			List<Perfil> resultList = query.getResultList();
			if (resultList != null && resultList.size() > 0) {
				for ( Perfil p : resultList ) {
				}
				lstPerfilBean = deListaPerfilAListaPerfilBean(resultList);
			}
			em.close();
			return lstPerfilBean;
		 
		
	/***	List<PerfilBean> lstPerfilBean = new ArrayList<PerfilBean>();
		List<Perfil> lstPerfil = null;

		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("perfil.listado"); 

		if (spq.execute()) {
			lstPerfil = spq.getResultList();
		}

		if (lstPerfil != null && lstPerfil.size() > 0) {
			for ( Perfil p : lstPerfil ) {
				System.out.println("perfil.getNombreCorto :: " + p.getNombreCorto());
			}
			lstPerfilBean = deListaPerfilAListaPerfilBean(lstPerfil);
		}
		em.close();

		return lstPerfilBean;*/
	}

}
