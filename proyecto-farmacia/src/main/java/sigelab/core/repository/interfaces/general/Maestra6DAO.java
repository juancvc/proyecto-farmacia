package sigelab.core.repository.interfaces.general;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

import java.util.List; 




public interface Maestra6DAO  extends BaseDAO<TablaBean>  {
	 
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException;
	
	public List<TablaBean> listarPorValor1(TablaBean TablaBean) throws DAOException;
	public List<TablaBean> listarPorValor3yNombre(TablaBean TablaBean) throws DAOException;
}
