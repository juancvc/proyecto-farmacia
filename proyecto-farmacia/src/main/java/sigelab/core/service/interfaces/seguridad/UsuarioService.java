package sigelab.core.service.interfaces.seguridad;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;


public interface UsuarioService extends BaseService<UsuarioBean>{

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws ServiceException;
}
