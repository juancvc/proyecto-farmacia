package proyect.core.service.interfaces.catalogo;
  
import java.util.List;

import proyect.core.bean.general.CatalogoBean;
import proyect.base.service.ServiceException;
import proyect.core.service.interfaces.BaseService;
 
public interface Catalogo2Service extends BaseService<CatalogoBean> {
	
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,long tipo) throws ServiceException;  
	
	public List<CatalogoBean> listarPorValor1(CatalogoBean TablaBean)  throws ServiceException; 
	
}
 
