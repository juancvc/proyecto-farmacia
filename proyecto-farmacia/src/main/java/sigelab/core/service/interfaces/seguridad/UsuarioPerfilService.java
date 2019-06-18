package sigelab.core.service.interfaces.seguridad;

import sigelab.core.bean.seguridad.UsuarioPerfilBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;




public interface UsuarioPerfilService extends BaseService<UsuarioPerfilBean>{
	
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws ServiceException;
}
