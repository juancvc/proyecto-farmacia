package sigelab.core.repository.implementacion.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sigelab.core.bean.asistencial.banco.DonanteBean; 
import sigelab.core.entity.asistencial.banco.Campania;
import sigelab.core.entity.asistencial.banco.Donante;
import sigelab.core.repository.DAOException; 
import sigelab.core.repository.interfaces.asistencial.banco.DonanteDAO; 

@Transactional
@Repository("DonanteDAOImp")
public class DonanteDAOImp implements DonanteDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public DonanteBean getDonanteBean(Object object){
		return (DonanteBean)object;
	}
	
	@Override
	public boolean insertar(DonanteBean DonanteBean) throws DAOException {

		Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.insertar"); 
			spq.setParameter("CODORGAN", DonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", DonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", DonanteBean.getCodigoSede()); 
			 
			spq.setParameter("SITUACRG", DonanteBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSCR", DonanteBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", DonanteBean.getIpCreacion());
			 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(4); 
			
			if (id != null) {
				DonanteBean.setCodigo(id.toString()); 
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
	public boolean actualizar(DonanteBean DonanteBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.modificar"); 
			spq.setParameter("CODORGAN", DonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", DonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", DonanteBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", DonanteBean.getCodigo());
			spq.setParameter("NROPERIO", DonanteBean.getNumeroPeriodo()); 
			spq.setParameter("SITUACRG", DonanteBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", DonanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", DonanteBean.getIpModificacion()); 
			
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
	public boolean eliminar(DonanteBean DonanteBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.eliminar"); 
			spq.setParameter("CODORGAN", DonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", DonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", DonanteBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", DonanteBean.getCodigo());
			spq.setParameter("NROPERIO", DonanteBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", DonanteBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", DonanteBean.getIpModificacion()); 
			
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
	public DonanteBean getBuscarPorObjecto(DonanteBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DonanteBean> getBuscarPorFiltros(DonanteBean DonanteBean) throws DAOException {
		List<Donante> lstCampania = null;	
		List<DonanteBean> lstDonanteBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.buscarPorFiltros");   
			spq.setParameter("SITUACRG", DonanteBean.getSituacion().getCodReg()); 
			
			 if (spq.execute()) {
				 lstCampania =  spq.getResultList(); 
			 }
			 
			if (lstCampania != null && lstCampania.size() > 0) {
				lstDonanteBean = deListaObjetoAListaObjetoBean(lstCampania);
			 }
			
			em.close();
			
		   
		return lstDonanteBean;
	}
	
	 

private List<DonanteBean> deListaObjetoAListaObjetoBean(List<Donante> lstDonante) {
		
		List<DonanteBean> lstDonanteBean = null;
		
		if (lstDonante != null && lstDonante.size() > 0) {
			
			lstDonanteBean = new ArrayList<DonanteBean>();
			
			for (int i = 0; i < lstDonante.size(); i++) { 
				Donante entity = lstDonante.get(i);
				DonanteBean bean = deObjetoAObjetoBean(entity);
				
				lstDonanteBean.add(bean);
			}
		}
		
		return lstDonanteBean;
	}
	
	private DonanteBean deObjetoAObjetoBean(Donante entity) {
		
		DonanteBean bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new DonanteBean();
			bean.setCodigo(entity.getId().getCodFleto());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			
			bean.setUltimaFechaDonacion(entity.getFecha());
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(DonanteBean t) throws DAOException {

		return false;
	}

	@Override
	public DonanteBean buscarUltimaDonacion(DonanteBean DonanteBean) {
		DonanteBean oDonante = null;	
		List<Donante> lstDonanteBean = null;
		System.out.println("DonanteBean.getDonante().getCodigo() " + DonanteBean.getPersona().getCodigo());
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("donante.buscarUltimaDonacion");   
			spq.setParameter("CODPERSO", DonanteBean.getPersona().getCodigo()); 
			
			 if (spq.execute()) {
				 lstDonanteBean =  spq.getResultList(); 
			 }
			 
			if (lstDonanteBean != null && lstDonanteBean.size() > 0) {
				oDonante = deObjetoAObjetoBean(lstDonanteBean.get(0));
			 }
			
			em.close();
			
		   
		return oDonante;
	}

	@Override
	public boolean insertarVoluntario(DonanteBean DonanteBean) throws DAOException {
		//Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("donante.insertarVoluntario"); 
			spq.setParameter("CODORGAN", DonanteBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", DonanteBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", DonanteBean.getCodigoSede()); 
			 
			spq.setParameter("NROVERSI", DonanteBean.getNumeroVersion()); 
			spq.setParameter("NROPERIO", DonanteBean.getNumeroPeriodo());  
			
			spq.setParameter("CODPERSO", DonanteBean.getPersona().getCodigo()); 
			spq.setParameter("TIPOREGT", DonanteBean.getTipoRegistro().getCodReg());   
			
			spq.setParameter("AUCDUSCR", DonanteBean.getNombreUsuarioCreacion().toUpperCase());
			spq.setParameter("AUPCIPCR", DonanteBean.getIpCreacion());
			 
			
			
			spq.execute();
			sw=true;
			/**id = spq.getOutputParameterValue(4); 
			
			if (id != null) {
				DonanteBean.setCodigo(id.toString()); 
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
}
