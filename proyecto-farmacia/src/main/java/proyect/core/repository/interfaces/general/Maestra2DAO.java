package proyect.core.repository.interfaces.general;

import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO; 




public interface Maestra2DAO  extends BaseDAO<TablaBean>  {
	 
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException;
	
	public List<TablaBean> listarPorValor1(TablaBean TablaBean) throws DAOException;
	
}
