package proyect.core.service.implementacion.movimiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.movimiento.MovimientoAlmacenBean;
import proyect.core.repository.interfaces.movimiento.MovimientoAlmacenDAO;
import proyect.core.service.interfaces.movimiento.MovimientoAlmacenService;

@Service("movimientoAlmacenService")
public class MovimientoAlmacenServiceImpl implements MovimientoAlmacenService {
	
	
	@Autowired
	private MovimientoAlmacenDAO movimientoAlmacenDAO; 

	public MovimientoAlmacenServiceImpl() {
	}

	@Override
	public boolean insertar(MovimientoAlmacenBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getMovimientoAlmacenDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(MovimientoAlmacenBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getMovimientoAlmacenDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(MovimientoAlmacenBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getMovimientoAlmacenDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public MovimientoAlmacenBean getBuscarPorObjecto(MovimientoAlmacenBean stockBean) throws ServiceException {
		MovimientoAlmacenBean oPedido=null;
		try {
			oPedido=this.getMovimientoAlmacenDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<MovimientoAlmacenBean> getBuscarPorFiltros(MovimientoAlmacenBean stockBean)
			throws ServiceException {
		List<MovimientoAlmacenBean> lstPedido=null;
		try {
			lstPedido=this.getMovimientoAlmacenDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 
	@Override
	public List<MovimientoAlmacenBean> listarReporteICI(MovimientoAlmacenBean stockBean)
			throws ServiceException {
		List<MovimientoAlmacenBean> lstPedido=null;
		try {
			lstPedido=this.getMovimientoAlmacenDAO().listarReporteICI(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}





	@Override
	public boolean existe(MovimientoAlmacenBean t) throws ServiceException { 
		return false;
	}

	public MovimientoAlmacenDAO getMovimientoAlmacenDAO() {
		return movimientoAlmacenDAO;
	}

	public void setMovimientoAlmacenDAO(MovimientoAlmacenDAO movimientoAlmacenDAO) {
		this.movimientoAlmacenDAO = movimientoAlmacenDAO;
	}

	@Override
	public List<MovimientoAlmacenBean> buscarxArticuloAlmacen(MovimientoAlmacenBean movimientoAlmacenBean)
			throws ServiceException {
		List<MovimientoAlmacenBean> lstPedido=null;
		try {
			lstPedido=this.getMovimientoAlmacenDAO().buscarxArticuloAlmacen(movimientoAlmacenBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
  

}

	
