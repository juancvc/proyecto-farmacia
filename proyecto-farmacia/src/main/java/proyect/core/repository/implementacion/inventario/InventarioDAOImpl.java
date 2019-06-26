package proyect.core.repository.implementacion.inventario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.core.entity.inventario.Inventario;
import proyect.base.repository.DAOException;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.repository.interfaces.inventario.InventarioDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("InventarioDAO")
public class InventarioDAOImpl implements InventarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(InventarioBean Inventario) throws DAOException {
		Object idInventario= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Inventario.insertar");
		 
			
			spq.execute();
			
			idInventario = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idInventario)) {
				Inventario.setCodigo(idInventario.toString());
				sw=true;
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InventarioBean Inventario) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Inventario.update");
			
		/*	spq.setParameter("ID_Inventario", Inventario.getIdInventario());	
			spq.setParameter("ID_ORGANIZACION", Inventario.getIdOrganizacionInventario());
			spq.setParameter("ID_INSTITUCION", Inventario.getIdInstitucionInventario());
			spq.setParameter("ID_SEDE", Inventario.getIdSedeInventario());
			spq.setParameter("NOMBRE_CORTO", Inventario.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", Inventario.getNombreLargo());
			spq.setParameter("ALIAS", Inventario.getAlias());
			spq.setParameter("ID_SITUACION", Inventario.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", Inventario.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", Inventario.getAud_ip());
			spq.setParameter("AUD_SESSION", Inventario.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", Inventario.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", Inventario.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", Inventario.getCodigoMinsa());
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
	public boolean eliminar(InventarioBean Inventario) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Inventario.delete");
			
	/*		spq.setParameter("ID_Inventario", Inventario.getIdInventario());	
			spq.setParameter("ID_ORGANIZACION", Inventario.getIdOrganizacionInventario());
			spq.setParameter("ID_INSTITUCION", Inventario.getIdInstitucionInventario());
			spq.setParameter("ID_SEDE", Inventario.getIdSedeInventario());
			spq.setParameter("AUD_ID_USUARIO", Inventario.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", Inventario.getAud_ip());
			spq.setParameter("AUD_SESSION", Inventario.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", Inventario.getAud_pc_mac());
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
	public InventarioBean getBuscarPorObjecto(InventarioBean Inventario) throws DAOException {
		List<Inventario> lstInventario = null;	
	   InventarioBean lstInventarioBean = null;
		
	   System.out.println("Inventario.getCodigo() " + Inventario.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Inventario.buscarPorObjeto");  
			spq.setParameter("idInventario", Inventario.getCodigo()); 
			
			 if (spq.execute()) {
				 lstInventario =  spq.getResultList(); 
			 }
			 
			if (lstInventario != null && lstInventario.size() > 0) {
				lstInventarioBean = deObjetoAObjetoBean(lstInventario.get(0));
			 }
			
			em.close();
			
		   
		return lstInventarioBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventarioBean> getBuscarPorFiltros(InventarioBean Inventario)
			throws DAOException {
		
		List<Inventario> lstInventario = null;	
		List<InventarioBean> lstInventarioBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Inventario.buscarPorFiltros");  
		//	spq.setParameter("nombreInventario", Inventario.getNombreInventario()); 
			
			 if (spq.execute()) {
				 lstInventario =  spq.getResultList(); 
			 }
			 
			if (lstInventario != null && lstInventario.size() > 0) {
				lstInventarioBean = deListaObjetoAListaObjetoBean(lstInventario);
			 }
			
			em.close();
			
		   
		return lstInventarioBean;
	}
 

private List<InventarioBean> deListaObjetoAListaObjetoBean(List<Inventario> lstInventario) {
		
		List<InventarioBean> lstInventarioBean = null;
		
		if (lstInventario != null && lstInventario.size() > 0) {
			
			lstInventarioBean = new ArrayList<InventarioBean>();
			
			for (int i = 0; i < lstInventario.size(); i++) { 
				Inventario entity = lstInventario.get(i);
				InventarioBean bean = deObjetoAObjetoBean(entity);
				
				lstInventarioBean.add(bean);
			}
		}
		
		return lstInventarioBean;
	}
	
	private InventarioBean deObjetoAObjetoBean(Inventario entity) {
		
		InventarioBean bean = null; 
		if (entity != null) {
			
			bean = new InventarioBean();
			bean.setCodigo(entity.getIdInventario());   
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(InventarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


}
