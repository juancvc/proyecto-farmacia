package sigelab.core.repository.interfaces.general;

import sigelab.core.bean.general.PacienteBean;
import sigelab.core.bean.general.PersonaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;





public interface PacienteDAO  extends BaseDAO<PacienteBean>  {
	
	public PacienteBean buscarxTipoDocumentoNumeroDocumento(PacienteBean pacienteBean)throws DAOException;
	
	public PacienteBean buscarxPersona(PersonaBean personaBean)throws DAOException;
	 
	public boolean actualizardatosuser(PacienteBean personaBean)throws DAOException;
	
	public boolean actualizardatosfotouser(PacienteBean personaBean)throws DAOException;
}
