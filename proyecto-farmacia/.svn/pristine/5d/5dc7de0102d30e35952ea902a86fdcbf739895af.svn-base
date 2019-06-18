package hnch.referencia.core.repository.implementacion.asistencial.banco;
 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hnch.referencia.core.bean.asistencial.banco.SeropositivoBean;  
import hnch.referencia.core.entity.asistencial.banco.Seropositivo;
import hnch.referencia.core.repository.DAOException; 
import hnch.referencia.core.repository.interfaces.asistencial.banco.SeropositivoDAO; 

@Transactional
@Repository("SeropositivoDAOImp")
public class SeropositivoDAOImp implements SeropositivoDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public SeropositivoBean getSeropositivoBean(Object object){
		return (SeropositivoBean)object;
	}
	
	@Override
	public boolean insertar(SeropositivoBean SeropositivoBean) throws DAOException {

	//	Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("seropositivo.insertar"); 
			spq.setParameter("CODORGAN", SeropositivoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", SeropositivoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", SeropositivoBean.getCodigoSede()); 
			spq.setParameter("NROVERSI", SeropositivoBean.getNumeroVersion()); 
			spq.setParameter("NROPERIO", SeropositivoBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("CODENTRE", SeropositivoBean.getCodigo()); 
			spq.setParameter("FECHA", SeropositivoBean.getsFecha());  
			spq.setParameter("NROPOST", SeropositivoBean.getPostulanteBean().getCodigo()); 
			
			spq.setParameter("CODPERSO", SeropositivoBean.getPostulanteBean().getPersona().getCodigo());  
			spq.setParameter("ESTADOPRE","1");  
			
			spq.setParameter("AUCDUSCR", SeropositivoBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", SeropositivoBean.getNombreUsuarioCreacion().toUpperCase());
			 
			
			
			spq.execute();
			
			sw=true;
			/*** 
			
			if (id != null) {
				SeropositivoBean.setCodigo(id.toString()); 
				sw=true;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}

	@Override
	public boolean actualizar(SeropositivoBean SeropositivoBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("seropositivo.modificar"); 
			spq.setParameter("CODORGAN", SeropositivoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", SeropositivoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", SeropositivoBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", SeropositivoBean.getCodigo());
			spq.setParameter("NROPERIO", SeropositivoBean.getNumeroPeriodo()); 
			spq.setParameter("SITUACRG", SeropositivoBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", SeropositivoBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", SeropositivoBean.getIpModificacion()); 
			
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
	public boolean eliminar(SeropositivoBean SeropositivoBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("seropositivo.eliminar"); 
			spq.setParameter("CODORGAN", SeropositivoBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", SeropositivoBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", SeropositivoBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", SeropositivoBean.getCodigo());
			spq.setParameter("NROPERIO", SeropositivoBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", SeropositivoBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", SeropositivoBean.getIpModificacion()); 
			
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
	public SeropositivoBean getBuscarPorObjecto(SeropositivoBean SeropositivoBean) throws DAOException {

		List<Seropositivo> lstSeropositivo = null;	
		SeropositivoBean oSeropositivoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("seropositivo.buscarPorObjeto");   
			spq.setParameter("NROPOST", SeropositivoBean.getPostulanteBean().getCodigo()); 
			spq.setParameter("NPERIODO", SeropositivoBean.getPostulanteBean().getNumeroPeriodo()); 
			spq.setParameter("CODPERSO", SeropositivoBean.getPostulanteBean().getPersona().getCodigo()); 
			 if (spq.execute()) {
				 lstSeropositivo =  spq.getResultList(); 
			 }
			 
			if (lstSeropositivo != null && lstSeropositivo.size() > 0) {
				System.out.println("lstSeropositivo "+lstSeropositivo.size());
				oSeropositivoBean = deListaObjetoAListaObjetoBean(lstSeropositivo).get(0);
			 }
			
			em.close();
			
		   
		return oSeropositivoBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SeropositivoBean> getBuscarPorFiltros(SeropositivoBean SeropositivoBean) throws DAOException {
		List<Seropositivo> lstSeropositivo = null;	
		List<SeropositivoBean> lstSeropositivoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("seropositivo.buscarPorFiltros");   
			spq.setParameter("CODPERSO", SeropositivoBean.getPostulanteBean().getPersona().getCodigo()); 
			spq.setParameter("NRODOCUM", SeropositivoBean.getPostulanteBean().getPersona().getNroDocumento()); 
			
			 if (spq.execute()) {
				 lstSeropositivo =  spq.getResultList(); 
			 }
			 
			if (lstSeropositivo != null && lstSeropositivo.size() > 0) {
				lstSeropositivoBean = deListaObjetoAListaObjetoBean(lstSeropositivo);
			 }
			
			em.close();
			
		   
		return lstSeropositivoBean;
	}
	
	 

private List<SeropositivoBean> deListaObjetoAListaObjetoBean(List<Seropositivo> lstDonante) {
		
		List<SeropositivoBean> lstSeropositivoBean = null;
		
		if (lstDonante != null && lstDonante.size() > 0) {
			
			lstSeropositivoBean = new ArrayList<SeropositivoBean>();
			
			for (int i = 0; i < lstDonante.size(); i++) { 
				Seropositivo entity = lstDonante.get(i);
				SeropositivoBean bean = deObjetoAObjetoBean(entity);
				
				lstSeropositivoBean.add(bean);
			}
		}
		
		return lstSeropositivoBean;
	}
	
	private SeropositivoBean deObjetoAObjetoBean(Seropositivo entity) {
		
		SeropositivoBean bean = null;
	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new SeropositivoBean();
			bean.setCodigo(entity.getId().getCodSerpt());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio()); 
			
			bean.getPostulanteBean().setCodigo(entity.getId().getNroPost()); 
			bean.getPostulanteBean().getPersona().setCodigo(entity.getId().getCodPerso()); 
			bean.getPostulanteBean().getPersona().setNroDocumento(entity.getNroDocum()); 
	
			bean.getAnalisisBean().setCodigo(entity.getCodAnali());
			bean.getAnalisisBean().setValorInicial(entity.getValorIni());
			bean.getAnalisisBean().setValorFinal(entity.getValorFin());
			bean.getAnalisisBean().setValorRis(entity.getValorRis());
			bean.getAnalisisBean().setUnidades(entity.getUnidades());
			bean.getAnalisisBean().setNombre(entity.getAnalisis());
			bean.setsFecha(entity.getFecha());
			bean.setResultado(entity.getResultado());
			bean.setObservacion(entity.getObserva());
			bean.setFechaCreacion(entity.getAufechcr()); 
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(SeropositivoBean t) throws DAOException {

		return false;
	}

	 
 
}
