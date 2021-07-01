package proyect.core.service.implementacion.movimiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.movimiento.TipoMovimientoBean;
import proyect.core.repository.interfaces.movimiento.TipoMovimientoDAO;
import proyect.core.service.interfaces.movimiento.TipoMovimientoService;

@Service("tipoMovimientoService")
public class TipoMovimientoServiceImpl implements TipoMovimientoService {
	
	
	@Autowired
	private TipoMovimientoDAO movimientoAlmacenDAO; 

	public TipoMovimientoServiceImpl() {
	}

	@Override
	public boolean insertar(TipoMovimientoBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTipoMovimientoDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(TipoMovimientoBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTipoMovimientoDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(TipoMovimientoBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getTipoMovimientoDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public TipoMovimientoBean getBuscarPorObjecto(TipoMovimientoBean stockBean) throws ServiceException {
		TipoMovimientoBean oPedido=null;
		try {
			oPedido=this.getTipoMovimientoDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<TipoMovimientoBean> getBuscarPorFiltros(TipoMovimientoBean stockBean)
			throws ServiceException {
		List<TipoMovimientoBean> lstPedido=null;
		try {
			lstPedido=this.getTipoMovimientoDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 


	@Override
	public boolean existe(TipoMovimientoBean t) throws ServiceException { 
		return false;
	}

	public TipoMovimientoDAO getTipoMovimientoDAO() {
		return movimientoAlmacenDAO;
	}

	public void setTipoMovimientoDAO(TipoMovimientoDAO movimientoAlmacenDAO) {
		this.movimientoAlmacenDAO = movimientoAlmacenDAO;
	}

 
  

}

	
