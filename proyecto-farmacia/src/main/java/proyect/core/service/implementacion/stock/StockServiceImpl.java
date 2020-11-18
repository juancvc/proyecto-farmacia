package proyect.core.service.implementacion.stock;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;
import proyect.core.repository.interfaces.stock.StockDAO;
import proyect.core.service.interfaces.stock.StockService;

@Service("stockService")
public class StockServiceImpl implements StockService {
	
	
	@Autowired
	private StockDAO stockDAO; 

	public StockServiceImpl() {
	}

	@Override
	public boolean insertar(StockBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getStockDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(StockBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getStockDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(StockBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getStockDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public StockBean getBuscarPorObjecto(StockBean stockBean) throws ServiceException {
		StockBean oPedido=null;
		try {
			oPedido=this.getStockDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<StockBean> getBuscarPorFiltros(StockBean stockBean)
			throws ServiceException {
		List<StockBean> lstPedido=null;
		try {
			lstPedido=this.getStockDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 



	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Override
	public boolean existe(StockBean t) throws ServiceException { 
		return false;
	}

	@Override
	public List<StockBean> listarPorIdArticulo(ArticuloBean articuloBean) throws ServiceException {
		List<StockBean> lstPedido=null;
		try {
			lstPedido=this.getStockDAO().listarPorIdArticulo(articuloBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
  

}

	
