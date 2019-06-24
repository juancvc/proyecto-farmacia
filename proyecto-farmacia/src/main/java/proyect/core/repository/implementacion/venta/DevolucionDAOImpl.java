package proyect.core.repository.implementacion.venta;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import proyect.base.repository.DAOException; 
import proyect.core.bean.venta.DevolucionBean; 
import proyect.core.entity.venta.Devolucion;
import proyect.core.repository.interfaces.venta.DevolucionDAO;
import proyect.web.utilitarios.VO;


@Transactional
@Repository("devolucionDAO")
public class DevolucionDAOImpl implements DevolucionDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(DevolucionBean devolucion) throws DAOException {
		Object idDevolucion= null;
		boolean sw=false;
		System.out.println("Datos :" + devolucion);
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.insertar");
		/*	spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("ID_SITUACION", devolucion.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 1);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", devolucion.getAud_Observacion());*/
			spq.execute();
			
			idDevolucion = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idDevolucion)) {
				devolucion.setCodigo((idDevolucion.toString()));
				sw=true;
			}
			em.close();
			System.out.println("Llego a :" + devolucion);
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(DevolucionBean devolucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.actualizar");
			
	/**		spq.setParameter("ID_CLASE", devolucion.getIdDevolucion());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("ID_SITUACION", devolucion.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", devolucion.getAud_Observacion());
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
	public boolean eliminar(DevolucionBean devolucion) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.eliminar");
		/*	
			spq.setParameter("ID_CLASE", devolucion.getIdDevolucion());	
			spq.setParameter("ID_ORGANIZACION", devolucion.getIdOrganizacionDevolucion());
			spq.setParameter("ID_INSTITUCION", devolucion.getIdInstitucionDevolucion());
			spq.setParameter("ID_SEDE", devolucion.getIdSedeDevolucion());
			spq.setParameter("AUD_ID_USUARIO", devolucion.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", devolucion.getAud_ip());
			spq.setParameter("AUD_SESSION", devolucion.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", devolucion.getAud_pc_mac());
			spq.execute();
			*/
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DevolucionBean getBuscarPorObjecto(DevolucionBean devolucion) throws DAOException {
		
		DevolucionBean oDevolucionBean = null;	
		List<Devolucion> lstDevolucion = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.getBuscarPorObjecto");
			spq.setParameter("idDevolucion", devolucion.getCodigo()); 
			 
			 if (spq.execute()) {
				 lstDevolucion =  spq.getResultList(); 
			 }
			 
			if (lstDevolucion != null && lstDevolucion.size() > 0) {
				oDevolucionBean = deObjetoAObjetoBean(lstDevolucion.get(0));
			 }
			
			em.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return oDevolucionBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DevolucionBean> getBuscarPorFiltros(DevolucionBean devolucion)
			throws DAOException {
		List<DevolucionBean> lstDevolucionBean = null;	
		List<Devolucion> lstDevolucion = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("devolucion.buscarxcriterios");	 
			
			 if (spq.execute()) {
				 lstDevolucion =  spq.getResultList(); 
			 }
			 
			if (lstDevolucion != null && lstDevolucion.size() > 0) {
				lstDevolucionBean = deListaObjetoAListaObjetoBean(lstDevolucion);
			 }
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lstDevolucionBean;
	}
 
	

private List<DevolucionBean> deListaObjetoAListaObjetoBean(List<Devolucion> lstDevolucion) {
		
		List<DevolucionBean> lstDevolucionBean = null;
		
		if (lstDevolucion != null && lstDevolucion.size() > 0) {
			
			lstDevolucionBean = new ArrayList<DevolucionBean>();
			
			for (int i = 0; i < lstDevolucion.size(); i++) { 
				Devolucion entity = lstDevolucion.get(i);
				DevolucionBean bean = deObjetoAObjetoBean(entity);
				
				lstDevolucionBean.add(bean);
			}
		}
		
		return lstDevolucionBean;
	}
	
	private DevolucionBean deObjetoAObjetoBean(Devolucion entity) {
		
		DevolucionBean bean = null; 
		if (entity != null) {
			
			bean = new DevolucionBean();
			bean.setCodigo(entity.getId().getIdDevolucion());   
			bean.setNumeroPeriodo(entity.getId().getNumeroPeriodo());    
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(DevolucionBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
