package proyect.core.repository.implementacion.movimiento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.movimiento.TipoMovimientoBean;
import proyect.core.entity.movimiento.TipoMovimiento;
import proyect.core.repository.interfaces.movimiento.TipoMovimientoDAO;
import proyect.web.utilitarios.VO; 

@Transactional
@Repository("TipoMovimientoDAO")
public class TipoMovimientoDAOImpl implements TipoMovimientoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insertar(TipoMovimientoBean TipoMovimiento) throws DAOException {
		Object idTipoMovimiento= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("TipoMovimiento.insertar");
		 
			
			spq.execute();
			
			idTipoMovimiento = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idTipoMovimiento)) {
				TipoMovimiento.setCodigo(idTipoMovimiento.toString());
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
	public boolean actualizar(TipoMovimientoBean TipoMovimiento) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("TipoMovimiento.update");
			
		/*	spq.setParameter("ID_TipoMovimiento", TipoMovimiento.getIdTipoMovimiento());	
			spq.setParameter("ID_ORGANIZACION", TipoMovimiento.getIdOrganizacionTipoMovimiento());
			spq.setParameter("ID_INSTITUCION", TipoMovimiento.getIdInstitucionTipoMovimiento());
			spq.setParameter("ID_SEDE", TipoMovimiento.getIdSedeTipoMovimiento());
			spq.setParameter("NOMBRE_CORTO", TipoMovimiento.getNombreCorto());
			spq.setParameter("NOMBRE_LARGO", TipoMovimiento.getNombreLargo());
			spq.setParameter("ALIAS", TipoMovimiento.getAlias());
			spq.setParameter("ID_SITUACION", TipoMovimiento.getSituacion().getIdSituacion());
			spq.setParameter("AUD_ID_USUARIO", TipoMovimiento.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", TipoMovimiento.getAud_ip());
			spq.setParameter("AUD_SESSION", TipoMovimiento.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 2);
			spq.setParameter("AUD_MAC", TipoMovimiento.getAud_pc_mac());
			spq.setParameter("AUD_OBSERVACION", TipoMovimiento.getAud_Observacion());
			spq.setParameter("CODIGO_MINSA", TipoMovimiento.getCodigoMinsa());
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
	public boolean eliminar(TipoMovimientoBean TipoMovimiento) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("TipoMovimiento.delete");
			
	/*		spq.setParameter("ID_TipoMovimiento", TipoMovimiento.getIdTipoMovimiento());	
			spq.setParameter("ID_ORGANIZACION", TipoMovimiento.getIdOrganizacionTipoMovimiento());
			spq.setParameter("ID_INSTITUCION", TipoMovimiento.getIdInstitucionTipoMovimiento());
			spq.setParameter("ID_SEDE", TipoMovimiento.getIdSedeTipoMovimiento());
			spq.setParameter("AUD_ID_USUARIO", TipoMovimiento.getAud_usuario().getIdUsuario());
			spq.setParameter("AUD_IP", TipoMovimiento.getAud_ip());
			spq.setParameter("AUD_SESSION", TipoMovimiento.getAud_session());
			spq.setParameter("AUD_ID_OPERACION", 3);
			spq.setParameter("AUD_MAC", TipoMovimiento.getAud_pc_mac());
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
	public TipoMovimientoBean getBuscarPorObjecto(TipoMovimientoBean TipoMovimiento) throws DAOException {
		List<TipoMovimiento> lstTipoMovimiento = null;	
	   TipoMovimientoBean lstTipoMovimientoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("TipoMovimiento.buscarPorObjeto");  
			//spq.setParameter("idTipoMovimiento", TipoMovimiento.getCodigo()); 
			
			 if (spq.execute()) {
				 lstTipoMovimiento =  spq.getResultList(); 
			 }
			 
			if (lstTipoMovimiento != null && lstTipoMovimiento.size() > 0) {
				lstTipoMovimientoBean = deObjetoAObjetoBean(lstTipoMovimiento.get(0));
			 }
			
			em.close();
			
		   
		return lstTipoMovimientoBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoMovimientoBean> getBuscarPorFiltros(TipoMovimientoBean TipoMovimiento)
			throws DAOException {
		
		List<TipoMovimiento> lstTipoMovimiento = null;	
		List<TipoMovimientoBean> lstTipoMovimientoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tipoMovimiento.buscarPorFiltros");  
		 	spq.setParameter("nombreTipoMovimiento", TipoMovimiento.getNombreTipoMovimiento()); 
			
			 if (spq.execute()) {
				 lstTipoMovimiento =  spq.getResultList(); 
			 }
			 
			if (lstTipoMovimiento != null && lstTipoMovimiento.size() > 0) {
				lstTipoMovimientoBean = deListaObjetoAListaObjetoBean(lstTipoMovimiento);
			 }
			
			em.close();
			
		   
		return lstTipoMovimientoBean;
	}
 

private List<TipoMovimientoBean> deListaObjetoAListaObjetoBean(List<TipoMovimiento> lstTipoMovimiento) {
		
		List<TipoMovimientoBean> lstTipoMovimientoBean = null;
		
		if (lstTipoMovimiento != null && lstTipoMovimiento.size() > 0) {
			
			lstTipoMovimientoBean = new ArrayList<TipoMovimientoBean>();
			
			for (int i = 0; i < lstTipoMovimiento.size(); i++) { 
				TipoMovimiento entity = lstTipoMovimiento.get(i);
				TipoMovimientoBean bean = deObjetoAObjetoBean(entity);
				
				lstTipoMovimientoBean.add(bean);
			}
		}
		
		return lstTipoMovimientoBean;
	}
	
	private TipoMovimientoBean deObjetoAObjetoBean(TipoMovimiento entity) {
		
		TipoMovimientoBean bean = null; 
		if (entity != null) {
			
			bean = new TipoMovimientoBean();
			bean.setCodigo(entity.getIdTipoMovimiento());   
			bean.setNombreTipoMovimiento(entity.getNombreTipoMovimiento());
			bean.setCategoriaTipoMovimiento(new CatalogoBean());
			bean.getCategoriaTipoMovimiento().setIdRegistro(entity.getIdCategoriaTipoMovimientoCat02());
			bean.getClase().setIdRegistro(entity.getIdClaseMovimientoCat02());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(TipoMovimientoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}


}
