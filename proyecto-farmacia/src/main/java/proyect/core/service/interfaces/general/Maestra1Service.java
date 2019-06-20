
package proyect.core.service.interfaces.general;
  
import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;
  

public interface Maestra1Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<TablaBean> listarComboGeneral(String codTabla) throws ServiceException;

	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws ServiceException; 
}
 
