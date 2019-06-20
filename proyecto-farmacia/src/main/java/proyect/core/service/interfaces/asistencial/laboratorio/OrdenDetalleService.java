package proyect.core.service.interfaces.asistencial.laboratorio;
 
 
import java.util.List;

import proyect.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;
public interface OrdenDetalleService extends BaseService<OrdenDetalleBean>{
 
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean)throws ServiceException;
	public List<OrdenDetalleBean > getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean)throws ServiceException;
}
