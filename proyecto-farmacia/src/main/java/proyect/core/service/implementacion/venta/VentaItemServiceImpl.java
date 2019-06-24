package proyect.core.service.implementacion.venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
import proyect.core.bean.venta.VentaItemBean;
import proyect.core.repository.interfaces.venta.VentaItemDAO;
import proyect.core.service.interfaces.venta.VentaItemService; 

@Service("ventaService")
public class VentaItemServiceImpl implements VentaItemService {
	
	
	@Autowired
	private VentaItemDAO VentaItemDAO; 

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(VentaItemBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	 
	
}

	
