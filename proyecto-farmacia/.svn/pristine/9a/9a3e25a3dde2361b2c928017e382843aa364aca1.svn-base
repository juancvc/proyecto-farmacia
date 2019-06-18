
package hnch.referencia.core.repository.implementacion.seguridad;

import hnch.referencia.core.bean.general.TablaBean;
import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.bean.seguridad.UsuarioBean;
import hnch.referencia.core.bean.seguridad.UsuarioRenaesBean;
import hnch.referencia.core.entity.seguridad.Perfil;
import hnch.referencia.core.entity.seguridad.SigehoUsuario;
import hnch.referencia.core.entity.seguridad.UsuarioRenaes;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.UsuarioDAO;
import hnch.referencia.core.repository.interfaces.seguridad.UsuarioRenaesDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository("usuarioRenaesDAOImp")
public class UsuarioRenaesDAOImp implements UsuarioRenaesDAO {

	@PersistenceContext//(unitName="emfSeguridad")
	private EntityManager em; 
	
	@Override
	public boolean insertar(UsuarioRenaesBean t) throws DAOException {
		// TODO Auto-generated method stub
		Object id= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioRenaes.insertar");
				spq.setParameter("CODUSUAR", t.getUsuario().getCodigo());
				spq.setParameter("CODORGAN", t.getCodigoOrganizacion());
	            spq.setParameter("CODINSTI", t.getCodigoInstitucion());
	            spq.setParameter("CODSEDEI", t.getCodigoSede());
	            
	            spq.setParameter("CODPERSO", t.getUsuario().getPersona().getCodigo());
	            spq.setParameter("CODRGREN", t.getRenaes().getCodigo());
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
	public boolean actualizar(UsuarioRenaesBean t) throws DAOException {
		boolean sw=false;
		/*
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.actualizar");
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
			spq.setParameter("p_nomusuari", t.getNombreUsuario());
            spq.setParameter("p_passusuar", t.getPasswordUsuario());
            spq.setParameter("p_tm1situsu", t.getSituacion()!=null?t.getSituacion().getCodReg():null);
            spq.setParameter("p_codusureg", t.getCodigoUsuarioCreacion());
            spq.setParameter("p_hostreg", t.getIpCreacion());
            spq.setParameter("p_codusumod", t.getCodigoUsuarioModificacion());
            spq.setParameter("p_fecmod", null);
            spq.setParameter("p_hostmod", t.getIpModificacion());
	        
	        spq.execute();
			sw=true;
				
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		*/
		return sw;
	}

	@Override
	public boolean eliminar(UsuarioRenaesBean t) throws DAOException {
		
		boolean sw=false; 
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioRenaes.eliminar");
				spq.setParameter("CODUSREN", t.getCodigo());
				spq.setParameter("CODUSUAR", t.getUsuario().getCodigo());
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
	public UsuarioRenaesBean getBuscarPorObjecto(UsuarioRenaesBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioRenaesBean> getBuscarPorFiltros(UsuarioRenaesBean t)
			throws DAOException {
		List<UsuarioRenaesBean> lstBean = new ArrayList<UsuarioRenaesBean>();
		List<SigehoUsuario> lstEntity = null;
		/*
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("leotbc_usuario.listar");
			
			spq.setParameter("p_codusuari", t.getCodigoUsuario());
			spq.setParameter("p_nomusuari", t.getNombreUsuario());
			spq.setParameter("p_codperso", t.getPersona()!=null? t.getPersona().getCodigo():null);
			spq.setParameter("p_codperfil", t.getCodigoPerfil());
            spq.setParameter("p_tm1situsu", t.getSituacion()!=null?t.getSituacion().getCodReg():null);
            spq.setParameter("p_codusuacc", t.getAudCodigoUsuario()); 
            spq.setParameter("p_codperusu", t.getCodPerfilUsuSelec()); 
			if (spq.execute()) {
				lstEntity = spq.getResultList();			
			}
			
			if (	lstEntity != null
				&&	lstEntity.size() > 0) {
				for (SigehoUsuario SigehoUsuario : lstEntity) {
					lstBean.add(deUsuarioToUsuarioRenaesBean(SigehoUsuario));
				}
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		*/
		return lstBean;
	}

	@Override
	public boolean existe(UsuarioRenaesBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
	
 
	
	private UsuarioRenaesBean deUsuarioRenaesToUsuarioRenaesBean(UsuarioRenaes entity){
		UsuarioRenaesBean bean = new UsuarioRenaesBean();
		if(entity!=null){
			bean.setCodigo(entity.getCodUsRen());//codigo Usuario
			bean.getUsuario().setCodigo(entity.getCodUsuar());
			bean.setEstado(entity.getEstadoRg()); 
			bean.getRenaes().setCodigo(entity.getCodRgRen()); 
			bean.getRenaes().setCodRenaes(entity.getCodRenea());
			bean.getRenaes().setNomRenaes(entity.getNomRenea());
			bean.getRenaes().setRed(entity.getRed()); 
			bean.getRenaes().getCategoria().setNombreCorto(entity.getCategoria());
		  } 
		return bean;
	}
	
	private List<UsuarioRenaesBean> deListaUsuarioRenaeAListaUsuarioRenaeBean(List<UsuarioRenaes> lstHorarioExcepcion) {

		List<UsuarioRenaesBean> lstPerfilBean = null;

		if (lstHorarioExcepcion != null && lstHorarioExcepcion.size() > 0) {

			lstPerfilBean = new ArrayList<UsuarioRenaesBean>();

			for (int i = 0; i < lstHorarioExcepcion.size(); i++) {
				UsuarioRenaes entity = lstHorarioExcepcion.get(i);
				UsuarioRenaesBean bean = deUsuarioRenaesToUsuarioRenaesBean(entity);

				lstPerfilBean.add(bean);
			}
		}

		return lstPerfilBean;
	}
  
	@Override
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException {
		List<UsuarioRenaesBean> lstUsuarioRenaesBean = null;
		List<UsuarioRenaes> lstLeotbcUsuario = null;
		
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuarioRenaes.buscarxcodigousua");
			spq.setParameter("CODUSUAR", prmUsuarioBean.getCodigo());
			if (spq.execute()) {
				lstLeotbcUsuario = spq.getResultList();
			}

			if (lstLeotbcUsuario != null && lstLeotbcUsuario.size() > 0) {
				 
				lstUsuarioRenaesBean = deListaUsuarioRenaeAListaUsuarioRenaeBean(lstLeotbcUsuario);
			}  

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
		return lstUsuarioRenaesBean;
	}

}