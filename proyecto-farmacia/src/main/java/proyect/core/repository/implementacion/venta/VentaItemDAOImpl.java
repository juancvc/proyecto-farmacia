package proyect.core.repository.implementacion.venta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import proyect.base.repository.DAOException;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.repository.interfaces.venta.VentaItemDAO; 

@Transactional
@Repository("ventaItemDAO")
public class VentaItemDAOImpl implements VentaItemDAO{
	
	@PersistenceContext
	private EntityManager em;

	public VentaItemDAOImpl() {
		
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
/*
	@Override
	public List<VentaItemBean> buscarxFechaClienteVO(VentaItemBean VentaItemBean) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularVenta(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaItemBean findByIdVenta(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cierreVentaDiaria(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaItemBean> listarVentasAnuladasFindByObject(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaItemBean> listarVentasAnuladasFindByObjectPagante(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaItemBean> listarAtencionesIME(VentaItemBean venta) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}*/
  
 
}
