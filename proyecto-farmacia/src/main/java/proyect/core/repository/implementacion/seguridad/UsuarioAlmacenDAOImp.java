
package proyect.core.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import proyect.base.repository.DAOException; 
import proyect.core.bean.seguridad.UsuarioAlmacenBean; 
import proyect.core.entity.seguridad.UsuarioAlmacen;
import proyect.core.repository.interfaces.seguridad.UsuarioAlmacenDAO; 



@Transactional
@Repository("usuarioAlmacenDAO")
public class UsuarioAlmacenDAOImp implements UsuarioAlmacenDAO {

	@PersistenceContext//(unitName="emfSeguridad")
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioAlmacenBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacen.insert"); 
			spq.setParameter("idUsuario", t.getUsuario().getCodigo()); 
			spq.setParameter("idAlmacen", t.getAlmacen().getCodigo()); 
            spq.setParameter("usuarioRegistro", t.getUsuarioRegistro());   
            spq.setParameter("ipRegistro", t.getIpRegistro());

	        spq.execute();
			
			id = spq.getOutputParameterValue(1); 
			if (id != null) {
			 	t.setCodigo(id.toString()); 
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
	public boolean actualizar(UsuarioAlmacenBean t) throws DAOException {
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.actualizar");
			    spq.setParameter("CODUSUAR", t.getCodigo()); 
				spq.setParameter("AUPCIPMO", t.getIpModificacion());
	        
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
	public boolean eliminar(UsuarioAlmacenBean t) throws DAOException {
		
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacen.delete");
			spq.setParameter("idUsuarioAlmacen", t.getCodigo());
		    spq.setParameter("usuarioModificacion", t.getUsuarioModificacion());         
			spq.setParameter("ipModificacion", t.getIpModificacion());
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
	public UsuarioAlmacenBean getBuscarPorObjecto(UsuarioAlmacenBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioAlmacenBean> getBuscarPorFiltros(UsuarioAlmacenBean t)
			throws DAOException {
		List<UsuarioAlmacenBean> lstBean = new ArrayList<UsuarioAlmacenBean>();
		List<UsuarioAlmacen> lstEntity = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacen.buscarPorCriterios");
			
			spq.setParameter("idUsuario", t.getUsuario().getCodigo()); 
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (UsuarioAlmacen usuarioAlmacen : lstEntity) {
					lstBean.add(deUsuarioAlmacenToUsuarioAlmacenBean(usuarioAlmacen));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioAlmacenBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	 
	
	
	private UsuarioAlmacenBean deUsuarioAlmacenToUsuarioAlmacenBean(UsuarioAlmacen entity){
		UsuarioAlmacenBean bean = new UsuarioAlmacenBean();
		if(entity!=null){
			bean.setCodigo(entity.getIdUsuarioAlmacen());
			bean.getUsuario().setCodigo(entity.getIdUsuario());
			bean.getAlmacen().setCodigo(entity.getIdAlmacen());
			bean.getAlmacen().setNombreAlmacen(entity.getNombreAlmacen());
		}
		return bean;
	}
	 

}