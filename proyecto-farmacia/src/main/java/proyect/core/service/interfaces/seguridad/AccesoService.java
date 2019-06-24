
package proyect.core.service.interfaces.seguridad;

import proyect.core.bean.seguridad.AccesoBean;
import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;


public interface AccesoService extends BaseService<AccesoBean>{

	public boolean asignar(AccesoBean bean) throws ServiceException;
	
}
