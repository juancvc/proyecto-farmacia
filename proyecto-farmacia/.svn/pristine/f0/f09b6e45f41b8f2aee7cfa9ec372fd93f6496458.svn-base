package hnch.referencia.core.repository.implementacion.asistencial.maestra;
  
import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.entity.asistencial.maestras.TgemaeAsis01; 
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.asistencial.maestra.MaestraAsis01DAO;  
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext; 
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



 
@Transactional
@Repository("maestraASIS01DAO")
public class MaestraAsis01DAOImp implements MaestraAsis01DAO {

@PersistenceContext//(unitName="emf")
private EntityManager em; 
	
public TablaBean getTablaBean(Object object){
		return (TablaBean)object;
	}


	
	@Override
	public boolean insertar(TablaBean TablaBean) throws DAOException {   
		Object idMaestraAsis14DAO= null; 
		 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tabla.insertar");
		 
			
			spq.execute();
			
			idMaestraAsis14DAO = spq.getOutputParameterValue(1);
			if (idMaestraAsis14DAO != null) {
				TablaBean.setCodigo(idMaestraAsis14DAO.toString());
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
	public boolean actualizar(TablaBean TablaBean) throws DAOException {
		boolean sw=false;
		System.out.println("tablaEspecialidadBean actualizar " + TablaBean );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tabla.actualizar");
			spq.setParameter("p_codlengua", TablaBean.getCodigo());  
			
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
	public boolean eliminar(TablaBean TablaBean) throws DAOException { 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tabla.eliminar");
			spq.setParameter("p_codlengua", TablaBean.getCodigo());  
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
		List<TgemaeAsis01> lsttabla = null;
		System.out.println("TablaBean getBuscarPorObjecto " + TablaBean.getCodigo() );
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tablaEspecialidad.buscar_por_codigo");			
			spq.setParameter("p_codlengua", TablaBean.getCodigo()); 
			
		
			if (spq.execute()) {
				lsttabla = spq.getResultList();			
			}
			
			if (	lsttabla != null
				&&	lsttabla.size() > 0) {
				
				oTablaBean = detablaATablaBean(lsttabla.get(0));
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
	public List<TablaBean> getBuscarPorFiltros(TablaBean tablaBean) throws DAOException { 
		List<TgemaeAsis01> lsttabla = null;	
		List<TablaBean> lstTablaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tgemae14.buscarPorFiltros");
			spq.setParameter("CODTABLA", tablaBean.getTabla());
			spq.setParameter("NOMCORTO", tablaBean.getNombreCorto());
			spq.setParameter("VALGEN0X", tablaBean.getValor1()); 
			 if (spq.execute()) {
				lsttabla =  spq.getResultList(); 
			} 
			if (lsttabla != null && lsttabla.size() > 0) {
				
				lstTablaBean = deListatablaAListaTablaBean(lsttabla);
			}
			//em.close();
			
		   
		return lstTablaBean;
	}


	@Override
	public boolean existe(TablaBean TablaBean) throws DAOException { 
		Boolean sw = true;
		List<TablaBean> lsttabla = null; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tabla.existe");			
		 	
		
			if (spq.execute()) {
				lsttabla = spq.getResultList();			
			}
			
			if (	lsttabla != null
				&&	lsttabla.size() > 0) {
				
				sw = true;
			}else{
				sw = false;
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return sw;
	}
	
	private List<TablaBean> deListatablaAListaTablaBean(List<TgemaeAsis01> lstHorarioExcepcion) {
		
		List<TablaBean> lstHorarioExcepcionBean = null;
		
		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {
			
			lstHorarioExcepcionBean = new ArrayList<TablaBean>();
			
			for (int i = 0; i < lstHorarioExcepcion.size(); i++) { 
				TgemaeAsis01 entity = lstHorarioExcepcion.get(i);
				TablaBean bean = detablaATablaBean(entity);
				
				lstHorarioExcepcionBean.add(bean);
			}
		}
		
		return lstHorarioExcepcionBean;
	}
	
	private TablaBean detablaATablaBean(TgemaeAsis01 entity) {
		
		TablaBean bean = null;
		
		if (entity != null) {
			
			bean = new TablaBean();
			bean.setNombreCorto(entity.getNomcorto());
			bean.setNombreLargo(entity.getNomlargo());
			bean.setCodReg(entity.getCodregis());
			bean.setValor1(entity.getValgen01());
			bean.setValor2(entity.getValgen02());
			bean.setValor3(entity.getValgen03());
			bean.setValor4(entity.getValgen04());
			bean.setValor5(entity.getValgen05());
			bean.setValor6(entity.getValgen06());
			
	 	}
		
		return bean;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<TablaBean> listarPorCodigoTabla(String codTabla, int tipo) throws DAOException {
		List<TgemaeAsis01> lstMaestra1 = null;	
		List<TablaBean> lstTablaBean = null;
		System.out.println("listarPorCodigoTabla  "+ codTabla);
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tgemaeAsis01.listarPorCodigoTabla");  
			spq.setParameter("CODTABLA", codTabla);   
			spq.setParameter("TIPO", tipo);   
			if (spq.execute()) {
				lstMaestra1 =  spq.getResultList(); 
			} 
			if (lstMaestra1 != null && lstMaestra1.size() > 0) {
				
				lstTablaBean = deListatablaAListaTablaBean(lstMaestra1);
				System.out.println("lstTablaBean dao :: " + lstTablaBean.size());
			}
			em.close();
		return lstTablaBean;
	}
    

}
