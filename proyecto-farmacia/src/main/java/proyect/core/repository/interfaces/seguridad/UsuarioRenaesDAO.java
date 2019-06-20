package proyect.core.repository.interfaces.seguridad;

import java.util.List;

import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioRenaesBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface UsuarioRenaesDAO extends BaseDAO<UsuarioRenaesBean> {
 
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	 
}
