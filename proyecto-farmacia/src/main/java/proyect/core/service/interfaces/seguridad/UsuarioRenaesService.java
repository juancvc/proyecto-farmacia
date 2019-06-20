package proyect.core.service.interfaces.seguridad;

import java.util.List;

import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioRenaesBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;


public interface UsuarioRenaesService extends BaseService<UsuarioRenaesBean>{
 
	
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException;
	 
}
