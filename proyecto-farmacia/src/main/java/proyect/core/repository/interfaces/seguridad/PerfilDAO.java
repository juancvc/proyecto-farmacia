package proyect.core.repository.interfaces.seguridad;

import java.util.List;

import proyect.core.bean.seguridad.PerfilBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;



public interface PerfilDAO extends BaseDAO<PerfilBean> {

	List<PerfilBean> listado () throws DAOException; 
}
