package hnch.referencia.core.repository.implementacion.general;

import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.entity.general.Tgemae02;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.Maestra2DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;  

 
@Transactional
@Repository("maestra2DAO")
public class Maestra2DAOImp implements Maestra2DAO {
	
	
	@PersistenceContext//(unitName="emf")
	private EntityManager em; 
	
	public TablaBean getTablaBean(Object object){
		return (TablaBean)object;
	}


	
	@Override
	public boolean insertar(TablaBean tablaBean) throws DAOException {   
		Object idtabla= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.insertar"); 
			spq.setParameter("p_codusureg", 1);
			spq.setParameter("p_hostreg", ""); 
			
			spq.execute();
			
			idtabla = spq.getOutputParameterValue(1);
			if (idtabla != null) {
				tablaBean.setCodReg(idtabla.toString());
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
	public boolean actualizar(TablaBean tablaBean) throws DAOException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.actualizar"); 
			spq.setParameter("p_codusumod", 1);
			spq.setParameter("p_hostmod", ""); 
			
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
	public boolean eliminar(TablaBean tablaBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.insertar");
			spq.setParameter("p_codtabla", tablaBean.getCodReg()); 
			
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
	public TablaBean getBuscarPorObjecto(TablaBean TablaBean) throws DAOException {
		TablaBean oTablaBean = null;
		List<Tgemae02> lstMaestra = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.buscar_por_codigo");
			
			spq.setParameter("p_codtabla", TablaBean.getCodReg()); 
			
		
			if (spq.execute()) {
				lstMaestra = spq.getResultList();			
			}
			
			if (	lstMaestra != null
				&&	lstMaestra.size() > 0) {
				
				oTablaBean = deMaestraATablaBean(lstMaestra.get(0));
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
		List<Tgemae02> lstMaestra = null;	
		List<TablaBean> lstTablaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.buscar_por_filtros");
			spq.setParameter("p_codtabla", TablaBean.getTabla()); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstMaestra);
			}
			em.close();
			
		   
		return lstTablaBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException {
		List<Tgemae02> lstMaestra = null;	
		List<TablaBean> lstTablaBean = null; 
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.listarPorCodigoTabla");
			spq.setParameter("p_codtabla", codTabla);
			spq.setParameter("p_tipo", tipo); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstMaestra);
			}
			em.close();
			
		   System.out.println("lstTablaBean " + lstTablaBean);
		return lstTablaBean;
	}
	
	@Override
	public boolean existe(TablaBean t) throws DAOException { 
		return false;
	}
	
	private List<TablaBean> deListaMaestra1AListaTablaBean(List<Tgemae02> lstHorarioExcepcion) {
		
		List<TablaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<TablaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				Tgemae02 entity = lstHorarioExcepcion.get(i);
				TablaBean bean = deMaestraATablaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private TablaBean deMaestraATablaBean(Tgemae02 entity) {
		
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



	@Override
	public List<TablaBean> listarPorValor1(TablaBean TablaBean) throws DAOException {
		List<Tgemae02> lstMaestra = null;	
		List<TablaBean> lstTablaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("Tgemae02.listarPorValor1");
			spq.setParameter("p_codtabla", TablaBean.getTabla()); 
			spq.setParameter("p_valor1", TablaBean.getValor1()); 
			if (spq.execute()) {
				lstMaestra =  spq.getResultList(); 
			} 
			if (lstMaestra != null && lstMaestra.size() > 0) {
				
				lstTablaBean = deListaMaestra1AListaTablaBean(lstMaestra);
			}
			em.close();
			
		   System.out.println("lstTablaBean " + lstTablaBean);
		return lstTablaBean;
	}


}
