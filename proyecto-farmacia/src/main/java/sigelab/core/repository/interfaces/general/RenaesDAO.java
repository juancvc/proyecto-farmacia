package sigelab.core.repository.interfaces.general;
  
import sigelab.core.bean.general.RenaesBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;


public interface RenaesDAO  extends BaseDAO<RenaesBean>  {
	
	public boolean insertarDestinoRenaes(RenaesBean personaBean)throws DAOException;
}
