package proyect.core.service.implementacion.venta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.venta.VentaBean;
import proyect.core.repository.interfaces.venta.VentaDAO;
import proyect.core.service.interfaces.venta.VentaService;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {
	
	
	@Autowired
	private VentaDAO ventaDAO; 

	public VentaServiceImpl() {
	}

	@Override
	public boolean insertar(VentaBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getVentaDAO().insertar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(VentaBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getVentaDAO().actualizar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(VentaBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getVentaDAO().eliminar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public VentaBean getBuscarPorObjecto(VentaBean venta) throws ServiceException {
		VentaBean oPedido=null;
		try {
			oPedido=this.getVentaDAO().getBuscarPorObjecto(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<VentaBean> getBuscarPorFiltros(VentaBean venta)
			throws ServiceException {
		List<VentaBean> lstPedido=null;
		try {
			lstPedido=this.getVentaDAO().getBuscarPorFiltros(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 
	
	@Override
	public boolean anularVenta(VentaBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getVentaDAO().anularVenta(venta);
			sw = true;
		} catch (DAOException e) {
			sw = false;
			throw new ServiceException(e);
		}
		return sw;
	} 
	
	@Override
	public boolean cierreVentaDiaria(VentaBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getVentaDAO().cierreVentaDiaria(venta);
			sw=true;
		} catch (DAOException e) {
			sw=false;
			throw new ServiceException(e);
		}
		return sw;
	}
 
 
	@Override
	public List<VentaBean> listarVentasAnuladas(VentaBean venta)throws ServiceException {
		List<VentaBean> lstVentaVO = null;
		try {
			lstVentaVO =  this.getVentaDAO().listarVentasAnuladasFindByObject(venta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstVentaVO;
	}
  
	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	@Override
	public boolean existe(VentaBean t) throws ServiceException { 
		return false;
	}
  

	@Override
	public List<VentaBean> listarAtencionesIME(VentaBean venta) throws ServiceException { 
		return null;
	}
}

	
