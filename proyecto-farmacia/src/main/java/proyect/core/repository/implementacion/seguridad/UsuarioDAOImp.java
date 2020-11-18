
package proyect.core.repository.implementacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.PersonaBean;
import proyect.base.repository.DAOException;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.entity.seguridad.SigehoUsuario;
import proyect.core.entity.seguridad.Usuario;
import proyect.core.repository.interfaces.seguridad.UsuarioDAO;



@Transactional
@Repository("usuarioDAO")
public class UsuarioDAOImp implements UsuarioDAO {

	@PersistenceContext//(unitName="emfSeguridad")
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.insertar");
            spq.setParameter("NOMUSUAR", t.getNombreUsuario());
            spq.setParameter("PSWUSUAR", t.getPasswordUsuario());
            
            spq.setParameter("CODPERSO", t.getPersona()!=null? t.getPersona().getCodigo():null);
            spq.setParameter("CODIPERF", t.getPerfil().getCodigo());
            spq.setParameter("EMAIL", 	 t.getPersona().getCorreo());   
            spq.setParameter("NUMECELU", t.getPersona().getTelfCelu());    ;

	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
		//	nroPeriodo = spq.getOutputParameterValue(2);
			if (id != null) {
			 	t.setCodigo(id.toString());
			// 	t.setNumeroPeriodo(nroPeriodo.toString());
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
	public boolean actualizar(UsuarioBean t) throws DAOException {
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.actualizar");
			    spq.setParameter("CODUSUAR", t.getCodigo());
	            spq.setParameter("NOMUSUAR", t.getNombreUsuario());
	            spq.setParameter("PSWUSUAR", t.getPasswordUsuario());
	            
	            spq.setParameter("CODPERSO", t.getPersona()!=null? t.getPersona().getCodigo():null);
	            
	            spq.setParameter("CODIPERF", t.getPerfil().getCodigo()); 
	            spq.setParameter("EMAIL", 	 t.getCorreo());   
	            spq.setParameter("NUMECELU", t.getNroCelular());    
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
	public boolean eliminar(UsuarioBean t) throws DAOException {
		
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.eliminar");
			spq.setParameter("CODUSUAR", t.getCodigo());
		    spq.setParameter("NROPERIO", t.getNumeroPeriodo());         
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
	public UsuarioBean getBuscarPorObjecto(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioBean> getBuscarPorFiltros(UsuarioBean t)
			throws DAOException {
		List<UsuarioBean> lstBean = new ArrayList<UsuarioBean>();
		List<Usuario> lstEntity = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.buscarPorCriterios");
			
			spq.setParameter("usuario", t.getNombreUsuario());
			spq.setParameter("nombre", t.getNombreUsuario());
			spq.setParameter("idPerfil", t.getPerfil().getCodigo()); 
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (Usuario SigehoUsuario : lstEntity) {
					lstBean.add(deSigehoUsuarioToUsuarioBean(SigehoUsuario));
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
	public boolean existe(UsuarioBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException {
		UsuarioBean objUsuarioBean = null;
		List<Usuario> lstLeotbcUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.validarAccesoAlmacen");
			spq.setParameter("nombreUsuario", prmUsuarioBean.getNombreUsuario());
			spq.setParameter("clave", prmUsuarioBean.getPasswordUsuario());
			spq.setParameter("idAlmacen", prmUsuarioBean.getAlmacen().getCodigo());
			
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();			
			}
			
			if (	lstLeotbcUsuario != null
				&&	lstLeotbcUsuario.size() > 0) {
				
				objUsuarioBean = deSigehoUsuarioToUsuarioBean(lstLeotbcUsuario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objUsuarioBean;
	}
	
	
	
	private UsuarioBean deSigehoUsuarioToUsuarioBean(Usuario entity){
		UsuarioBean bean = new UsuarioBean();
		if(entity!=null){
			bean.setCodigo(entity.getIdUsuario());
			bean.setCodigoUsuario(entity.getIdUsuario()); 
			bean.setNombreUsuario(entity.getUsuario());
			bean.setPasswordUsuario(entity.getClave()); 
			bean.setActivo(entity.getFglgest()); 
			bean.setPersona(new PersonaBean()); 
			bean.getPersona().setCodigo(entity.getIdPersona()); 
			bean.getPersona().setApellidoMaterno(entity.getApellidoMaterno());
			bean.getPersona().setApellidoPaterno(entity.getApellidoPaterno());
			bean.getPersona().setNombres(entity.getNombres()); 
			bean.setFlgRestPass(entity.getFlgResetClave()); 
			bean.getPerfil().setCodigo(entity.getIdPerfil());
			bean.getPerfil().setNombrePerfil(entity.getNombrePerfil());
		}
		return bean;
	}
	
	
	
	
	

	@Override
	public Integer cambiarPassword(UsuarioBean t)
			throws DAOException {
		Object obj;
		Integer result = -1;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.resetpass");
			spq.setParameter("CODUSUAR", t.getCodigo());
		    spq.setParameter("NROPERIO", t.getNumeroPeriodo());   
            spq.setParameter("PSWUSUAR", t.getNewPassword());  
			spq.setParameter("AUPCIPMO", t.getIpModificacion());
	        
	        spq.execute();
	        obj = spq.getOutputParameterValue(6);
	        if(obj!=null){
	        	t.setPasswordUsuario(obj.toString()); 
	        	result = 1;
	        }
				
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}finally{
			em.close();
		}
		return result;
	}

	@Override
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException {
		UsuarioBean objUsuarioBean = null;
		List<Usuario> lstLeotbcUsuario = null;
		System.out.println("buscarxcodigousua DAO " + prmUsuarioBean.getCodigoUsuario());
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioObj.buscarPorCodigoUsuario");
			spq.setParameter("CODUSUAR", prmUsuarioBean.getCodigoUsuario());
		
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();			
			}
			
			if (	lstLeotbcUsuario != null
				&&	lstLeotbcUsuario.size() > 0) {
				
				objUsuarioBean = deSigehoUsuarioToUsuarioBean(lstLeotbcUsuario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objUsuarioBean;
	}
	
	@Override
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws DAOException {
		UsuarioBean objUsuarioBean = null;
		List<Usuario> lstLeotbcUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.buscarxcodperso");
			spq.setParameter("CODPERSO", prmUsuarioBean.getPersona().getCodigo());
		
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();			
			}
			
			if (	lstLeotbcUsuario != null
				&&	lstLeotbcUsuario.size() > 0) {
				
				objUsuarioBean = deSigehoUsuarioToUsuarioBean(lstLeotbcUsuario.get(0));
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return objUsuarioBean;
	}

}