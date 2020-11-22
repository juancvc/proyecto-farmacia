package proyect.core.service.implementacion.stock;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.repository.interfaces.stock.ArticuloDAO;
import proyect.core.service.interfaces.stock.ArticuloService;

@Service("articuloService")
public class ArticuloServiceImpl implements ArticuloService {
	
	
	@Autowired
	private ArticuloDAO articuloDAO; 

	public ArticuloServiceImpl() {
	}

	@Override
	public boolean insertar(ArticuloBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getArticuloDAO().insertar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(ArticuloBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getArticuloDAO().actualizar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArticuloBean stockBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getArticuloDAO().eliminar(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public ArticuloBean getBuscarPorObjecto(ArticuloBean stockBean) throws ServiceException {
		ArticuloBean oPedido=null;
		try {
			oPedido=this.getArticuloDAO().getBuscarPorObjecto(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<ArticuloBean> getBuscarPorFiltros(ArticuloBean stockBean)
			throws ServiceException {
		List<ArticuloBean> lstPedido=null;
		try {
			lstPedido=this.getArticuloDAO().getBuscarPorFiltros(stockBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 





	public ArticuloDAO getArticuloDAO() {
		return articuloDAO;
	}

	public void setArticuloDAO(ArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	@Override
	public boolean existe(ArticuloBean t) throws ServiceException { 
		return false;
	}

	@Override
	public List<ArticuloBean> reportePorStockAlerta() throws ServiceException {
		List<ArticuloBean> lstPedido=null;
		try {
			lstPedido=this.getArticuloDAO().reportePorStockAlerta();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
}

	
