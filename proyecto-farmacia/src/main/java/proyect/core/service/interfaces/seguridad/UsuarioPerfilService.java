package proyect.core.service.interfaces.seguridad;

import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;




public interface UsuarioPerfilService extends BaseService<UsuarioPerfilBean>{
	
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException;
}
