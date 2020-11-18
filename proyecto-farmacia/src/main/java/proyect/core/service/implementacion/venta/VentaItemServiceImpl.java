package proyect.core.service.implementacion.venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.general.EpisodioBean;
import proyect.core.bean.venta.VentaBean;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.repository.interfaces.venta.VentaItemDAO;
import proyect.core.service.interfaces.venta.VentaItemService; 

@Service("VentaItemService")
public class VentaItemServiceImpl implements VentaItemService {
	
	
	@Autowired
	private VentaItemDAO ventaItemDAO; 

	public VentaItemServiceImpl() {
	}

	@Override
	public boolean insertar(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VentaItemBean getBuscarPorObjecto(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaItemBean> getBuscarPorFiltros(VentaItemBean t) throws ServiceException {
		List<VentaItemBean> lstPedido=null;
		try {
			lstPedido=ventaItemDAO.getBuscarPorFiltros(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

	@Override
	public boolean existe(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VentaItemBean> listarArtPorEpisodio(EpisodioBean episodio) throws ServiceException {
		List<VentaItemBean> lstPedido=null;
		try {
			lstPedido=ventaItemDAO.listarArtPorEpisodio(episodio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

	@Override
	public List<VentaItemBean> listarConsumoPaciente(VentaBean ventaBean) throws ServiceException {
		List<VentaItemBean> lstPedido=null;
		try {
			lstPedido=ventaItemDAO.listarConsumoPaciente(ventaBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstPedido;
	}

}

	
