package sigelab.core.service.interfaces.seguridad;

import java.util.List;

import sigelab.core.bean.seguridad.PerfilBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

public interface PerfilService extends BaseService<PerfilBean>{
	
	List<PerfilBean> listado () throws ServiceException;

}
