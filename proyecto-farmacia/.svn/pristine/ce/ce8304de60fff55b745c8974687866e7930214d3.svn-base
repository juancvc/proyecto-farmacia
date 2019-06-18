package hnch.referencia.core.repository.implementacion.general;

import hnch.referencia.core.bean.general.PersonaBean;
import hnch.referencia.core.entity.general.Persona;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.general.PersonaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository("personaDAO")
public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext//(unitName="emf")
	private EntityManager em;
	
	@Override
	public boolean insertar(PersonaBean persona) throws DAOException {
  
		Object idPersona= null; 
		Object nroPeriodo= null; 
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.insertar");
			spq.setParameter("CODORGAN", persona.getCodigoOrganizacion()); 
			spq.setParameter("CODINSTI", persona.getCodigoInstitucion()); 
			spq.setParameter("CODSEDEI", persona.getCodigoSede()); 
			
			spq.setParameter("APEPATER", persona.getApellidoPaterno());
			spq.setParameter("APEMATER", persona.getApellidoMaterno());
			spq.setParameter("PRINOMBR", persona.getPrimerNombre()); 
			spq.setParameter("SEGNOMBR", persona.getSegundoNombre()); 
			spq.setParameter("TG1SEXO", persona.getSexo().getCodReg());  
			spq.setParameter("TG1TPDOC", persona.getTipoDocumento().getCodReg());  
			spq.setParameter("NRODOCUM", persona.getNroDocumento()); 
			
			spq.setParameter("AUCDUSCR", persona.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", persona.getIpCreacion());
			spq.setParameter("CDPERSIG", persona.getCodigoPersonaSigeho());
			spq.setParameter("FECHANAC", persona.getFechaNac());
			spq.setParameter("NROCELU", persona.getTelfCelu());
			//spq.setParameter("SWRENIEC","0");
			spq.setParameter("SWRENIEC", persona.getSwReniec()? "1":"0");
			
		/*	spq.execute();
			
			idPersona = spq.getOutputParameterValue(1);
			nroPeriodo = spq.getOutputParameterValue(16);
			if (idPersona != null) {
				persona.setCodigo(idPersona.toString());
				persona.setNumeroPeriodo(nroPeriodo.toString());
				sw=true;
			}*/
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
			
			spq.setParameter("p_tm1tpdope", persona.getTipoDocumento().getCodReg());  
			spq.setParameter("p_tm1sitper", persona.getSituacion().getCodReg());
			
			spq.setParameter("p_fechnacim", persona.getFechaNac());
			spq.setParameter("p_tm2pais", persona.getNacionalidad().getCodReg());
			spq.setParameter("p_tm2estciv", persona.getEstadoCivil().getCodReg()); 
			spq.setParameter("p_tm2sexo", persona.getSexo().getCodReg()); 
			spq.setParameter("p_correo", persona.getCorreo()); 
			spq.setParameter("p_codusumod", Integer.valueOf(String.valueOf(persona.getCodigoUsuarioCreacion())));
			spq.setParameter("p_hostmod", persona.getIpCreacion());

			
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
	public List<PersonaBean> getBuscarPorFiltros(PersonaBean t)
			throws DAOException {
		
		return null;
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
			spq.setParameter("TG1TPDOC", personaBean.getTipoDocumento().getCodReg());  
			spq.setParameter("NRODOCUM", personaBean.getNroDocumento());  
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
	
	private PersonaBean dePersonaAPersonaBean(Persona entity) {
		
		PersonaBean bean = null;
		
		if (entity != null) {
			
			bean = new PersonaBean(); 
			bean.setCodigo(entity.getId().getCodperso());
			bean.setCodigoPersonaSigeho(entity.getCodPersoSigeho());
			bean.setNroPeriodoPersona(""+entity.getId().getNroperio());
			bean.setNumeroPeriodo(""+entity.getId().getNroperio());
			bean.setCodigoOrganizacion(entity.getId().getCodorgan());
			bean.setCodigoInstitucion(entity.getId().getCodinsti());
			bean.setCodigoSede(entity.getId().getCodsedei());
			bean.setPrimerNombre(entity.getPrinombr());
			bean.setSegundoNombre(entity.getSegnombr());
			bean.setApellidoPaterno(entity.getApepater());
			bean.setApellidoMaterno(entity.getApemater());
			bean.getTipoDocumento().setCodReg(entity.getTg1TpDoc());
			bean.getTipoDocumento().setNombreCorto(entity.getNOMBTPDO());
			
			bean.setNroDocumento(entity.getNroDocum()); 
			bean.getSexo().setCodReg(entity.getTg1sexop());
			bean.getSexo().setNombreCorto(entity.getNOMBTPSX());
			
			bean.setFechaNac(entity.getFechanac());
			bean.setFoto(entity.getFotoDeta()); 
			bean.setDireccion(entity.getDesDirec());
			bean.getEstadoCivil().setCodReg(entity.getTg1esciv());
			bean.getNacionalidad().setCodReg(entity.getTg1nacio());
			bean.getNacionalidad().setNombreCorto(entity.getNOMBTPNA());
			
			bean.getOcupacion().setCodReg(entity.getTg1ocupa());
			bean.getOcupacion().setNombreCorto(entity.getNOMBTPOC());
			bean.getNivelInstrucion().setCodReg(entity.getTg1niins());
			
			bean.getUbigeoDireccion().setCodigoRegistro(entity.getUBIDIREG());
			bean.getUbigeoDireccion().setCodigoUbigeo(entity.getTgUbigeo());
			bean.getUbigeoDireccion().setNombreUbigeo(entity.getNOMLARGO());
			
			bean.getUbigeoNacimiento().setCodigoRegistro(entity.getUBINAREG());
			bean.getUbigeoNacimiento().setNombreUbigeo(entity.getNOMLUGNAC());
			bean.getUbigeoNacimiento().setCodigoUbigeo(entity.getCODUBINA());
			
			bean.setTelefonoNumero(entity.getTELFNUMR());
			bean.setCorreo(entity.getCORDESCR());
			bean.setCodigoCorreo(entity.getCODCORXP());
			bean.setCodigoDireccion(entity.getCODDIXPE());
			bean.setCodigoTelefono(entity.getCODTEXPE());
			
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
			spq.setParameter("p_codusumod", persona.getCodigoUsuarioModificacion());
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
			spq.setParameter("p_codusumod", persona.getCodigoUsuarioModificacion());
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
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.buscarPorDocumentoSigeho");
			spq.setParameter("TG1TPDOC", personaBean.getTipoDocumento().getCodReg());  
			spq.setParameter("NRODOCUM", personaBean.getNroDocumento());  
			spq.setParameter("TIPO", personaBean.getTipo());  
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

	@Override
	public boolean insertarPersonaBanco(PersonaBean persona) throws DAOException {
		Object idPersona= null; 
		//Object nroPeriodo= null; 
		Object nroVersi = null;
		
		Object codigoCorreo = null;
		Object codigoDireccion = null;
		Object codigoTelefono = null;
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.insertarPersonaBanco");
			spq.setParameter("CODORGAN", persona.getCodigoOrganizacion()); 
			spq.setParameter("CODINSTI", persona.getCodigoInstitucion()); 
			spq.setParameter("CODSEDEI", persona.getCodigoSede()); 
			
			spq.setParameter("APEPATER", persona.getApellidoPaterno());
			spq.setParameter("APEMATER", persona.getApellidoMaterno());
			spq.setParameter("PRINOMBR", persona.getPrimerNombre()); 
			spq.setParameter("SEGNOMBR", persona.getSegundoNombre()); 
			spq.setParameter("TG1SEXOP", persona.getSexo().getCodReg());
			spq.setParameter("FECHANAC", persona.getFechaNacStr());
			
			spq.setParameter("CODTIPOD", persona.getTipoDocumento().getCodReg());  
			spq.setParameter("NRODOCUM", persona.getNroDocumento()); 
			
			spq.setParameter("LUGANACI", persona.getUbigeoNacimiento().getCodigoRegistro()); 
			spq.setParameter("TG1NACIO", persona.getNacionalidad().getCodReg()); 
			spq.setParameter("TG1ESCIV", persona.getEstadoCivil().getCodReg()); 
			spq.setParameter("TG1OCUPA", persona.getOcupacion().getCodReg()); 
			spq.setParameter("TG1NIINS", persona.getNivelInstrucion().getCodReg()); 
			 
			spq.setParameter("CORREODE", persona.getCorreo()); 
			
			spq.setParameter("DIRECCIO", persona.getDireccion()); 
			spq.setParameter("CODRGUBI", persona.getUbigeoDireccion().getCodigoRegistro());  
			
			spq.setParameter("TELFNUMR", persona.getTelefonoNumero()); 
			spq.setParameter("FOTO", persona.getFoto()); 
			spq.setParameter("VARENIEC", persona.getSwReniec()? "1":"0");
			spq.setParameter("ORIGREGI", persona.getOrigenDeRegistro()); 
			
			spq.setParameter("AUCDUSCR", persona.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", persona.getIpCreacion());
			
			
			spq.execute();
			
			idPersona = spq.getOutputParameterValue(4);
			nroVersi = spq.getOutputParameterValue(5);
			codigoCorreo = spq.getOutputParameterValue(19);
			codigoDireccion = spq.getOutputParameterValue(21);
			codigoTelefono = spq.getOutputParameterValue(24);
			
			if (idPersona != null) { 
				persona.setCodigo(idPersona.toString());
				persona.setNumeroVersion(nroVersi.toString());
				persona.setCodigoCorreo(codigoCorreo.toString());
				persona.setCodigoDireccion(codigoDireccion.toString());
				persona.setCodigoTelefono(codigoTelefono.toString());
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
	public boolean actualizarPersonaBanco(PersonaBean persona) throws DAOException {
		Object idPersona= null; 
		//Object nroPeriodo= null; 
		Object nroVersi = null;
		
		Object codigoCorreo = null;
		Object codigoDireccion = null;
		Object codigoTelefono = null;
		
	
		
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("persona.actualizarPersonaBanco");
			spq.setParameter("CODORGAN", persona.getCodigoOrganizacion()); 
			spq.setParameter("CODINSTI", persona.getCodigoInstitucion()); 
			spq.setParameter("CODSEDEI", persona.getCodigoSede()); 
			spq.setParameter("CODPERSO", persona.getCodigo()); 
			
			spq.setParameter("LUGANACI", persona.getUbigeoNacimiento().getCodigoRegistro()); 
			spq.setParameter("TG1OCUPA", persona.getOcupacion().getCodReg()); 
			spq.setParameter("TG1NIINS", persona.getNivelInstrucion().getCodReg()); 
			 
			spq.setParameter("CODCORXP", persona.getCodigoCorreo()); 
			spq.setParameter("CORREODE", persona.getCorreo()); 
			
			spq.setParameter("CODDIXPE", persona.getCodigoDireccion());
			spq.setParameter("DIRECCIO", persona.getDireccion()); 
			spq.setParameter("CODRGUBI", persona.getUbigeoDireccion().getCodigoRegistro());  
			
			spq.setParameter("CODTEXPE", persona.getCodigoTelefono());
			spq.setParameter("TELFNUMR", persona.getTelefonoNumero()); 
			
			spq.setParameter("AUCDUSCR", persona.getCodigoUsuarioCreacion());
			spq.setParameter("AUPCIPCR", persona.getIpCreacion());
			
			
			spq.execute();
			
		//	idPersona = spq.getOutputParameterValue(4);
			nroVersi = spq.getOutputParameterValue(5);
			codigoCorreo = spq.getOutputParameterValue(9);
			codigoDireccion = spq.getOutputParameterValue(11);
			codigoTelefono = spq.getOutputParameterValue(14);
			
		/*	if (idPersona != null) { 
				persona.setCodigo(idPersona.toString());
				
			}*/
			
		//	persona.setNumeroVersion(nroVersi.toString());
			persona.setCodigoCorreo(codigoCorreo.toString());
			persona.setCodigoDireccion(codigoDireccion.toString());
			persona.setCodigoTelefono(codigoTelefono.toString());
			sw=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			sw=false; 
		}finally{
			em.close();
		}
		return sw;
	}


}
