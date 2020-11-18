package proyect.core.repository.interfaces.stock;
 
import java.util.List;

import proyect.base.repository.DAOException;
import proyect.base.repository.interfaces.BaseDAO;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.bean.stock.StockBean;
 

public interface StockDAO extends BaseDAO<StockBean> {
	
	public List<StockBean > listarPorIdArticulo(ArticuloBean articuloBean) throws DAOException;

}
