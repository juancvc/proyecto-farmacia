package sigelab.core.repository.implementacion.general;

import sigelab.core.bean.general.UbigeoBean;
import sigelab.core.entity.general.Ubigeo;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.general.UbigeoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("ubigeoDAO")
public  class UbigeoDAOImpl implements UbigeoDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UbigeoBean getBuscarPorObjecto(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UbigeoBean> getBuscarPorFiltros(UbigeoBean t)
			throws DAOException {
		List<Ubigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ubigeo.listaUbigeo");
			spq.setParameter("INSTITUC", t.getInstitucion());  
			spq.setParameter("CATEGORI", t.getCategoria()); 
			spq.setParameter("VARIABLE", t.getVariable());   
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			em.close();
			
		   
		return lstUbigeoBean;
	}

	@Override
	public boolean existe(UbigeoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UbigeoBean> listarRegion()
			throws DAOException {
		List<Ubigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboRegion");

			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}
	private List<UbigeoBean> deListaUbigeoAListaUbigeoBean(List<Ubigeo> lstLeotbcUbigeo) {
		
		List<UbigeoBean> lstUbigeoBean= null;
		
		if (lstLeotbcUbigeo != null && lstLeotbcUbigeo.size() > 0) {
			
			lstUbigeoBean = new ArrayList<UbigeoBean>();
			
			for (int i = 0; i < lstLeotbcUbigeo.size(); i++) { 
				Ubigeo entity = lstLeotbcUbigeo.get(i);
				UbigeoBean bean = deUbigeoAUbigeoBean(entity);
				
				lstUbigeoBean.add(bean);
			}
		}
		
		return lstUbigeoBean;
	}
	private UbigeoBean deUbigeoAUbigeoBean(Ubigeo entity) {
		
		UbigeoBean bean = null;
		
		if (entity != null) {
			
			bean = new UbigeoBean(); 
			//bean.setCodigo(entity.getnCodubigre());
			bean.setNombreUbigeo(entity.getNomLargo()); 
			bean.setCodigoProvincia(entity.getCodprovin());
			bean.setCodigoDistrito(entity.getCoddistrito());
			bean.setCodigoUbigeo(entity.getCodUbige());
			bean.setCodigoPais(entity.getCodpais());
			bean.setDetalle(entity.getDetalle());
			bean.setCodigoRegistro(entity.getCodRegis());
		}
		
		return bean;
	}

	@Override
	public List<UbigeoBean> listarProvincia(UbigeoBean ubigeoBean)
			throws DAOException {
		List<Ubigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboProvincia");
			spq.setParameter("p_codregion",ubigeoBean.getCodigoRegion());  
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}

	@Override
	public List<UbigeoBean> listarDistrito(UbigeoBean ubigeoBean)
			throws DAOException {
		List<Ubigeo> lstUbigeo = null;	
		List<UbigeoBean> lstUbigeoBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbcUbigeo.listarComboDistrito");
			spq.setParameter("p_codregion", ubigeoBean.getCodigoRegion());  
			spq.setParameter("p_codprovin", ubigeoBean.getCodigoProvincia());  
			if (spq.execute()) {
				lstUbigeo =  spq.getResultList(); 
			} 
			if (lstUbigeo != null && lstUbigeo.size() > 0) {
				
				lstUbigeoBean = deListaUbigeoAListaUbigeoBean(lstUbigeo);
			}
			//em.close();
			
		   
		return lstUbigeoBean;
	}

	@Override
	public UbigeoBean buscarEquivalenteReniecMinsa(UbigeoBean ubigeoBean) { 
		List<Ubigeo> oUbigeo = null;	
		UbigeoBean oUbigeoBean = null;
		
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("ubigeo.equivalenciaReniecMinsa");
		spq.setParameter("CODUBIGE", ubigeoBean.getCodigoUbigeo());   
		if (spq.execute()) {
			oUbigeo =  spq.getResultList(); 
		} 
		if (oUbigeo != null && oUbigeo.size() > 0) {
			
			oUbigeoBean = deUbigeoAUbigeoBean(oUbigeo.get(0));
		}
		em.close();
		
	   
	return oUbigeoBean;
	}

}
