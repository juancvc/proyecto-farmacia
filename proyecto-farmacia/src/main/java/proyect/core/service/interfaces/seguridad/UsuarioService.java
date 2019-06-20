package proyect.core.service.interfaces.seguridad;

import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;


public interface UsuarioService extends BaseService<UsuarioBean>{

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws ServiceException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws ServiceException;
}
