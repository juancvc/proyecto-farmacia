package proyect.core.service.interfaces.seguridad;

import java.util.List;

import proyect.core.bean.seguridad.AuditoriaAccesoBean;
import proyect.core.bean.seguridad.AuditoriaBean;
import proyect.core.bean.seguridad.AuditoriaDetalleBean;
import proyect.core.bean.seguridad.AuditoriaTablaBean;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.BaseService;


public interface AuditoriaService extends BaseService<AuditoriaBean>{
	
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws ServiceException;
	
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean) throws ServiceException;
	
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
}