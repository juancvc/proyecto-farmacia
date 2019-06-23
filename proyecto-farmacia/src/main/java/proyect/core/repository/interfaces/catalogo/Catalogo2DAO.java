package proyect.core.repository.interfaces.catalogo;

import java.util.List;

import proyect.core.bean.general.CatalogoBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.BaseDAO; 




public interface Catalogo2DAO  extends BaseDAO<CatalogoBean>  {
	 
   public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
	
	public List<CatalogoBean> listarComboGeneral(String codTabla) throws DAOException;

	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean TablaBean) throws DAOException;
	
}
