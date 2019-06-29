package proyect.core.service.implementacion.stock;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.stock.ProveedorBean;
import proyect.core.repository.interfaces.stock.ProveedorDAO;
import proyect.core.service.interfaces.stock.ProveedorService;

@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService {
	
	
	@Autowired
	private ProveedorDAO proveedorDAO; 

	public ProveedorServiceImpl() {
	}

	@Override
	public boolean insertar(ProveedorBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getProveedorDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(ProveedorBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getProveedorDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(ProveedorBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getProveedorDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public ProveedorBean getBuscarPorObjecto(ProveedorBean stockBean) throws ServiceException {
		ProveedorBean oPedido=null;
		try {
			oPedido=this.getProveedorDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<ProveedorBean> getBuscarPorFiltros(ProveedorBean stockBean)
			throws ServiceException {
		List<ProveedorBean> lstPedido=null;
		try {
			lstPedido=this.getProveedorDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
	public ProveedorDAO getProveedorDAO() {
		return proveedorDAO;
	}

	public void setProveedorDAO(ProveedorDAO proveedorDAO) {
		this.proveedorDAO = proveedorDAO;
	}

	@Override
	public boolean existe(ProveedorBean t) throws ServiceException { 
		return false;
	}
  

}

	
