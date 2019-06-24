package proyect.core.repository.interfaces.seguridad;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.seguridad.UsuarioPerfilBean;




public interface UsuarioPerfilDAO extends BaseDAO<UsuarioPerfilBean> {
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws DAOException;
}
