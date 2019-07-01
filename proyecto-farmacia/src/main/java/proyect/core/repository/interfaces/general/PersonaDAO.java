package proyect.core.repository.interfaces.general;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.PersonaBean;





public interface PersonaDAO  extends BaseDAO<PersonaBean>  {
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws DAOException;
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumentoSigeho(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PersonaBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PersonaBean personaBean)throws DAOException;
	
}
