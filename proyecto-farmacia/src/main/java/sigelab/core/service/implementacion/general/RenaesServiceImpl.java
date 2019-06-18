package sigelab.core.service.implementacion.general;

import sigelab.core.bean.general.RenaesBean;
import sigelab.core.repository.DAOException;
import sigelab.core.repository.interfaces.general.RenaesDAO;
import sigelab.core.service.exception.ServiceException;
import sigelab.core.service.interfaces.general.PersonaService;
import sigelab.core.service.interfaces.general.RenaesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("renaesService")
@Transactional (readOnly = true)
public class RenaesServiceImpl implements RenaesService {

	@Autowired
	private RenaesDAO RenaesDAO;
	
	
	
	public RenaesDAO getRenaesDAO() {
		return RenaesDAO;
	}

	public void setRenaesDAO(RenaesDAO RenaesDAO) {
		this.RenaesDAO = RenaesDAO;
	}

	@Override
	public boolean insertar(RenaesBean RenaesBean) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  RenaesDAO.insertar(RenaesBean);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(RenaesBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  RenaesDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(RenaesBean t) throws ServiceException {
		 
		return false;
	}

	@Override
	public RenaesBean getBuscarPorObjecto(RenaesBean t)
			throws ServiceException {
 
		RenaesBean oRenaesBean = null;
		try {
			oRenaesBean = RenaesDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oRenaesBean;
	}

	@Override
	public List<RenaesBean> getBuscarPorFiltros(RenaesBean t)
			throws ServiceException {
	 
		List<RenaesBean> lstReferenciaBean =  null;
		try {
			lstReferenciaBean = this.RenaesDAO.getBuscarPorFiltros(t);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return lstReferenciaBean;
	}

	@Override
	public boolean existe(RenaesBean t) throws ServiceException {
 
		return false;
	}
 
}
