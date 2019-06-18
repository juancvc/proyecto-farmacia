package sigelab.core.repository.interfaces.general;

import sigelab.core.bean.general.PersonaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;





public interface PersonaDAO  extends BaseDAO<PersonaBean>  {
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumento(PersonaBean personaBean)throws DAOException;
	
	public PersonaBean buscarxTipoDocumentoNumeroDocumentoSigeho(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PersonaBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PersonaBean personaBean)throws DAOException;
	
	public boolean insertarPersonaLaboratorio(PersonaBean persona) throws DAOException ;
	
	public boolean actualizarPersonaLaboratorio(PersonaBean persona) throws DAOException ;
	
}
