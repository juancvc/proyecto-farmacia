package proyect.core.repository.interfaces.seguridad;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.seguridad.UsuarioBean;

public interface UsuarioDAO extends BaseDAO<UsuarioBean> {

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws DAOException;
}
