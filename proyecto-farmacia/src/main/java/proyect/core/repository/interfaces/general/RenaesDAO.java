package proyect.core.repository.interfaces.general;
  
import proyect.core.bean.general.RenaesBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;


public interface RenaesDAO  extends BaseDAO<RenaesBean>  {
	
	public boolean insertarDestinoRenaes(RenaesBean personaBean)throws DAOException;
}
