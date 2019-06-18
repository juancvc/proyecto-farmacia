package hnch.referencia.core.repository.implementacion.asistencial.referencia;
 
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.entity.asistencial.referencia.Refapoyo;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaEspecialidad;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaApoyoDXDAO;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaDiagnosticoDAO; 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



 
@Transactional
@Repository("referenciaApoyodxDAO")
public class ReferenciaApoyoDxDAOImp implements ReferenciaApoyoDXDAO{
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public ReferenciaApoyoDxBean getReferenciaApoyoDxBean(Object object){
		return (ReferenciaApoyoDxBean)object;
	}


	
	@Override
	public boolean insertar(ReferenciaApoyoDxBean ReferenciaApoyoDxBean) throws DAOException {   
		Object idReferenciaEspecialidad= null; 
		System.out.println("ReferenciaApoyoDxBean.getCodigoUsuarioCreacion() " + ReferenciaApoyoDxBean.getCodigoUsuarioCreacion());
		System.out.println("ReferenciaApoyoDxBean.getIpCreacion() " + ReferenciaApoyoDxBean.getIpCreacion());
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaApoyoDX.insertar");
			spq.setParameter("CODREFCB", ReferenciaApoyoDxBean.getReferenciaBean().getCodigo()); 
			spq.setParameter("NROPERCB", ReferenciaApoyoDxBean.getReferenciaBean().getNumeroPeriodo());
			spq.setParameter("NROVERCB", ReferenciaApoyoDxBean.getReferenciaBean().getNumeroVersion());
			
			spq.setParameter("CODORGAN", ReferenciaApoyoDxBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ReferenciaApoyoDxBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ReferenciaApoyoDxBean.getCodigoSede()); 
			
			spq.setParameter("TG14TPAP", ReferenciaApoyoDxBean.getTipoApoyo().getCodReg());
			spq.setParameter("CODTARCB", ReferenciaApoyoDxBean.getApoyoDX().getCodReg());
			
			spq.setParameter("AUCDUSCR", ReferenciaApoyoDxBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", ReferenciaApoyoDxBean.getIpCreacion()); 
			
			spq.execute();
			
			idReferenciaEspecialidad = spq.getOutputParameterValue(1);
			if (idReferenciaEspecialidad != null) {
				ReferenciaApoyoDxBean.setCodigo(idReferenciaEspecialidad.toString());
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
	public boolean actualizar(ReferenciaApoyoDxBean ReferenciaApoyoDxBean) throws DAOException {
		boolean sw=false;
		System.out.println("ReferenciaApoyoDxBean actualizar " + ReferenciaApoyoDxBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.actualizar");
			spq.setParameter("p_codlengua", ReferenciaApoyoDxBean.getCodigo());  
			
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
	public boolean eliminar(ReferenciaApoyoDxBean ReferenciaApoyoDxBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.eliminar");
			spq.setParameter("p_codlengua", ReferenciaApoyoDxBean.getCodigo()); 
			spq.setParameter("p_codusumod", ReferenciaApoyoDxBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ReferenciaApoyoDxBean.getIpModificacion());
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
	public ReferenciaApoyoDxBean getBuscarPorObjecto(ReferenciaApoyoDxBean ReferenciaApoyoDxBean) throws DAOException {
		ReferenciaApoyoDxBean oReferenciaApoyoDxBean = null;
		List<Refapoyo> lstReferenciaEspecialidad = null;
		System.out.println("ReferenciaApoyoDxBean getBuscarPorObjecto " + ReferenciaApoyoDxBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_codigo");			
			spq.setParameter("p_codlengua", ReferenciaApoyoDxBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstReferenciaEspecialidad = spq.getResultList();			
			}
			
			if (	lstReferenciaEspecialidad != null
				&&	lstReferenciaEspecialidad.size() > 0) {
				
				oReferenciaApoyoDxBean = deLenguaAReferenciaApoyoDxBean(lstReferenciaEspecialidad.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oReferenciaApoyoDxBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ReferenciaApoyoDxBean> getBuscarPorFiltros(ReferenciaApoyoDxBean lengua) throws DAOException { 
		List<Refapoyo> lstLengua = null;	
		List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_filtros");
			 if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstReferenciaApoyoDxBean = deListaRefapoyoAListaReferenciaApoyoDxBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaApoyoDxBean;
	}


	@Override
	public boolean existe(ReferenciaApoyoDxBean ReferenciaApoyoDxBean) throws DAOException { 
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
	
	private List<ReferenciaApoyoDxBean> deListaRefapoyoAListaReferenciaApoyoDxBean(List<Refapoyo> lstHorarioExcepcion) {
		
		List<ReferenciaApoyoDxBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<ReferenciaApoyoDxBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Refapoyo entity = lstHorarioExcepcion.get(i);
				ReferenciaApoyoDxBean bean = deLenguaAReferenciaApoyoDxBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private ReferenciaApoyoDxBean deLenguaAReferenciaApoyoDxBean(Refapoyo entity) {
		
		ReferenciaApoyoDxBean bean = null;
		
		if (entity != null) {
			
			bean = new ReferenciaApoyoDxBean();
			bean.setCodigo(entity.getId().getCodapoyo());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			bean.setNumeroVersion(entity.getId().getNroversi());
			
			bean.getTipoApoyo().setCodReg(entity.getTg14tpap());
			bean.getTipoApoyo().setNombreCorto(entity.getNomTPApo());
			bean.getApoyoDX().setCodReg(entity.getCodtarcb());
			bean.getApoyoDX().setNombreCorto(entity.getNomApoyo());
		}
		
		return bean;
	}



	@Override
	public List<ReferenciaApoyoDxBean> listarPorReferenciaBean(ReferenciaBean referenciaBean)
			throws hnch.referencia.base.repository.DAOException {
		List<Refapoyo> lstLengua = null;	
		List<ReferenciaApoyoDxBean> lstReferenciaApoyoDxBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaApoyoDX.findByRefCb");
			spq.setParameter("CODREFCB", referenciaBean.getCodigo()); 
			spq.setParameter("NROPERIO", referenciaBean.getNumeroPeriodo());
			spq.setParameter("NROVERSI", referenciaBean.getNumeroVersion());
			
			spq.setParameter("CODORGAN", referenciaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", referenciaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", referenciaBean.getCodigoSede()); 
			 if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstReferenciaApoyoDxBean = deListaRefapoyoAListaReferenciaApoyoDxBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaApoyoDxBean;
	}
    

}
