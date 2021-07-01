
package proyect.core.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional; 
import proyect.base.repository.DAOException; 
import proyect.core.bean.seguridad.UsuarioAlmacenTurnoBean; 
import proyect.core.entity.seguridad.UsuarioAlmacenTurno;
import proyect.core.repository.interfaces.seguridad.UsuarioAlmacenTurnoDAO; 



@Transactional
@Repository("usuarioAlmacenTurnoDAO")
public class UsuarioAlmacenTurnoDAOImp implements UsuarioAlmacenTurnoDAO {

	@PersistenceContext//(unitName="emfSeguridad")
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioAlmacenTurnoBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacenTurno.insert"); 
			spq.setParameter("idUsuarioAlmacen", t.getUsuarioAlmacen().getCodigo()); 
			spq.setParameter("idTurno", t.getTurno().getCodigo()); 
			spq.setParameter("estadoTurno", t.getEstadoTurno()); 
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
	public boolean actualizar(UsuarioAlmacenTurnoBean t) throws DAOException {
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
	public boolean eliminar(UsuarioAlmacenTurnoBean t) throws DAOException {
		
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacenTurno.delete");
			spq.setParameter("idUsuarioAlmacenTurno", t.getCodigo());
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
	public UsuarioAlmacenTurnoBean getBuscarPorObjecto(UsuarioAlmacenTurnoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioAlmacenTurnoBean> getBuscarPorFiltros(UsuarioAlmacenTurnoBean t)
			throws DAOException {
		List<UsuarioAlmacenTurnoBean> lstBean = new ArrayList<UsuarioAlmacenTurnoBean>();
		List<UsuarioAlmacenTurno> lstEntity = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioAlmacenTurno.buscarPorCriterios");
			
			spq.setParameter("idUsuarioAlmacen", t.getUsuarioAlmacen().getCodigo()); 
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (UsuarioAlmacenTurno usuarioAlmacen : lstEntity) {
					lstBean.add(deUsuarioAlmacenTurnoToUsuarioAlmacenTurnoBean(usuarioAlmacen));
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
	public boolean existe(UsuarioAlmacenTurnoBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	 
	
	
	private UsuarioAlmacenTurnoBean deUsuarioAlmacenTurnoToUsuarioAlmacenTurnoBean(UsuarioAlmacenTurno entity){
		UsuarioAlmacenTurnoBean bean = new UsuarioAlmacenTurnoBean();
		if(entity!=null){
			bean.setCodigo(entity.getIdUsuarioAlmacenTurno());
			bean.getUsuarioAlmacen().setCodigo(entity.getIdUsuarioAlmacen());
			bean.getTurno().setCodigo(entity.getIdTurno());
			bean.getTurno().setNombreTurno(entity.getNombreAlmacen());
		}
		return bean;
	}
	 

}