package proyect.core.service.interfaces.general;
  
import java.util.List;

import proyect.core.bean.general.TablaBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;
 
public interface Maestra2Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<TablaBean> listarPorValor1(TablaBean TablaBean)  throws ServiceException; 
	
}
 
