package proyect.core.service.implementacion.inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.inventario.PreciosVentaArticuloBean;
import proyect.core.repository.interfaces.inventario.PreciosVentaArticuloDAO;
import proyect.core.service.interfaces.inventario.PreciosVentaArticuloService;

@Service("PreciosVentaArticuloService")
public class PreciosVentaArticuloServiceImpl implements PreciosVentaArticuloService {
	
	
	@Autowired
	private PreciosVentaArticuloDAO preciosVentaArticuloDAO; 

	public PreciosVentaArticuloServiceImpl() {
	}

	@Override
	public boolean insertar(PreciosVentaArticuloBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getPreciosVentaArticuloDAO().insertar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(PreciosVentaArticuloBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getPreciosVentaArticuloDAO().actualizar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(PreciosVentaArticuloBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getPreciosVentaArticuloDAO().eliminar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public PreciosVentaArticuloBean getBuscarPorObjecto(PreciosVentaArticuloBean venta) throws ServiceException {
		PreciosVentaArticuloBean oPedido=null;
		try {
			oPedido=this.getPreciosVentaArticuloDAO().getBuscarPorObjecto(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<PreciosVentaArticuloBean> getBuscarPorFiltros(PreciosVentaArticuloBean venta)
			throws ServiceException {
		List<PreciosVentaArticuloBean> lstPedido=null;
		try {
			lstPedido=this.getPreciosVentaArticuloDAO().getBuscarPorFiltros(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 
	/*
	@Override
	public boolean anularVenta(PreciosVentaArticuloBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getPreciosVentaArticuloDAO().anularVenta(venta);
			sw = true;
		} catch (DAOException e) {
			sw = false;
			throw new ServiceException(e);
		}
		return sw;
	} 
	
	@Override
	public boolean cierreVentaDiaria(PreciosVentaArticuloBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getPreciosVentaArticuloDAO().cierreVentaDiaria(venta);
			sw=true;
		} catch (DAOException e) {
			sw=false;
			throw new ServiceException(e);
		}
		return sw;
	}
 
 
	@Override
	public List<PreciosVentaArticuloBean> listarVentasAnuladas(PreciosVentaArticuloBean venta)throws ServiceException {
		List<PreciosVentaArticuloBean> lstVentaVO = null;
		try {
			lstVentaVO =  this.getPreciosVentaArticuloDAO().listarVentasAnuladasFindByObject(venta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstVentaVO;
	}
  */


	public PreciosVentaArticuloDAO getPreciosVentaArticuloDAO() {
		return preciosVentaArticuloDAO;
	}

	public void setPreciosVentaArticuloDAO(PreciosVentaArticuloDAO preciosVentaArticuloDAO) {
		this.preciosVentaArticuloDAO = preciosVentaArticuloDAO;
	}

	@Override
	public boolean existe(PreciosVentaArticuloBean t) throws ServiceException { 
		return false;
	}
  


	
	
}

	
