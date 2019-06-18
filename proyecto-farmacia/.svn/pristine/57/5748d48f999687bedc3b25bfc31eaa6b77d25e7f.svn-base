package hnch.referencia.core.repository.implementacion.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.bean.asistencial.banco.EstadoFisicoBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.entity.asistencial.banco.EstadoFisico;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.banco.EstadoFisicoDAO; 

@Transactional
@Repository("EstadoFisicoDAOImp")
public class EstadoFisicoDAOImp implements EstadoFisicoDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public EstadoFisicoBean getEstadoFisicoBean(Object object){
		return (EstadoFisicoBean)object;
	}
	
	@Override
	public boolean insertar(EstadoFisicoBean EstadoFisicoBean) throws DAOException {

		Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("estadoFisico.insertar"); 
			spq.setParameter("CODORGAN", EstadoFisicoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", EstadoFisicoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", EstadoFisicoBean.getCodigoSede()); 
			 
			spq.setParameter("NROVERSI", EstadoFisicoBean.getNumeroVersion());
			spq.setParameter("NROPERIO", EstadoFisicoBean.getNumeroPeriodo());
			
			spq.setParameter("CODPERSO", EstadoFisicoBean.getPersonaBean().getCodigo()); 
			
			spq.setParameter("FECHA", EstadoFisicoBean.getFecha()); 
			spq.setParameter("HORA", EstadoFisicoBean.getHora()); 
			spq.setParameter("HTCO", EstadoFisicoBean.getHtco()); 
			spq.setParameter("CODGRUPO", EstadoFisicoBean.getGrupoSanguineo().getCodReg()); 
			spq.setParameter("CODFACTOR", EstadoFisicoBean.getFactor().getCodReg()); 
			
			spq.setParameter("CALIFDONA", EstadoFisicoBean.getCalificacion().getCodReg()); 
			spq.setParameter("OBS", EstadoFisicoBean.getObservacion()); 
			spq.setParameter("ESTADOEVF", "1"); 
			spq.setParameter("AUCDUSCR", EstadoFisicoBean.getIpCreacion());
			spq.setParameter("AUPCIPCR", EstadoFisicoBean.getNombreUsuarioCreacion().toUpperCase());
			 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(15); 
			
			if (id != null) {
				EstadoFisicoBean.setCodigo(id.toString()); 
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
	public boolean actualizar(EstadoFisicoBean EstadoFisicoBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("estadoFisico.modificar"); 
			spq.setParameter("CODFISICO", EstadoFisicoBean.getCodigo()); 
			spq.setParameter("NVERSION", EstadoFisicoBean.getNumeroVersion());
			spq.setParameter("NPERIODO", EstadoFisicoBean.getNumeroPeriodo()); 
			spq.setParameter("CODPERSO", EstadoFisicoBean.getPersonaBean().getCodigo()); 
			spq.setParameter("HCTO", EstadoFisicoBean.getHtco()); 
			spq.setParameter("CODGRUPO", EstadoFisicoBean.getGrupoSanguineo().getCodReg()); 
			spq.setParameter("CODFACTOR", EstadoFisicoBean.getFactor().getCodReg());  
			spq.setParameter("CALIFDONA", EstadoFisicoBean.getCalificacion().getCodReg()); 
			spq.setParameter("OBS", EstadoFisicoBean.getObservacion()); 
			spq.setParameter("ESTADOEVF", "0"); 
			
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
	public boolean eliminar(EstadoFisicoBean EstadoFisicoBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.eliminar"); 
			spq.setParameter("CODORGAN", EstadoFisicoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", EstadoFisicoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", EstadoFisicoBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", EstadoFisicoBean.getCodigo());
			spq.setParameter("NROPERIO", EstadoFisicoBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", EstadoFisicoBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", EstadoFisicoBean.getIpModificacion()); 
			
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
	public EstadoFisicoBean getBuscarPorObjecto(EstadoFisicoBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoFisicoBean> getBuscarPorFiltros(EstadoFisicoBean EstadoFisicoBean) throws DAOException {
		List<EstadoFisico> lstEstadoFisico = null;	
		List<EstadoFisicoBean> lstEstadoFisicoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("estadoFisico.buscarPorFiltros");   
			spq.setParameter("CODPERSO", EstadoFisicoBean.getPersonaBean().getCodigo()); 
			
			 if (spq.execute()) {
				 lstEstadoFisico =  spq.getResultList(); 
			 }
			 
			if (lstEstadoFisico != null && lstEstadoFisico.size() > 0) {
				lstEstadoFisicoBean = deListaObjetoAListaObjetoBean(lstEstadoFisico);
			 }
			
			em.close();
			
		   
		return lstEstadoFisicoBean;
	}
	
	 

private List<EstadoFisicoBean> deListaObjetoAListaObjetoBean(List<EstadoFisico> lstEstadoFisico) {
		
		List<EstadoFisicoBean> lstEstadoFisicoBean = null;
		
		if (lstEstadoFisico != null && lstEstadoFisico.size() > 0) {
			
			lstEstadoFisicoBean = new ArrayList<EstadoFisicoBean>();
			
			for (int i = 0; i < lstEstadoFisico.size(); i++) { 
				EstadoFisico entity = lstEstadoFisico.get(i);
				EstadoFisicoBean bean = deObjetoAObjetoBean(entity);
				
				lstEstadoFisicoBean.add(bean);
			}
		}
		
		return lstEstadoFisicoBean;
	}
	
	private EstadoFisicoBean deObjetoAObjetoBean(EstadoFisico entity) {
		
		EstadoFisicoBean bean = null; 
		if (entity != null) { 
			bean = new EstadoFisicoBean();
			bean.setCodigo(entity.getId().getCodFisico());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			
			bean.setFecha(entity.getFecha());
			bean.setsHora(entity.getHora());
			bean.setHtco(entity.getHtco());
			bean.getFactor().setNombreCorto(entity.getGrupo());
			bean.getGrupoSanguineo().setNombreCorto(entity.getFactor());
			bean.setObservacion(entity.getObserva());
			bean.getCalificacion().setNombreCorto(entity.getCALIFDONAN());
			bean.setResultadoSerologia(entity.getRESULTADO());
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(EstadoFisicoBean t) throws DAOException {

		return false;
	}

	 

}
