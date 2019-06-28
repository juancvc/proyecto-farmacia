package proyect.core.repository.implementacion.Stock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.stock.ProveedorBean;
import proyect.core.repository.interfaces.stock.ProveedorDAO;

@Transactional
@Repository("ProveedorDAO")
public class ProveedorDAOImpl implements ProveedorDAO{
	
	@PersistenceContext
	private EntityManager em;

	public ProveedorDAOImpl() {
		
	}

	@Override
	public boolean insertar(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProveedorBean getBuscarPorObjecto(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProveedorBean> getBuscarPorFiltros(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(ProveedorBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
