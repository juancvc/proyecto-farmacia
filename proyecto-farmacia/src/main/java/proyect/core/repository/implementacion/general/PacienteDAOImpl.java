package proyect.core.repository.implementacion.general;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.entity.general.Paciente;
import proyect.core.entity.general.Persona;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.PacienteDAO;



@Transactional
@Repository("pacienteBeanDAO")
public class PacienteDAOImpl implements PacienteDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(PacienteBean pacienteBean) throws DAOException { 

		//System.out.println("pacienteBean DAO "+pacienteBean);
		Object idPersona= null; 
		Object nroPeriodo= null; 
		Object nroVersion= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("paciente.insertar");
			 
		//	spq.setParameter("SWVALSIS", pacienteBean.getSwValidaSISwebService()? "1":"0");
			spq.execute();
			
			idPersona = spq.getOutputParameterValue(1);
			nroPeriodo = spq.getOutputParameterValue(2);
			nroVersion = spq.getOutputParameterValue(6);
			if (idPersona != null) {
				pacienteBean.setCodigo(idPersona.toString());
				pacienteBean.setNumeroPeriodo(nroPeriodo.toString());
				pacienteBean.setNumeroVersion(nroVersion.toString()); 
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
	public boolean actualizar(PacienteBean pacienteBean) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("pacienteBean DAO "+pacienteBean);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("pacienteBean.actualizar");
			 
			spq.setParameter("p_hostmod", pacienteBean.getIpCreacion());

			
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
	public boolean eliminar(PacienteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PacienteBean getBuscarPorObjecto(PacienteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteBean> getBuscarPorFiltros(PacienteBean t)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(PacienteBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PacienteBean buscarxTipoDocumentoNumeroDocumento(
			PacienteBean pacienteBeanBean) throws DAOException { 
		List<Paciente> lstpacienteBean = null;	
		PacienteBean oPacienteBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("pacienteBean.buscar_x_tipodocumento_numero_documento");
			if (spq.execute()) {
				lstpacienteBean =  spq.getResultList(); 
			} 
			if (lstpacienteBean != null && lstpacienteBean.size() > 0) {
				
				oPacienteBean = dePersonaAPacienteBean(lstpacienteBean.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
			
			//em.close();
			
		   
		return oPacienteBean;
	}
	
	private PacienteBean dePersonaAPacienteBean(Paciente entity) {
		
		PacienteBean bean = null;
		
		if (entity != null) {
			
			bean = new PacienteBean();
		/**	 
			bean.setCodigo(entity.getId().getCodpacie());
			bean.setNumeroPeriodo(""+entity.getId().getNroPerio());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.getPersona().setCodigo(entity.getCodPerso());  
			bean.getTipoSeguro().setCodReg(entity.getTg14tpse());  
			bean.setCategoriaSeguro(entity.getCategoria());
			*/
		}
		
		return bean;
	}

	@Override
	public boolean actualizardatosuser(PacienteBean pacienteBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("pacienteBean DAO "+pacienteBean);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("pacienteBean.actualizaruser");
			
			spq.setParameter("p_codperso", pacienteBean.getCodigo());  
			spq.setParameter("p_codusumod", pacienteBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", pacienteBean.getIpModificacion());

			
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
	public boolean actualizardatosfotouser(PacienteBean pacienteBean) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("pacienteBean DAO "+pacienteBean);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("pacienteBean.actualizarfotouser");
			
			spq.setParameter("p_codperso", pacienteBean.getCodigo()); 
			spq.setParameter("p_codusumod", pacienteBean.getCodigoUsuarioModificacion());
			spq.setParameter("p_hostmod", pacienteBean.getIpModificacion());

			
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
	public PacienteBean buscarxPersona(PersonaBean personaBean) throws DAOException {
		List<Paciente> lstpacienteBean = null;	
		PacienteBean oPacienteBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("paciente.buscarPorPersona");
			spq.setParameter("CODPERSO", personaBean.getCodigo());  
			spq.setParameter("NROPERPE", personaBean.getNumeroPeriodo());  
			
			if (spq.execute()) {
				lstpacienteBean =  spq.getResultList(); 
			} 
			if (lstpacienteBean != null && lstpacienteBean.size() > 0) {
				
				oPacienteBean = dePersonaAPacienteBean(lstpacienteBean.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
			 
		return oPacienteBean;
	}


}
