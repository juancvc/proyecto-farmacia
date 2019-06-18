package sigelab.core.repository.interfaces.asistencial.maestra; 
import java.util.List;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

 
public interface MaestraAsis03DAO  extends BaseDAO<TablaBean>  {
	  
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
}
