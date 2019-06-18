
package sigelab.core.service.interfaces.general;
  
import sigelab.core.bean.general.TablaBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

import java.util.List;
  

public interface Maestra1Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<TablaBean> listarComboGeneral(String codTabla) throws ServiceException;

	public TablaBean getBuscarPorTablaYRegistro(TablaBean TablaBean) throws ServiceException; 
}
 
