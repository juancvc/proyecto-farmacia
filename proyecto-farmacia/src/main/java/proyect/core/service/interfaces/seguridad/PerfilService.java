package proyect.core.service.interfaces.seguridad;

import java.util.List;

import proyect.core.bean.seguridad.PerfilBean;
import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;

public interface PerfilService extends BaseService<PerfilBean>{
	
	List<PerfilBean> listado () throws ServiceException;

}
