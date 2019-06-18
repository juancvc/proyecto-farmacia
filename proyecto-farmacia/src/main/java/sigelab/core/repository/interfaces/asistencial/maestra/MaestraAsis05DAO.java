package sigelab.core.repository.interfaces.asistencial.maestra; 
import java.util.List;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

 
public interface MaestraAsis05DAO  extends BaseDAO<TablaBean>  {
	  
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException; 
	
	public List<TablaBean> listarPorFiltros(TablaBean tabla,int tipo) throws DAOException; 
}
