
package proyect.core.service.interfaces.catalogo;
  
import java.util.List;

import proyect.base.service.ServiceException;
import proyect.core.bean.general.CatalogoBean;
import proyect.core.service.interfaces.BaseService;
  

public interface Catalogo1Service extends BaseService<CatalogoBean> {
	
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<CatalogoBean> listarComboGeneral(String codTabla) throws ServiceException;

	public CatalogoBean getBuscarPorTablaYRegistro(CatalogoBean TablaBean) throws ServiceException; 
}
 
