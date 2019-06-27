package proyect.core.service.interfaces.catalogo;
  
import java.util.List;

import proyect.core.bean.general.CatalogoBean;
import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
 
public interface Catalogo2Service extends BaseService<CatalogoBean> {
	
	public List<CatalogoBean> listarPorCodigoTabla(String codTabla,int tipo) throws ServiceException;  
	
	public List<CatalogoBean> listarPorValor1(CatalogoBean catalogoBean)  throws ServiceException; 
	
}
 
