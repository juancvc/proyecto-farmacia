package sigelab.core.repository.interfaces.general;

import java.util.List;

import sigelab.base.repository.interfaces.GenericDAO;
import sigelab.core.entity.general.PacienteReniec;
import sigelab.core.repository.DAOException;

 
public interface PacienteReniecDAO extends GenericDAO<PacienteReniec> {
	
	

	public List<PacienteReniec>  pacienteReniecVerificacion(PacienteReniec pacienteReniec) throws DAOException;
}
	

	

