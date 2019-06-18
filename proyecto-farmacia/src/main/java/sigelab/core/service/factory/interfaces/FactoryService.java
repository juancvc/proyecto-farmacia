//package pe.gob.procalidad.natigu.core.service.service.factory.interfaces;
package sigelab.core.service.factory.interfaces;
 
import sigelab.core.service.interfaces.general.Maestra1Service;
import sigelab.core.service.interfaces.general.Maestra2Service; 
import sigelab.core.service.interfaces.general.PersonaService;
import sigelab.core.service.interfaces.general.PersonalService;
import sigelab.core.service.interfaces.general.UbigeoService;
import sigelab.core.service.interfaces.seguridad.AccesoService;
import sigelab.core.service.interfaces.seguridad.AuditoriaService;
import sigelab.core.service.interfaces.seguridad.PerfilService;
import sigelab.core.service.interfaces.seguridad.UsuarioPerfilService;
import sigelab.core.service.interfaces.seguridad.UsuarioService;




public interface FactoryService {
	/** ADMINISTRATIVO **/
	/** ASISTENCIAL **/ 

 

	/** GENERAL **/
	
 	public Maestra1Service getMaestra1Service();
	public Maestra2Service getMaestra2Service();
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