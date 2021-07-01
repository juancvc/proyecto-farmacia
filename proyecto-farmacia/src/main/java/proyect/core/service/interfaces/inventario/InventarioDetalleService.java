package proyect.core.service.interfaces.inventario;

  
import java.util.List;

import proyect.base.service.ServiceException;
import proyect.base.service.interfaces.BaseService;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.bean.inventario.InventarioDetalleBean;
 
 
public interface InventarioDetalleService extends BaseService<InventarioDetalleBean> { 
	
	public List<InventarioDetalleBean> listarReporteProceso(InventarioBean inventarioBean) throws ServiceException;
	
}
