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
	public boolean insertar(InventarioBean inventario) throws DAOException {
		Object idInventario= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.insert");
			spq.setParameter("idAlmacen", inventario.getAlmacen().getCodigo());
			spq.setParameter("mes", inventario.getMes().getIdRegistro());
			spq.setParameter("anio", inventario.getPeriodo().getIdRegistro());
			spq.setParameter("cantidadItems", inventario.getCantidadItems());
			spq.setParameter("cadenaCantidad", inventario.getCadenaCantidad());
			spq.setParameter("nroDocumento", inventario.getNroDocumento());
			spq.setParameter("idPersonalResponsable", inventario.getPersonalResponsable().getCodigo());
			spq.setParameter("fecha", inventario.getFecha());
			spq.setParameter("usuarioRegistro", inventario.getUsuarioRegistro());
			spq.setParameter("ipRegistro", inventario.getIpRegistro());
			spq.setParameter("cadenaIdStock", inventario.getCadenaIdStock());
			spq.execute();
			
			idInventario = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idInventario)) {
				inventario.setCodigo(idInventario.toString());
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.update");
			
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.delete");
			
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.buscarPorObjeto");  
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
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.buscarPorFiltros");  
			spq.setParameter("idAlmacen", Inventario.getAlmacen().getCodigo()); 
			spq.setParameter("mes", Inventario.getMes().getIdRegistro()); 
			spq.setParameter("anio", Inventario.getPeriodo().getIdRegistro()); 
			
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
			bean.setNroDocumento(entity.getNroDocumento()); 
			bean.getAlmacen().setCodigo(entity.getIdAlmacen()); 
			bean.setUsuarioRegistro(entity.getUsuarioRegistro()); 
			bean.setIpRegistro(entity.getIpRegistro()); 
			bean.getAlmacen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacen().setNombreAlmacen(entity.getNombreAlmacen());
			bean.getMes().setIdRegistro(entity.getMes());
			bean.getMes().setDescripcionCorta(entity.getNombreMes());
			bean.getPeriodo().setIdRegistro(entity.getAnio());
			bean.setFecha(entity.getFechaInvetario());
			bean.getSituacion().setIdRegistro(entity.getIdSituacion());
			bean.getSituacion().setDescripcionCorta(entity.getSituacion());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(InventarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<InventarioBean> listarBuscarxNroDocumento(InventarioBean inventarioBean) {
		List<Inventario> lstInventario = null;	
		List<InventarioBean> lstInventarioBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.buscarXNroDocumento");  
			spq.setParameter("idAlmacen", inventarioBean.getAlmacen().getCodigo()); 
			spq.setParameter("nroDocumento", inventarioBean.getNroDocumento()); 
			 if (spq.execute()) {
				 lstInventario =  spq.getResultList(); 
			 }
			 
			if (lstInventario != null && lstInventario.size() > 0) {
				lstInventarioBean = deListaObjetoAListaObjetoBean(lstInventario);
			 }
			
			em.close();
			
		   
		return lstInventarioBean;
	}

	@Override
	public boolean insertarHistorico(InventarioBean inventario) throws DAOException {
		Object idInventario= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("inventario.insertHistorico");
			spq.setParameter("idFarmacia", inventario.getAlmacen().getCodigo());
			spq.setParameter("nroDocumento", inventario.getNroDocumento());
			spq.setParameter("usuarioRegistro", inventario.getUsuarioRegistro());

			spq.execute();
			
			idInventario = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idInventario)) {
				inventario.setCodigo(idInventario.toString());
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


}
