package proyect.core.repository.interfaces.asistencial.maestra; 
import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO;

 
public interface MaestraAsis01DAO  extends BaseDAO<TablaBean>  {
	  
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
}
