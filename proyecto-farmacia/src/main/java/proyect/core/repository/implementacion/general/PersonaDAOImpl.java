package proyect.core.repository.implementacion.general;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.general.PersonaBean;
import proyect.core.entity.general.Persona;
import proyect.core.repository.interfaces.general.PersonaDAO;



@Transactional
@Repository("personaDAO")
public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(PersonaBean persona) throws DAOException {
  
		Object idPersona= null; 
		//Object nroPeriodo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.insertar");
			
			spq.setParameter("apellidoPaterno", persona.getApellidoPaterno());
			spq.setParameter("apellidoMaterno", persona.getApellidoMaterno());
			spq.setParameter("nombres", persona.getNombres());  
			spq.setParameter("direccion", persona.getNroDocumento()); 
			 
			spq.setParameter("fechaNacimiento", persona.getFechaNacStr());
			spq.setParameter("idTipoDocumentoCat02", persona.getTipoDocumento().getIdRegistro());
			spq.setParameter("nroDocumento", persona.getNroDocumento());
			spq.setParameter("ruc",persona.getRuc());
			spq.setParameter("idRegUbigeoDireccion",persona.getUbigeoDireccion().getCodigoRegistro());
			spq.setParameter("telefono",persona.getTelefonoNumero());
			spq.setParameter("correo",persona.getCorreo());
			spq.setParameter("idSexoCat02",persona.getSexo().getIdRegistro());
			spq.setParameter("idNacionalidadCat01",persona.getNacionalidad().getIdRegistro());
			spq.setParameter("idEstadoCivilCat01",persona.getEstadoCivil().getIdRegistro());
			spq.setParameter("usuarioRegistro",persona.getUsuarioRegistro());
			spq.setParameter("ipRegistro",persona.getIpRegistro());
		//	spq.setParameter("SWRENIEC", persona.getSwReniec()? "1":"0");
			
			spq.execute();
			
			idPersona = spq.getOutputParameterValue(1);
			//nroPeriodo = spq.getOutputParameterValue(16);
			if (idPersona != null) {
				persona.setCodigo(idPersona.toString());
				//persona.setNumeroPeriodo(nroPeriodo.toString());
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
	public boolean actualizar(PersonaBean persona) throws DAOException {
		//LenguaBean lengua= this.getLenguaBean(objeto);
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.actualizar");
			
			spq.setParameter("p_codperso", persona.getCodigo());
			spq.setParameter("p_apepatper", persona.getApellidoPaterno());
			spq.setParameter("p_apematper", persona.getApellidoMaterno());  
			spq.setParameter("p_correo", persona.getCorreo());   

			
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
	public boolean eliminar(PersonaBean t) throws DAOException {
		
		return false;
	}

	@Override
	public PersonaBean getBuscarPorObjecto(PersonaBean t) throws DAOException {
		
		return null;
	}

	@Override
	public List<PersonaBean> getBuscarPorFiltros(PersonaBean personaBean)
			throws DAOException {
		List<Persona> lstPersona = null;	
		List<PersonaBean> lstPersonaBean = null;
		
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.buscarPorFiltros");   
			spq.setParameter("nroDocumento", personaBean.getNroDocumento());
			 if (spq.execute()) {
				 lstPersona =  spq.getResultList(); 
			 }
			if (lstPersona != null && lstPersona.size() > 0) {
				lstPersonaBean = deListaObjetoAListaObjetoBean(lstPersona);
			 }
			
			em.close();
			
		   
		return lstPersonaBean;
	}

	@Override
	public boolean existe(PersonaBean t) throws DAOException {
		
		return false;
	}

	@Override
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(
			PersonaBean personaBean) throws DAOException { 
		List<Persona> lstpersona = null;	
		PersonaBean oPersonaBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.buscarPorDocumento"); 
			spq.setParameter("nroDocumento", personaBean.getNroDocumento());  
			if (spq.execute()) {
				lstpersona =  spq.getResultList(); 
			} 
			if (lstpersona != null && lstpersona.size() > 0) {
				
				oPersonaBean = dePersonaAPersonaBean(lstpersona.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		}
			
			//em.close();
			
		   
		return oPersonaBean;
	}
	
private List<PersonaBean> deListaObjetoAListaObjetoBean(List<Persona> lstPersona) {
		
		List<PersonaBean> lstPersonaBean = null;
		
		if (lstPersona != null && lstPersona.size() > 0) {
			System.out.println("pasa 1");
			lstPersonaBean = new ArrayList<PersonaBean>();
			
			for (int i = 0; i < lstPersona.size(); i++) { 
				Persona entity = lstPersona.get(i);
				PersonaBean bean = dePersonaAPersonaBean(entity);
				
				lstPersonaBean.add(bean);
			}
		}
		
		return lstPersonaBean;
	}
	
	
	private PersonaBean dePersonaAPersonaBean(Persona entity) {
		
		PersonaBean bean = null;
		
		if (entity != null) {
			
			bean = new PersonaBean(); 
			bean.setCodigo(entity.getIdPersona());
			bean.setNombres(entity.getNombres());
			bean.setApellidoPaterno(entity.getApellidoPaterno());
			bean.setApellidoMaterno(entity.getApellidoMaterno());
			bean.getTipoDocumento().setIdRegistro(entity.getIdTipoDocumento());;
			bean.setNroDocumento(entity.getNroDocumento()); 
			bean.getSexo().setIdRegistro(entity.getIdSexo()); 
			bean.setTelefonoNumero(entity.getTelefono());
			bean.setCorreo(entity.getCorreo());
			bean.setDireccion(entity.getDireccion());
			bean.getEstadoCivil().setIdRegistro(entity.getIdEstadoCivil());
			bean.getNacionalidad().setIdRegistro(entity.getIdNacionalidad());
			bean.getUbigeoDireccion().setCodigoRegistro(entity.getIdRegUbigeoDireccion());
			bean.setCodigoPersonaSigeho(entity.getCodPersoSigeho());
			
			/**
			bean.setFechaNac(entity.getFechanac());
			bean.setFoto(entity.getFotoDeta()); 
			
			bean.getNacionalidad().setNombreCorto(entity.getNOMBTPNA());
			bean.getSituacion().setNombreCorto(entity.getNOMBSITU());
			bean.getUbigeoDireccion().setCodigoUbigeo(entity.getTgUbigeo());
			bean.getUbigeoDireccion().setNombreUbigeo(entity.getNOMLARGO());
			bean.setNombreUsuarioCreacion(entity.getNOMUSUAR());
			bean.getUbigeoNacimiento().setCodigoRegistro(entity.getUBINAREG());
			bean.getUbigeoNacimiento().setNombreUbigeo(entity.getNOMLUGNAC());
			bean.getUbigeoNacimiento().setCodigoUbigeo(entity.getCODUBINA());
			
			*/
			
		}
		
		return bean;
	}

	@Override
	public boolean actualizardatosuser(PersonaBean persona) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.actualizaruser");
			
			spq.setParameter("p_codperso", persona.getCodigo()); 
			spq.setParameter("p_correo", persona.getCorreo());  
			spq.setParameter("p_hostmod", persona.getIpModificacion());

			
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
	public boolean actualizardatosfotouser(PersonaBean persona) throws DAOException {
		System.out.println("em :: " + em);
		System.out.println("persona DAO "+persona);
 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.actualizarfotouser");
			
			spq.setParameter("p_codperso", persona.getCodigo());  
			spq.setParameter("p_hostmod", persona.getIpModificacion());

			
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
	public PersonaBean buscarxTipoDocumentoNumeroDocumentoSigeho(PersonaBean personaBean) throws DAOException {
		List<Persona> lstpersona = null;	
		PersonaBean oPersonaBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.buscarPorDocumentoV2");
			spq.setParameter("nroDocumento", personaBean.getNroDocumento());     
			if (spq.execute()) {
				lstpersona =  spq.getResultList(); 
			} 
			if (lstpersona != null && lstpersona.size() > 0) {
				
				oPersonaBean = dePersonaAPersonaBean(lstpersona.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally{
			em.close();
		} 
		return oPersonaBean;
	}
 

}
