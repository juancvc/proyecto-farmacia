package proyect.core.service.implementacion.inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.inventario.InventarioDetalleBean;
import proyect.core.repository.interfaces.inventario.InventarioDetalleDAO;
import proyect.core.service.interfaces.inventario.InventarioDetalleService;

@Service("InventarioDetalleBeanService")
@Transactional(readOnly = true)
public class InventarioDetalleServiceImpl implements InventarioDetalleService {
	
	
	@Autowired
	private InventarioDetalleDAO inventarioDetalleDAO; 

	public InventarioDetalleServiceImpl() {
	}

	@Override
	public boolean insertar(InventarioDetalleBean InventarioDetalleBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDetalleDAO.insertar(InventarioDetalleBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InventarioDetalleBean InventarioDetalleBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDetalleDAO.actualizar(InventarioDetalleBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InventarioDetalleBean InventarioDetalleBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDetalleDAO.eliminar(InventarioDetalleBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InventarioDetalleBean getBuscarPorObjecto(InventarioDetalleBean InventarioDetalleBean) throws ServiceException {
		InventarioDetalleBean oInventarioDetalleBean=null;
		try {
			oInventarioDetalleBean=inventarioDetalleDAO.getBuscarPorObjecto(InventarioDetalleBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInventarioDetalleBean;
	}
 
	@Override
	public List<InventarioDetalleBean> getBuscarPorFiltros(InventarioDetalleBean InventarioDetalleBean) throws ServiceException {
		List<InventarioDetalleBean> lstInventarioDetalleBean=null;
		try {
			lstInventarioDetalleBean=inventarioDetalleDAO.getBuscarPorFiltros(InventarioDetalleBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstInventarioDetalleBean;
	}
 
	@Override
	public boolean existe(InventarioDetalleBean t) throws ServiceException {
		return false;
	}
 
 

}
