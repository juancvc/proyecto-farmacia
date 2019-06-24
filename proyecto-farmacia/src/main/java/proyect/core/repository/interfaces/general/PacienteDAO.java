package proyect.core.repository.interfaces.general;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.PacienteBean;
import proyect.core.bean.general.PersonaBean;





public interface PacienteDAO  extends BaseDAO<PacienteBean>  {
	
	public PacienteBean buscarxTipoDocumentoNumeroDocumento(PacienteBean pacienteBean)throws DAOException;
	
	public PacienteBean buscarxPersona(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PacienteBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PacienteBean personaBean)throws DAOException;
}
