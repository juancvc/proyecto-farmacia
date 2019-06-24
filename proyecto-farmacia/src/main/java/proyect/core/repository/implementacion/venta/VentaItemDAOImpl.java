package proyect.core.repository.implementacion.venta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.venta.VentaBean;
import proyect.core.repository.interfaces.venta.VentaDAO; 

@Transactional
@Repository("ventaDAO")
public class VentaItemDAOImpl implements VentaDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaItemDAOImpl() {
		
	}

	@Override
	public boolean insertar(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaBean getBuscarPorObjecto(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> getBuscarPorFiltros(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(VentaBean t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaBean> buscarxFechaClienteVO(VentaBean VentaBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularVenta(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaBean findByIdVenta(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cierreVentaDiaria(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaBean> listarVentasAnuladasFindByObject(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> listarVentasAnuladasFindByObjectPagante(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaBean> listarAtencionesIME(VentaBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
  
 
}
