//package pe.gob.procalidad.natigu.core.service.service.factory.interfaces;
package proyect.core.service.factory.interfaces;
 
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




public interface FactoryService {
	/** ADMINISTRATIVO **/
	/** ASISTENCIAL **/ 

 

	/** GENERAL **/
	
 	public Catalogo1Service getMaestra1Service();
	public Catalogo2Service getMaestra2Service();
 	public PersonalService getPersonalService();
 	public PersonaService getPersonaService();
 	public UbigeoService getUbigeoService(); 
	

	/** SEGURIDAD **/
	public AccesoService getAccesoService();
	public PerfilService getPerfilService();
	public UsuarioPerfilService getUsuarioPerfilService();
	public UsuarioService getUsuarioService();
	public AuditoriaService getAuditoriaService(); 

}