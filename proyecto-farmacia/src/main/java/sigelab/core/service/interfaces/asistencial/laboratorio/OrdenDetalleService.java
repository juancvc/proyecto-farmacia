package sigelab.core.service.interfaces.asistencial.laboratorio;
 
 
import java.util.List;

import sigelab.core.bean.asistencial.laboratorio.OrdenDetalleBean;
import sigelab.core.service.interfaces.BaseService;
import sigelab.core.service.exception.ServiceException;
public interface OrdenDetalleService extends BaseService<OrdenDetalleBean>{
 
	public boolean resultadoModificar(OrdenDetalleBean ordenDetalleBean)throws ServiceException;
	public List<OrdenDetalleBean > getBuscarPorFiltrosReporte(OrdenDetalleBean ordenDetalleBean)throws ServiceException;
}
