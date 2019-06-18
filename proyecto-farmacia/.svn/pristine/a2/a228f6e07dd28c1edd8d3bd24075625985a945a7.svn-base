package hnch.referencia.core.repository.implementacion.asistencial.referencia;
 
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaBean;
import hnch.referencia.core.bean.asistencial.referencia.ReferenciaDiagnosticoBean;
import hnch.referencia.core.entity.asistencial.referencia.Refediag;
import hnch.referencia.core.entity.asistencial.referencia.ReferenciaEspecialidad;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.referencia.ReferenciaDiagnosticoDAO; 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



 
@Transactional
@Repository("referenciaDiagnosticoDAO")
public class ReferenciaDiagnosticoDAOImp implements ReferenciaDiagnosticoDAO {
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public ReferenciaDiagnosticoBean getReferenciaDiagnosticoBean(Object object){
		return (ReferenciaDiagnosticoBean)object;
	}


	
	@Override
	public boolean insertar(ReferenciaDiagnosticoBean ReferenciaDiagnosticoBean) throws DAOException {   
		Object idReferenciaEspecialidad= null; 
		System.out.println("ReferenciaDiagnosticoBean.getCodigoUsuarioCreacion() " + ReferenciaDiagnosticoBean.getCodigoUsuarioCreacion());
		System.out.println("ReferenciaDiagnosticoBean.getIpCreacion() " + ReferenciaDiagnosticoBean.getIpCreacion());
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaDiagnostico.insertar");
			spq.setParameter("CODREFCB", ReferenciaDiagnosticoBean.getReferenciaBean().getCodigo()); 
			spq.setParameter("NROPERCB", ReferenciaDiagnosticoBean.getReferenciaBean().getNumeroPeriodo());
			
			spq.setParameter("CODORGAN", ReferenciaDiagnosticoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", ReferenciaDiagnosticoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", ReferenciaDiagnosticoBean.getCodigoSede()); 
			spq.setParameter("TG6CIEX", ReferenciaDiagnosticoBean.getDiagnostico().getCodReg());
			 
			spq.setParameter("AUCDUSCR", ReferenciaDiagnosticoBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", ReferenciaDiagnosticoBean.getIpCreacion()); 
			spq.setParameter("CODESPEC", ReferenciaDiagnosticoBean.getEspecialidad().getCodReg()); 
			spq.setParameter("TG1TPDX", ReferenciaDiagnosticoBean.getTipo().getCodReg()); 
			spq.execute();
			
			idReferenciaEspecialidad = spq.getOutputParameterValue(1);
			if (idReferenciaEspecialidad != null) {
				ReferenciaDiagnosticoBean.setCodigo(idReferenciaEspecialidad.toString());
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
	public boolean actualizar(ReferenciaDiagnosticoBean ReferenciaDiagnosticoBean) throws DAOException {
		boolean sw=false;
		System.out.println("ReferenciaDiagnosticoBean actualizar " + ReferenciaDiagnosticoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.actualizar");
			spq.setParameter("p_codlengua", ReferenciaDiagnosticoBean.getCodigo());  
			
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
	public boolean eliminar(ReferenciaDiagnosticoBean ReferenciaDiagnosticoBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.eliminar");
			spq.setParameter("p_codlengua", ReferenciaDiagnosticoBean.getCodigo()); 
			spq.setParameter("p_codusumod", ReferenciaDiagnosticoBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", ReferenciaDiagnosticoBean.getIpModificacion());
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
	public ReferenciaDiagnosticoBean getBuscarPorObjecto(ReferenciaDiagnosticoBean ReferenciaDiagnosticoBean) throws DAOException {
		ReferenciaDiagnosticoBean oReferenciaDiagnosticoBean = null;
		List<ReferenciaEspecialidad> lstReferenciaEspecialidad = null;
		System.out.println("ReferenciaDiagnosticoBean getBuscarPorObjecto " + ReferenciaDiagnosticoBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_codigo");			
			spq.setParameter("p_codlengua", ReferenciaDiagnosticoBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lstReferenciaEspecialidad = spq.getResultList();			
			}
			
			if (	lstReferenciaEspecialidad != null
				&&	lstReferenciaEspecialidad.size() > 0) {
				
				//oReferenciaDiagnosticoBean = deLenguaAReferenciaDiagnosticoBean(lstReferenciaEspecialidad.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oReferenciaDiagnosticoBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ReferenciaDiagnosticoBean> getBuscarPorFiltros(ReferenciaDiagnosticoBean lengua) throws DAOException { 
		List<ReferenciaEspecialidad> lstLengua = null;	
		List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ReferenciaEspecialidad.buscar_por_filtros");
			 if (spq.execute()) {
				lstLengua =  spq.getResultList(); 
			} 
			if (lstLengua != null && lstLengua.size() > 0) {
				
				//lstReferenciaDiagnosticoBean = deListaRefDxAListaReferenciaDiagnosticoBean(lstLengua);
			}
			//em.close();
			
		   
		return lstReferenciaDiagnosticoBean;
	}


	@Override
	public boolean existe(ReferenciaDiagnosticoBean ReferenciaDiagnosticoBean) throws DAOException { 
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
	
	private List<ReferenciaDiagnosticoBean> deListaRefDxAListaReferenciaDiagnosticoBean(List<Refediag> lstHorarioExcepcion) {
		
		List<ReferenciaDiagnosticoBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<ReferenciaDiagnosticoBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Refediag entity = lstHorarioExcepcion.get(i);
				ReferenciaDiagnosticoBean bean = deRefediagAReferenciaDiagnosticoBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private ReferenciaDiagnosticoBean deRefediagAReferenciaDiagnosticoBean(Refediag entity) {
		
		ReferenciaDiagnosticoBean bean = null;
		
		if (entity != null) {
			
			bean = new ReferenciaDiagnosticoBean();
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setCodigo(entity.getId().getCoddiagn());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.getDiagnostico().setValor4(entity.getValgen04());
			bean.getDiagnostico().setCodReg(entity.getTg6ciex());
			bean.getDiagnostico().setNombreCorto(entity.getNombDiag());
			bean.getEspecialidad().setCodReg(entity.getCodEspec());
			bean.getEspecialidad().setNombreCorto(entity.getNomEspec());
			bean.getTipo().setCodReg(entity.getTg1TPDXx());
			bean.getTipo().setNombreCorto(entity.getNomTpDx());
			bean.getSituacion().setCodReg(entity.getSituacrg());
	 	}
		
		return bean;
	}



	@Override
	public List<ReferenciaDiagnosticoBean> listarPorReferenciaBean(ReferenciaBean referenciaBean)
			throws hnch.referencia.base.repository.DAOException {
		List<Refediag> lstLengua = null;	
		List<ReferenciaDiagnosticoBean> lstReferenciaDiagnosticoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("referenciaDiagnostico.findByRefCb");
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
				
				lstReferenciaDiagnosticoBean = deListaRefDxAListaReferenciaDiagnosticoBean(lstLengua);
			}
			em.close();
			
		   
		return lstReferenciaDiagnosticoBean;
	}
    

}
