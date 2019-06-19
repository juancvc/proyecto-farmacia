package sigelab.core.repository.implementacion.farmacia.general;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import sigelab.core.bean.asistencial.farmacia.general.AlmacenBean;
import sigelab.core.entity.asistencial.banco.Campania;
import sigelab.core.entity.inventario.Almacen;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.farmacia.general.AlmacenDAO; 

@Transactional
@Repository("almacenDAO")
public class AlmacenDAOImpl implements AlmacenDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(AlmacenBean almacen) throws DAOException {
		Object idAlmacen= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.insertar");
		/*	spq.setParameter("ID_ORGANIZACION", almacen.getIdOrganizacionAlmacen());
			spq.setParameter("ID_INSTITUCION", almacen.getIdInstitucionAlmacen());
			spq.setParameter("ID_SEDE", almacen.getIdSedeAlmacen());
			spq.setParameter("NOMBRE_CORTO", almacen.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", almacen.getNombreLargo());
			spq.setParameter("ALIAS", almacen.getAlias());
			spq.setParameter("ID_SITUACION", almacen.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", almacen.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", almacen.getAud_ip());
			spq.setParameter("AUD_SESSION", almacen.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 1);
			spq.setParameter("AUD_MAC", almacen.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", almacen.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", almacen.getCodigoMinsa());
			spq.execute();
			
			idAlmacenBean = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idAlmacen)) {
				almacen.setIdAlmacen(Integer.valueOf(idAlmacen.toString()));
				sw=true;
			}*/
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(AlmacenBean almacen) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.update");
			
		/*	spq.setParameter("ID_ALMACEN", almacen.getIdAlmacen());	
			spq.setParameter("ID_ORGANIZACION", almacen.getIdOrganizacionAlmacen());
			spq.setParameter("ID_INSTITUCION", almacen.getIdInstitucionAlmacen());
			spq.setParameter("ID_SEDE", almacen.getIdSedeAlmacen());
			spq.setParameter("NOMBRE_CORTO", almacen.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", almacen.getNombreLargo());
			spq.setParameter("ALIAS", almacen.getAlias());
			spq.setParameter("ID_SITUACION", almacen.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", almacen.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", almacen.getAud_ip());
			spq.setParameter("AUD_SESSION", almacen.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", almacen.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", almacen.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", almacen.getCodigoMinsa());
			*/
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(AlmacenBean almacen) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.delete");
			
	/*		spq.setParameter("ID_ALMACEN", almacen.getIdAlmacen());	
			spq.setParameter("ID_ORGANIZACION", almacen.getIdOrganizacionAlmacen());
			spq.setParameter("ID_INSTITUCION", almacen.getIdInstitucionAlmacen());
			spq.setParameter("ID_SEDE", almacen.getIdSedeAlmacen());
			spq.setParameter("AUD_ID_USUARIO", almacen.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", almacen.getAud_ip());
			spq.setParameter("AUD_SESSION", almacen.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", almacen.getAud_pc_mac());
			spq.execute();
			*/
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public AlmacenBean getBuscarPorObjecto(AlmacenBean almacen) throws DAOException {
		List<Almacen> lstAlmacen = null;	
	   AlmacenBean lstAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.buscarPorObjeto");  
			spq.setParameter("ID_ALMACEN", almacen.getCodigo()); 
			
			 if (spq.execute()) {
				 lstAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstAlmacen != null && lstAlmacen.size() > 0) {
				lstAlmacenBean = deObjetoAObjetoBean(lstAlmacen.get(0));
			 }
			
			em.close();
			
		   
		return lstAlmacenBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlmacenBean> getBuscarPorFiltros(AlmacenBean almacen)
			throws DAOException {
		
		List<Almacen> lstAlmacen = null;	
		List<AlmacenBean> lstAlmacenBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("almacen.buscarPorFiltros");  
			spq.setParameter("NOMBRE_CORTO", almacen.getNombreAlmacen()); 
			
			 if (spq.execute()) {
				 lstAlmacen =  spq.getResultList(); 
			 }
			 
			if (lstAlmacen != null && lstAlmacen.size() > 0) {
				lstAlmacenBean = deListaObjetoAListaObjetoBean(lstAlmacen);
			 }
			
			em.close();
			
		   
		return lstAlmacenBean;
	}
 

private List<AlmacenBean> deListaObjetoAListaObjetoBean(List<Almacen> lstAlmacen) {
		
		List<AlmacenBean> lstAlmacenBean = null;
		
		if (lstAlmacen != null && lstAlmacen.size() > 0) {
			
			lstAlmacenBean = new ArrayList<AlmacenBean>();
			
			for (int i = 0; i < lstAlmacen.size(); i++) { 
				Almacen entity = lstAlmacen.get(i);
				AlmacenBean bean = deObjetoAObjetoBean(entity);
				
				lstAlmacenBean.add(bean);
			}
		}
		
		return lstAlmacenBean;
	}
	
	private AlmacenBean deObjetoAObjetoBean(Almacen entity) {
		
		AlmacenBean bean = null; 
		if (entity != null) {
			
			bean = new AlmacenBean();
			bean.setCodigo(entity.getIdAlmacen());   
			
			bean.setNombreAlmacen(entity.getNombreCorto());
			 
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(AlmacenBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


}
