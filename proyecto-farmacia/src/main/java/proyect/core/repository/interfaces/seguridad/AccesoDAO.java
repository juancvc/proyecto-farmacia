package proyect.core.repository.interfaces.seguridad;

import proyect.core.bean.seguridad.AccesoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

public interface AccesoDAO extends BaseDAO<AccesoBean> {

	public boolean asignar(AccesoBean bean) throws DAOException;
	
}
