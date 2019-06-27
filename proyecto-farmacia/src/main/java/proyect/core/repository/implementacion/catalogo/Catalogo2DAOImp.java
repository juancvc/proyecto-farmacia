

package proyect.core.repository.implementacion.catalogo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.entity.catalogo.Catalogo02;
import proyect.core.repository.interfaces.catalogo.Catalogo2DAO;

 
@Transactional
@Repository("Maestra2DAO")
public class Catalogo2DAOImp implements Catalogo2DAO {
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public CatalogoBean getCatalogoBean(Object object){
		return (CatalogoBean)object;
	} 
	
	@Override
	public boolean insertar(CatalogoBean CatalogoBean) throws DAOException {   
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.insertar");
			
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", ""); 
			spq.execute();
			
			
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				CatalogoBean.setIdRegistro(idMaestra.toString());
				System.out.println("CatalogoBean.getIdRegistro()"+CatalogoBean.getIdRegistro());
				if (CatalogoBean.getIdRegistro()!="0") {
					sw=true;
				}else{
					System.out.println("CatalogoBean.getIdRegistro() = 0");
				}
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
	public boolean eliminar(CatalogoBean CatalogoBean) throws DAOException { 
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra.eliminar");
	 
			spq.setParameter("p_codregis", CatalogoBean.getIdRegistro()); 
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				CatalogoBean.setIdRegistro((idMaestra.toString()));
				if (CatalogoBean.getIdRegistro().equals("")) {
					sw=false;
				}
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
	public boolean actualizar(CatalogoBean CatalogoBean) throws DAOException {
		Object idMaestra= null;
		boolean sw=false;
		System.out.println("CatalogoBean actualizar " + CatalogoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.actualizar");
			  
			spq.setParameter("p_codregis", CatalogoBean.getIdRegistro()); 
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				CatalogoBean.setIdRegistro((idMaestra.toString()));
				if (CatalogoBean.getIdRegistro().equals("")) {
					sw=false;
				}
			}  
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
	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean CatalogoBean) throws DAOException {
		CatalogoBean oCatalogoBean = null;
		List<Catalogo02> lstLeotbcMaestra = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.buscarXcod_Tabla_Registro");
			spq.setParameter("p_codregis", CatalogoBean.getIdRegistro());
		
			if (spq.execute()) {
				lstLeotbcMaestra = spq.getResultList();			
			}
			
			if (	lstLeotbcMaestra != null
				&&	lstLeotbcMaestra.size() > 0) {
				
				oCatalogoBean = deCatalogoACatalogoBean(lstLeotbcMaestra.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oCatalogoBean;
	}


//	@Override
//	public boolean eliminar(CatalogoBean Maestra2Bean) throws DAOException { 
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.eliminar");
//			spq.setParameter("p_codMaestra2", Maestra2Bean.getId()); 
//			
//			spq.execute();  
//			sw=true;
//			 
//		} catch (Exception e) {
//			e.printStackTrace();
//			sw=false; 
//		}finally{
//			em.close();
//		}
//		return sw;
//	}


	@SuppressWarnings("unchecked")
	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean Maestra2Bean) throws DAOException {
		CatalogoBean oCatalogoBean = null;
		List<Catalogo02> lstCatalogo02 = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.buscar_por_codigo");
			
		
			if (spq.execute()) {
				lstCatalogo02 = spq.getResultList();			
			}
			
			if (	lstCatalogo02 != null
				&&	lstCatalogo02.size() > 0) {
				
				oCatalogoBean = deCatalogoACatalogoBean(lstCatalogo02.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oCatalogoBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<CatalogoBean> getBuscarPorFiltros(CatalogoBean CatalogoBean) throws DAOException { 
		System.out.println("em " + em);
		List<Catalogo02> lstmaestra = null;	
		List<CatalogoBean> lstCatalogoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.listar");
			 
			lstmaestra =  spq.getResultList(); 
			 
			if (lstmaestra != null && lstmaestra.size() > 0) {
				
				lstCatalogoBean = deListaMaestra2AListaCatalogoBean(lstmaestra);
			}
//			em.close();
			
		   
		return lstCatalogoBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla, int tipo) throws DAOException {
		List<Catalogo02> lstMaestra2 = null;	
		List<CatalogoBean> lstCatalogoBean = null;
		System.out.println("catalogo02 listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.listarPorCodigoTabla");  
			spq.setParameter("CodigoTabla", codTabla);   
			spq.setParameter("tipo", tipo);   
			if (spq.execute()) {
				lstMaestra2 =  spq.getResultList(); 
			} 
			if (lstMaestra2 != null && lstMaestra2.size() > 0) {
				
				lstCatalogoBean = deListaMaestra2AListaCatalogoBean(lstMaestra2);
				System.out.println("lstCatalogoBean dao :: " + lstCatalogoBean.size());
			}
			em.close();
		return lstCatalogoBean;
	}
    
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoBean> listarComboGeneral(String codTabla) throws DAOException {
		List<Catalogo02> lstMaestra2 = null;	
		List<CatalogoBean> lstCatalogoBean = null;
//		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Catalogo02.listarComboGeneral");   
			spq.setParameter("p_codregis", codTabla); 
			if (spq.execute()) {
				lstMaestra2 =  spq.getResultList(); 
			} 
			if (lstMaestra2 != null && lstMaestra2.size() > 0) {
				
				lstCatalogoBean = deListaMaestra2AListaCatalogoBean(lstMaestra2);
			}
			System.out.println("lstCatalogoBean dao :: " + lstCatalogoBean.size());
			em.close();
		return lstCatalogoBean;
	}
	

	@Override
	public boolean existe(CatalogoBean t) throws DAOException { 
		return false;
	}
	
	private List<CatalogoBean> deListaMaestra2AListaCatalogoBean(List<Catalogo02> lstHorarioExcepcion) {
		
		List<CatalogoBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<CatalogoBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Catalogo02 entity = lstHorarioExcepcion.get(i);
				CatalogoBean bean = deCatalogoACatalogoBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private CatalogoBean deCatalogoACatalogoBean(Catalogo02 entity) {
		
		CatalogoBean bean = null;
		
		if (entity != null) {
			
			bean = new CatalogoBean();
			bean.setIdRegistro(entity.getNroRegistro());  
			bean.setDescripcionCorta(entity.getDescripcionCorta()); 
			bean.setDescripcionLarga(entity.getDescripcionLarga()); 
			bean.setIdCatalogo(entity.getIdCatalogo()); 
			bean.setNroOrden(Integer.valueOf(entity.getNroOrden())); 
			bean.setActivo(Boolean.valueOf(entity.getFlag()));  
			 
		}
		
		return bean;
	}

}
