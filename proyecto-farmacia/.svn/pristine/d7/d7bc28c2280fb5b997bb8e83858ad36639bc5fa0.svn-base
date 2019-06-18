package hnch.referencia.core.repository.implementacion.asistencial.referencia;
 
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaApoyoDxResultadoBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.entity.asistencial.referencia.Dxresult;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaEspecialidad;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaApoyoDXDAO;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaApoyoDxResultadoDAO;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaDiagnosticoDAO; 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



 
@Transactional
@Repository("referenciaApoyodxResultadoDAO")
public class ReferenciaApoyoDxResultadoDAOImp implements ReferenciaApoyoDxResultadoDAO{
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public ReferenciaApoyoDxResultadoBean getReferenciaApoyoDxResultadoBean(Object object){
		return (ReferenciaApoyoDxResultadoBean)object;
	}


	
	@Override
	public boolean insertar(ReferenciaApoyoDxResultadoBean ReferenciaApoyoDxResultadoBean) throws DAOException {   
		Object idReferenciaEspecialidad= null; 
		System.out.println("ReferenciaApoyoDxResultadoBean.getCodigoUsuarioCreacion() " + ReferenciaApoyoDxResultadoBean.getCodigoUsuarioCreacion());
		System.out.println("ReferenciaApoyoDxResultadoBean.getIpCreacion() " + ReferenciaApoyoDxResultadoBean.getIpCreacion());
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaApoyoDXResultado.insertar");
			spq.setParameter("CODORGAN", ReferenciaApoyoDxResultadoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ReferenciaApoyoDxResultadoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ReferenciaApoyoDxResultadoBean.getCodigoSede()); 
			
			spq.setParameter("CODREFCB", ReferenciaApoyoDxResultadoBean.getReferenciaBean().getCodigo()); 
			spq.setParameter("NROPERCB", ReferenciaApoyoDxResultadoBean.getReferenciaBean().getNumeroPeriodo());
			spq.setParameter("NROVERCB", ReferenciaApoyoDxResultadoBean.getReferenciaBean().getNumeroVersion());
			 
			spq.setParameter("TG14TPAP", ReferenciaApoyoDxResultadoBean.getTipoApoyo().getCodReg());
			spq.setParameter("CODTARCB", ReferenciaApoyoDxResultadoBean.getApoyoDX().getCodReg());
			
			spq.setParameter("TG1APOYO", ReferenciaApoyoDxResultadoBean.getApoyoDX().getCodReg());
			spq.setParameter("NOMRESUL", ReferenciaApoyoDxResultadoBean.getNombreDocumentoResultado());
			spq.setParameter("EXTRESUL", ReferenciaApoyoDxResultadoBean.getExtensionDocumentoResultado());
			
			spq.setParameter("AUCDUSCR", ReferenciaApoyoDxResultadoBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", ReferenciaApoyoDxResultadoBean.getIpCreacion()); 
			
			spq.execute();
			
			idReferenciaEspecialidad = spq.getOutputParameterValue(1);
			if (idReferenciaEspecialidad != null) {
				ReferenciaApoyoDxResultadoBean.setCodigo(idReferenciaEspecialidad.toString());
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
	public boolean actualizar(ReferenciaApoyoDxResultadoBean ReferenciaApoyoDxResultadoBean) throws DAOException {
		boolean sw=false;
		System.out.println("ReferenciaApoyoDxResultadoBean actualizar " + ReferenciaApoyoDxResultadoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.actualizar");
			spq.setParameter("p_codlengua", ReferenciaApoyoDxResultadoBean.getCodigo());  
			
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
	public boolean eliminar(ReferenciaApoyoDxResultadoBean ReferenciaApoyoDxResultadoBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.eliminar");
			spq.setParameter("p_codlengua", ReferenciaApoyoDxResultadoBean.getCodigo()); 
			spq.setParameter("p_codusumod", ReferenciaApoyoDxResultadoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ReferenciaApoyoDxResultadoBean.getIpModificacion());
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
	public ReferenciaApoyoDxResultadoBean getBuscarPorObjecto(ReferenciaApoyoDxResultadoBean ReferenciaApoyoDxResultadoBean) throws DAOException {
		ReferenciaApoyoDxResultadoBean oReferenciaApoyoDxResultadoBean = null;
		List<Dxresult> lstReferenciaEspecialidad = null;
		System.out.println("ReferenciaApoyoDxResultadoBean getBuscarPorObjecto " + ReferenciaApoyoDxResultadoBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_codigo");			
			spq.setParameter("p_codlengua", ReferenciaApoyoDxResultadoBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstReferenciaEspecialidad = spq.getResultList();			
			}
			
			if (	lstReferenciaEspecialidad != null
				&&	lstReferenciaEspecialidad.size() > 0) {
				
				oReferenciaApoyoDxResultadoBean = deLenguaAReferenciaApoyoDxResultadoBean(lstReferenciaEspecialidad.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oReferenciaApoyoDxResultadoBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ReferenciaApoyoDxResultadoBean> getBuscarPorFiltros(ReferenciaApoyoDxResultadoBean lengua) throws DAOException { 
		List<Dxresult> lstLengua = null;	
		List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoDxResultadoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_filtros");
			 if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				lstReferenciaApoyoDxResultadoBean = deListaLenguaAListaReferenciaApoyoDxResultadoBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaApoyoDxResultadoBean;
	}


	@Override
	public boolean existe(ReferenciaApoyoDxResultadoBean ReferenciaApoyoDxResultadoBean) throws DAOException { 
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
	
	private List<ReferenciaApoyoDxResultadoBean> deListaLenguaAListaReferenciaApoyoDxResultadoBean(List<Dxresult> lstHorarioExcepcion) {
		
		List<ReferenciaApoyoDxResultadoBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<ReferenciaApoyoDxResultadoBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Dxresult entity = lstHorarioExcepcion.get(i);
				ReferenciaApoyoDxResultadoBean bean = deLenguaAReferenciaApoyoDxResultadoBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private ReferenciaApoyoDxResultadoBean deLenguaAReferenciaApoyoDxResultadoBean(Dxresult entity) {
		
		ReferenciaApoyoDxResultadoBean bean = null;
		
		if (entity != null) {
			
			bean = new ReferenciaApoyoDxResultadoBean();
			bean.setCodigo(entity.getId().getCoddxres());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			bean.setNumeroVersion(entity.getId().getNroversi());
			
			bean.setNombreDocumentoResultado(entity.getNomresul());
			bean.getTipoApoyo().setCodReg(entity.getTg14tpap());
			bean.getTipoApoyo().setNombreCorto(entity.getNomTPApo());
			bean.getApoyoDX().setCodReg(entity.getCodTarCB());
			bean.getApoyoDX().setNombreCorto(entity.getNomApoyo());
			
	 	}
		
		return bean;
	}



	@Override
	public List<ReferenciaApoyoDxResultadoBean> listarPorReferenciaBean(ReferenciaBean referenciaBean)
			throws hnch.referencia.base.repository.DAOException {
		List<Dxresult> lstLengua = null;	
		List<ReferenciaApoyoDxResultadoBean> lstReferenciaApoyoDxResultadoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaApoyoDXResultado.findByRefCb");
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
				
				lstReferenciaApoyoDxResultadoBean = deListaLenguaAListaReferenciaApoyoDxResultadoBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaApoyoDxResultadoBean;
	}
    

}
