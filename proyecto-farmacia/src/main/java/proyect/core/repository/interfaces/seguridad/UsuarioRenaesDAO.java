package proyect.core.repository.interfaces.seguridad;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.seguridad.UsuarioBean;
import proyect.core.bean.seguridad.UsuarioRenaesBean;

public interface UsuarioRenaesDAO extends BaseDAO<UsuarioRenaesBean> {
 
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	 
}
