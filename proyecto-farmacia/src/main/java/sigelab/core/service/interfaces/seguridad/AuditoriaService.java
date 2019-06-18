package sigelab.core.service.interfaces.seguridad;

import sigelab.core.bean.seguridad.AuditoriaAccesoBean;
import sigelab.core.bean.seguridad.AuditoriaBean;
import sigelab.core.bean.seguridad.AuditoriaDetalleBean;
import sigelab.core.bean.seguridad.AuditoriaTablaBean;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.BaseService;

import java.util.List;


public interface AuditoriaService extends BaseService<AuditoriaBean>{
	
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws ServiceException;
	
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean) throws ServiceException;
	
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
}