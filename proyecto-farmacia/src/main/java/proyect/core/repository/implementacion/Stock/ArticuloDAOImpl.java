package proyect.core.repository.implementacion.Stock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ArticuloBean;
import proyect.core.repository.interfaces.stock.ArticuloDAO;


@Transactional
@Repository("ArticuloDAO")
public class ArticuloDAOImpl implements ArticuloDAO{
	
	@PersistenceContext
	private EntityManager em;

	public ArticuloDAOImpl() {
		
	}

	@Override
	public boolean insertar(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticuloBean getBuscarPorObjecto(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticuloBean> getBuscarPorFiltros(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ArticuloBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
