
package sigelab.core.service.interfaces.asistencial.maestra;
  
import sigelab.core.bean.general.TablaBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

import java.util.List;
  

public interface MaestraPreguntaBanc02Service extends BaseService<TablaBean> {
	
	public List<TablaBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<TablaBean> listarPreguntasPorSexo(String valgen01) throws ServiceException; 
}
 
