package sigelab.core.repository.interfaces.seguridad;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface UsuarioDAO extends BaseDAO<UsuarioBean> {

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws DAOException;
}
