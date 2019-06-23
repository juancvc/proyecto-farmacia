//package pe.gob.procalidad.natigu.core.service.service.factory.implementacion;
package proyect.core.service.factory.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.core.service.factory.interfaces.FactoryService;
import proyect.core.service.interfaces.catalogo.Catalogo1Service;
import proyect.core.service.interfaces.catalogo.Catalogo2Service;
import proyect.core.service.interfaces.general.PersonaService;
import proyect.core.service.interfaces.general.PersonalService;
import proyect.core.service.interfaces.general.UbigeoService;
import proyect.core.service.interfaces.seguridad.AccesoService;
import proyect.core.service.interfaces.seguridad.AuditoriaService;
import proyect.core.service.interfaces.seguridad.PerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioPerfilService;
import proyect.core.service.interfaces.seguridad.UsuarioService;
 
 

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService {
	/** ADMINISTRATICO **/
	/** ASISTENCIAL **/
	
	/** ACADEMICO **/
	 
	
	/** GENERAL **/
	
	 
	@Autowired
	private Catalogo1Service maestra1Service;
	@Autowired
	private Catalogo2Service maestra2Service;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private PersonaService personaService;
	@Autowired 
	private UbigeoService ubigeoService;
	 

	/** SEGURIDAD **/
	
	@Autowired
	private AccesoService accesoService;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuditoriaService auditoriaService;
	
	 
	 
	@Override
	public Catalogo1Service getMaestra1Service() {
		return maestra1Service;
	}
	@Override
	public Catalogo2Service getMaestra2Service() {
		return maestra2Service;
	} 
	@Override
	public PersonalService getPersonalService() {
		return personalService;
	}
	 
	@Override
	public PersonaService getPersonaService() {
		return personaService;
	} 
	@Override
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	} 
	
	
	
	@Override
	public AccesoService getAccesoService() {
		return accesoService;
	}
	@Override
	public PerfilService getPerfilService() {
		return perfilService;
	}
	@Override
	public UsuarioPerfilService getUsuarioPerfilService() {
		return usuarioPerfilService;
	}
	@Override
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	/*
	@Override
	public AuditoriaService getAuditoriaService() {
		// TODO Auto-generated method stub
		return auditoriaService;
	}*/
	
	 
	@Override
	public AuditoriaService getAuditoriaService() {
		return auditoriaService;
	}
	 

}