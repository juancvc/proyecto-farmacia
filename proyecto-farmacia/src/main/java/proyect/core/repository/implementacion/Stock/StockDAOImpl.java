package proyect.core.repository.implementacion.Stock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.StockBean;
import proyect.core.repository.interfaces.stock.StockDAO;


@Transactional
@Repository("StockDAO")
public class StockDAOImpl implements StockDAO{
	
	@PersistenceContext
	private EntityManager em;

	public StockDAOImpl() {
		
	}

	@Override
	public boolean insertar(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockBean getBuscarPorObjecto(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockBean> getBuscarPorFiltros(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(StockBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
