package sigelab.core.repository.interfaces.seguridad;

import java.util.List;
 
import sigelab.core.bean.seguridad.PerfilBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;



public interface PerfilDAO extends BaseDAO<PerfilBean> {

	List<PerfilBean> listado () throws DAOException; 
}
