package hnch.referencia.core.repository.implementacion.asistencial.referencia;
 
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaEspecialidadBean;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaEspecialidad;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaEspecialidadDAO; 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



 
@Transactional
@Repository("referenciaEspecialidadDAO")
public class ReferenciaEspecialidadDAOImp implements ReferenciaEspecialidadDAO {
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public ReferenciaEspecialidadBean getReferenciaEspecialidadBean(Object object){
		return (ReferenciaEspecialidadBean)object;
	}


	
	@Override
	public boolean insertar(ReferenciaEspecialidadBean ReferenciaEspecialidadBean) throws DAOException {   
		Object idReferenciaEspecialidad= null; 
		System.out.println("ReferenciaEspecialidadBean.getCodigoUsuarioCreacion() " + ReferenciaEspecialidadBean.getCodigoUsuarioCreacion());
		System.out.println("ReferenciaEspecialidadBean.getIpCreacion() " + ReferenciaEspecialidadBean.getIpCreacion());
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaEspecialidad.insertar");
			spq.setParameter("CODORGAN", ReferenciaEspecialidadBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ReferenciaEspecialidadBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ReferenciaEspecialidadBean.getCodigoSede());
			spq.setParameter("CODPERSO", ReferenciaEspecialidadBean.getReferenciaBean().getPaciente().getCodigo());
			spq.setParameter("CODCBREF", ReferenciaEspecialidadBean.getReferenciaBean().getCodigo()); 
			spq.setParameter("NROPERCB", ReferenciaEspecialidadBean.getReferenciaBean().getNumeroPeriodo());
			spq.setParameter("NROVERCB", ReferenciaEspecialidadBean.getReferenciaBean().getNumeroVersion()); 
			spq.setParameter("NUMREFER", ReferenciaEspecialidadBean.getReferenciaBean().getNumeroReferencia());
			spq.setParameter("TG01CLRE", ReferenciaEspecialidadBean.getReferenciaBean().getServicioUPSReferencia().getCodReg());
			spq.setParameter("TG01TIRE", ReferenciaEspecialidadBean.getReferenciaBean().getTipoReferencia().getCodReg());
			spq.setParameter("CODRESPE", ReferenciaEspecialidadBean.getEspecialidad().getCodReg());
			
			spq.setParameter("SITUACRG", ReferenciaEspecialidadBean.getSituacion().getCodReg());
			spq.setParameter("AUCDUSCR", ReferenciaEspecialidadBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", ReferenciaEspecialidadBean.getAudHostIP());
			spq.setParameter("AUOBSEMO", ReferenciaEspecialidadBean.getAudObservacionModificacion());
			
			spq.execute();
			
			idReferenciaEspecialidad = spq.getOutputParameterValue(1);
			if (idReferenciaEspecialidad != null) {
				ReferenciaEspecialidadBean.setCodigo(idReferenciaEspecialidad.toString());
				sw=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


	@Override
	public boolean actualizar(ReferenciaEspecialidadBean ReferenciaEspecialidadBean) throws DAOException {
		boolean sw=false;
		System.out.println("ReferenciaEspecialidadBean actualizar " + ReferenciaEspecialidadBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.actualizar");
			spq.setParameter("p_codlengua", ReferenciaEspecialidadBean.getCodigo());  
			
			spq.execute();   
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


	@Override
	public boolean eliminar(ReferenciaEspecialidadBean ReferenciaEspecialidadBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.eliminar");
			spq.setParameter("p_codlengua", ReferenciaEspecialidadBean.getCodigo()); 
			spq.setParameter("p_codusumod", ReferenciaEspecialidadBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ReferenciaEspecialidadBean.getIpModificacion());
			spq.execute();  
			sw=true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


	@SuppressWarnings("unchecked")
	@Override
	public ReferenciaEspecialidadBean getBuscarPorObjecto(ReferenciaEspecialidadBean ReferenciaEspecialidadBean) throws DAOException {
		ReferenciaEspecialidadBean oReferenciaEspecialidadBean = null;
		List<ReferenciaEspecialidad> lstReferenciaEspecialidad = null;
		System.out.println("ReferenciaEspecialidadBean getBuscarPorObjecto " + ReferenciaEspecialidadBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_codigo");			
			spq.setParameter("p_codlengua", ReferenciaEspecialidadBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstReferenciaEspecialidad = spq.getResultList();			
			}
			
			if (	lstReferenciaEspecialidad != null
				&&	lstReferenciaEspecialidad.size() > 0) {
				
				oReferenciaEspecialidadBean = deLenguaAReferenciaEspecialidadBean(lstReferenciaEspecialidad.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oReferenciaEspecialidadBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ReferenciaEspecialidadBean> getBuscarPorFiltros(ReferenciaEspecialidadBean lengua) throws DAOException { 
		List<ReferenciaEspecialidad> lstLengua = null;	
		List<ReferenciaEspecialidadBean> lstReferenciaEspecialidadBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_filtros");
			 if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstReferenciaEspecialidadBean = deListaLenguaAListaReferenciaEspecialidadBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaEspecialidadBean;
	}


	@Override
	public boolean existe(ReferenciaEspecialidadBean ReferenciaEspecialidadBean) throws DAOException { 
		Boolean sw = true;
		List<ReferenciaEspecialidad> lstReferenciaEspecialidad = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.existe");			
		 	
		
			if (spq.execute()) {
				lstReferenciaEspecialidad = spq.getResultList();			
			}
			
			if (	lstReferenciaEspecialidad != null
				&&	lstReferenciaEspecialidad.size() > 0) {
				
				sw = true;
			}else{
				sw = false;
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}
	
	private List<ReferenciaEspecialidadBean> deListaLenguaAListaReferenciaEspecialidadBean(List<ReferenciaEspecialidad> lstHorarioExcepcion) {
		
		List<ReferenciaEspecialidadBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<ReferenciaEspecialidadBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				ReferenciaEspecialidad entity = lstHorarioExcepcion.get(i);
				ReferenciaEspecialidadBean bean = deLenguaAReferenciaEspecialidadBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private ReferenciaEspecialidadBean deLenguaAReferenciaEspecialidadBean(ReferenciaEspecialidad entity) {
		
		ReferenciaEspecialidadBean bean = null;
		
		if (entity != null) {
			
			bean = new ReferenciaEspecialidadBean();
			
	 	}
		
		return bean;
	}
    

}
