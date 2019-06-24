package proyect.core.repository.implementacion.venta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.repository.interfaces.venta.VentaDAO;
import proyect.core.repository.interfaces.venta.VentaItemDAO; 

@Transactional
@Repository("VentaItemDAO")
public class VentaDAOImpl implements VentaItemDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaDAOImpl() {
		
	}

	@Override
	public boolean insertar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaItemBean getBuscarPorObjecto(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaItemBean> getBuscarPorFiltros(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(VentaItemBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
 
  
 
}
