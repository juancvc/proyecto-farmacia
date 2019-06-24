package proyect.core.service.implementacion.venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.venta.DevolucionBean;
import proyect.core.repository.interfaces.venta.DevolucionDAO;
import proyect.core.service.interfaces.venta.DevolucionService; 

@Service("devolucionService")
public class DevolucionServiceImpl implements DevolucionService {
	
	
	@Autowired
	private DevolucionDAO devolucionDAO; 

	public DevolucionServiceImpl() {
	}

	@Override
	public boolean insertar(DevolucionBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getDevolucionDAO().insertar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(DevolucionBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getDevolucionDAO().actualizar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(DevolucionBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getDevolucionDAO().eliminar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public DevolucionBean getBuscarPorObjecto(DevolucionBean devolucion) throws ServiceException {
		DevolucionBean oDevolucion=null;
		try {
			oDevolucion=this.getDevolucionDAO().getBuscarPorObjecto(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDevolucion;
	}

	@Override
	public List<DevolucionBean> getBuscarPorFiltros(DevolucionBean devolucion)throws ServiceException {
		List<DevolucionBean> lstDevolucion=null;
		try {
			lstDevolucion=this.getDevolucionDAO().getBuscarPorFiltros(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstDevolucion;
	}
	
	public DevolucionDAO getDevolucionDAO() {
		return devolucionDAO;
	}

	public void setDevolucionDAO(DevolucionDAO devolucionDAO) {
		this.devolucionDAO = devolucionDAO;
	}

	@Override
	public boolean existe(DevolucionBean t) throws ServiceException { 
		return false;
	}
 
}
