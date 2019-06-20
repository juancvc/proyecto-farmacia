package proyect.core.service.implementacion.general;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyect.core.bean.general.TarifarioDetalleBean;
import proyect.core.repository.DAOException;
import proyect.core.repository.interfaces.general.TarifarioDetalleDAO;
import proyect.core.service.exception.ServiceException;
import proyect.core.service.interfaces.general.TarifarioDetalleService;

@Service("TarifarioDetalleService")
@Transactional (readOnly = true)
public class TarifarioDetalleServiceImpl implements TarifarioDetalleService {
	
	
	@Autowired
	 private TarifarioDetalleDAO TarifarioDAO;
	
	@Override
	public boolean insertar(TarifarioDetalleBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TarifarioDetalleBean t) throws ServiceException { 
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TarifarioDetalleBean t) throws ServiceException { 
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TarifarioDetalleBean getBuscarPorObjecto(TarifarioDetalleBean t) throws ServiceException { 
		return null;
	}

	@Override
	public List<TarifarioDetalleBean> getBuscarPorFiltros(TarifarioDetalleBean t)
			throws ServiceException {
		List<TarifarioDetalleBean> lstTarifarioDetalleBean =  null;
		try {
			lstTarifarioDetalleBean = TarifarioDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstTarifarioDetalleBean;
	}

	@Override
	public boolean existe(TarifarioDetalleBean t) throws ServiceException { 
		return false;
	}

	 
	 
}
