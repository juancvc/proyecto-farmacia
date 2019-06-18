package hnch.referencia.core.repository.implementacion.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hnch.referencia.core.bean.asistencial.banco.CampaniaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.entity.asistencial.banco.Campania;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.banco.CampaniaDAO; 

@Transactional
@Repository("CampaniaDAOImp")
public class CampaniaDAOImp implements CampaniaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public CampaniaBean getCampaniaBean(Object object){
		return (CampaniaBean)object;
	}
	
	@Override
	public boolean insertar(CampaniaBean CampaniaBean) throws DAOException {

		Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.insertar"); 
			spq.setParameter("CODORGAN", CampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", CampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", CampaniaBean.getCodigoSede()); 
			
			spq.setParameter("NOMCAMPA", CampaniaBean.getNombre());
			spq.setParameter("LUGCAMPA", CampaniaBean.getLugar());
			spq.setParameter("FECHAINI", CampaniaBean.getsFechaInicio()); 
			spq.setParameter("FECHAFIN", CampaniaBean.getsFechaFin()); 
			spq.setParameter("CODLUGCA", CampaniaBean.getLugarCampaniaBean().getCodigo()); 
			spq.setParameter("SITUACRG", CampaniaBean.getSituacion().getCodReg());
			
			spq.setParameter("AUCDUSCR", CampaniaBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", CampaniaBean.getIpCreacion());
			 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(4); 
			
			if (id != null) {
				CampaniaBean.setCodigo(id.toString()); 
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
	public boolean actualizar(CampaniaBean CampaniaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.modificar"); 
			spq.setParameter("CODORGAN", CampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", CampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", CampaniaBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", CampaniaBean.getCodigo());
			spq.setParameter("NROPERIO", CampaniaBean.getNumeroPeriodo());
			spq.setParameter("NOMCAMPA", CampaniaBean.getNombre());
			spq.setParameter("LUGCAMPA", CampaniaBean.getLugar());
			spq.setParameter("FECHAINI", CampaniaBean.getsFechaInicio()); 
			spq.setParameter("FECHAFIN", CampaniaBean.getsFechaFin()); 
			spq.setParameter("CODLUGCA", CampaniaBean.getLugarCampaniaBean().getCodigo()); 
			spq.setParameter("SITUACRG", CampaniaBean.getSituacion().getCodReg()); 
			
			spq.setParameter("AUCDUSMO", CampaniaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", CampaniaBean.getIpModificacion()); 
			
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
	public boolean eliminar(CampaniaBean CampaniaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.eliminar"); 
			spq.setParameter("CODORGAN", CampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", CampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", CampaniaBean.getCodigoSede()); 
			spq.setParameter("CODCAMPA", CampaniaBean.getCodigo());
			spq.setParameter("NROPERIO", CampaniaBean.getNumeroPeriodo()); 
			
			spq.setParameter("AUCDUSMO", CampaniaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", CampaniaBean.getIpModificacion()); 
			
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
	public CampaniaBean getBuscarPorObjecto(CampaniaBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CampaniaBean> getBuscarPorFiltros(CampaniaBean CampaniaBean) throws DAOException {
		List<Campania> lstCampania = null;	
		List<CampaniaBean> lstCampaniaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("campania.buscarPorFiltros");  
			spq.setParameter("NOMCAMPA", CampaniaBean.getNombre());
			spq.setParameter("SITUACRG", CampaniaBean.getSituacion().getCodReg()); 
			
			 if (spq.execute()) {
				 lstCampania =  spq.getResultList(); 
			 }
			 
			if (lstCampania != null && lstCampania.size() > 0) {
				lstCampaniaBean = deListaObjetoAListaObjetoBean(lstCampania);
			 }
			
			em.close();
			
		   
		return lstCampaniaBean;
	}
	
	 

private List<CampaniaBean> deListaObjetoAListaObjetoBean(List<Campania> lstCampania) {
		
		List<CampaniaBean> lstCampaniaBean = null;
		
		if (lstCampania != null && lstCampania.size() > 0) {
			
			lstCampaniaBean = new ArrayList<CampaniaBean>();
			
			for (int i = 0; i < lstCampania.size(); i++) { 
				Campania entity = lstCampania.get(i);
				CampaniaBean bean = deObjetoAObjetoBean(entity);
				
				lstCampaniaBean.add(bean);
			}
		}
		
		return lstCampaniaBean;
	}
	
	private CampaniaBean deObjetoAObjetoBean(Campania entity) {
		
		CampaniaBean bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new CampaniaBean();
			bean.setCodigo(entity.getId().getCodcampa());  
			bean.setCodigoInstitucion(entity.getId().getCodinsti());  
			bean.setCodigoSede(entity.getId().getCodsedei());  
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setNumeroVersion(entity.getId().getNroversi());
			bean.setNumeroPeriodo(entity.getId().getNroperio());
			
			bean.setNombre(entity.getNomCampa());
			bean.setLugar(entity.getLugCampa());
			bean.setFechaInicio(entity.getFechaIni());
			bean.setFechaFin(entity.getFechaFin()); 
			bean.getSituacion().setCodReg(entity.getSituacRg());
			bean.getSituacion().setNombreCorto(entity.getNombSitu());
			
			bean.getLugarCampaniaBean().setNombre(entity.getNomLugCa());
			bean.getLugarCampaniaBean().setCodigo(entity.getCodLugCa()); 
			
			bean.setsFechaInicio(sdf.format(entity.getFechaIni()));
			bean.setsFechaFin(sdf.format(entity.getFechaFin()));
	 	}
		
		return bean;
	}

	
	
	@Override
	public boolean existe(CampaniaBean t) throws DAOException {

		return false;
	}

	 

}
