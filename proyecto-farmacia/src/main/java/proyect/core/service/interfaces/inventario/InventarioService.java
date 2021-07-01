package proyect.core.service.interfaces.inventario;

  
import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.inventario.InventarioBean;
 
 
public interface InventarioService extends BaseService<InventarioBean> { 
	
	public boolean procesar(InventarioBean inventarioBean) throws ServiceException; 
	
}
