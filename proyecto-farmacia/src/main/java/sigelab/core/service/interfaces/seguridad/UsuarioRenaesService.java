package sigelab.core.service.interfaces.seguridad;

import java.util.List;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.bean.seguridad.UsuarioRenaesBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;


public interface UsuarioRenaesService extends BaseService<UsuarioRenaesBean>{
 
	
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException;
	 
}
