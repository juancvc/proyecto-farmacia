package proyect.core.service.implementacion.cuentaCorriente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.cuentaCorriente.CuentaCorrienteBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.repository.interfaces.cuentaCorriente.CuentaCorrienteDAO;
import proyect.core.repository.interfaces.venta.DevolucionDAO;
import proyect.core.service.interfaces.cuentaCorriente.CuentaCorrienteService;


@Service("cuentaCorrienteService")
public class CuentaCorrienteServiceImpl implements CuentaCorrienteService {
	
	
	@Autowired
	private CuentaCorrienteDAO cuentaCorrienteDAO; 

	public CuentaCorrienteServiceImpl() {
	}

	@Override
	public boolean insertar(CuentaCorrienteBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCuentaCorrienteDAO().insertar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(CuentaCorrienteBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCuentaCorrienteDAO().actualizar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(CuentaCorrienteBean devolucion) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCuentaCorrienteDAO().eliminar(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public CuentaCorrienteBean getBuscarPorObjecto(CuentaCorrienteBean devolucion) throws ServiceException {
		CuentaCorrienteBean oDevolucion=null;
		try {
			oDevolucion=this.getCuentaCorrienteDAO().getBuscarPorObjecto(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oDevolucion;
	}

	@Override
	public List<CuentaCorrienteBean> getBuscarPorFiltros(CuentaCorrienteBean devolucion)throws ServiceException {
		List<CuentaCorrienteBean> lstDevolucion=null;
		try {
			lstDevolucion=this.getCuentaCorrienteDAO().getBuscarPorFiltros(devolucion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstDevolucion;
	}
	
	
	@Override
	public List<CuentaCorrienteBean> listarCtaCtePacientePendientes(CuentaCorrienteBean venta)
			throws ServiceException {
		List<CuentaCorrienteBean> lstPedido=null;
		try {
			lstPedido=this.getCuentaCorrienteDAO().listarCtaCtePacientePendientes(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}


	public CuentaCorrienteDAO getCuentaCorrienteDAO() {
		return cuentaCorrienteDAO;
	}

	public void setCuentaCorrienteDAO(CuentaCorrienteDAO cuentaCorrienteDAO) {
		this.cuentaCorrienteDAO = cuentaCorrienteDAO;
	}

	@Override
	public boolean existe(CuentaCorrienteBean t) throws ServiceException { 
		return false;
	}
 
}
