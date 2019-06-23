package proyect.core.service.interfaces.general;
  
import java.util.List;

import proyect.core.bean.general.CatalogoBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;
 
public interface Maestra6Service extends BaseService<CatalogoBean> {
	
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<CatalogoBean> listarPorValor1(CatalogoBean TablaBean)  throws ServiceException; 
	public List<CatalogoBean> listarPorValor3yNombre(CatalogoBean TablaBean) throws ServiceException;
	
}
 
