package proyect.core.repository.interfaces.seguridad;

import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface UsuarioDAO extends BaseDAO<UsuarioBean> {

	public UsuarioBean autenticar(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public Integer cambiarPassword(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	
	public UsuarioBean buscarxcodperso(UsuarioBean prmUsuarioBean) throws DAOException;
}
