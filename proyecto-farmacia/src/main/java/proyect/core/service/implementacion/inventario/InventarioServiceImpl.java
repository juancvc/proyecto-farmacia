package proyect.core.service.implementacion.inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.inventario.InventarioBean;
import proyect.core.repository.interfaces.inventario.InventarioDAO;
import proyect.core.service.interfaces.inventario.InventarioService;
 

@Service("InventarioBeanService")
@Transactional(readOnly = true)
public class InventarioServiceImpl implements InventarioService {
	
	
	@Autowired
	private InventarioDAO inventarioDAO; 

	public InventarioServiceImpl() {
	}

	@Override
	public boolean insertar(InventarioBean InventarioBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDAO.insertar(InventarioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InventarioBean InventarioBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDAO.actualizar(InventarioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InventarioBean InventarioBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=inventarioDAO.eliminar(InventarioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InventarioBean getBuscarPorObjecto(InventarioBean InventarioBean) throws ServiceException {
		InventarioBean oInventarioBean=null;
		try {
			oInventarioBean=inventarioDAO.getBuscarPorObjecto(InventarioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInventarioBean;
	}
 
	@Override
	public List<InventarioBean> getBuscarPorFiltros(InventarioBean InventarioBean) throws ServiceException {
		List<InventarioBean> lstInventarioBean=null;
		try {
			lstInventarioBean=inventarioDAO.getBuscarPorFiltros(InventarioBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstInventarioBean;
	}
 
	@Override
	public boolean existe(InventarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
 
 

}
