

package sigelab.core.repository.implementacion.general;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.entity.asistencial.maestras.TgemaeAsis01;
import sigelab.core.entity.general.Tgemae01;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.general.Maestra1DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
@Transactional
@Repository("maestra1DAO")
public class Maestra1DAOImp implements Maestra1DAO {
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public TablaBean getTablaBean(Object object){
		return (TablaBean)object;
	} 
	
	@Override
	public boolean insertar(TablaBean TablaBean) throws DAOException {   
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.insertar");
			spq.setParameter("p_codtabla", TablaBean.getTabla());
		    spq.setParameter("p_codregis", TablaBean.getCodReg()); 
			spq.setParameter("p_nomcorto", TablaBean.getNombreCorto()); 
			spq.setParameter("p_nomlargo", TablaBean.getNombreLargo());
			spq.setParameter("p_valor1", TablaBean.getValor1());
			spq.setParameter("p_valor2", TablaBean.getValor2());
			spq.setParameter("p_valor3", TablaBean.getValor3()); 
			spq.setParameter("p_orden", TablaBean.getOrden());
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", ""); 
			spq.execute();
			
			
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				TablaBean.setCodReg(idMaestra.toString());
				System.out.println("TablaBean.getCodReg()"+TablaBean.getCodReg());
				if (TablaBean.getCodReg()!="0") {
					sw=true;
				}else{
					System.out.println("TablaBean.getCodReg() = 0");
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
	public boolean eliminar(TablaBean TablaBean) throws DAOException { 
		Object idMaestra= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcMaestra.eliminar");
	 
			spq.setParameter("p_codtabla", TablaBean.getTabla()); 
			spq.setParameter("p_codregis", TablaBean.getCodReg()); 
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				TablaBean.setCodReg((idMaestra.toString()));
				if (TablaBean.getCodReg().equals("")) {
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
	public boolean actualizar(TablaBean TablaBean) throws DAOException {
		Object idMaestra= null;
		boolean sw=false;
		System.out.println("TablaBean actualizar " + TablaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.actualizar");
			  
			spq.setParameter("p_codregis", TablaBean.getCodReg()); 
			spq.setParameter("p_codtabla", TablaBean.getTabla()); 
			spq.setParameter("p_nomcorto", TablaBean.getNombreCorto());  
			spq.setParameter("p_nomlargo", TablaBean.getNombreLargo()); 
			spq.setParameter("p_valor1", TablaBean.getValor1()); 
			spq.setParameter("p_valor2", TablaBean.getValor2()); 
			spq.setParameter("p_valor3", TablaBean.getValor3()); 
			spq.setParameter("p_orden", TablaBean.getOrden());    
			System.out.println(" p_codtabla" +  TablaBean.getTabla());   
			spq.execute();   
			sw=true;
			System.out.println("spq.getOutputParameterValue(1)"+spq.getOutputParameterValue(1));
			idMaestra = spq.getOutputParameterValue(1);
			if (idMaestra != null) {
				TablaBean.setCodReg((idMaestra.toString()));
				if (TablaBean.getCodReg().equals("")) {
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
	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws DAOException {
		TablaBean oTablaBean = null;
		List<Tgemae01> lstLeotbcMaestra = null;
		System.out.println("TablaBean getBuscarPorObjecto2 codreg" + TablaBean.getCodReg() );
		System.out.println("TablaBean getBuscarPorObjecto2 codtabl" + TablaBean.getTabla() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.buscarXcod_Tabla_Registro");			
			spq.setParameter("p_codtabla", TablaBean.getTabla()); 
			spq.setParameter("p_codregis", TablaBean.getCodReg());
		
			if (spq.execute()) {
				lstLeotbcMaestra = spq.getResultList();			
			}
			
			if (	lstLeotbcMaestra != null
				&&	lstLeotbcMaestra.size() > 0) {
				
				oTablaBean = deMaestraATablaBean(lstLeotbcMaestra.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oTablaBean;
	}


//	@Override
//	public boolean eliminar(TablaBean maestra1Bean) throws DAOException { 
//		boolean sw=false;
//		try {
//			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.eliminar");
//			spq.setParameter("p_codmaestra1", maestra1Bean.getId()); 
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
	public TablaBean getBuscarPorObjecto(TablaBean maestra1Bean) throws DAOException {
		TablaBean oTablaBean = null;
		List<Tgemae01> lstTgemae01 = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.buscar_por_codigo");
			
			spq.setParameter("p_codtabla", maestra1Bean.getTabla()); 
			
		
			if (spq.execute()) {
				lstTgemae01 = spq.getResultList();			
			}
			
			if (	lstTgemae01 != null
				&&	lstTgemae01.size() > 0) {
				
				oTablaBean = deMaestraATablaBean(lstTgemae01.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return oTablaBean;
	}


	@SuppressWarnings({ "unchecked" })
	@Override
	public List<TablaBean> getBuscarPorFiltros(TablaBean TablaBean) throws DAOException { 
		System.out.println("em " + em);
		List<Tgemae01> lstmaestra = null;	
		List<TablaBean> lstTablaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.listar");
			spq.setParameter("p_codtabla", TablaBean.getTabla());   
			spq.setParameter("p_nomcorto", TablaBean.getNombreCorto()); 
			
			 
			lstmaestra =  spq.getResultList(); 
			 
			if (lstmaestra != null && lstmaestra.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstmaestra);
			}
//			em.close();
			
		   
		return lstTablaBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla, int tipo) throws DAOException {
		List<Tgemae01> lstMaestra1 = null;	
		List<TablaBean> lstTablaBean = null;
		System.out.println("tgemaeGene01 listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tgemaeGene01.listarPorCodigoTabla");  
			spq.setParameter("CODTABLA", codTabla);   
			spq.setParameter("TIPO", tipo);   
			if (spq.execute()) {
				lstMaestra1 =  spq.getResultList(); 
			} 
			if (lstMaestra1 != null && lstMaestra1.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstMaestra1);
				System.out.println("lstTablaBean dao :: " + lstTablaBean.size());
			}
			em.close();
		return lstTablaBean;
	}
    
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TablaBean> listarComboGeneral(String codTabla) throws DAOException {
		List<Tgemae01> lstMaestra1 = null;	
		List<TablaBean> lstTablaBean = null;
//		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae01.listarComboGeneral");   
			spq.setParameter("p_codregis", codTabla); 
			if (spq.execute()) {
				lstMaestra1 =  spq.getResultList(); 
			} 
			if (lstMaestra1 != null && lstMaestra1.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstMaestra1);
			}
			System.out.println("lstTablaBean dao :: " + lstTablaBean.size());
			em.close();
		return lstTablaBean;
	}
	

	@Override
	public boolean existe(TablaBean t) throws DAOException { 
		return false;
	}
	
	private List<TablaBean> deListaMaestra1AListaTablaBean(List<Tgemae01> lstHorarioExcepcion) {
		
		List<TablaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<TablaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Tgemae01 entity = lstHorarioExcepcion.get(i);
				TablaBean bean = deMaestraATablaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private TablaBean deMaestraATablaBean(Tgemae01 entity) {
		
		TablaBean bean = null;
		
		if (entity != null) {
			
			bean = new TablaBean();
			bean.setCodReg(entity.getCodregis());  
			bean.setNombreCorto(entity.getNomcorto()); 
			bean.setNombreLargo(entity.getNomlargo()); 
			bean.setTabla(entity.getCodtabla()); 
			bean.setValor1(entity.getValgen01());
			bean.setValor2(entity.getValgen02());
			bean.setValor3(entity.getValgen03()); 
			bean.setOrden(Integer.valueOf(entity.getNroorden())); 
			bean.setEstado(Boolean.valueOf(entity.getEstadorg()));  
			 
		}
		
		return bean;
	}

}
