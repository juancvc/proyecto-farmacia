

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
	public boolean insertar(CatalogoBean catalogoBean) throws DAOException {   
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.insertar");
			
			spq.setParameter("IdCatalogo", catalogoBean.getIdCatalogo());
			spq.setParameter("DescripcionCorta", catalogoBean.getDescripcionCorta()); 
			spq.setParameter("DescripcionLarga", catalogoBean.getDescripcionLarga());  
			spq.setParameter("usuarioRegistro", catalogoBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", catalogoBean.getIpRegistro());
			spq.execute();
			
			
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				catalogoBean.setIdRegistro(idMaestra.toString());
				System.out.println("CatalogoBean.getIdRegistro()"+catalogoBean.getIdRegistro());
				if (catalogoBean.getIdRegistro()!="0") {
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
	public boolean eliminar(CatalogoBean catalogoBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.eliminar");
			spq.setParameter("NroRegistro", catalogoBean.getIdRegistro());
			spq.setParameter("IdCatalogo", catalogoBean.getIdCatalogo());
			spq.setParameter("usuarioModificacion", catalogoBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", catalogoBean.getIpModificacion());
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
	public boolean actualizar(CatalogoBean catalogoBean) throws DAOException { 
		boolean sw=false;
		System.out.println("CatalogoBean actualizar " + catalogoBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.actualizar");
			spq.setParameter("NroRegistro", catalogoBean.getIdRegistro());
			spq.setParameter("IdCatalogo", catalogoBean.getIdCatalogo());
			spq.setParameter("DescripcionCorta", catalogoBean.getDescripcionCorta()); 
			spq.setParameter("DescripcionLarga", catalogoBean.getDescripcionLarga());  
			spq.setParameter("usuarioModificacion", catalogoBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", catalogoBean.getIpModificacion());
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
	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean CatalogoBean) throws DAOException {
		CatalogoBean oCatalogoBean = null;
		List<Catalogo02> lstLeotbcMaestra = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.buscarXcod_Tabla_Registro");
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
 

	@SuppressWarnings("unchecked")
	@Override
	public CatalogoBean getBuscarPorObjecto(CatalogoBean Maestra2Bean) throws DAOException {
		CatalogoBean oCatalogoBean = null;
		List<Catalogo02> lstCatalogo02 = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.buscar_por_codigo");
			
		
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
	public List<CatalogoBean> listarCatalogoRegistros(CatalogoBean catalogoBean) throws DAOException {
		List<Catalogo02> lstMaestra2 = null;	
		List<CatalogoBean> lstCatalogoBean = null;
//		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.listarCatalogoRegistros");   
			spq.setParameter("IdCatalogo", catalogoBean.getIdCatalogo()); 
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
			bean.setNombreCatalogo(entity.getNombreCatalogo());
			 
		}
		
		return bean;
	}

	@Override
	public List<CatalogoBean> listarTodascatalogos() throws DAOException {
		List<Catalogo02> lstmaestra = null;	
		List<CatalogoBean> lstCatalogoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("catalogo02.listarTodascatalogos");
			 
			lstmaestra =  spq.getResultList(); 
			 
			if (lstmaestra != null && lstmaestra.size() > 0) {
				
				lstCatalogoBean = deListaMaestra2AListaCatalogoBean(lstmaestra);
			}
//			em.close();
			
		   
		return lstCatalogoBean;
	}

}
