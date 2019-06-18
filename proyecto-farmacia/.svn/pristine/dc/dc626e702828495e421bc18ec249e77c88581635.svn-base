
package hnch.referencia.core.repository.implementacion.seguridad;

import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.entity.seguridad.SigehoUsuario;
import hnch.referencia.core.entity.seguridad.Usuario;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



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
            spq.setParameter("CODORGAN", t.getCodigoOrganizacion());
            spq.setParameter("CODINSTI", t.getCodigoInstitucion());
            spq.setParameter("CODSEDEI", t.getCodigoSede());
            spq.setParameter("NOMUSUAR", t.getNombreUsuario());
            spq.setParameter("PSWUSUAR", t.getPasswordUsuario());
            
            spq.setParameter("CODPERSO", t.getPersona()!=null? t.getPersona().getCodigo():null);
            
            spq.setParameter("CODIPERF", t.getPerfil().getCodigo());            
            spq.setParameter("AUCDUSCR", t.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", t.getIpCreacion());

	        
	        spq.execute();
			
			id = spq.getOutputParameterValue(1);
			nroPeriodo = spq.getOutputParameterValue(2);
			if (id != null) {
			 	t.setCodigo(id.toString());
			 	t.setNumeroPeriodo(nroPeriodo.toString());
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
			    spq.setParameter("NROPERIO", t.getNumeroPeriodo());
			    spq.setParameter("CODORGAN", t.getCodigoOrganizacion());
	            spq.setParameter("CODINSTI", t.getCodigoInstitucion());
	            spq.setParameter("CODSEDEI", t.getCodigoSede());
	            spq.setParameter("NOMUSUAR", t.getNombreUsuario());
	            spq.setParameter("PSWUSUAR", t.getPasswordUsuario());
	            
	            spq.setParameter("CODPERSO", t.getPersona()!=null? t.getPersona().getCodigo():null);
	            
	            spq.setParameter("CODIPERF", t.getPerfil().getCodigo());            
	            spq.setParameter("AUCDUSMO", t.getCodigoUsuarioModificacion());
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
		    spq.setParameter("CODORGAN", t.getCodigoOrganizacion());
            spq.setParameter("CODINSTI", t.getCodigoInstitucion());
            spq.setParameter("CODSEDEI", t.getCodigoSede());         
            spq.setParameter("AUCDUSMO", t.getCodigoUsuarioModificacion());
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.listar");
			
			spq.setParameter("NOMUSUAR", t.getNombreUsuario());
			spq.setParameter("CODIPERF", t.getPerfil().getCodigo()); 
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.autenticar");
			spq.setParameter("NOMUSUAR", prmUsuarioBean.getNombreUsuario());
			spq.setParameter("PSWUSUAR", prmUsuarioBean.getPasswordUsuario());
		
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
			bean.setCodigo(entity.getnCodusuari());//codigo Usuario
			bean.setCodigoOrganizacion(entity.getCodOrgan());
			bean.setCodigoInstitucion(entity.getCodInsti());
			bean.setCodigoSede(entity.getCodSedei());
			bean.setNumeroPeriodo(entity.getNroPerio());
			bean.setNumeroVersion(entity.getNroVersi());
			
			bean.setCodigoUsuario(entity.getnCodusuari()); 
			bean.setEstado(entity.getvFlgest());
			bean.setNombreUsuario(entity.getvNomusuari());
			bean.setPasswordUsuario(entity.getvPassusuar());
			
			bean.setPersona(new PersonaBean()); 
			bean.getPersona().setCodigo(entity.getnCodperso()); 
			bean.getPersona().setApellidoMaterno(entity.getApeMater());
			bean.getPersona().setApellidoPaterno(entity.getApePater());
			bean.getPersona().setPrimerNombre(entity.getPriNombr());
			bean.getPersona().setSegundoNombre(entity.getSegNombr());
			bean.getPersona().setTipoDocumento(new TablaBean());
			bean.getPersona().getTipoDocumento().setCodReg(entity.getTg1TpDoc());
			bean.getPersona().setNroDocumento(entity.getNroDocum()); 

			bean.setPerfil(new PerfilBean());
			bean.getPerfil().setCodigo(entity.getnCodperfil());
			bean.getPerfil().setNombrePerfil(entity.getNomPerfil());
			bean.setNombrePerfiles(entity.getNomPerfil());
			bean.setFlgRestPass(entity.getvFlgrestpas()); 
		 	if(entity.getnTm1situsu()!=""){

			 	if(entity.getnTm1situsu()!=null){

				bean.setSituacion(new TablaBean());
				bean.getSituacion().setCodReg(entity.getnTm1situsu()); 
			}
		  }
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
		    spq.setParameter("CODORGAN", t.getCodigoOrganizacion());
            spq.setParameter("CODINSTI", t.getCodigoInstitucion());
            spq.setParameter("CODSEDEI", t.getCodigoSede());   
            spq.setParameter("PSWUSUAR", t.getNewPassword()); 
            spq.setParameter("AUCDUSMO", t.getCodigoUsuarioModificacion());
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