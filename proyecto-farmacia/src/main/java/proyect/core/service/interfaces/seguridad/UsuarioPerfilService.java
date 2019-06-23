package proyect.core.service.interfaces.seguridad;

import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.BaseService;




public interface UsuarioPerfilService extends BaseService<UsuarioPerfilBean>{
	
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException;
}
