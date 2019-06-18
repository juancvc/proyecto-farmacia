package sigelab.core.repository.implementacion.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sigelab.core.bean.asistencial.banco.PreDonanteEntrevistaBean;  
import sigelab.core.entity.asistencial.banco.Donante;
import sigelab.core.entity.asistencial.banco.PreDonanteEntrevista;
import sigelab.core.repository.DAOException;  
import sigelab.core.repository.interfaces.asistencial.banco.PreDonanteEntrevistaDAO; 

@Transactional
@Repository("PreDonanteEntrevistaDAOImp")
public class PreDonanteEntrevistaDAOImp implements PreDonanteEntrevistaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public PreDonanteEntrevistaBean getPreDonanteEntrevistaBean(Object object){
		return (PreDonanteEntrevistaBean)object;
	}
	
	@Override
	public boolean insertar(PreDonanteEntrevistaBean PreDonanteEntrevistaBean) throws DAOException {

		Object numeroPeriodo= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonanteEntrevista.insertar"); 
			spq.setParameter("CODORGAN", PreDonanteEntrevistaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteEntrevistaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteEntrevistaBean.getCodigoSede()); 
			spq.setParameter("NROVERSI", PreDonanteEntrevistaBean.getNumeroVersion()); 
		//	spq.setParameter("NROPERIO", PreDonanteEntrevistaBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("NROPOST", PreDonanteEntrevistaBean.getPostulanteBean().getCodigo()); 
			spq.setParameter("FECHA", PreDonanteEntrevistaBean.getsFecha());  
			spq.setParameter("CODPERSO", PreDonanteEntrevistaBean.getPostulanteBean().getPersona().getCodigo()); 
			spq.setParameter("CODREG", PreDonanteEntrevistaBean.getPregunta().getCodReg()); 
			spq.setParameter("RESPTA", PreDonanteEntrevistaBean.getRespuesta()); 
			spq.setParameter("OBSERVAC", PreDonanteEntrevistaBean.getObservacion()); 
			spq.setParameter("CODRESPU", ""); 
			spq.setParameter("AUCDUSCR", PreDonanteEntrevistaBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", PreDonanteEntrevistaBean.getNombreUsuarioCreacion().toUpperCase());
			 
			
			
			spq.execute();
			numeroPeriodo = spq.getOutputParameterValue(5);
			sw=true; 
			
			if (numeroPeriodo != null) {
				PreDonanteEntrevistaBean.setNumeroPeriodo(numeroPeriodo.toString()); 
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
	public boolean actualizar(PreDonanteEntrevistaBean PreDonanteEntrevistaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.modificar"); 
			spq.setParameter("CODORGAN", PreDonanteEntrevistaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteEntrevistaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteEntrevistaBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", PreDonanteEntrevistaBean.getCodigo());
			spq.setParameter("NROPERIO", PreDonanteEntrevistaBean.getNumeroPeriodo()); 
			spq.setParameter("SITUACRG", PreDonanteEntrevistaBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", PreDonanteEntrevistaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PreDonanteEntrevistaBean.getIpModificacion()); 
			
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
	public boolean eliminar(PreDonanteEntrevistaBean PreDonanteEntrevistaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonante.eliminar"); 
			spq.setParameter("CODORGAN", PreDonanteEntrevistaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", PreDonanteEntrevistaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", PreDonanteEntrevistaBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", PreDonanteEntrevistaBean.getCodigo());
			spq.setParameter("NROPERIO", PreDonanteEntrevistaBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", PreDonanteEntrevistaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", PreDonanteEntrevistaBean.getIpModificacion()); 
			
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
	public PreDonanteEntrevistaBean getBuscarPorObjecto(PreDonanteEntrevistaBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreDonanteEntrevistaBean> getBuscarPorFiltros(PreDonanteEntrevistaBean PreDonanteEntrevistaBean) throws DAOException {
		List<PreDonanteEntrevista> lstPreDonanteEntrevista = null;	
		List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("preDonanteEntrevista.buscarPorFiltros");   
			spq.setParameter("NROPOST", PreDonanteEntrevistaBean.getPostulanteBean().getCodigo()); 
			spq.setParameter("NPERIODO", PreDonanteEntrevistaBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("CODPERSO", PreDonanteEntrevistaBean.getPostulanteBean().getPersona().getCodigo()); 
			 if (spq.execute()) {
				 lstPreDonanteEntrevista =  spq.getResultList(); 
			 }
			 
			if (lstPreDonanteEntrevista != null && lstPreDonanteEntrevista.size() > 0) {
				System.out.println("lstPreDonanteEntrevista " + lstPreDonanteEntrevista.size());
				lstPreDonanteEntrevistaBean = deListaObjetoAListaObjetoBean(lstPreDonanteEntrevista);
			 }
			
			em.close();
			
		   
		return lstPreDonanteEntrevistaBean;
	}
	
	 

private List<PreDonanteEntrevistaBean> deListaObjetoAListaObjetoBean(List<PreDonanteEntrevista> lstDonante) {
		
		List<PreDonanteEntrevistaBean> lstPreDonanteEntrevistaBean = null;
		
		if (lstDonante != null && lstDonante.size() > 0) {
			
			lstPreDonanteEntrevistaBean = new ArrayList<PreDonanteEntrevistaBean>();
			
			for (int i = 0; i < lstDonante.size(); i++) { 
				PreDonanteEntrevista entity = lstDonante.get(i);
				PreDonanteEntrevistaBean bean = deObjetoAObjetoBean(entity);
				
				lstPreDonanteEntrevistaBean.add(bean);
			}
		}
		
		return lstPreDonanteEntrevistaBean;
	}
	
	private PreDonanteEntrevistaBean deObjetoAObjetoBean(PreDonanteEntrevista entity) {
		
		PreDonanteEntrevistaBean bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new PreDonanteEntrevistaBean();
			bean.setCodigo(entity.getId().getCodRespu());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio()); 
			bean.getPostulanteBean().getPersona().setCodigo(entity.getId().getCodPerso());
			bean.getPostulanteBean().setCodigo(entity.getId().getNroPost());
			bean.getPostulanteBean().getPersona().setApellidoPaterno(entity.getApepater());
			bean.getPostulanteBean().getPersona().setApellidoMaterno(entity.getApemater());
			bean.getPostulanteBean().getPersona().setPrimerNombre(entity.getPrinombr());
			bean.getPostulanteBean().getPersona().setSegundoNombre(entity.getSegnombr());
			bean.getPostulanteBean().getPersona().setNroDocumento(entity.getNroDocum());
			bean.setFechaCreacion(entity.getAufechcr());
			bean.setObservacion(entity.getObservac()); 
			bean.getPregunta().setNombreCorto(entity.getPREGUNTA().toUpperCase());
			bean.setRespuesta(entity.getRespta());
	 	}
		 
		return bean;
	}

	
	
	@Override
	public boolean existe(PreDonanteEntrevistaBean t) throws DAOException {

		return false;
	}

	 
 
}
