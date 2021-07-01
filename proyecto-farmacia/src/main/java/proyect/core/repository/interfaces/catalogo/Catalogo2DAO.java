package proyect.core.repository.interfaces.catalogo;

import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.general.CatalogoBean; 




public interface Catalogo2DAO  extends BaseDAO<CatalogoBean>  {
	 
    public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo) throws DAOException;
	
	public List<CatalogoBean> listarCatalogoRegistros(CatalogoBean catalogoBean) throws DAOException;

	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean TablaBean) throws DAOException;
	
	public List<CatalogoBean> listarTodascatalogos() throws DAOException;
	
}
