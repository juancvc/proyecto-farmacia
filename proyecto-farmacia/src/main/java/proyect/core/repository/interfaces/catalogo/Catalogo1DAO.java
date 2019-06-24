
 package proyect.core.repository.interfaces.catalogo;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.CatalogoBean;
 

public interface Catalogo1DAO  extends BaseDAO<CatalogoBean>  {
	
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
	
	public List<CatalogoBean> listarComboGeneral(String codTabla) throws DAOException;

	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean TablaBean) throws DAOException;
	
 
	
}
