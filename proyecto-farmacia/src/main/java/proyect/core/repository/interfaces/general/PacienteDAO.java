package proyect.core.repository.interfaces.general;

import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.PersonaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;





public interface PacienteDAO  extends BaseDAO<PacienteBean>  {
	
	public PacienteBean buscarxTipoDocumentoNumeroDocumento(PacienteBean pacienteBean)throws DAOException;
	
	public PacienteBean buscarxPersona(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PacienteBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PacienteBean personaBean)throws DAOException;
}
