package sigelab.core.service.implementacion.general;


import sigelab.core.bean.general.TarifarioBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.general.TarifarioDAO;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.general.TarifarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TarifarioService")
@Transactional (readOnly = true)
public class TarifarioServiceImpl implements TarifarioService {
	
	
	@Autowired
	 private TarifarioDAO TarifarioDAO;
	
	@Override
	public boolean insertar(TarifarioBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(TarifarioBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(TarifarioBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  TarifarioDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public TarifarioBean getBuscarPorObjecto(TarifarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TarifarioBean> getBuscarPorFiltros(TarifarioBean t)
			throws ServiceException {
		List<TarifarioBean> lstTarifarioBean =  null;
		try {
			lstTarifarioBean = TarifarioDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstTarifarioBean;
	}

	@Override
	public boolean existe(TarifarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	 
	 
}
