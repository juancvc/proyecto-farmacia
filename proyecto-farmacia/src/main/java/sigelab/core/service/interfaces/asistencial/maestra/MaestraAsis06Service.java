package sigelab.core.service.interfaces.asistencial.maestra;
  
import java.util.List;

import sigelab.core.bean.general.TablaBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;
 

public interface MaestraAsis06Service extends BaseService<TablaBean> {
	 
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<TablaBean> buscar(TablaBean tabla) throws ServiceException; 
}
 
