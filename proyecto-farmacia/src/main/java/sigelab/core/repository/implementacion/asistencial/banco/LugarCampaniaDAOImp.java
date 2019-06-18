package sigelab.core.repository.implementacion.asistencial.banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery; 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import sigelab.core.bean.asistencial.banco.LugarCampaniaBean;  
import sigelab.core.entity.asistencial.banco.LugarCampania;
import sigelab.core.repository.DAOException; 
import sigelab.core.repository.interfaces.asistencial.banco.LugarCampaniaDAO; 

@Transactional
@Repository("LugarCampaniaDAOImp")
public class LugarCampaniaDAOImp implements LugarCampaniaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	
	public LugarCampaniaBean getLugarCampaniaBean(Object object){
		return (LugarCampaniaBean)object;
	}
	
	@Override
	public boolean insertar(LugarCampaniaBean LugarCampaniaBean) throws DAOException {

		Object id= null;   
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("lugarCampania.insertar"); 
			spq.setParameter("CODORGAN", LugarCampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", LugarCampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", LugarCampaniaBean.getCodigoSede()); 
			 
			spq.setParameter("NOMLUGCA", LugarCampaniaBean.getNombre()); 
			spq.setParameter("CODREGUB", LugarCampaniaBean.getUbigeoLugar().getCodigoRegistro()); 
			
			spq.setParameter("AUCDUSCR", LugarCampaniaBean.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", LugarCampaniaBean.getIpCreacion());
			 
			
			
			spq.execute();
			
			id = spq.getOutputParameterValue(4); 
			
			if (id != null) {
				LugarCampaniaBean.setCodigo(id.toString()); 
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
	public boolean actualizar(LugarCampaniaBean LugarCampaniaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("lugarCampania.modificar"); 
			spq.setParameter("CODORGAN", LugarCampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", LugarCampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", LugarCampaniaBean.getCodigoSede()); 
			
			spq.setParameter("CODLUGCA", LugarCampaniaBean.getCodigo());
			spq.setParameter("NOMLUGCA", LugarCampaniaBean.getNombre()); 
			spq.setParameter("CODREGUB", LugarCampaniaBean.getUbigeoLugar().getCodigoRegistro()); 
			
			spq.setParameter("AUCDUSMO", LugarCampaniaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", LugarCampaniaBean.getIpModificacion()); 
			
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
	public boolean eliminar(LugarCampaniaBean LugarCampaniaBean) throws DAOException {

		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("lugarCampania.eliminar"); 
			spq.setParameter("CODORGAN", LugarCampaniaBean.getCodigoOrganizacion());
			spq.setParameter("CODINSTI", LugarCampaniaBean.getCodigoInstitucion());
			spq.setParameter("CODSEDEI", LugarCampaniaBean.getCodigoSede()); 
			spq.setParameter("CODLUGCA", LugarCampaniaBean.getCodigo()); 
			
			spq.setParameter("AUCDUSMO", LugarCampaniaBean.getCodigoUsuarioModificacion());
			spq.setParameter("AUPCIPMO", LugarCampaniaBean.getIpModificacion()); 
			
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
	public LugarCampaniaBean getBuscarPorObjecto(LugarCampaniaBean t) throws DAOException {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LugarCampaniaBean> getBuscarPorFiltros(LugarCampaniaBean LugarCampaniaBean) throws DAOException {
		List<LugarCampania> lstCampania = null;	
		List<LugarCampaniaBean> lstLugarCampaniaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("lugarCampania.buscarPorFiltros");   
			spq.setParameter("NOMLUGCA", LugarCampaniaBean.getNombre()); 
			
			 if (spq.execute()) {
				 lstCampania =  spq.getResultList(); 
			 }
			 
			if (lstCampania != null && lstCampania.size() > 0) {
				lstLugarCampaniaBean = deListaObjetoAListaObjetoBean(lstCampania);
			 }
			
			em.close();
			
		   
		return lstLugarCampaniaBean;
	}
	
	 

private List<LugarCampaniaBean> deListaObjetoAListaObjetoBean(List<LugarCampania> lstLugarCampania) {
		
		List<LugarCampaniaBean> lstLugarCampaniaBean = null;
		
		if (lstLugarCampania != null && lstLugarCampania.size() > 0) {
			
			lstLugarCampaniaBean = new ArrayList<LugarCampaniaBean>();
			
			for (int i = 0; i < lstLugarCampania.size(); i++) { 
				LugarCampania entity = lstLugarCampania.get(i);
				LugarCampaniaBean bean = deObjetoAObjetoBean(entity);
				
				lstLugarCampaniaBean.add(bean);
			}
		}
		
		return lstLugarCampaniaBean;
	}
	
	private LugarCampaniaBean deObjetoAObjetoBean(LugarCampania entity) {
		
		LugarCampaniaBean bean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (entity != null) {
			
			bean = new LugarCampaniaBean();
			bean.setCodigo(entity.getCodLugCa());  
			bean.setCodigoInstitucion(entity.getCodinsti());  
			bean.setCodigoSede(entity.getCodsedei());  
			bean.setCodigoOrganizacion(entity.getCodorgan());
			bean.setNumeroVersion(entity.getNroversi());
			bean.setNumeroPeriodo(entity.getNroperio());
			bean.setNombre(entity.getNomLugCa());
			bean.getUbigeoLugar().setCodigoUbigeo(entity.getCodRegUb());
			bean.getUbigeoLugar().setCodigoRegistro(entity.getCodRegUb()); 
			bean.getUbigeoLugar().setDetalle(entity.getNombrLug());
	 	}
		
		return bean;
	}

	@Override
	public boolean existe(LugarCampaniaBean t) throws DAOException {
		 
		return false;
	}
 

}
