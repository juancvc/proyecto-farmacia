package sigelab.core.repository.interfaces.seguridad;

import java.util.List;

import sigelab.core.bean.seguridad.UsuarioBean;
import sigelab.core.bean.seguridad.UsuarioRenaesBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface UsuarioRenaesDAO extends BaseDAO<UsuarioRenaesBean> {
 
	public List<UsuarioRenaesBean> buscarxcodigousua(UsuarioBean prmUsuarioBean) throws DAOException;
	 
}
