package proyect.core.repository.interfaces.general;
  
import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.RenaesBean;


public interface RenaesDAO  extends BaseDAO<RenaesBean>  {
	
	public boolean insertarDestinoRenaes(RenaesBean personaBean)throws DAOException;
}
