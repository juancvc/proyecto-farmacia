package proyect.core.service.implementacion.general;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyect.core.bean.general.InstitucionBean;
import proyect.core.repository.interfaces.general.InstitucionDAO;
import proyect.core.service.interfaces.general.InstitucionService; 
import proyect.base.repository.DAOException;
import proyect.base.service.ServiceException;
 

@Service("institucionService")
@Transactional(readOnly = true)
public class InstitucionServiceImpl implements InstitucionService {
	
	@Autowired
	private InstitucionDAO InstitucionDAO; 

	public InstitucionServiceImpl() {
	}

	@Override
	public boolean insertar(InstitucionBean InstitucionBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getInstitucionDAO().insertar(InstitucionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(InstitucionBean InstitucionBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getInstitucionDAO().actualizar(InstitucionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(InstitucionBean InstitucionBean) throws ServiceException {
		boolean sw=false;
		try {
			sw=this.getInstitucionDAO().eliminar(InstitucionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return sw;
	}

	@Override
	public InstitucionBean getBuscarPorObjecto(InstitucionBean InstitucionBean) throws ServiceException {
		InstitucionBean oInstitucionBean=null;
		try {
			oInstitucionBean=this.getInstitucionDAO().getBuscarPorObjecto(InstitucionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return oInstitucionBean;
	}
 
	@Override
	public List<InstitucionBean> getBuscarPorFiltros(InstitucionBean InstitucionBean) throws ServiceException {
		List<InstitucionBean> lstInstitucionBean=null;
		try {
			lstInstitucionBean=this.getInstitucionDAO().getBuscarPorFiltros(InstitucionBean);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return lstInstitucionBean;
	}
 
	@Override
	public boolean existe(InstitucionBean t) throws ServiceException { 
		return false;
	}

	public InstitucionDAO getInstitucionDAO() {
		return InstitucionDAO;
	}

	public void setInstitucionDAO(InstitucionDAO institucionDAO) {
		InstitucionDAO = institucionDAO;
	}
 

}
