package sigelab.core.service.interfaces.general;
  
import sigelab.core.bean.general.TablaBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

import java.util.List;
 
public interface Maestra2Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<TablaBean> listarPorValor1(TablaBean TablaBean)  throws ServiceException; 
	
}
 
