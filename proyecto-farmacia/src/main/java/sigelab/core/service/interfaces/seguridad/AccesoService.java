
package sigelab.core.service.interfaces.seguridad;

import sigelab.core.bean.seguridad.AccesoBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;


public interface AccesoService extends BaseService<AccesoBean>{

	public boolean asignar(AccesoBean bean) throws ServiceException;
	
}
