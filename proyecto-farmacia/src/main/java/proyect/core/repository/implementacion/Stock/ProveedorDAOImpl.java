package proyect.core.repository.implementacion.Stock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ProveedorBean;
import proyect.core.entity.stock.Proveedor;
import proyect.core.repository.interfaces.stock.ProveedorDAO;
import proyect.web.utilitarios.VO;

@Transactional
@Repository("ProveedorDAO")
public class ProveedorDAOImpl implements ProveedorDAO{
	
	@PersistenceContext
	private EntityManager em;

	public ProveedorDAOImpl() {
		
	}

	@Override
	public boolean insertar(ProveedorBean proveedorBean) throws DAOException {
		Object idProveedor= null;
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.insert");
		 
			spq.setParameter("nombreProveedor",   proveedorBean.getNombreProveedor());
			spq.setParameter("descripcion", 	  proveedorBean.getDescripcion());
			spq.setParameter("usuarioRegistro",   proveedorBean.getUsuarioRegistro());
			spq.setParameter("ipRegistro", 		  proveedorBean.getIpRegistro());
			spq.execute();
			
			idProveedor = spq.getOutputParameterValue(1);
			if (VO.isNotNull(idProveedor)) {
				proveedorBean.setCodigo(idProveedor.toString());
				sw=true;
			}
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(ProveedorBean proveedorBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.update");
			
			spq.setParameter("idProveedor",    			proveedorBean.getCodigo());
			spq.setParameter("nombreProveedor",  	 	proveedorBean.getNombreProveedor());
			spq.setParameter("descripcion", 	  		proveedorBean.getDescripcion());	
			spq.setParameter("usuarioModificacion",     proveedorBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", 		    proveedorBean.getIpModificacion());
	
			spq.execute();
			
			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(ProveedorBean proveedorBean) throws DAOException {
		boolean sw=true;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.delete");
			spq.setParameter("idProveedor",    			proveedorBean.getCodigo());
			spq.setParameter("usuarioModificacion",     proveedorBean.getUsuarioModificacion());
			spq.setParameter("ipModificacion", 		    proveedorBean.getIpModificacion());
			spq.execute();

			em.close();
			
		} catch (Exception e) {
			sw=false;
			throw new DAOException(e);
		}
		return sw;
	}

	@Override
	public ProveedorBean getBuscarPorObjecto(ProveedorBean proveedorBean) throws DAOException {
		List<Proveedor> lstProveedor = null;	
		ProveedorBean   lstProveedorBean = null;

				StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.findByObject");  
				spq.setParameter("idProveedor", proveedorBean.getCodigo()); 
				
				 if (spq.execute()) {
					 lstProveedor =  spq.getResultList(); 
				 }
				 
				if (lstProveedor != null && lstProveedor.size() > 0) {
					lstProveedorBean = deObjetoAObjetoBean(lstProveedor.get(0));
				 }
				
				em.close();
				
			   
			return lstProveedorBean;
	}

	@Override
	public List<ProveedorBean> getBuscarPorFiltros(ProveedorBean proveedorBean) throws DAOException {
		List<Proveedor> lstProveedor = null;	
		List<ProveedorBean> lstProveedorBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proveedor.buscarPorFiltros");  
			spq.setParameter("nombreProveedor", proveedorBean.getNombreProveedor()); 
			spq.setParameter("descripcion", 	proveedorBean.getDescripcion());
			 if (spq.execute()) {
				 lstProveedor =  spq.getResultList(); 
			 }
			 
			if (lstProveedor != null && lstProveedor.size() > 0) {
				lstProveedorBean = deListaObjetoAListaObjetoBean(lstProveedor);
			 }
			
			em.close();
			
		   
		return lstProveedorBean;
	}

	@Override
	public boolean existe(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
private List<ProveedorBean> deListaObjetoAListaObjetoBean(List<Proveedor> lstProveedor) {
		
		List<ProveedorBean> lstProveedorBean = null;
		
		if (lstProveedor != null && lstProveedor.size() > 0) {
			
			lstProveedorBean = new ArrayList<ProveedorBean>();
			
			for (int i = 0; i < lstProveedor.size(); i++) { 
				Proveedor entity = lstProveedor.get(i);
				ProveedorBean bean = deObjetoAObjetoBean(entity);
				
				lstProveedorBean.add(bean);
			}
		}
		
		return lstProveedorBean;
	}
	
	
private ProveedorBean deObjetoAObjetoBean(Proveedor entity) {
		
		ProveedorBean bean = null; 
		if (entity != null) {
			
			bean = new ProveedorBean();
			bean.setCodigo(entity.getIdProveedor());   
			bean.setNombreProveedor(entity.getNombreProveedor());
			bean.setDescripcion(entity.getDescripcion());
			bean.setUsuarioRegistro(entity.getUsuarioRegistro());
			bean.setIpRegistro(entity.getIpRegistro());
		
	 	}
		
		return bean;
	}
	
 
	
 
  
 
}
