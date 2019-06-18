package sigelab.core.repository.interfaces.seguridad;

import sigelab.core.bean.seguridad.AuditoriaAccesoBean;
import sigelab.core.bean.seguridad.AuditoriaBean;
import sigelab.core.bean.seguridad.AuditoriaDetalleBean;
import sigelab.core.bean.seguridad.AuditoriaTablaBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.BaseDAO;

import java.util.List;

/*
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaAccesoBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaDetalleBean;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.AuditoriaTablaBean;
import pe.gob.procalidad.natigu.core.repository.exception.DAOException;
import pe.gob.procalidad.natigu.core.repository.repository.interfaces.BaseDAO;
*/

public interface AuditoriaDAO extends BaseDAO<AuditoriaBean> {
	
	public List<AuditoriaTablaBean> listarTablas(AuditoriaTablaBean prmAuditoriaTablaBean) throws DAOException;
	
	public List<AuditoriaDetalleBean> listarAuditoriaDetalle(AuditoriaDetalleBean prmAuditoriaDetalleBean) throws DAOException;
	
	public boolean insertarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws DAOException;
	
	public List<AuditoriaAccesoBean> listarAuditoriaAcceso(AuditoriaAccesoBean prmAuditoriaAccesoBean) throws DAOException;

}