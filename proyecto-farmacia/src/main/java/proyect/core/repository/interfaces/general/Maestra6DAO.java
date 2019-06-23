package proyect.core.repository.interfaces.general;

import java.util.List;

import proyect.core.bean.general.CatalogoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO; 




public interface Maestra6DAO  extends BaseDAO<CatalogoBean>  {
	 
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,long tipo) throws DAOException;
	
	public List<CatalogoBean> listarPorValor1(CatalogoBean TablaBean) throws DAOException;
	public List<CatalogoBean> listarPorValor3yNombre(CatalogoBean TablaBean) throws DAOException;
}
