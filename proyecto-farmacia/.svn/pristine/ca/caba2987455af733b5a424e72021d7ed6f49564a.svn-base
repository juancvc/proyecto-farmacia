package hnch.referencia.core.service.interfaces.seguridad;

import hnch.referencia.core.bean.seguridad.AuditoriaAccesoBean;
import hnch.referencia.core.bean.seguridad.AuditoriaBean;
import hnch.referencia.core.bean.seguridad.AuditoriaDetalleBean;
import hnch.referencia.core.bean.seguridad.AuditoriaTablaBean;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.BaseService;

import java.util.List;


public interface AuditoriaService extends BaseService<AuditoriaBean>{
	
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws ServiceException;
	
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean) throws ServiceException;
	
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws ServiceException;
	
}