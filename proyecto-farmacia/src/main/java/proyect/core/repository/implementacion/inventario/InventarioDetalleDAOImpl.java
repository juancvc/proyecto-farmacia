package proyect.core.repository.implementacion.inventario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.inventario.InventarioDetalleBean;
import proyect.core.repository.interfaces.inventario.InventarioDetalleDAO;
import proyect.web.utilitarios.VO; 
import proyect.core.entity.inventario.InventarioDetalle;

@Transactional
@Repository("InventarioDetalleDAO")
public class InventarioDetalleDAOImpl implements InventarioDetalleDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(InventarioDetalleBean InventarioDetalle) throws DAOException {
		Object idInventarioDetalle= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("InventarioDetalle.insertar");
		 
			
			spq.execute();
			
			idInventarioDetalle = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idInventarioDetalle)) {
				InventarioDetalle.setCodigo(idInventarioDetalle.toString());
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
	public boolean actualizar(InventarioDetalleBean InventarioDetalle) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("InventarioDetalle.update");
			
		/*	spq.setParameter("ID_InventarioDetalle", InventarioDetalle.getIdInventarioDetalle());	
			spq.setParameter("ID_ORGANIZACION", InventarioDetalle.getIdOrganizacionInventarioDetalle());
			spq.setParameter("ID_INSTITUCION", InventarioDetalle.getIdInstitucionInventarioDetalle());
			spq.setParameter("ID_SEDE", InventarioDetalle.getIdSedeInventarioDetalle());
			spq.setParameter("NOMBRE_CORTO", InventarioDetalle.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", InventarioDetalle.getNombreLargo());
			spq.setParameter("ALIAS", InventarioDetalle.getAlias());
			spq.setParameter("ID_SITUACION", InventarioDetalle.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", InventarioDetalle.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", InventarioDetalle.getAud_ip());
			spq.setParameter("AUD_SESSION", InventarioDetalle.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", InventarioDetalle.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", InventarioDetalle.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", InventarioDetalle.getCodigoMinsa());
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
	public boolean eliminar(InventarioDetalleBean InventarioDetalle) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("InventarioDetalle.delete");
			
	/*		spq.setParameter("ID_InventarioDetalle", InventarioDetalle.getIdInventarioDetalle());	
			spq.setParameter("ID_ORGANIZACION", InventarioDetalle.getIdOrganizacionInventarioDetalle());
			spq.setParameter("ID_INSTITUCION", InventarioDetalle.getIdInstitucionInventarioDetalle());
			spq.setParameter("ID_SEDE", InventarioDetalle.getIdSedeInventarioDetalle());
			spq.setParameter("AUD_ID_USUARIO", InventarioDetalle.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", InventarioDetalle.getAud_ip());
			spq.setParameter("AUD_SESSION", InventarioDetalle.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", InventarioDetalle.getAud_pc_mac());
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
	public InventarioDetalleBean getBuscarPorObjecto(InventarioDetalleBean InventarioDetalle) throws DAOException {
		List<InventarioDetalle> lstInventarioDetalle = null;	
	   InventarioDetalleBean lstInventarioDetalleBean = null;
		
	   System.out.println("InventarioDetalle.getCodigo() " + InventarioDetalle.getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("InventarioDetalle.buscarPorObjeto");  
			spq.setParameter("idInventarioDetalle", InventarioDetalle.getCodigo()); 
			
			 if (spq.execute()) {
				 lstInventarioDetalle =  spq.getResultList(); 
			 }
			 
			if (lstInventarioDetalle != null && lstInventarioDetalle.size() > 0) {
				lstInventarioDetalleBean = deObjetoAObjetoBean(lstInventarioDetalle.get(0));
			 }
			
			em.close();
			
		   
		return lstInventarioDetalleBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventarioDetalleBean> getBuscarPorFiltros(InventarioDetalleBean InventarioDetalle)
			throws DAOException {
		
		List<InventarioDetalle> lstInventarioDetalle = null;	
		List<InventarioDetalleBean> lstInventarioDetalleBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventarioDetalle.buscarPorFiltros");  
		 	spq.setParameter("idInventario", InventarioDetalle.getInventario().getCodigo()); 
			
			 if (spq.execute()) {
				 lstInventarioDetalle =  spq.getResultList(); 
			 }
			 
			if (lstInventarioDetalle != null && lstInventarioDetalle.size() > 0) {
				lstInventarioDetalleBean = deListaObjetoAListaObjetoBean(lstInventarioDetalle);
			 }
			
			em.close();
			
		   
		return lstInventarioDetalleBean;
	}
 

private List<InventarioDetalleBean> deListaObjetoAListaObjetoBean(List<InventarioDetalle> lstInventarioDetalle) {
		
		List<InventarioDetalleBean> lstInventarioDetalleBean = null;
		
		if (lstInventarioDetalle != null && lstInventarioDetalle.size() > 0) {
			
			lstInventarioDetalleBean = new ArrayList<InventarioDetalleBean>();
			
			for (int i = 0; i < lstInventarioDetalle.size(); i++) { 
				InventarioDetalle entity = lstInventarioDetalle.get(i);
				InventarioDetalleBean bean = deObjetoAObjetoBean(entity);
				
				lstInventarioDetalleBean.add(bean);
			}
		}
		
		return lstInventarioDetalleBean;
	}
	
	private InventarioDetalleBean deObjetoAObjetoBean(InventarioDetalle entity) {
		
		InventarioDetalleBean bean = null; 
		if (entity != null) { 
			bean = new InventarioDetalleBean();
			bean.setCodigo(entity.getIdInventarioDetalle());  
			bean.setCantidad(entity.getCantidad());
			bean.getStock().setCodigo(entity.getIdStock());
			bean.getStock().setLote(entity.getLote());
			bean.getStock().setStock(entity.getStock());
			bean.getStock().getArticulo().setCodigo(entity.getIdArticulo());
			bean.getStock().getArticulo().setNombre(entity.getNombreArticulo());
			bean.getStock().getArticulo().getTipoPresentacion().setDescripcionLarga(entity.getDescripcionLargaPresentacion());
			bean.getStock().getArticulo().setCodigoSismed(entity.getCodigoSismed());
			bean.setFaltantes(entity.getFaltante());
			bean.setSobrantes(entity.getSobrante());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(InventarioDetalleBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InventarioDetalleBean> listarReporteProceso(InventarioBean inventarioBean) 
			throws DAOException {
		List<InventarioDetalle> lstInventarioDetalle = null;	
		List<InventarioDetalleBean> lstInventarioDetalleBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventarioDetalle.reporteProceso");  
		 	spq.setParameter("idInventario", inventarioBean.getCodigo()); 
			
			 if (spq.execute()) {
				 lstInventarioDetalle =  spq.getResultList(); 
			 } 
			 
			if (lstInventarioDetalle != null && lstInventarioDetalle.size() > 0) {
				lstInventarioDetalleBean = deListaObjetoAListaObjetoBean(lstInventarioDetalle);
			 } 
			em.close(); 
		   
		return lstInventarioDetalleBean;
	}
 
}
