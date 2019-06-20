
package proyect.core.service.interfaces.asistencial.maestra;
  
import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;
  

public interface MaestraBanc01Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
}
 
