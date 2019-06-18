package sigelab.core.repository.interfaces.seguridad;

import sigelab.core.bean.seguridad.AccesoBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

public interface AccesoDAO extends BaseDAO<AccesoBean> {

	public boolean asignar(AccesoBean bean) throws DAOException;
	
}
