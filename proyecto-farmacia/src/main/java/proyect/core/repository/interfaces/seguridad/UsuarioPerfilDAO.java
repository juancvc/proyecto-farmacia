package proyect.core.repository.interfaces.seguridad;

import proyect.core.bean.seguridad.UsuarioPerfilBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;




public interface UsuarioPerfilDAO extends BaseDAO<UsuarioPerfilBean> {
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws DAOException;
}
