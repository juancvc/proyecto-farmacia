package proyect.core.repository.interfaces.seguridad;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.seguridad.PerfilBean;



public interface PerfilDAO extends BaseDAO<PerfilBean> {

	List<PerfilBean> listado () throws DAOException; 
}
