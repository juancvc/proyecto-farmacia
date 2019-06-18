package sigelab.core.repository.interfaces.seguridad;

import sigelab.core.bean.seguridad.UsuarioPerfilBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;




public interface UsuarioPerfilDAO extends BaseDAO<UsuarioPerfilBean> {
	public UsuarioPerfilBean buscarXcodigoUsu(UsuarioPerfilBean usuarioPerfilBean) throws DAOException;
}
