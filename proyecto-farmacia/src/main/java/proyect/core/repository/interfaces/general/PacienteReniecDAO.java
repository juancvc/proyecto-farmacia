package proyect.core.repository.interfaces.general;

import java.util.List;

import proyect.base.repository.interfaces.GenericDAO;
import proyect.core.entity.general.PacienteReniec;
import proyect.core.repository.DAOException;

 
public interface PacienteReniecDAO extends GenericDAO<PacienteReniec> {
	
	

	public List<PacienteReniec>  pacienteReniecVerificacion(PacienteReniec pacienteReniec) throws DAOException;
}
	

	

