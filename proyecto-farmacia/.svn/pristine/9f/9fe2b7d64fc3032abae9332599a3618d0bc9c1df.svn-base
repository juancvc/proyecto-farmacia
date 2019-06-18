package hnch.referencia.core.service.implementacion.seguridad;
 
import hnch.referencia.core.bean.seguridad.PerfilBean;
import hnch.referencia.core.repository.DAOException;
import hnch.referencia.core.repository.interfaces.seguridad.PerfilDAO;
import hnch.referencia.core.service.exception.ServiceException;
import hnch.referencia.core.service.interfaces.seguridad.PerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

@Service("perfilService")
@Transactional (readOnly = true)
public class PerfilServiceImp implements PerfilService{
	
	@Autowired
	PerfilDAO perfilDAO;
	
	@Override
	public boolean insertar(PerfilBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  perfilDAO.insertar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean actualizar(PerfilBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  perfilDAO.actualizar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public boolean eliminar(PerfilBean t) throws ServiceException {
		Boolean sw = false;
		try {
			sw =  perfilDAO.eliminar(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return sw;
	}

	@Override
	public PerfilBean getBuscarPorObjecto(PerfilBean t) throws ServiceException {
		PerfilBean oPerfilBean = null;
		try {
			oPerfilBean = perfilDAO.getBuscarPorObjecto(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oPerfilBean;
	}

	@Override
	public List<PerfilBean> getBuscarPorFiltros(PerfilBean t)
			throws ServiceException {
		List<PerfilBean> lstBean = null;
		try {
			lstBean =  perfilDAO.getBuscarPorFiltros(t);
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	@Override
	public boolean existe(PerfilBean t) throws ServiceException {
		return false;
	}

	@Transactional
	public List<PerfilBean> listado() throws ServiceException {
		List<PerfilBean> lstBean = null;
		try {
			lstBean =  getPerfilDAO().listado();
			
		} catch (DAOException e) { 
			e.printStackTrace();
		}
		return lstBean;
	}

	public PerfilDAO getPerfilDAO() {
		return perfilDAO;
	}

	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}

}
