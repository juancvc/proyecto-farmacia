package sigelab.core.service.interfaces.general;

import java.util.List;

import sigelab.base.service.interfaces.GenericService;
import sigelab.core.entity.general.PacienteReniec;
import sigelab.core.service.exception.ServiceException;

public interface PacienteReniecService extends GenericService<PacienteReniec> {
	

	

	public List<PacienteReniec>  pacienteReniecVerificacion(PacienteReniec acienteReniec) throws ServiceException;
	
}
