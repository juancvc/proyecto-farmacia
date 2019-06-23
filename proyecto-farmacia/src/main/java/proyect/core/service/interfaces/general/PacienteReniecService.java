package proyect.core.service.interfaces.general;

import java.util.List;

import proyect.base.service.interfaces.GenericService;
import proyect.core.entity.general.PacienteReniec;
import proyect.base.service.ServiceException;

public interface PacienteReniecService extends GenericService<PacienteReniec> {
	

	

	public List<PacienteReniec>  pacienteReniecVerificacion(PacienteReniec acienteReniec) throws ServiceException;
	
}
