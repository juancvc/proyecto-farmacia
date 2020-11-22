package proyect.core.service.implementacion.compra;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.compra.CompraBean;
import proyect.core.repository.interfaces.compra.CompraDAO;
import proyect.core.service.interfaces.compra.CompraService;

@Service("compraService")
public class CompraServiceImpl implements CompraService {
	
	
	@Autowired
	private CompraDAO ventaDAO; 

	public CompraServiceImpl() {
	}

	@Override
	public boolean insertar(CompraBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCompraDAO().insertar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}
   
	@Override
	public boolean actualizar(CompraBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCompraDAO().actualizar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(CompraBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCompraDAO().eliminar(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public CompraBean getBuscarPorObjecto(CompraBean venta) throws ServiceException {
		CompraBean oPedido=null;
		try {
			oPedido=this.getCompraDAO().getBuscarPorObjecto(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public List<CompraBean> getBuscarPorFiltros(CompraBean venta)
			throws ServiceException {
		List<CompraBean> lstPedido=null;
		try {
			lstPedido=this.getCompraDAO().getBuscarPorFiltros(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}
 
 
	
	@Override
	public boolean anularCompra(CompraBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCompraDAO().anularCompra(venta);
			sw = true;
		} catch (DAOException e) {
			sw = false;
			throw new ServiceException(e);
		}
		return sw;
	} 
	
	@Override
	public boolean cierreCompraDiaria(CompraBean venta) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getCompraDAO().cierreCompraDiaria(venta);
			sw=true;
		} catch (DAOException e) {
			sw=false;
			throw new ServiceException(e);
		}
		return sw;
	}
 
 
	@Override
	public List<CompraBean> listarComprasAnuladas(CompraBean venta)throws ServiceException {
		List<CompraBean> lstCompraVO = null;
		try {
			lstCompraVO =  this.getCompraDAO().listarComprasAnuladasFindByObject(venta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstCompraVO;
	}
  
	public CompraDAO getCompraDAO() {
		return ventaDAO;
	}

	public void setCompraDAO(CompraDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	@Override
	public boolean existe(CompraBean t) throws ServiceException { 
		return false;
	}
  

	@Override
	public List<CompraBean> listarAtencionesIME(CompraBean venta) throws ServiceException { 
		return null;
	}

	@Override
	public List<CompraBean> listarComprasDiarias(CompraBean venta) throws ServiceException {
		List<CompraBean> lstCompraVO = null;
		try {
			lstCompraVO =  this.getCompraDAO().listarComprasDiarias(venta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstCompraVO;
	}

	@Override
	public String cantidadConLetra(float monto) throws ServiceException {
		String sw="";
		try {
			sw=this.getCompraDAO().cantidadConLetra(monto);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public List<CompraBean> listarPacientes(CompraBean venta) throws ServiceException {
		List<CompraBean> lstCompraVO = null;
		try {
			lstCompraVO =  this.getCompraDAO().listarPacientes(venta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstCompraVO;
	}

	@Override
	public CompraBean buscarPorNroDocumento(CompraBean venta) throws ServiceException {
		CompraBean oPedido=null;
		try {
			oPedido=this.getCompraDAO().buscarPorNroDocumento(venta);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}

	@Override
	public CompraBean totalCompra(int tipo, CompraBean compra) throws ServiceException {
		CompraBean oPedido=null;
		try {
			oPedido=this.getCompraDAO().totalCompra(tipo,compra);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPedido;
	}
}

	
